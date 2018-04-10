package cs102.notes.LinkedList;

public class Node {
    protected Object data;
    protected Node next, prev;

    public Node()
    {
        next = null;
        prev = null;
        data = 0;
    }

    public Node(Object initData, Node initNext, Node initPrev)
    {
        data = initData;
        next = initNext;
        prev = initPrev;
    }

    public void setData(Object newData)
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

    public Object getData()
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