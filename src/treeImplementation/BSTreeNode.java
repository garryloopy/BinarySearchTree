package treeImplementation;

/**
 * Represents a binary search tree node
 * @author Garry Jr
 * @author Kevin Wong
 * @author Zackaria Osman
 * @param <E> The type for the binary search tree node
 */
public class BSTreeNode<E> {
    // Data for the node
    private E element;
    
    // Left node
    private BSTreeNode<E> left;
    
    // Right node
    private BSTreeNode<E> right;
    
    /**
     * Constructor that takes an element, a left node, and a right node
     * @param element The data for the node
     * @param left The left node
     * @param right The right node
     */
    public BSTreeNode(E element, BSTreeNode<E> left, BSTreeNode<E> right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }
    
    /**
     * Constructor that takes an element
     * @param element The data for the node
     */
    public BSTreeNode(E element) {
        this.element = element;
        left = null;
        right = null;
    }
    
    /**
     * Gets the element for the node
     * @return The element for the node
     */
    public E getElement() {
        return element;
    }
    
    /**
     * Sets the element for the node
     * @param element The new element for the node
     */
    public void setElement(E element) {
        this.element = element;
    }
    
    /**
     * Gets the left node
     * @return The left node
     */
    public BSTreeNode<E> getLeft() {
        return left;
    }
    /**
     * Sets the left node
     * @param left The new left node
     */
    public void setLeft(BSTreeNode<E> left) {
        this.left = left;
    }
    
    /**
     * Gets the right node
     * @return The right node
     */
    public BSTreeNode<E> getRight() {
        return right;
    }
    
    /**
     * Sets the right node
     * @param right The new right node
     */
    public void setRight(BSTreeNode<E> right) {
        this.right = right;
    }
    
    /**
     * Check if the node has a left child
     * @return True if left child is not null, otherwise return false
     */
    public boolean hasLeftChild() {
        return left != null;
    }
    
    /**
     * Check if the node has a right child
     * @return True if right child is not null, otherwise return false
     */
    public boolean hasRightChild() {
        return right != null;
    }
    
    /**
     * Check if the node is a leaf(does not have a child)
     * @return True if left and right nodes are null, otherwise return false
     */
    public boolean isLeaf() {
        return right == null && left == null;
    }
    
    /**
     * Gets the number of nodes in the rooted at this node
     * @return 
     */
    public int getNumberNodes() {
        int count = 1;
        
        if (hasLeftChild())
            count += getLeft().getNumberNodes();
        
        if (hasRightChild())
            count += getRight().getNumberNodes();
        
        return count;
    }
    
    /**
     * Gets the height of the sub-tree rooted at this node
     * @return 
     */
    public int getHeight() {
        if (isLeaf()) return 1;
        
        int leftHeight = hasLeftChild() ? getLeft().getHeight() : 1;
        
        int rightHeight = hasRightChild() ? getRight().getHeight() : 1;
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
