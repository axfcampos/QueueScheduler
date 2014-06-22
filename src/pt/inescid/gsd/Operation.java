package pt.inescid.gsd;

import pt.inescid.gsd.k.*;

public class Operation implements Comparable<Operation> {


    private K k;
    private long hash; //row id

    //real order position in the transaction
    //info relativa as rows alteradas ainda por decidir
    //private RowKeyRead = null or not
    //private RowKeyWrite = null or not

    public Operation(K k, long hash){
        this.k = k;
        this.hash = hash;
    }

    public void updateKValues(){
        this.k.incSequence();
        this.k.incTime();
    }
    public void updateKValues(double v){
        this.k.incValue(v);
        this.k.incSequence();
        this.k.incTime();
    }


    @Override
    public int compareTo(Operation o) {

        if(this.k.compareTo(o.k) == 1){
            //i won, im more urgent
            return 1;
        }else{
            //i lost, he is more urgent
            return -1;
        }
    }

    @Override
    public String toString(){
        return k.toString();
    }
}
