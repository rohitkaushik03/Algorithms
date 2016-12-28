package DesignProblems;


import java.util.Hashtable;

/**
 * Created by rkaushik on 11/22/16.
 */
public class clsMemDB implements IMemDB
{

    Hashtable<String,Integer> ht = new Hashtable<String,Integer>();
    Hashtable<Integer,Integer> hashCount = new Hashtable<Integer, Integer>();

    public void set(String name, Integer value)
    {
        /*
        We have to store the key value like
         a-10
         b-15
         a-15

         We also want to know if value exists multiple times what is the count of the same
        */

        int count=1;
        if (ht.containsValue(value))
        {
            count=hashCount.get(value);
            hashCount.put(value,++count);
        }
        else
        {
            hashCount.put(value,count);
        }

        ht.put(name,value);
    }

    public int get(String name)
    {
        if (ht.containsKey(name))
        {
            int value= ht.get(name);
            return value;
        }
        return 0;
    }

    public void Delete(String name)
    {

        if (ht.containsKey(name))
        {
            //15  - 2
            if (hashCount.containsKey(ht.get(name)))
            {
                int countValue = hashCount.get(ht.get(name));
                hashCount.put(ht.get(name),countValue -1);
            }
            ht.remove(name);
        }
    }
    public int getCount(Integer value)
    {
        if (hashCount.containsKey(value))
        {
            int result= hashCount.get(value);
            return result;
        }
        return 0;
    }

}
