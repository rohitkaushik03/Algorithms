/**
 * Created by rkaushik on 10/4/16.
 */
public class ArrayAlgos {

    public static void main(String args[])
    {

       int[] arr = { 2, 6, 2, 2, 6, 2, 2, 8, 2, 1 };
       int majority = getMajorityElement(arr);
       System.out.println("Majority element is : " + majority);
    }

    public static Integer getMajorityElement(int[] arr)
    {

        int count=0;
        int candidate=0;

        for (int i=0;i<arr.length;i++)
        {
            if (count==0)
            {
                candidate=arr[i];
                count++;
            }
            else
            {
                if (candidate==arr[i]){
                    count++;
                }
                else
                {
                    count--;
                }
            }
        }

        if (count==0)
        {
            return null;
        }
        else
        {
            count=0;
            for (int i = 0; i < arr.length; i++)
            {
                if (candidate == arr[i])
                {
                    count++;
                }
            }
            if (count > arr.length / 2)
            {
                return candidate;
            }
        }

        return null;

    }
}
