package BinaryTree;

/**
 * Created by rkaushik on 11/10/16.
 */
public class MyBST
{
    BSTNode root=null;

    public void InsertNode(int data) {
        BSTNode newNode = new BSTNode(data);

        if (root == null) {
            root = newNode;
            return;
        }
        BSTNode current = root;
        BSTNode parent;

        while (true)
        {
            parent = current;

            if (data < current.data) {
                current = current.left;
                if (current == null) {
                    parent.left = newNode;
                    return;
                }
            } else if (data > current.data) {
                current = current.right;
                if (current == null) {
                    parent.right = newNode;
                    return;
                }
            }
        }
    }
}
