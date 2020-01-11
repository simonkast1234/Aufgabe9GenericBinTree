public class BTree<T extends Comparable<T>> {

    private BTreeNode<T> root;

    public void insert(T value){
        if(root==null){
            this.root = new BTreeNode<T>(value);
            return;
        }
        insert(root,value);
    }

    private void insert(BTreeNode<T> node, T value) {
        if (node.value.compareTo(value) > 0) {
            // links
            if (node.left == null) {
                // hier einfuegen
                node.left = new BTreeNode(value);
                return;
            } else {
                // an Kindknoten delegieren
                insert(node.left, value);
            }

        } else if (node.value.compareTo(value) < 0) {
            // rechts
            if (node.right == null) {
                node.right = new BTreeNode(value);
                return;
            } else {
                insert(node.right, value);
            }
        }
    }

}