package pt.inescid.gsd.k;


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

    public void updateKValues(double v) {
        this.currentSequence++;
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
