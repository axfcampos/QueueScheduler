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


        //Aqui tem que se verificar outras operacoes existentes
        //Ver se sao as mesmas e fazer update... portanto as cenas dos hash_codes estao mal??
        //.....
        //Identificando assim tabem se ha operacoes em comum que teem que ser update entano tambem he dependencias implicitas.
        //Caso nao venha nenhuma dependencia explicita. Serao inferidas dependencias implicitas atravez deste metodo!!!! :D


        //Agora tenho de resolver o problema do id da operacao. Ver como e que eles fazem no Omid e simplesmente fazer hijack
        //esses ids... ou implementar algo parecido.







        for (RowKey r : rows){
            tx.addOperation(r);
        }

        //so the story is:
        //For the inserted transaction check for each operation
        //which operations are commom with the ones in the queue.
        //If there are update their urgency according to the values.
        //and place them as dependencies if there arent explicit dependencies.

        for (Transaction t : this.theQueue){

            t.update(tx, rows);
        }
        this.theQueue.add(tx);
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
