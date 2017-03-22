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
                return;
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

    public void DeleteNode(int data)
    {
        Node current = head;
        if (current.data==data)
        {
            head=current.next;
            return;
        }
        else
        {
            Node prev = head;
            current = head.next;

            while (current !=null)
            {
                if(current.data==data)
                {
                    prev.next=current.next;
                    return;
                }
                else
                {
                    prev=current;
                    current = current.next;
                }

            }

        }
    }

    public void ReverseLinkedList()
    {
        //Reverse Linked list iterative method
        Node current=head;
        Node previous=null;
        Node nxtNode;

        while (current != null)
        {
            nxtNode = current.next;
            current.next=previous;
            previous=current;
            current=nxtNode;
        }
        head=previous;
    }

    //You are given two linked lists representing two non-negative numbers.
    // The digits are stored in reverse order and each of their nodes contain a single digit.
    // Add the two numbers and return it as a linked list.
    public MyLinkedList AddTwoNumbers(MyLinkedList list1,MyLinkedList list2)
    {
        Node n1 = list1.head;
        Node n2 = list2.head;

        MyLinkedList newlist = new MyLinkedList();
        int carry=0;

        while (n1 !=null)
        {
            int sum = n1.data + n2.data + carry;

            if(sum >= 10)
            {
                carry=sum/10;
                newlist.Add(sum%10);
            }
            else{
                newlist.Add(sum);
            }

            //if (n1.next !=null)
                n1 = n1.next;

            //if(n2.next!=null)
                n2 = n2.next;
        }

        return newlist;
    }
}
