package pt.inescid.gsd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 *
 */
public class QueueScheduler {


    private List<Transaction> theQueue;

    public QueueScheduler(){
        theQueue = new ArrayList<Transaction>();
    }


    public void sort(){
        Collections.sort(theQueue);
    }

    //transactionid -> startTimestamp
    //RowKey[] rows -> affected rows
    public void insertTransaction(long transaction_id, long commit_ts, RowKey[] rows){


        Transaction tx = new Transaction(transaction_id, commit_ts);

        for (RowKey r : rows){
            tx.addOperation(r);
        }

        //For the inserted transaction check for each operation
        //which operations are commom with the ones in the queue.
        //If they are, update their urgency according to the values.
        //and place them as dependencies if there arent explicit dependencies.

        for (Transaction t : this.theQueue){

            t.update(tx, rows);
        }
        this.theQueue.add(tx);
    }

    public void insertTransaction (long transaction_id, long commit_ts, RowKey[] rows, RowKey[] dependencies){

        //Here dependencies may be completely unrelated to the rows being changed.
        //As in a dependency can be declared even if there are no common rows affected between Transactions.
        //Since it is impossible to infer dependencies if there are no common affected rows they need to be
        //explicitly defined.
        if(dependencies != null ){
            //TODO implement explicit dependency declaration

        }else{
            insertTransaction(transaction_id, commit_ts, rows);
        }
    }

    public void print(){
        System.out.println(this.toString());
    }

    @Override
    public String toString(){

        String ret = "+++Printing Schedule Queue:\n";
        int size = theQueue.size();

        for (Transaction tx : theQueue){
            size--;
            if(size != 0) {
                ret += tx.toString() + ",\n";
            }else{
                ret += tx.toString() + "\n+++++++ end.";
            }
        }

        return ret;
    }
}
