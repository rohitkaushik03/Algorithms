package BinaryTree;

import LinkedList.Node;

import java.util.Stack;

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

    public boolean FindNode(int data)
    {
        BSTNode current = root;

        while(current != null)
        {
            if (data == current.data) {
                return true;
            } else if (data > current.data) {
                current = current.right;
            } else if (data < current.data) {
                current  =current.left;
            }

        }
        return false;
    }

    public void CallInOrderTraversal()
    {
        InOrderTraversal(root);
    }

    private void InOrderTraversal(BSTNode root)
    {
        //InOrder traversal means we have to traverse Left root Right
        //without recursion, using stack, Time Complexity O(n), Space Complexity is also O(n)
        if (root == null)
            return;
        Stack<BSTNode> stk = new Stack<BSTNode>();
        while (true)
        {
            if (root != null)
            {
                stk.push(root);
                root = root.left;
            }
            else
            {
                if (stk.isEmpty())
                    break;
                root = stk.pop();
                System.out.println(root.data);
                root = root.right;
            }
        }
    }
}
