package cs102.notes.BinaryTrees;

class Node
{
    private int data;
    private Node left, right;

    public Node(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public Node(int data, Node left, Node right)
    {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int compareTo(Node node) {
        return Integer.compare(data, node.getData());
    }
}