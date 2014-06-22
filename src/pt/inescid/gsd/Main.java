package pt.inescid.gsd;

import pt.inescid.gsd.k.K_Seq;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

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




//        Set<RowKey> set = new HashSet<RowKey>();
//        set.add(new RowKey());
//
//        //Queue
//        QueueScheduler q = new QueueScheduler();
//        q.insertTransaction(1, set.toArray(new RowKey[0]));
//
//        q.print();
//        q.sort();
//        q.print();

        TreeMap<Integer, String> map = new TreeMap<Integer, String>();

        map.put(7, "a");
        map.put(2, "b");
        map.put(3, "c");
        map.put(4, "e");
        map.put(5, "f");
        map.put(6, "g");

        System.out.println(map.firstKey() + "   " + map.lastKey());

        map.put(1, "lol");

        System.out.println(map.firstKey() + "   " + map.lastKey());

    }

}
