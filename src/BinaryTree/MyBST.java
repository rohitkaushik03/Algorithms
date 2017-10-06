package BinaryTree;


import LinkedList.Node;
import com.sun.tools.javac.util.Pair;
import sun.tools.tree.WhileStatement;


import java.util.*;


/**
 * Created by rkaushik on 11/10/16.
 */
public class MyBST
{
    BSTNode root=null;

    public static void main(String[] args)
    {
        BinaryTree.Node root = new BinaryTree.Node(10);
        root.left = new BinaryTree.Node(9);
        root.right = new BinaryTree.Node(8);

        root.left.left = new BinaryTree.Node(7);
        root.left.right = new BinaryTree.Node(6);

        root.right.left = new BinaryTree.Node(5);
        root.right.right = new BinaryTree.Node(4);

        connectToRightNode(root);

    }

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
        int height = getHeightOfTree(root);
        System.out.println(height);

        System.out.println("---BFS order Traversal using Queue---");
        BFSTraversal(root);

        System.out.println("---Post order Traversal using stack---");
        PostOrderTraversal(root);

        System.out.println("---Inorder Traversal using stack---");
        PreOrderTraversal(root);

        findChildBelowGivenLevel(root,1);

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

    private void PreOrderTraversal(BSTNode root)
    {
        //PreOrder traversal means we have to traverse root - Left- Right
        //without recursion, using stack, Time Complexity O(n), Space Complexity is also O(n)
        if(root == null)
            return;

        Stack<BSTNode> stk = new Stack<BSTNode>();
        stk.push(root);
        while (true)
        {
            if (!stk.isEmpty()) {
                root = stk.pop();
                System.out.println(root.data + " -> ");
                //We are pushing right child first, so it will be processed after left subtree as Stack is LIFO.
                if (root.right != null)
                    stk.push(root.right);

                if (root.left != null)
                    stk.push(root.left);
            }
            else
            {
                break;
            }
        }
    }

    private void PostOrderTraversal(BSTNode root)
    {
        //Post Order traversal - left - right - root
        //We have to use two Stacks for Post order traversal
        if (root == null)
            return;
        Stack<BSTNode> stk1 = new Stack<BSTNode>();
        Stack<BSTNode> stk2 = new Stack<BSTNode>();
        stk1.add(root);

        while(!stk1.isEmpty())
        {
            root = stk1.pop();
            stk2.push(root);

            if(root.left !=null)
                stk1.push(root.left);

            if (root.right !=null)
                stk1.push(root.right);
        }

        while (!stk2.isEmpty())
        {
            root = stk2.pop();
            System.out.print(root.data + "->");
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

    //Breadth First Traversal
    public void BFSTraversal(BSTNode root)
    {
        if (root == null)
            return;
        Queue<BSTNode> q = new LinkedList<BSTNode>();
        q.add(root);
        while(true) {
            if (!q.isEmpty()) {
                root = q.poll();

                System.out.print(root.data + " -> ");

                if (root.left != null)
                    q.add(root.left);

                if (root.right !=null)
                    q.add(root.right);
            } else {
                return;
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

    public int findChildBelowGivenLevel(BSTNode root, int level)
    {
        return findUtil(root,0,level,0);
    }

    public int findUtil(BSTNode root,int current,int level, int count)
    {
        if (root==null)
            return 0;
        if (current > level)
            count++;

        findUtil(root.left,current+1,level,count);
        findUtil(root.right,current+1,level,count);

        return count;
    }

    private void PrintBoundaries(BSTNode root)
    {

        if (root == null)
            return;
        int level=0;
        //we store the level and List of Nodes on that level
        TreeMap<Integer,ArrayList<Integer>> map = new TreeMap<Integer, ArrayList<Integer>>();
        //Queue to keep track of level and Node
        Queue<Pair<BSTNode,Integer>> q = new LinkedList<Pair<BSTNode, Integer>>();
        q.add(new Pair<BSTNode, Integer>(root,level));

    }

    public static int getHeightOfTree(BSTNode root)
    {
        if(root==null)
            return 0;

        int height=0;
        int nodeCount=0;
        Queue<BSTNode> q = new LinkedList<BSTNode>();
        q.add(root);

        while(true)
        {
            if (!q.isEmpty())
            {
                nodeCount=q.size();

                while(nodeCount > 0)
                {
                    BSTNode node = q.poll();

                    if (node.left != null)
                        q.add(node.left);

                    if (node.right != null)
                        q.add(node.right);

                    nodeCount--;

                }
                height++;

            }
            else
                return height;
        }

    }

    /*Connect nodes at same level
    Write a function to connect all the adjacent nodes at the same level in a binary tree. Structure of the given Binary Tree node is like following.

    struct node{
    int data;
    struct node* left;
    struct node* right;
    struct node* nextRight;*/

    public static void connectToRightNode(BinaryTree.Node root)
    {
        if (root == null)
            return;

        Queue<BinaryTree.Node> q = new LinkedList<BinaryTree.Node>();
        q.add(root);
        //to mark the next level
        q.add(null);

        while(!q.isEmpty())
        {

            BinaryTree.Node node = q.poll();

            if (node != null)
            {
                node.nextRight = q.peek();


                if (node.left != null)
                    q.add(node.left);

                if (node.right != null)
                    q.add(node.right);
            }
                // if queue is not empty, push NULL to mark
                // nodes at this level are visited
            else if (!q.isEmpty())
            {
                    q.add(null);
            }

        }

    }
}

