package HashTablesAlgos;

import java.util.HashSet;

/**
 * Created by rkaushik on 11/1/16.
 */
public class HashAlgos
{

    public static void main(String args[])
    {
        boolean result = checkStringUniqueCharacter("I am Rohit");
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

}
