/**
 * Created by rkaushik on 10/1/17.
 */
public class SortingAlgos {

    public static void main(String[] args)
    {
        int[] arr = {2,4,1,6,8,5,3,7};
        mergeSort(arr);

        for (int i=0;i<arr.length;i++)
        {
            System.out.println(arr[i]);
        }
    }


    public static void mergeSort(int[] arr)
    {
        int arrLength = arr.length;

        if(arrLength < 2)
            return;

        int mid = arrLength/2;
        int leftArrSize = mid;
        int rightArrSize = arrLength - mid;

        int[] left = new int[leftArrSize];
        int[] right = new int[rightArrSize];

        for (int i=0;i<leftArrSize;i++)
        {
            left[i] = arr[i];
        }
        for (int i=mid;i<arrLength;i++)
        {
            right[i - mid]=arr[i];
        }


        mergeSort(left);
        mergeSort(right);
        merge(left,right,arr);
    }

    private static void merge(int[] left, int[] right,int[] arr)
    {
        int i=0,j=0,k=0;

         while(i < left.length && j < right.length)
         {
            if(left[i] < right[j])
            {
                arr[k] = left[i];
                i++;
            }
             else if(left[i] > right[j])
            {
                arr[k]=right[j];
                j++;
            }
             k++;
         }

        //below loop for the leftover items
        while (i < left.length)
        {
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length)
        {
            arr[k] = right[j];
            j++;
            k++;
        }

    }
}
