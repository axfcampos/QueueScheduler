package pt.inescid.gsd;

import pt.inescid.gsd.K.K_Seq;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here

        /*List<Integer> intlist = new ArrayList<Integer>();

        intlist.add(6);
        intlist.add(3);
        intlist.add(2);
        intlist.add(4);
        intlist.add(7);
        intlist.add(5);
        intlist.add(4);
        intlist.add(1);

        Collections.sort(intlist);

        System.out.println(intlist);*/

        //Transaction 1
        ArrayList<Operation> ops1 = new ArrayList<Operation>();
        ops1.add(new Operation(new K_Seq(10)));
        ops1.add(new Operation(new K_Seq(10)));
        Transaction t1 = new Transaction(ops1, null);

        //Transaction 2
        ArrayList<Operation> ops2 = new ArrayList<Operation>();
        ops2.add(new Operation(new K_Seq(10)));
        ops2.add(new Operation(new K_Seq(10)));
        Transaction t2 = new Transaction(ops2, null);

        //Transaction 3
        ArrayList<Operation> ops3 = new ArrayList<Operation>();
        ops3.add(new Operation(new K_Seq(10)));
        ops3.add(new Operation(new K_Seq(10)));
        Transaction t3 = new Transaction(ops3, null);

        //Queue
        QueueScheduler q = new QueueScheduler();
        q.getQueueScheduler().add(t1);
        q.getQueueScheduler().add(t3);
        q.getQueueScheduler().add(t2);

        q.print();
        q.sort();
        q.print();

    }
}
