package pt.inescid.gsd;

import java.util.*;

/**
 *
 * Incorporates the group of Operations involved in a Transaction
 * Reads and Puts
*/
public class Transaction implements Comparable<Transaction> {

    //treemap is inverted so it sorts Operations through compare method
    //therefore to get the most urgent Operation you simply do op.getfirstkey
    private TreeMap<Operation, Long> ops;
    private List <Transaction> causalDependencies;
    private long transaction_id; //start_ts?
    private long commit_ts; //might be usefull for recollect serial order

    public Transaction(long transaction_id, long commit_ts){
        this.transaction_id = transaction_id;
        this.commit_ts = commit_ts;
        this.ops = new TreeMap<Operation, Long>();
        this.causalDependencies = new ArrayList<Transaction>();
    }

    public void addOperation(RowKey row){

        Operation op = new Operation(this, row);
        ops.put(op, row.getHashCode());
    }

    public long getTransactionId(){
        return this.transaction_id;
    }

    public void update(Transaction tx, RowKey[] rows){

        //if i have one of these rows on my operations
        //  update the operation K vector
        //  and add myself to the tx dependencies
        //  since tx depends on me

        for (Operation op : this.ops.keySet()){
            for ( RowKey row : rows){
                if(op.getHash() == row.getHashCode()){
                    op.updateKValues(row.value);
                    tx.addDependency(this);
                }
            }
        }
    }

    public void addDependency(Transaction tx){
        this.causalDependencies.add(tx);
    }
    @Override
    public int compareTo(Transaction o) {

        if(this.getMostUrgent().compareTo(o.getMostUrgent()) == 1){

            if(this.checkIfInDependencies(o)){
                return 1;
            }else{
                return -1;
            }
        }else{
            if(o.checkIfInDependencies(this)){
                return -1;
            }else{
                return 1;
            }
        }
    }

    public boolean checkIfInDependencies(Transaction follower){

        if(this.causalDependencies.isEmpty()){
            return false;
        }

        //Breath-first search
        //This could be improved significantly.
        //A smarter algorithm that can learn with data behaviour and match that to heuristics
        Transaction t;
        LinkedList<Transaction> Q = new LinkedList<Transaction>(); //visit order
        LinkedList<Transaction> V = new LinkedList<Transaction>(); //visited nodes

        Q.addFirst(this);
        V.addFirst(this);


        while(!Q.isEmpty()){

            t = Q.getFirst();
            Q.removeFirst();

            //dependency found! its ogre
            if(t.getTransactionId() == follower.getTransactionId()){
                return true;
            }

            for (Transaction tx : t.causalDependencies) {
                if (!V.contains(tx)) {
                    V.addFirst(tx);
                    Q.addFirst(tx);
                }
            }
        }
        return false;
    }

    public Operation getMostUrgent(){

        //TODO find a way to sort and keep the order in which the operations were made (although it might be useless)
        return ops.firstKey();
    }



    @Override
    public String toString(){

        String ret = "[ tx_id: " + this.transaction_id + " c_ts: " + this.commit_ts + " urg: " +
                this.ops.firstKey().getHash() + " deps: ";

        for (Transaction tx : this.causalDependencies){

            ret += tx.getTransactionId() + ",";
        }

        ret += "\n";

        int size = ops.size();
        for (Operation op : ops.keySet()){
            size--;
            if(size == 0) {
                ret += "   " + op.toString() + "  ]";
            }else{
            if(size == (ops.size())){
                ret += "  " + op.toString() + ",\n";
            }else{
                ret += "   " + op.toString() + ",\n";
            }}
        }
        return ret;
    }
}
