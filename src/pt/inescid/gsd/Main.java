package pt.inescid.gsd;

import pt.inescid.gsd.k.K_Seq;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
	// write your code here

        QueueScheduler q = new QueueScheduler();

        RowKey[] rows1 = new RowKey[5];

        RowKey r1 = new RowKey();
        r1.sequence = 20;
        rows1[0] = r1;
        RowKey r2 = new RowKey();
        r2.sequence = 20;
        rows1[1] = r2;
        RowKey r3 = new RowKey();
        r3.sequence = 20;
        rows1[2] = r3;
        RowKey r4 = new RowKey();
        r4.sequence = 20;
        rows1[3] = r4;
        RowKey r5 = new RowKey();
        r5.sequence = 20;
        rows1[4] = r5;

        q.insertTransaction(1, 2, rows1);


        //#########################################

        RowKey[] rows2 = new RowKey[5];

        RowKey rr1 = new RowKey();
        rr1.sequence = 20;
        rows2[0] = rr1;
        RowKey rr2 = new RowKey();
        rr2.sequence = 20;
        rows2[1] = rr2;
        RowKey rr3 = new RowKey();
        rr3.sequence = 20;
        rows2[2] = rr3;
        RowKey rr4 = new RowKey();
        rr4.sequence = 20;
        rows2[3] = rr4;
        RowKey rr5 = new RowKey();
        rr5.sequence = 20;
        rows2[4] = rr5;

        q.insertTransaction(3, 4, rows2);

        System.out.println(q.toString());

        q.sort();

        System.out.println(q.toString());



    }



}
