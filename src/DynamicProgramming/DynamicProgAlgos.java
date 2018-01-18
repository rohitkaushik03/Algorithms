package DynamicProgramming;

/**
 * Created by rkaushik on 8/17/17.
 */
public class DynamicProgAlgos {

    public static int n = 3;
    public static void main(String[] args)
    {
        int  mat[][] = { {1, 2, 9},
                         {5, 3, 8},
                         {4, 6, 7} };
        System.out.println("Length of the longest path is " +
                finLongestOverAll(mat));
    }

    // Function that returns longest increasing sequence in 2d array
    // beginning with mat[i][j]
    // This function mainly uses lookup table dp[n][n]
    public static int findLongestFromACell(int i, int j, int mat[][], int dp[][])
    {
        // Base case
        if (i<0 || i>=n || j<0 || j>=n)
            return 0;

        // If this subproblem is already solved
        if (dp[i][j] != -1)
            return dp[i][j];

        // Since all numbers are unique and in range from 1 to n*n,
        // there is atmost one possible direction from any cell
        if (j<n-1 && ((mat[i][j] +1) == mat[i][j+1]))
            return dp[i][j] = 1 + findLongestFromACell(i,j+1,mat,dp);

        if (j>0 && (mat[i][j] +1 == mat[i][j-1]))
            return dp[i][j] = 1 + findLongestFromACell(i,j-1,mat,dp);

        if (i>0 && (mat[i][j] +1 == mat[i-1][j]))
            return dp[i][j] = 1 + findLongestFromACell(i-1,j,mat,dp);

        if (i<n-1 && (mat[i][j] +1 == mat[i+1][j]))
            return dp[i][j] = 1 + findLongestFromACell(i+1,j,mat,dp);

        // If none of the adjacent fours is one greater
        return dp[i][j] = 1;
    }

    // Function that returns length of the longest path
    // beginning with any cell
    static int finLongestOverAll(int mat[][])
    {
        // Initialize result
        int result = 1;

        // Create a lookup table and fill all entries in it as -1
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                dp[i][j] = -1;

        // Compute longest path beginning from all cells
        for (int i=0; i<n; i++)
        {
            for (int j=0; j<n; j++)
            {
                if (dp[i][j] == -1)
                    findLongestFromACell(i, j, mat, dp);

                //  Update result if needed
                result = Math.max(result, dp[i][j]);
            }
        }

        return result;
    }

    public static void longestPalindromSubStr(String str)
    {
        int strLen = str.length();
        boolean[][] dp = new boolean[strLen][strLen];
        int maxLength=1;

        //all substring of Length 1 are palindromes
        for (int i=0;i< strLen;i++)
            dp[i][i] = true;

        //check for substring of length 2

        for (int i=0;i< strLen;i++)
        {
            if(str.charAt(i) == str.charAt(i+1))
            {
                dp[i][i+1]=true;
                maxLength=2;
            }
        }



    }

}
