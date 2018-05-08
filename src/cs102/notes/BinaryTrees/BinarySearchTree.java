package cs102.notes.BinaryTrees;

class BinarySearchTree {
    public Node root;

    public BinarySearchTree(int key)
    {
        root = new Node(key);
    }

    public BinarySearchTree()
    {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    private void makeEmpty() {
        root = null;
    }

    // Wrapper method to insert at root
    public void insert(int data) {
        root = insert(root, data);
    }

    // Wrapper method to insert a tree at root
    public void insert(BinarySearchTree tree) {
        root = insert(root, tree.root);
        tree.makeEmpty();
    }

    // Insert based on data value
    private Node insert(Node node, int data) {
        if (node == null)
            node = new Node(data);
        else if (node.getData() != data){
            if (node.getData() < data)
                node.setRight(insert(node.getRight(), data));
            else if (node.getData() > data)
                node.setLeft(insert(node.getLeft(), data));
        }

        return node;
    }

    // Insert node based on data value
    private Node insert(Node node, Node newNode) {
        if (node == null)
            node = newNode;
        else if (node.getData() != newNode.getData()){
            if (node.getData() < newNode.getData())
                node.setRight(insert(node.getRight(), newNode));
            else if (node.getData() > newNode.getData())
                node.setLeft(insert(node.getLeft(), newNode));
        }

        return node;
    }

    // Wrapper method to count from root
    public int countNodes() {
        return countNodes(root);
    }

    // Count total number of nodes recursively
    private int countNodes(Node r) {
        if (r == null)
            return 0;
        else {
            int l = 1;
            l += countNodes(r.getLeft());
            l += countNodes(r.getRight());
            return l;
        }
    }

    // Wrapper method to search from root
    public boolean search(int val)
    {
        return search(root, val);
    }

    // Search for a node recursively
    private boolean search(Node r, int val)
    {
        if (r.getData() == val)
            return true;

        if (r.getLeft() != null && r.getLeft().getData() < val)
            if (search(r.getLeft(), val))
                return true;

        if (r.getRight() != null&& r.getRight().getData() > val)
            if (search(r.getRight(), val))
                return true;
        return false;
    }

    // Wrapper method for inorder traversal from root
    public void inorder() {
        inorder(root);
    }

    // Traverse tree inorder
    private void inorder(Node r) {
        if (r != null) {
            inorder(r.getLeft());
            System.out.print(r.getData() +" ");
            inorder(r.getRight());
        }
    }

    // Wrapper method for preorder traversal from root
    public void preorder() {
        preorder(root);
    }

    // Traverse tree preorder
    private void preorder(Node r) {
        if (r != null) {
            System.out.print(r.getData() +" ");
            preorder(r.getLeft());
            preorder(r.getRight());
        }
    }

    // Wrapper method for postorder traversal from root
    public void postorder() {
        postorder(root);
    }

    // Traverse tree postorder
    private void postorder(Node r) {

        if (r != null) {
            postorder(r.getLeft());
            postorder(r.getRight());
            System.out.print(r.getData() +" ");
        }
    }
}