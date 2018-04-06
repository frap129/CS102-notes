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

    public Node(int d, Node n, Node p)
    {
        data = d;
        next = n;
        prev = p;
    }

    public void setNext(Node n)
    {
        next = n;
    }

    public void setPrev(Node p)
    {
        prev = p;
    }

    public Node getNext()
    {
        return next;
    }

    public Node getPrev()
    {
        return prev;
    }

    public void setData(int d)
    {
        data = d;
    }

    public int getData()
    {
        return data;
    }
}