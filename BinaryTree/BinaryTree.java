package BinaryTree;
import java.util.Queue;
import java.util.LinkedList;
/**
 * @author ANDERSON BALLESTEROS
 */
public class BinaryTree {
    
    private BinaryNode root;
    
    public BinaryTree(BinaryNode root) {
        this.root = root;
    }
    
    public String preOrder(){
        return preOrder(root);
    }
    
    private String preOrder(BinaryNode node){
        String toReturn=node.getElement() + " ";
        if(node.getLeftChild() != null) toReturn+=preOrder(node.getLeftChild());
        if(node.getRightChild()!= null) toReturn+=preOrder(node.getRightChild());
        return toReturn;
    }
    
    public String inOrder(){
        return inOrder(root);
    }
    
    private String inOrder(BinaryNode node){
        String toReturn="";
        if(node.getLeftChild() != null) toReturn+=inOrder(node.getLeftChild());
        toReturn+=node.getElement() + " ";
        if(node.getRightChild()!= null) toReturn+=inOrder(node.getRightChild());
        return toReturn;
    }
 
    public String postOrder(){
        return postOrder(root);
    }
    
    private String postOrder(BinaryNode node){
        String toReturn="";
        if(node.getLeftChild() != null) toReturn+=postOrder(node.getLeftChild());
        if(node.getRightChild()!= null) toReturn+=postOrder(node.getRightChild());
        toReturn+=node.getElement() + " ";
        return toReturn;
    }
    
    public String levelOrder(){
        Queue<BinaryNode> queue = new LinkedList<>();
        String toReturn = "";
        queue.add(root);
        
        while (!queue.isEmpty()) {
            BinaryNode node = queue.poll();
            toReturn+=node.getElement() + " ";
            if(node.getLeftChild()!=null) queue.add(node.getLeftChild());
            if(node.getRightChild()!=null) queue.add(node.getRightChild());
        }
        return toReturn;
    }
    
}
