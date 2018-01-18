package HashTablesAlgos;

import java.util.HashMap;
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

        //boolean result =  checkPermutation("kaushik","kihsuak");

        String result = bullsAndCowsGame("1807","7810");
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

    public static int cooldownProblem(int[] arr , int cooldownTime)
    {

        //Input array  = {1,2,1,3} and cool down time = 2
        //So there should be a cool down time between two same task
        //{1,2,"",1,3} output is 5

        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        int total=0;

        for (int i=0;i<arr.length;i++)
        {
            if (map.containsKey(arr[i]))
            {
                int expected=map.get(arr[i]) + cooldownTime + 1;

                if (expected > total)
                {
                 total = expected;
                }
                else
                    total ++;
            }
            else
                total++;

            map.put(arr[i],total);
        }
        return total;
    }


    /*
    You are playing the following Bulls and Cows game with your friend: You write down a number and
    ask your friend to guess what the number is. Each time your friend makes a guess, you provide a hint that
    indicates how many digits in said guess match your secret number exactly in both digit and position (called "bulls")
    and how many digits match the secret number but locate in the wrong position (called "cows").
    Your friend will use successive guesses and hints to eventually derive the secret number.

    For example:
    Secret number: "1807"
    Friend's guess: "7810"

    Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)
    Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls
    and B to indicate the cows. In the above example, your function should return "1A3B".
    */
    public static String bullsAndCowsGame(String secret, String guess)
    {
        int countBulls=0;
        int countCows=0;

        HashMap<Character,Integer> map = new HashMap<Character, Integer>();

        //count Bulls
        for(int i=0;i<secret.length();i++)
        {
            char s = secret.charAt(i);
            char g = guess.charAt(i);

            if(s==g){
                countBulls++;
            }
            else{
                if(map.containsKey(s))
                {
                    int freq = map.get(s);
                    freq++;
                    map.put(s,freq);
                }
                else{
                    map.put(s,1);
                }
            }
        }

        //count cows
        for(int i=0;i<secret.length();i++)
        {
            char s = secret.charAt(i);
            char g = guess.charAt(i);

            if(s!=g){
                if(map.containsKey(g)){
                    countCows++;
                   int freq = map.get(g);
                    if(freq==1)
                    {
                        map.remove(g);
                    }
                    else {
                        freq--;
                        //update the freq in the map
                        map.put(g, freq);
                    }
                }
            }
        }

        return countBulls + "Bulls" + countCows + "Cows";
    }
}
