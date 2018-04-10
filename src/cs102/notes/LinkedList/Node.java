package cs102.notes.LinkedList;

public class Node {
    private Object data;
    private Node next, prev;

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

    protected void setData(Object newData)
    {
        data = newData;
    }

    protected void setNext(Node newNext)
    {
        next = newNext;
    }

    protected void setPrev(Node newPrev)
    {
        prev = newPrev;
    }

    protected Object getData()
    {
        return data;
    }

    protected Node getNext()
    {
        return next;
    }

    protected Node getPrev()
    {
        return prev;
    }
}