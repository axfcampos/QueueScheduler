package pt.inescid.gsd.K;


import java.util.Date;

/**
 * Created by axfcampos on 06/06/14.
 */
public abstract class K implements Comparable<K> {

    //immutable bounds
    protected long time;
    protected int sequence;
    protected double value;

    //GETTERS
    public long getTime() {
        return time;
    }
    public int getSequence() {
        return sequence;
    }
    public double getValue() {
        return value;
    }

    public abstract void reset();

    public abstract String toString();

    @Override
    public int compareTo(K o) {

        if(this.getUrgency() >= o.getUrgency()){
            return 1; //im more urgent
        }else{
            return -1; //im less urgent
        }
    }

    public abstract double getUrgency();

}