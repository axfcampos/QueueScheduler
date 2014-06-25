package pt.inescid.gsd;

import pt.inescid.gsd.k.*;

public class Operation implements Comparable<Operation> {


    private K k;
    private long hash; //row id

    //real order position in the transaction
    //info relativa as rows alteradas ainda por decidir
    //private RowKeyRead = null or not
    //private RowKeyWrite = null or not

    public Operation(RowKey r){


//        if(r.sequence != -1 && r.value != -1 && r.time != -1){
//            this.k = new K_TimeSeqValue();
//        }else{
//        if(r.sequence != -1 && r.value != -1 && !(r.time != -1)){
//            this.k = new K_ValueSeq();
//        }else{
//        if(r.sequence != -1 && !(r.value != -1) && r.time != -1){
//            this.k = new K_SeqTime();
//        }else{
//        if(!(r.sequence != -1) && r.value != -1 && r.time != -1){
//            this.k = new K_TimeValue();
//        }else{
//        if(r.sequence != -1 && !(r.value != -1) && !(r.time != -1)){
//            System.out.println("here");
//            this.k = new K_Seq(r.sequence);
//        }else{
//        if(!(r.sequence != -1) && !(r.value != -1) && r.time != -1){
//            this.k = new K_Time();
//        }else{
//        if(!(r.sequence != -1) && r.value != -1 && !(r.time != -1)){
//            this.k = new K_Value();
//        }else{
//            System.out.println("huge error K");
//        }}}}}}}

        this.k = new K_Seq(r.sequence);
        this.hash = r.hashCode();
    }

    public void updateKValues(double value){
        this.k.updateKValues(value);
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
