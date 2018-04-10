package cs102.notes.LinkedList;

public class LinkedList {
    private Node start;
    private Node end ;
    private int size;

    // Constructor for the list, requires no args
    public LinkedList()
    {
        start = null;
        end = null;
        size = 0;
    }

    // Return if the list is empty or not
    public boolean isEmpty()
    {
        return start == null;
    }

    // Return size of the list
    public int getSize()
    {
        return size;
    }

    // Insert a new item at HEAD
    public void prepend(Object data)
    {
        // Create a new nude with the given data
        Node newNode = new Node(data, null, null);

        // If the list is empty, set to head and link circularly
        // else move to HEAD
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

        // Update size to reflect new addition
        size++ ;
    }

    // Insert a new item at tail
    public void append(Object data)
    {
        // Create a new nude with the given data
        Node newNode = new Node(data, null, null);

        // If the list is empty, set to head and link circularly
        // else move to tail
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

        // Update size to reflect new addition
        size++;
    }

    // Insert item at the given position
    public void insert(Object data, int pos)
    {
        // Check if pos is impossible, throw an exception
        if (pos > ++size)
            throw new RuntimeException("Position out of range");

        // Create a new nude with the given data
        Node newNode = new Node(data, null, null);

        // If position is 1, prepend value
        // else, check if pos is new tail
        if (pos == 1)
        {
            prepend(data);
            return;
        } else if (pos == ++size) {
            append(data);
            return;
        }

        // Iterate to position starting at head
        Node node = start;
        for (int i = 2; i <= size; i++)
        {
            // Once we find the correct position, insert the node
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

        // Update size to reflect new addition
        size++ ;
    }

    // Remove item at the given position
    public void remove(int pos)
    {
        // Check if pos is impossible, throw an exception
        if (pos > size)
            throw new RuntimeException("Position out of range");

        // If removing HEAD, check if that's the only node
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
            return;
        }

        // If removing tail, relink from prev to HEAD and reduce size
        if (pos == size)
        {
            end = end.getPrev();
            end.setNext(start);
            start.setPrev(end);
            size--;
        }

        // Otherwise, find position and remove
        Node node = start.getNext();
        for (int i = 2; i <= size; i++)
        {
            if (i == pos)
            {
                Node prev = node.getPrev();
                Node next = node.getNext();
                prev.setNext(next);
                next.setPrev(prev);
                size--;
                return;
            }

            node = node.getNext();
        }
    }

    // Empty the list
    public void removeAll() {
        start = null;
        end = null;
        size = 0;
    }

    // Return the data contained by a Node
    public Object get(int pos) {
        // Check if pos is impossible, throw an exception
        if (pos > ++size)
            throw new RuntimeException("Position out of range");

        // Start at HEAD, iterate to requested position
        Node node = start;
        if (pos > size)
            return null;
        for (int i = 1; i <= size; i++)
        {
            if (i == pos)
                return node.getData();

            node = node.getNext();
        }
        return null;
    }

    // Format the list as a string
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
