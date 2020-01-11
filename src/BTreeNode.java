public class BTreeNode<T extends Comparable<T>> {

    public T value;
    public BTreeNode<T> left;
    public BTreeNode<T> right;

    public BTreeNode(T value) {
        super();
        this.value = value;
    }
}