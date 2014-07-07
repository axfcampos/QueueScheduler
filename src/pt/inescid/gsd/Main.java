package pt.inescid.gsd;


import com.sun.rowset.internal.Row;

public class Main {

    public static void main(String[] args) {
	// write your code here



        test_broad_graph();

    }

    public static void test_broad_graph(){
        long startTime = System.currentTimeMillis();


        QueueScheduler q = new QueueScheduler();

        //Focal point transaction
        RowKey rkA0 = new RowKey();
        rkA0.sequence = 20;
        rkA0.id = 0;

        RowKey rkA1 = new RowKey();
        rkA1.sequence = 20;
        rkA1.id = 1;

        RowKey rkA2 = new RowKey();
        rkA2.sequence = 20;
        rkA2.id = 2;

        RowKey rkA3 = new RowKey();
        rkA3.sequence = 20;
        rkA3.id = 3;

        RowKey rkA4 = new RowKey();
        rkA4.sequence = 20;
        rkA4.id = 4;

        RowKey[] rowsA = {rkA0, rkA1, rkA2, rkA3, rkA4};
        q.insertTransaction(0, 0, rowsA);


        //Key 0 incrementer branch
        RowKey rkB0 = new RowKey();
        rkB0.sequence = 20;
        rkB0.id = 0;
        RowKey[] rowsB = {rkB0};
        q.insertTransaction(1, 1, rowsB);

        //Key 1 incrementer branch
        RowKey rkC1 = new RowKey();
        rkC1.sequence = 20;
        rkC1.id = 1;
        RowKey[] rowsC = {rkC1};
        q.insertTransaction(2, 2, rowsC);

        RowKey rkD1 = new RowKey();
        rkD1.sequence = 20;
        rkD1.id = 1;
        RowKey[] rowsD = {rkD1};
        q.insertTransaction(3, 3, rowsD);

        //Key 2 incrementer branch
        RowKey rkE2 = new RowKey();
        rkE2.sequence = 20;
        rkE2.id = 2;
        RowKey[] rowsE = {rkE2};
        q.insertTransaction(4, 4, rowsE);

        RowKey rkF2 = new RowKey();
        rkF2.sequence = 20;
        rkF2.id = 2;
        RowKey[] rowsF = {rkF2};
        q.insertTransaction(5, 5, rowsF);

        RowKey rkG2 = new RowKey();
        rkG2.sequence = 20;
        rkG2.id = 2;
        RowKey[] rowsG = {rkG2};
        q.insertTransaction(6, 6, rowsG);

        //Key 3 incrementer branch
        RowKey rkH3 = new RowKey();
        rkH3.sequence = 20;
        rkH3.id = 3;
        RowKey[] rowsH = {rkH3};
        q.insertTransaction(7, 7, rowsH);

        RowKey rkI3 = new RowKey();
        rkI3.sequence = 20;
        rkI3.id = 3;
        RowKey[] rowsI = {rkI3};
        q.insertTransaction(8, 8, rowsI);

        RowKey rkJ3 = new RowKey();
        rkJ3.sequence = 20;
        rkJ3.id = 3;
        RowKey[] rowsJ = {rkJ3};
        q.insertTransaction(9, 9, rowsJ);

        RowKey rkK3 = new RowKey();
        rkK3.sequence = 20;
        rkK3.id = 3;
        RowKey[] rowsK = {rkK3};
        q.insertTransaction(10, 10, rowsK);

        //Key 4 incrementer branch

        RowKey rkL4 = new RowKey();
        rkL4.sequence = 20;
        rkL4.id = 4;
        RowKey[] rowsL = {rkL4};
        q.insertTransaction(11, 11, rowsL);

        RowKey rkM4 = new RowKey();
        rkM4.sequence = 20;
        rkM4.id = 4;
        RowKey[] rowsM = {rkM4};
        q.insertTransaction(12, 12, rowsM);

        RowKey rkN4 = new RowKey();
        rkN4.sequence = 20;
        rkN4.id = 4;
        RowKey[] rowsN = {rkN4};
        q.insertTransaction(13, 13, rowsN);

        RowKey rkO4 = new RowKey();
        rkO4.sequence = 20;
        rkO4.id = 4;
        RowKey[] rowsO = {rkO4};
        q.insertTransaction(14, 14, rowsO);

        RowKey rkP4 = new RowKey();
        rkP4.sequence = 20;
        rkP4.id = 4;
        RowKey[] rowsP = {rkP4};
        q.insertTransaction(15, 15, rowsP);


        q.print();
        q.sort();
        q.print();
        long time = System.currentTimeMillis() - startTime;
        System.out.println("*** exec time: " + time);
    }

    public static void test_most_urgent_operation_follow(QueueScheduler q, long startTime){


        //Main transaction with a row id = 1
        //This transaction will have one of its rows sequence incremented.
        //To check if the comparator chooses it as the most urgent.
        RowKey[] rows1 = new RowKey[3];
        RowKey r02 = new RowKey();
        r02.sequence = 20;
        r02.id = 60;
        rows1[1] = r02;
        RowKey r03 = new RowKey();
        r03.sequence = 20;
        r03.id = 61;
        rows1[2] = r03;
        RowKey r01 = new RowKey();
        r01.sequence = 20;
        r01.id = 2;
        rows1[0] = r01;
        q.insertTransaction(9, 10, rows1);

        //Update Transactions with 1 operation
        RowKey[] rows2 = new RowKey[1];
        RowKey r11 = new RowKey();
        r11.sequence = 20;
        r11.id = 2;
        rows2[0] = r11;
        q.insertTransaction(11, 12, rows2);

        RowKey[] rows3 = new RowKey[1];
        RowKey r21 = new RowKey();
        r21.sequence = 20;
        r21.id = 2;
        rows3[0] = r21;
        q.insertTransaction(13, 14, rows3);

        RowKey[] rows4 = new RowKey[1];
        RowKey r31 = new RowKey();
        r31.sequence = 20;
        r31.id = 2;
        rows4[0] = r31;
        q.insertTransaction(15, 16, rows4);

        q.sort();
        long endTime = System.currentTimeMillis() - startTime;
        q.print();
        System.out.println(" \\ \\ Execution time = " + endTime + " ms");

    }

    public static void test_most_urgent_operation(){

        long startTime = System.currentTimeMillis();
        QueueScheduler q = new QueueScheduler();

        //Main transaction with a row id = 1
        //This transaction will have one of its rows sequence incremented.
        //To check if the comparator chooses it as the most urgent.
        RowKey[] rows1 = new RowKey[3];
        RowKey r02 = new RowKey();
        r02.sequence = 20;
        r02.id = 50;
        rows1[1] = r02;
        RowKey r03 = new RowKey();
        r03.sequence = 20;
        r03.id = 51;
        rows1[2] = r03;
        RowKey r01 = new RowKey();
        r01.sequence = 20;
        r01.id = 1;
        rows1[0] = r01;
        q.insertTransaction(1, 2, rows1);

        //Update Transactions with 1 operation
        RowKey[] rows2 = new RowKey[1];
        RowKey r11 = new RowKey();
        r11.sequence = 20;
        r11.id = 1;
        rows2[0] = r11;
        q.insertTransaction(3, 4, rows2);

        RowKey[] rows3 = new RowKey[1];
        RowKey r21 = new RowKey();
        r21.sequence = 20;
        r21.id = 1;
        rows3[0] = r21;
        q.insertTransaction(5, 6, rows3);

        RowKey[] rows4 = new RowKey[1];
        RowKey r31 = new RowKey();
        r31.sequence = 20;
        r31.id = 1;
        rows4[0] = r31;
        q.insertTransaction(7, 8, rows4);

        q.sort();


        test_most_urgent_operation_follow(q, startTime);

    }

    public static void test_random(){

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


