package HashTablesAlgos;

import java.util.HashSet;
import java.util.Hashtable;

/**
 * Created by rkaushik on 11/1/16.
 */
public class HashAlgos
{

    public static void main(String args[])
    {
        //boolean result = checkStringUniqueCharacter("I am Rohit");
        //System.out.println(result);

        boolean result =  checkPermutation("kaushik","kihsuak");
        System.out.println(result);
    }


    public static boolean checkStringUniqueCharacter(String strInput)
    {
        //Implement an algorithm to determine if a string has all unique characters
        char[] chrInput = strInput.toCharArray();
        HashSet hs = new HashSet();
        boolean isUnique;

        for (char chr: chrInput)
        {
            isUnique = hs.add(chr);
            if (isUnique != true )
                return false;
        }
        return true;
    }

    public static boolean checkPermutation(String str1, String str2)
    {
        //Given two strings, write a method to decide if one is a permutation of the other.

        if (str1.toCharArray().length != str2.toCharArray().length)
            return false;

        Hashtable<Character,Integer> ht = new Hashtable<Character,Integer>();
        Hashtable<Character,Integer> ht2 = new Hashtable<Character,Integer>();

        int cnt=1;
        for(char chr : str1.toCharArray())
        {
            if(ht.containsKey(chr))
                ht.put(chr,++cnt);
            else
                ht.put(chr,1);
        }
        cnt=1;

        for(char chr : str2.toCharArray())
        {
            if(ht2.containsKey(chr))
                ht2.put(chr,++cnt);
            else
                ht2.put(chr,1);
        }

        for(char chr : ht.keySet())
        {
            if (ht2.containsKey(chr))
            {
                int htval = ht.get(chr);
                int ht2val = ht2.get(chr);

                if (htval !=ht2val)
                {
                    return false;
                }
            }
        }
        return true;

    }

}
