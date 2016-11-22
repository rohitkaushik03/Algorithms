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
        System.out.println("---Inorder Traversal using stack---");
        InOrderTraversal(root);

        System.out.println("---Morris traversal---");
        MorrisTraversal(root);

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

    public void MorrisTraversal(BSTNode root)
    {
        BSTNode current = root;

        while(current != null)
        {

            if (current.left == null)
            {
                System.out.println(current.data);
                current = current.right;
            }
            else
            {
                //find predecessor
                BSTNode predecessor = current.left;
                //to find predecessor keep going right
                while(predecessor.right != current && predecessor.right !=null)
                {
                    predecessor = predecessor.right;
                }
                //if right path is null then set the right link of predecessor to current
                if (predecessor.right == null)
                {
                    predecessor.right = current;
                    current = current.left;
                }
                else
                { //that means we already visited left side now move to the right after visiting current
                    predecessor.right = null;
                    System.out.println(current.data);
                    current = current.right;
                }


            }
        }
    }
}
