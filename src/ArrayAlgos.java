import java.util.HashSet;
import java.util.Stack;
import java.util.*;

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

        //boolean result = isUniqueCharacter("america");

        //int[] arr = {98,23,54,12,20,7,27};
        //NextGreatestElement(arr);

        //int[] arr = {1,2,3,4,5};
        //leftRotateArray(arr, 4);

        //int[] arr = {3,2,1,5,6,4};
        //kthLargestElement(arr,2);

        //boolean result =  hasSumExists(arr, 10);

        //String result= getMaximumTime(1,8,3,2);
        //System.out.println(result);

        //int[] arr  =  {1,5,6,9,28,30};
        //finMinTicketsCost(arr);

        int[] arr = {6, 2, 18};
        int result = CountNumbers(arr);
        System.out.println(result);
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

    //Implement an algorithm to determine if a string has all unique characters. What if
    //you cannot use additional data structures?
    public static boolean isUniqueCharacter(String str)
    {
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

    //Given an array of integers(positive or negative), print the next greater element of all elements in the array.
    // If there is no greater element then print null.
    public static void NextGreatestElement(int[] arr)
    {
        Stack<Integer> stk = new Stack<Integer>();
        for (int i=0;i < arr.length;i++)
        {
            while(!stk.empty() && arr[i] > stk.peek()) {

                System.out.println("Next greater element of " + stk.pop() + " is " + arr[i]);
            }
            stk.push(arr[i]);
        }

        while(!stk.empty())
        {
        System.out.println("Next greater element of " + stk.pop() + " is null");
        }
    }

    //Given an array of  integers and a number,d , perform d  left rotations on the array.
    // Then print the updated array as a single line of space-separated integers.
    public static void leftRotateArray(int[] arr,int d)
    {
        for (int i=1;i<=d;i++)
        {
            int temp = arr[0];
            int j;
            for (j=0;j<arr.length -1;j++)
            {
                arr[j] = arr[j+1];
            }
            arr[j] = temp;
        }

        for (int p = 0;p < arr.length;p++)
        {
            System.out.print(arr[p] + " ");
        }
    }

    //Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
    //For example, given [3,2,1,5,6,4] and k = 2, return 5.
    public static int kthLargestElement(int[] arr,int k)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k);

        for(int i : arr)
        {
            //Inserts in Priority queue
            pq.offer(i);

            //if priority queue size is greater than k then remove one element
            if (pq.size()>k)
            {
                pq.poll();
            }
        }
        System.out.println(pq.peek());
        return pq.peek();
    }

    //Function should return true if the given sum exists in the array in the continuous sequence
    //For e.g. if the sum is 9, {1,5,6,3,10,2}, it should return true as the elements in sequence is 6,3
    public static boolean hasSumExists(int[] arr, int total)
    {
        int tempSum = 0,count=0;
        for (int i=0;i<arr.length;i++)
        {
            if (arr[i] == total)
                return true;

            tempSum = tempSum + arr[i];
            while (tempSum > total)
            {
                tempSum = tempSum - arr[count];
                count++;
            }
            if (tempSum == total)
            {
                return true;
            }
        }
        return false;
    }

    //Given four digits find the maximum valid time that can be displayed on a digital clock(24 hours format)
    //using those digits.
    public static String getMaximumTime(int A,int B,int C, int D)
    {
        int firstDigit=0;
        int secondDigit=0;
        int thirdDigit=0;
        int fourDigit=0;

        List<Integer> lst = new ArrayList<Integer>();
        lst.add(A);
        lst.add(B);
        lst.add(C);
        lst.add(D);

        for(int i: lst)
        {
            if(i<=2 && i > firstDigit)
            {
                firstDigit=i;
            }
        }

        lst.remove((Object)firstDigit);


        for(int i: lst)
        {
            if(i<4 && i > secondDigit)
            {
                secondDigit=i;
            }
        }
        lst.remove((Object)secondDigit);

        for(int i: lst)
        {
            if(i <= 5 && i > thirdDigit)
            {
                thirdDigit=i;
            }
        }
        lst.remove((Object)thirdDigit);

        fourDigit = lst.get(0);

        return "" + firstDigit + secondDigit + ":" + thirdDigit + fourDigit;

    }

    public static int finMinTicketsCost(int[] a)
    {
        boolean[] dayTrip = new boolean[31]; // note: initializes to false
        for (final int day : a) {
            dayTrip[day] = true;
        }
        int[] minCostDP = new int[31];
        minCostDP[0] = 0; // technically redundant
        for (int d = 1; d <= 30; d++)
        {
            if (! dayTrip[d]) {
                minCostDP[d] = minCostDP[d-1];
                continue;
            }
            int minCost;
            // Possibility #1: one-day pass on day d:
            minCost = minCostDP[d-1] + 2;
            // Possibility #2: seven-day pass ending on or after day d:
            for (int prevD = Math.max(0, d - 7); prevD <= d - 4; ++prevD)
            {
                minCost = Math.min(minCost, minCostDP[prevD] + 7);
            }
            // Possibility #3: 30-day pass for the whole period:
            minCost = Math.min(minCost, 25);

            minCostDP[d] = minCost;
        }
        return minCostDP[30];
    }

    public static int CountNumbers(int[] arr)
    {
        int div;
        List<Integer> lst = new ArrayList<Integer>();
        for(int num:arr)
            lst.add(num);

        for(int i=0;i<lst.size();i++)
        {
            for(int j=i+1;j<lst.size();j++)
            {
                if(lst.get(i)>lst.get(j))
                    div=lst.get(i)/lst.get(j);
                else
                    div = lst.get(j)/lst.get(i);

                if(!lst.contains(div))
                    lst.add(div);
            }
        }
        return lst.size();
    }
}
