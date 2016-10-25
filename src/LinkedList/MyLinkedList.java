package LinkedList;

/**
 * Created by rkaushik on 10/24/16.
 */
public class MyLinkedList
{

    Node head=null;
    Node tail=null;

    public void Add(int data)
    {
        Node temp = new Node(data);

        if (head==null)
        {

            head=temp;
            tail=temp;
        }
        else
        {
            tail.next=temp;
            tail=temp;
        }
    }

    public void AddInFront(int data)
    {
        Node newNode = new Node(25);

        newNode.next = head;
        head = newNode;

    }

    public void AddInMiddle(int newdata,int addAfterData)
    {
        Node newNode = new Node(newdata);
        Node currentNode = head;

        while(currentNode != null)
        {
            if (currentNode.data == addAfterData)
            {
                newNode.next=currentNode.next;
                currentNode.next=newNode;
            }
            currentNode=currentNode.next;
        }


    }
    public void PrintList()
    {
        Node nd = head;
        while (nd != null)
        {
            System.out.println(nd.data + "->");
            nd=nd.next;
        }
    }

    public Node findNode(int data)
    {
        Node nd = head;
        if(head.data==data)
            return head;
        while (nd.next!=null)
        {
            if (nd.data==data)
            {
               return nd;
            }
            nd=nd.next;
        }
        return null;
    }
}
