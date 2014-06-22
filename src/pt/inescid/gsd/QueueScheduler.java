package pt.inescid.gsd;

import pt.inescid.gsd.k.K_Seq;

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

    public List<Transaction> getQueueScheduler(){
        return theQueue;
    }

    //transactionid -> startTimestamp
    //RowKey[] rows -> affected rows
    public void insertTransaction(long transactionid, RowKey[] rows){

        //para cada rowkey criar uma op
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
