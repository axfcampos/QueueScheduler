package pt.inescid.gsd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by axfcampos on 06/06/14.
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

    public void print(){
        System.out.println(this.toString());
    }

}
