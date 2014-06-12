package pt.inescid.gsd;

import pt.inescid.gsd.K.K;

/**
 * Created by axfcampos on 06/06/14.
 */
public class Operation implements Comparable<Operation> {


    private K k;

    //info relativa as rows alteradas ainda por decidir
    //private RowKeyRead = null or not
    //private RowKeyWrite = null or not
    //real order position in the transaction


    public Operation(K k){
        this.k = k;
    }

    //TODO incrementers to K values

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
