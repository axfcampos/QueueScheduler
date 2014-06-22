package pt.inescid.gsd.k;

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

    @Override
    public void incSequence(){
        this.currentSequence++;
    }

    @Override
    public void incValue(double value) {

    }

    @Override
    public void incTime() {

    }

    @Override
    public String toString() {
        return "k( ., " + this.currentSequence + ":" + super.sequence + ", .)";
    }

    @Override
    public double getUrgency() {
        return this.currentSequence;
    }


}
