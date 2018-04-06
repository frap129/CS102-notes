package cs102.notes.LinkedList;

public class Node {
    protected int data;
    protected Node next, prev;

    public Node()
    {
        next = null;
        prev = null;
        data = 0;
    }

    public Node(int initData, Node initNext, Node initPrev)
    {
        data = initData;
        next = initNext;
        prev = initPrev;
    }

    public void setData(int newData)
    {
        data = newData;
    }

    public void setNext(Node newNext)
    {
        next = newNext;
    }

    public void setPrev(Node newPrev)
    {
        prev = newPrev;
    }

    public int getData()
    {
        return data;
    }

    public Node getNext()
    {
        return next;
    }

    public Node getPrev()
    {
        return prev;
    }
}