import java.util.HashSet;
import java.util.Hashtable;

/**
 * Created by rkaushik on 9/30/16.
 */
public class Hello {

    public static void main(String args[])
    {
        System.out.println("Hello world");
        //TestHashTable();
        TestHashSet();
    }

    public static  void TestHashTable()
    {
        Hashtable<Integer,String> ht = new Hashtable<Integer, String>();
        ht.put(1,"Rohit");
        ht.put(2,"Anil");
        ht.put(3,"Venkat");
        ht.put(4,"Piyush");
        ht.put(5,"Francyne");
        ht.put(6,"Ramola");

        //for each key in ht
        for(Integer i: ht.keySet())
        {
            System.out.println(ht.get(i));
        }

    }

    public static void TestHashSet()
    {
        HashSet<String> hs = new HashSet<String>();
        boolean result = hs.add("Apple");
        System.out.println(result);

        boolean result1 = hs.add("Apple");
        System.out.println(result1);

        //hs.add("Orange");
        //hs.add("grapes");
        //hs.add("grapes");

        //for(String str: hs)
          //  System.out.println(str);

    }

    }
