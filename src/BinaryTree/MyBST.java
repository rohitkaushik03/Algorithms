package BinaryTree;

import LinkedList.Node;
import com.sun.tools.javac.util.Pair;

import java.util.*;


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
        System.out.println("---Invert Binary Tree---");
        InvertBinaryTree(root);

        System.out.println("---Print Tree In Vertical Order---");
        PrintTreeInVerticalOrder(root);

        System.out.println("---Inorder Traversal using stack---");
        InOrderTraversal(root);

        System.out.println("---Morris traversal---");
        MorrisTraversal(root);

    }

    private void InOrderTraversal(BSTNode root)
    {
        //InOrder traversal means we have to traverse Left - root - Right
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

    //Given a binary tree, print it in vertical order path.
    public void PrintTreeInVerticalOrder(BSTNode root)
    {
        if (root == null)
            return;

        //ArrayList to store the Node elements
        ArrayList<Integer> list;
        //TreeMap to hold the Level and Node elements on that level
        TreeMap<Integer,ArrayList<Integer>> map = new TreeMap<Integer, ArrayList<Integer>>();
        Queue<Pair<BSTNode,Integer>> q = new LinkedList<Pair<BSTNode, Integer>>();

        //keep track of horizontal distance from root.
        int hd=0;
        //add the root node to the queue
        q.add(new Pair<BSTNode, Integer>(root,hd));

        while (!q.isEmpty())
        {
            //pop the element from queue
            Pair<BSTNode,Integer> temp = q.poll();
            //fetch the horizontal distance from q
            hd = temp.snd;
            //fetch the node from q
            BSTNode node = temp.fst;

            if (!map.containsKey(hd))
            {
                list = new ArrayList<Integer>();
            }
            else
            {
                list = map.get(hd);
            }

            list.add(node.data);
            map.put(hd,list);

            //Move to the left node
            if(node.left !=null)
            {
                q.add(new Pair<BSTNode, Integer>(node.left,hd-1));
            }
            if (node.right != null)
            {
                q.add(new Pair<BSTNode, Integer>(node.right,hd+1));
            }
        }

        /// Traverse the map and print nodes at every horizontal distance (hd)
        Set<Integer> set = map.keySet();
        for(int key:set)
        {
            System.out.print(map.get(key));
        }
    }

    //Invert or mirror the binary tree
    public void InvertBinaryTree(BSTNode root)
    {
        if (root == null)
            return;

        Queue<BSTNode> q = new LinkedList<BSTNode>();
        q.add(root);

        while (!q.isEmpty())
        {
            BSTNode node  = q.poll();

            BSTNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if (node.left != null) {
                q.add(node.left);
            }
            if(node.right != null) {
                q.add(node.right);
            }
        }
    }
}
