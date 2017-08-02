package StackQueue;

/**
 * Created by rkaushik on 7/14/17.

/*
 Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

        push(x) -- Push element x onto stack.
        pop() -- Removes the element on top of the stack.
        top() -- Get the top element.
        getMin() -- Retrieve the minimum element in the stack.
 */

public class DesignStack
{
    public Element top;

    public void push(int data)
    {
        if (top==null)
        {
            top = new Element(data,data);
        }
        else
        {
            Element elem = new Element(data,Math.min(data,top.min));
            elem.next = top;
            top = elem;
        }
    }

    public void pop()
    {
        if (top==null)
            return;
        Element temp = top.next;
        top.next = null;
        top = temp;
    }

    public int top()
    {
        return top.data;
    }

    public int getMin()
    {
        return top.min;
    }
}

class Element
{
    public int data;
    public int min;
    public Element next;

    public Element(int data,int min)
    {
        this.data = data;
        this.min = min;
    }

}
