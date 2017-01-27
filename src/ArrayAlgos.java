import java.util.HashSet;

/**
 * Created by rkaushik on 10/4/16.
 */
public class ArrayAlgos {

    public static void main(String args[])
    {

       //calling get getMajorityElement function
//       int[] arr = { 2, 6, 2, 2, 6, 2, 2, 8, 2, 1 };
//       int majority = getMajorityElement(arr);
//       System.out.println("Majority element is : " + majority);

        //calling get stairSearch function
        int[][] mat =  {   { 2, 6, 7, 11},
                           { 3, 8, 10, 12},
                           { 4, 9, 11, 13},
                           { 5, 15, 16, 18}
                       };

        //System.out.println(stairSearch(mat, 4, 16));
        //String output = ReverseString("I am the best");
        //System.out.println(output);

        //String output1 = ReverseString2("Hello World");
        //System.out.println(output1);

        //spiralPrinting(4,4,mat);

     boolean result = isUniqueCharacter("america");


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

    public static boolean stairSearch(int[][] matrix,int n, int item)
    {
        //Given a sorted matrix where rows and the columns are sorted.
        //Write an algorithm to search an element in the matrix in O(n)

        int r = 0; //rows
        int c = n-1; //cols

        if (item < matrix[0][0] || item > matrix[n-1][n-1])
        {
            return false;
        }

        while (r < n && c >= 0)
        {
             if (item < matrix[r][c])
             {
                 c--;
             }
             else if(item > matrix[r][c])
             {
                 r++;
             }
             else
             {
              return true;
             }

        }
        return false;
    }

    public static String ReverseString(String strInput)
    {
        char[] chrInput = strInput.toCharArray();
        char[] chroutput = new char[chrInput.length];

        int j=0;
        for (int i=chrInput.length -1;i >= 0;i--)
        {
            chroutput[j]=chrInput[i];
            j++;
        }
        String strOuput = new String(chroutput);
        return strOuput;
    }

    public static String ReverseString2(String strInput)
    {
        //The only "gotcha" is to try to do it in place
        char[] chrInput = strInput.toCharArray();
        int start = 0;
        int end = chrInput.length - 1;

        while(start < end)
        {
            swapChar(start, end, chrInput);
            start ++;
            end--;
        }
        String strOutput = new String(chrInput);
        return strOutput;
    }

    private static void swapChar(int start, int end,char[] chrInput)
    {
        char temp = chrInput[start];
        chrInput[start] = chrInput[end];
        chrInput[end] = temp;
    }

    public static void spiralPrinting(int tr, int tc, int arr[][])
    {
        /* Given a 2D array, print it in spiral form. See the following examples.

        Input:
        1    2   3   4
        5    6   7   8
        9   10  11  12
        13  14  15  16
        Output:
        1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10 */

        //we will take two pointers starting row(r) and ending row (er)
        //and we will take two pointers for columns as well starting column(c) and ending column (ec)
        int r=0,er=tr-1,c=0, ec = tc-1, i=0;

        while (r < er && c < ec)
        {
            //print first row
            for (i=c;i<=ec;i++)
            {
                System.out.println(arr[r][i]);
            }
            r++;

            //print last column of each row
            for (i=r;i<=er;i++)
            {

                System.out.println(arr[i][ec]);
            }
            ec--;

            //print last row all columns in ascending order

            for (i=ec;i>=c; i--)
            {
                System.out.println(arr[er][i]);
            }
            er--;

            //print the first column for remaining rows
            for (i=er;i>=r;i--)
            {
                System.out.println(arr[i][c]);
            }
            c++;

        }
    }

    public static boolean isUniqueCharacter(String str)
    {
        //Implement an algorithm to determine if a string has all unique characters. What if
        //you cannot use additional data structures?
        if (str.length() > 256)
            return false;
        boolean[] charset = new boolean[256];
        for (int i=0;i<str.length();i++) {
            int val = str.charAt(i);

            if (charset[val])
                //means character already exists
                return false;
            else
                charset[val] = true;
        }
        return true;
    }
}
