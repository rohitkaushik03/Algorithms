package BinaryTree;

/**
 * Created by rkaushik on 11/11/16.
 */
public class BSTMain
{
    public static void main(String args[])
    {
        MyBST objBST = new MyBST();
        objBST.InsertNode(10);
        objBST.InsertNode(15);
        objBST.InsertNode(9);
        objBST.InsertNode(6);

        System.out.println(objBST.FindNode(10));
        System.out.println(objBST.FindNode(9));
        System.out.println(objBST.FindNode(6));
        System.out.println(objBST.FindNode(60));
    }
}
