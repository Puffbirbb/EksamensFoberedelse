public class main {
    public static void main(String[] args) {
        BinaryTree<Integer> leaf15 = new BinaryTree<>(15);
        BinaryTree<Integer> leaf25 = new BinaryTree<>(25);
        BinaryTree<Integer> leaf88 = new BinaryTree<>(88);
        BinaryTree<Integer> parent11 = new BinaryTree<>(11, null, leaf15);
        BinaryTree<Integer> parent30 = new BinaryTree<>(30, leaf25, null);
        BinaryTree<Integer> parent90 = new BinaryTree<>(90, leaf88, null);
        BinaryTree<Integer> parent22 = new BinaryTree<>(22, parent11, parent30);
        BinaryTree<Integer> parent77 = new BinaryTree<>(77, null, parent90);
        BinaryTree<Integer> root = new BinaryTree<>(45, parent22, parent77);

        System.out.println(root.getHeight());

        System.out.println(root.getSize());

        System.out.println(root.getLeaf());

        root.getPreOrder();

        System.out.println();

        root.getInOrder();

        System.out.println();

        root.getPostOrder();

        System.out.println();

        root.getLevelOrder();
    }
}
