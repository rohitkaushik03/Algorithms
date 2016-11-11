package BinaryTree;

/**
 * Created by rkaushik on 11/10/16.
 */
public class MyBST
{
    BSTNode root=null;

    public void InsertNode(int data)
    {
        if (root == null)
        {
            root = new BSTNode(data);
            root.right = null;
            root.left = null;
        }
    }
}
