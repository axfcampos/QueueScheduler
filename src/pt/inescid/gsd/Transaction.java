package pt.inescid.gsd;

import java.util.*;

/**
 *
 * Incorporates the group of Operations involved in a Transaction
 * Reads and Puts
*/
public class Transaction implements Comparable<Transaction> {

    private TreeMap<Operation, Long> ops;
    private List <Transaction> causalDependencies;
    private long transactionid;
    private long commit_ts; //might be usefull for recollect serial order

    public Transaction(long transactionid, long commit_ts){
        this.transactionid = transactionid;
        this.commit_ts = commit_ts;
        this.ops = new TreeMap<Operation, Long>();
        this.causalDependencies = new ArrayList<Transaction>();
    }



    @Override
    public int compareTo(Transaction o) {

        if(this.getMostUrgent().compareTo(o.getMostUrgent()) == 1){

            if(this.checkIfInDependencies(o)){
                return -1;
            }else{
                return 1;
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
        LinkedList<Transaction> Q = new LinkedList<Transaction>(); //visit order
        Set<Transaction> V = new TreeSet<Transaction>(); //visited nodes

        Q.addFirst(this);
        V.add(this);

        while(!Q.isEmpty()){

            Transaction t = Q.getFirst();

            //dependency found! its ogre
            if(t.equals(follower)){
                return true;
            }

            for (Transaction tx : t.causalDependencies) {
                if (!V.contains(tx)) {
                    V.add(tx);
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

        String ret = "[";

        int size = ops.size();
        for (Operation op : ops.keySet()){
            size--;
            if(size == 0) {
                ret += "   " + op.toString() + "  ]";
            }else{
            if(size == (ops.size()-1)){
                ret += "  " + op.toString() + ",\n";
            }else{
                ret += "   " + op.toString() + ",\n";
            }}
        }
        return ret;
    }
}
