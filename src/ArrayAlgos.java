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
        //int[] arr = {1,3,5,8,9,10};
        //finMinTicketsCost(arr);

        // int[] arr = {6, 2, 18};
        // int result = CountNumbers(arr);
        // System.out.println(result);

        //int[] arr={1,2,5,3};
        //int[] arr = {2,3,0,5};
        //MultiplicationElement(arr);

        //int[] arr = {0, 2, 1, 0, 1, 2};
        //int[] result =  dutchFlagProblem(arr);

        //String result = LookAndSayNumbers(4);
        //System.out.println(result);

        //int[] height = {2,1,5,6,2,3};
        //largestRectangleArea(height);

        //int[] arr = {1,2,3,3,3,3,4,5,5,6,7};
        //number25PercentTimes(arr);

        //multiple(20);
        //int[] arr = {2,3,6,7};
        //combinationSum(arr,7);

        //int[] arr = {-2,3,2,-1};
        //int[] arr = {-2,-3,4,-1,-2,1,5,-3};
        //maximumSumSubArray(arr);

        //int[] arr = {1, 4, 45, 6, 0, 19};
        //int[] arr = {1, 10, 5, 2, 7};
        //int result = smallestSubWithSum(arr,9);
        //System.out.println(result);

        /*int[][] input =  {
                { 0, 1, 1, 0},
                { 1, 1, 1, 1},
                { 1, 1, 1, 1},
                { 1, 1, 0, 0}
        };

        MaxRectangleAreaOf1s(input);*/

        //int[] arr = {0,1,0,3,12};
        //MoveZeroes(arr);

        //computeSum(15);

        String wordInput = "Hi How are you. Today payment very successfully i was able to do very payment successfully . Thank you.";
        String wordMatch = "payment very successfully";
        int result= SearchPattern(wordInput, wordMatch);
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

    //Find the kth largest element in an unsorted array.
    // Note that it is the kth largest element in the sorted order, not the kth distinct element.
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


    public static int[] MultiplicationElement(int[] arr)
    {
        //{2,3,5,0}
        //result would be {0,0,0,30}
        int totalMultiple = 1;
        int tmWithZero = 0;
        boolean isZeroExists=false;
        int[] result = new int[arr.length];

        for (int i=0;i< arr.length;i++)
        {
            if (arr[i] !=0)
            {
                totalMultiple = totalMultiple * arr[i];
            }
            else
            {
                isZeroExists=true;
            }
        }

        for (int i=0;i<arr.length;i++)
        {
            if (isZeroExists)
            {
                if (arr[i]!=0)
                {
                    result[i] =0;
                }
                else
                {
                    result[i] = totalMultiple;
                }
            }
            else
            {
                result[i] = totalMultiple/arr[i];
            }

        }
        return result;
    }

    public static int[] dutchFlagProblem(int[] arr)
    {
        //Given an array A[] consisting 0s, 1s and 2s, write a function that sorts A[].
        //The functions should put all 0s first, then all 1s and all 2s in last.
        int low=0;
        int high=2;
        int lowerIndex=0;
        int upperIndex=arr.length-1;
        int currentIndex = 0;
        int temp=0;

        while (currentIndex <= upperIndex)
        {
            if (arr[currentIndex] == low)
            {
                temp = arr[currentIndex];
                arr[currentIndex]=arr[lowerIndex];
                arr[lowerIndex] = temp;
                currentIndex++;
                lowerIndex++;
            }
            else if (arr[currentIndex] == high)
            {
                temp = arr[currentIndex];
                arr[currentIndex] = arr[upperIndex];
                arr[upperIndex] = temp;
                upperIndex--;
            }
            else
            {
                currentIndex++;
            }
        }

        return arr;
    }

    //The count-and-say sequence is the sequence of integers beginning as follows:
    //1, 11, 21, 1211, 111221, ...
    public static String LookAndSayNumbers(int n)
    {
        String result="11";
        int i=1;
        while (i<n)
        {
            StringBuilder sb = new StringBuilder();
            int count =1;
            for (int j=1;j<result.length();j++)
            {
                if (result.charAt(j)==result.charAt(j-1))
                {
                    count++;
                }
                else
                {
                    sb.append(count);
                    sb.append(result.charAt(j-1));
                }
            }

            sb.append(count);
            sb.append(result.charAt(result.length()-1));
            i++;
            result = sb.toString();
        }

        return result;
    }

    public static int largestRectangleArea(int[] height)
    {
        if (height == null || height.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<Integer>();

        int max = 0;
        int i = 0;

        while (i < height.length) {
            //push index to stack when the current height is larger than the previous one
            if (stack.isEmpty() || height[i] >= height[stack.peek()]) {
                stack.push(i);
                i++;
            } else {
                //calculate max value when the current height is less than the previous one
                int p = stack.pop();
                int h = height[p];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(h * w, max);
            }

        }

        while (!stack.isEmpty()) {
            int p = stack.pop();
            int h = height[p];
            int w = stack.isEmpty() ? i : i - stack.peek() - 1;
            max = Math.max(h * w, max);
        }

        return max;
    }

    //find an element in an array which is repeating more than or equal to 25% of the time.
    public static int number25PercentTimes(int[] arr)
    {

        //1,2,3,4,5,5,6,7

        int limit = arr.length/4;
        int count=1;
        int temp= arr[0];
        int max = 0;
        int major_element = arr[0];
        for (int i=1;i<arr.length;i++)
        {
            if (arr[i]==arr[i-1])
            {
                count++;
                temp = arr[i];
            }
            else
            {
                count = 1;
                if (count > max)
                {
                    max = count;
                    major_element = temp;
                }
            }
        }

        if (max >= limit)
            return major_element;
        else
            return 0;
    }

    public static void multiple(int number)
    {
        for (int i=1;i < number/3;i++)
        {
            if (number % i == 0)
            {
                int result = number/i;
                System.out.println(i + " * " + result);

                if (result % 2==0 && result != number)
                {
                    System.out.println(i + " * " + result/2 + " * 2");
                }
            }
        }
    }


    public static ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target)
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if(candidates == null || candidates.length == 0) return result;

        ArrayList<Integer> current = new ArrayList<Integer>();
        Arrays.sort(candidates);

        combinationSum(candidates, target, 0, current, result);

        return result;
    }

    public static void combinationSum(int[] candidates, int target, int j, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> result)
    {
        if(target == 0)
        {
            ArrayList<Integer> temp = new ArrayList<Integer>(curr);
            result.add(temp);
            return;
        }

        for(int i=j; i<candidates.length; i++)
        {
            if(target < candidates[i])
                return;

            curr.add(candidates[i]);
            combinationSum(candidates, target - candidates[i], i, curr, result);
            curr.remove(curr.size()-1);
        }
    }


    public static int maximumSumSubArray(int[] arr)
    {
        //maximum sum subarray
        //Input : [-2,3,2,-1]
        //Output: 5 from elements {3,2}
        int maxCurrentSum = arr[0];
        int maxGlobalSum = arr[0];

        for (int i=1;i<arr.length;i++)
        {
            maxCurrentSum = Math.max(arr[i],maxCurrentSum + arr[i]);

            if (maxCurrentSum > maxGlobalSum)
                maxGlobalSum = maxCurrentSum;
        }
        return maxGlobalSum;
    }

    public static int smallestSubWithSum(int[] arr, int x)
    {
        /*
        Given an array of integers and a number x, find the smallest subarray with sum greater than the given value
        Examples:
        arr[] = {1, 4, 45, 6, 0, 19}
        x  =  51
        Output: 3
        Minimum length subarray is {4, 45, 6}

        arr[] = {1, 10, 5, 2, 7}
        x  = 9
        Output: 1
        Minimum length subarray is {10}
        */

        int sum =0;
        int output = 0;
        int start = 0;
        for (int i=0;i<arr.length;i++)
        {
            if(arr[i] > x)
            {
                output = 1;
                return output;
            }
            sum = sum + arr[i];
            output++;
            if (sum > x)
            {
                while(sum > x)
                {
                    sum = sum - arr[start];
                    output--;
                    start++;
                }
            }
        }

        return output;
    }


    public static int MaxRectangleAreaOf1s(int[][] inputArr)
    {
        //Given a 2D matrix of 0s and 1s. Find largest rectangle of all 1s in this matrix.
    /*Input :   0 1 1 0
                1 1 1 1
                1 1 1 1
                1 1 0 0

    Output :  1 1 1 1
              1 1 1 1 */

    /*Maintain a temp array of same size as number of columns.
    * Copy first row to this temp array and find largest rectangular area
    * for histogram. Then keep adding elements of next row to this temp
    * array if they are not zero. If they are zero then put zero there.
            * Every time calculate max area in histogram.
    *
            * Time complexity - O(rows*cols)
    * Space complexity - O(cols) - if number of cols is way higher than rows
    * then do this process for rows and not columns.*/

         int nosOfRows = inputArr.length;
        int nosOfCols = inputArr[0].length;
        int area = 0;
        int maxArea = 0;
        int[] temp = new int[nosOfCols];

        for (int r = 0;r< nosOfRows;r++)
        {
          for(int c=0; c< nosOfCols; c++)
          {
            if (inputArr[r][c]==0)
                temp[c] = 0;
              else
                temp[c]= temp[c] + inputArr[r][c];
          }

           area =  largestRectangleArea(temp);

            if (area > maxArea)
                maxArea = area;

        }
        return  maxArea;
    }

    public static void MoveZeroes(int[] arr)
    {
        /*Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
        For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].*/

        int i=0;
        int j=0;

        while(j < arr.length)
        {
            if(arr[j]==0)
            {
                j++;
            }
            else
            {
                arr[i]=arr[j];
                j++;
                i++;
            }
        }

        while (i<=arr.length)
        {
            arr[i]=0;
            i++;
        }

    }

    public static void computeSum(int num)
    {
        //Print all possible sums of consecutive numbers with sum N
        //For e.g. Give N=15
        //output should be
        // 1+2+3+4+5
        //4+5+6
        //7+8
        int start=1,end=1,sum=1;

        while(start <= num/2)
        {
            if(sum<num)
            {
                end++;
                sum = sum+end;

            }
            else if(sum>num)
            {
                sum = sum-start;
                start++;
            }
            else if(sum==num)
            {
                for(int i=start;i<=end;i++)
                {
                    System.out.print(i + " + ");
                }
                System.out.println();
                sum = sum-start;
                start++;
            }
        }
    }

    // Problem Statement:
// Input Data: Hi How are you. Today i was able to do payment very successfully. Thank you. - TRUE
// Input Data: Hi How are you. Today i was able to do very payment successfully. Thank you. - TRUE
// Input Data: Hi How are you. Today i was able to do successfully payment very. Thank you. - TRUE
// Input Data: Hi How are you. Today i was payment able to do very successfully. Thank you. - FALSE

    // Match Data: payment very successfully
    public static int SearchPattern(String input, String match)
    {
        Map<String, Integer> pattern = new HashMap<String, Integer>();

        String[] patternArray = match.split(" ");

        int tokencount = 0;
        for(int i=0; i < patternArray.length; i++)
        {
            String token = patternArray[i];
            if(!pattern.containsKey(token))
            {
                pattern.put(token, 1);
            }
            else
            {
                pattern.put(token, pattern.get(token) + 1);
            }
            tokencount++;
        }

        String[] inputArray = input.split(" ");

        //loop through all the words
        //check if the word exists in the hashmap

        Map<String, Integer> temppattern = new HashMap<String, Integer>();
        DeepCopyMap(pattern, temppattern);

        int tempTokenCount = tokencount;

        int patterncount = 0;
        for(int i=0; i < inputArray.length; i++)
        {
            String token = inputArray[i];

            if(pattern.containsKey(token))
            {
                while(pattern.containsKey(token))
                {
                    int count = pattern.get(token);
                    if (count > 0)
                    {
                        pattern.put(token, count-1);
                        tokencount--;
                    }
                    else
                        break;

                    i++;
                    token = inputArray[i];
                }

                if(tokencount ==0)
                    patterncount++;

                pattern.clear();
                DeepCopyMap(temppattern, pattern);
                tokencount = tempTokenCount;
            }

        }
        return patterncount;

    }

    private static void DeepCopyMap(Map<String, Integer> a, Map<String, Integer> b)
    {
        b.clear();
        for(Map.Entry<String, Integer> entry : a.entrySet())
            b.put(entry.getKey(), entry.getValue());
    }
}

