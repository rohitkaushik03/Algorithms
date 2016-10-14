/**
 * Created by rkaushik on 10/13/16.
 */
public class KnapsackProblem {
    public static void main(String[] args)
    {
        int [] val = {3,7,2,9};
        int [] weight = {2,2,4,5};
        int TotalWeight=10;

        //int [] val = {1,4,5,7};
        //int [] weight = {1,3,4,5};
        //int TotalWeight=7;

        int output = knapsack(val,weight,TotalWeight);
        System.out.println(output);
    }

    public static int knapsack(int[] val,int[] weight, int TW)
    {
        int[][] Metrix= new int[weight.length][TW+1];
        int row=0;

        for (int r=0;r<weight.length;r++)
        {
            for (int c=0;c<=TW;c++)
            {
                if ((r-1)<0)
                {
                    row=0;
                }
                else
                {
                    row=r-1;
                }
                //if item weight is greater than total weight
                if (weight[r]>c)
                {
                    Metrix[r][c]=Metrix[row][c];
                }
                else
                {
                    Metrix[r][c]= Math.max(val[r]+ Metrix[row][c-weight[r]],Metrix[row][c]);
                }
            }
        }
        return Metrix[weight.length-1][TW];
    }
}
