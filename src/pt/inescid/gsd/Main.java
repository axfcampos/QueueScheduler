package pt.inescid.gsd;


public class Main {

    public static void main(String[] args) {
	// write your code here



        test_most_urgent_operation();

    }


    public static void test_most_urgent_operation(){


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
        q.print();

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
