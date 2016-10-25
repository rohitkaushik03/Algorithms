package LinkedList;

/**
 * Created by rkaushik on 10/24/16.
 */
public class LinkedListMain
{
    public static void main(String args[])
    {
        MyLinkedList list = new MyLinkedList();
        list.Add(15);
        list.Add(20);
        list.Add(10);

        //add 25 in the starting and make it head node
        list.AddInFront(25);

        //add new data 50 after 15
        list.AddInMiddle(50,15);

        list.PrintList();

        Node nd = list.findNode(20);
    }
}
