package LinkedList;

/**
 * Created by rkaushik on 10/24/16.
 */
public class LinkedListMain
{
    public static void main(String args[])
    {
        MyLinkedList list = new MyLinkedList();
        list.Add(2);
        list.Add(4);
        list.Add(3);

        MyLinkedList list2 = new MyLinkedList();
        list2.Add(5);
        list2.Add(6);
        list2.Add(4);

        //add 25 in the starting and make it head node
        //list.AddInFront(25);

        //add new data 50 after 15
        //list.AddInMiddle(50,15);

        list.PrintList();
        System.out.println();
        list2.PrintList();

        MyLinkedList newlist = list.AddTwoNumbers(list,list2);
        newlist.PrintList();

        //Delete node from LinkedList
        //list.DeleteNode(10);

        list.ReverseLinkedList();
        System.out.println("*************");

        list.PrintList();

        Node nd = list.findNode(20);
    }
}
