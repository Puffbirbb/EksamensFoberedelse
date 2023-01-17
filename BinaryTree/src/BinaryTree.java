/**
 * BinaryTree models a binary tree.
 */
public class BinaryTree<E> {
    private Node root;

    /**
     * Create an empty binary tree.
     */
    public BinaryTree() {
        root = null;
    }

    /**
     * Create a binary tree with one node.
     */
    public BinaryTree(E rootData) {
        root = new Node(rootData);
    }

    /**
     * Create a BinaryTree with a root node, and
     * 'left' as left subtree and 'right' as right subtree.
     * Pre: 'left' != 'right'.
     * Note: 'left' and 'right' are nullable.
     */
    public BinaryTree(E rootData, BinaryTree<E> left, BinaryTree<E> right) {
        root = new Node(rootData);
        if (left != null) {
            root.left = left.root;
        }
        if (right != null) {
            root.right = right.root;
        }
    }

    //-------------------------------------------------------------------------

    /**
     * Return true if this tree is empty.
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Return the data at the root of this tree.
     * Pre: The tree is not empty.
     */
    public E rootData() {
        return root.data;
    }

    /**
     * Return a reference to the left subtree of this tree.
     * Pre: The tree is not empty.
     * Note: Nullable return value.
     */
    public BinaryTree<E> left() {
        BinaryTree<E> tree = new BinaryTree<>();
        tree.root = root.left;
        return tree;
    }

    /**
     * Return a reference to the right subtree of this tree.
     * Pre: The tree is not empty.
     * Note: Nullable return value.
     */
    public BinaryTree<E> right() {
        BinaryTree<E> tree = new BinaryTree<>();
        tree.root = root.right;
        return tree;
    }

    public int getHeight(){
        return height(root);
    }

    private int height(Node root){
        int height = 0;
        if (root == null){
            return 0;
        }
        int h1 = height(root.left);
        int h2 = height(root.right);
        height = 1 + Math.max(h1, h2);
        return height;
    }

    public int getSize(){
        return Size(root);
    }

    private int Size(Node root){
        int size = 0;
        if (root == null){
            return 0;
        }
        int h1 = Size(root.left);
        int h2 = Size(root.right);
        size = h1 + h2 + 1;
        return size;
    }

    public int getLeaf(){
        return Leaf(root);
    }

    private int Leaf(Node root){
        int leaf = 1;
        if (root.left != null && root.right != null){
            int h1 = Leaf(root.left);
            int h2 = Leaf(root.right);
            leaf = h1 + h2;
        }
        return leaf;
    }

    public void getPreOrder(){
        PreOrder(root);
    }

    private void PreOrder(Node root){
        if (root != null){
            System.out.print(root.data + " ");
            PreOrder(root.left);
            PreOrder(root.right);
        }
    }

    public void getInOrder() {
        InOrder(root);
    }

    private void InOrder(Node root){
        if(root != null){
            InOrder(root.left);
            System.out.print(root.data + " ");
            InOrder(root.right);
        }
    }

    public void getPostOrder() {
        PostOrder(root);
    }

    private void PostOrder(Node root){
        if (root != null){
            PostOrder(root.left);
            PostOrder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public void getLevelOrder() {
        int h = height(root);
        for (int i = 0; i <= h; i++){
            LevelOrder(root, i);
        }
    }

    private void LevelOrder(Node root, int level){
        if (root == null){
            return;
        }
        if (level == 1){
            System.out.print(root.data + " ");
        }
        else if (level > 1){
            LevelOrder(root.left, level-1);
            LevelOrder(root.right, level-1);
        }
    }

    //-------------------------------------------------------------------------

    private class Node {
        private E data;
        private Node left;
        private Node right;

        public Node(E data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
}
