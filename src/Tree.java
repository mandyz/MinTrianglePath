/**
 * Tree Data Structure.
 *
 * @author Mandy Zammit {@literal <zammit.mandy@gmail.com>}
 */
public class Tree<T> {

    private T rootNode;
    private Tree<T> leftChildNode = null;
    private Tree<T> rightChildNode = null;

    public Tree(T rootNode){
        this.rootNode = rootNode;
    }

    public T getRootNode() {
        return rootNode;
    }

    public Tree<T> getLeftChildNode() {
        return leftChildNode;
    }

    public void setLeftChildNode(Tree<T> leftChildNode) {
        this.leftChildNode = leftChildNode;
    }

    public Tree<T> getRightChildNode() {
        return rightChildNode;
    }

    public void setRightChildNode(Tree<T> rightChildNode) {
        this.rightChildNode = rightChildNode;
    }
}
