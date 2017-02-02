package BitManipulation;

/**
 * Created by rkaushik on 2/1/17.
 */
public class BitAlgos {

    public static void main(String[] args)
    {
        int[] arr = {3,5,6,3,5,6,7};
        int result = SingleNumber(arr);
        System.out.println(result);
    }

    public static int SingleNumber(int[] arr)
    {
        //Given an array of integers, every element appears twice except for one. Find that single one.
        int result=0;
        for (int i=0;i<arr.length;i++)
        {
            //we will do the xor operation on arrays each elements
            result = result ^ arr[i];
        }
        return result;
    }

}
