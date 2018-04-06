package cs102.notes.LinkedList;

public class LinkedList {
    protected Node start;
    protected Node end ;
    public int size;

    // Constructor for the list, requires no args
    public LinkedList()
    {
        start = null;
        end = null;
        size = 0;
    }

    public boolean isEmpty()
    {
        return start == null;
    }

    public int getSize()
    {
        return size;
    }

    // Insert a new item at HEAD
    public void prepend(int val)
    {
        Node newNode = new Node(val, null, null);
        if (start == null)
        {
            newNode.setNext(newNode);
            newNode.setPrev(newNode);
            start = newNode;
            end = start;
        } else {
            newNode.setPrev(end);
            end.setNext(newNode);
            start.setPrev(newNode);
            newNode.setNext(start);
            start = newNode;
        }

        size++ ;
    }

    // Insert a new item at tail
    public void append(int val)
    {
        Node newNode = new Node(val, null, null);
        if (start == null)
        {
            newNode.setNext(newNode);
            newNode.setPrev(newNode);
            start = newNode;
            end = start;
        } else {
            newNode.setPrev(end);
            end.setNext(newNode);
            start.setPrev(newNode);
            newNode.setNext(start);
            end = newNode;
        }

        size++;
    }

    // Insert item at the given position
    public void insert(int val , int pos)
    {
        Node newNode = new Node(val, null, null);
        if (pos == 1)
        {
            prepend(val);
            return;
        }

        Node node = start;
        for (int i = 2; i <= size; i++)
        {
            if (i == pos)
            {
                Node tmp = node.getNext();
                node.setNext(newNode);
                newNode.setPrev(node);
                newNode.setNext(tmp);
                tmp.setPrev(newNode);
            }

            node = node.getNext();
        }

        size++ ;
    }

    // remove item at the given position
    public void remove(int pos)
    {
        if (pos == 1)
        {
            if (size == 1)
            {
                start = null;
                end = null;
                size = 0;
                return;
            }

            start = start.getNext();
            start.setPrev(end);
            end.setNext(start);
            size--;
            return ;
        }

        if (pos == size)
        {
            end = end.getPrev();
            end.setNext(start);
            start.setPrev(end);
            size-- ;
        }

        Node node = start.getNext();
        for (int i = 2; i <= size; i++)
        {
            if (i == pos)
            {
                Node prev = node.getPrev();
                Node next = node.getNext();
                prev.setNext(next);
                next.setPrev(prev);
                size-- ;
                return;
            }

            node = node.getNext();
        }
    }

    public String toString()
    {
        Node node = start;

        // Check if empty first
        if (size == 0)
            return "empty\n";

        // If one item, show it as circular
        if (start.getNext() == start)
        {
            return start.getData()+ " <-> "+node.getData()+ "\n";
        }

        String linkedList = start.getData()+ " <-> ";
        node = start.getNext();

        // Iterate over all elements
        while (node.getNext() != start)
        {
            linkedList += node.getData()+ " <-> ";
            node = node.getNext();
        }

        linkedList += node.getData()+ " <-> ";
        node = node.getNext();
        return linkedList + node.getData()+ "\n";
    }
}
