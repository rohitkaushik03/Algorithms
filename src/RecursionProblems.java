import com.sun.tools.doclets.internal.toolkit.util.DirectoryManager;

/**
 * Created by rkaushik on 6/30/17.
 */
public class RecursionProblems {

    public static void main(String args[])
    {
        //combine("wxyz");
        getFilesCount("/Users/rkaushik");
    }

    public static void combine(String str)
    {
        int length = str.length();
        char[] instr = str.toCharArray();
        StringBuilder outstr = new StringBuilder();

        doCombine(instr,outstr,length,0,0);
    }

    public static void doCombine(char[] instr,StringBuilder outstr,int length,int level,int start)
    {
        for (int i=start;i<length;i++)
        {
            outstr.append(instr[i]);
            System.out.println(outstr);

            if (i<length -1)
            {
                doCombine(instr,outstr,length,level+1,i+1);
            }

            outstr.setLength(outstr.length() -1);
        }
    }

    public static int getFilesCount(String inputDir)
    {
        int count =0;

        String dir = DirectoryManager.getDirectoryPath(inputDir);

        return count;

    }
}
