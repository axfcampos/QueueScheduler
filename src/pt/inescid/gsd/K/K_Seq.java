package pt.inescid.gsd.K;

/**
 * Created by axfcampos on 07/06/14.
 */
public class K_Seq extends K {

    private int currentSequence;

    public K_Seq(int sequence){
        super.time = -1;
        super.sequence = sequence;
        super.value = -1;
        this.currentSequence = 0;
    }

    @Override
    public void reset() {
        this.currentSequence = 0;
    }

    public void incSequence(){
        this.currentSequence++;
    }

    @Override
    public String toString() {
        return "K( ., " + this.currentSequence + ":" + super.sequence + ", .)";
    }

    @Override
    public double getUrgency() {
        return this.currentSequence;
    }


}
