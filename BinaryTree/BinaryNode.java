package BinaryTree;

/**
 * @author ANDERSON BALLESTEROS
 */
public class BinaryNode {

    private Object element;
    private BinaryNode leftChild;
    private BinaryNode rightChild;

    public BinaryNode(Object element) {
        this.element = element;
    }

    public BinaryNode(Object element, BinaryNode leftChild, BinaryNode rightChild) {
        this.element = element;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public BinaryNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinaryNode leftChild) {
        this.leftChild = leftChild;
    }

    public BinaryNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinaryNode rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return ""+element;
    }
    
    
    
}
