public class BTree<T extends Comparable<T>> {

    private BTreeNode<T> root;
    private Traversal traversal = Traversal.INORDER;

    public void insert(T value){
        if(root==null){
            this.root = new BTreeNode<>(value);
            return;
        }
        insert(root,value);
    }

    private void insert(BTreeNode<T> node, T value) {
        if (node.value.compareTo(value) > 0) {
            // links
            if (node.left == null) {
                // hier einfuegen
                node.left = new BTreeNode<>(value);
            } else {
                // an Kindknoten delegieren
                insert(node.left, value);
            }

        } else if (node.value.compareTo(value) < 0) {
            // rechts
            if (node.right == null) {
                node.right = new BTreeNode<>(value);
            } else {
                insert(node.right, value);
            }
        }
    }

    public void setTraversal(Traversal traversal) {
        this.traversal = traversal;
    }

    @Override
    public String toString() {
        switch (this.traversal) {
            case INORDER:
                return inOrder(this.root);
            case PREORDER:
                return PreOrder(this.root);
            case POSTORDER:
                return PostOrder(this.root);
        }
        return "";
    }
    private String inOrder(BTreeNode<T> current) {
        String res = "";
        if(current.left!= null)
            res += inOrder(current.left) + ",";
        res += current.value;
        if(current.right!= null)
            res += ","+ inOrder(current.right);
        return res;
    }
    private String PreOrder(BTreeNode<T> current) {
        String res = "";
        res += current.value;
        if(current.left!= null)
            res += "," + PreOrder(current.left);
        if(current.right!= null)
            res += "," + PreOrder(current.right);
        return res;
    }
    private String PostOrder(BTreeNode<T> current) {
        String res = "";
        if(current.left!= null)
            res += PostOrder(current.left) + ",";
        if(current.right!= null)
            res += PostOrder(current.right) + ",";
        res += current.value;
        return res;
    }
}