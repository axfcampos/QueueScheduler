package pt.inescid.gsd;

import java.util.List;

/**
 * Created by axfcampos on 06/06/14.
 *
 * Incorporates the group of Operations involved in a Transaction
 * Reads and Puts
*/
public class Transaction implements Comparable<Transaction> {

    private List <Operation> Ops;
    private List <Transaction> causalDeps;
    private Operation mostUrgent;


    @Override
    public int compareTo(Transaction o) {
        return 0;
    }
}
