package utilities;

import treeImplementation.BSTreeNode;

/**
 * Represents a Binary Search Tree
 * @author Garry Jr
 * @author Kevin Wong
 * @author Zackaria Osman
 * @param <E> The type for the binary search tree
 */
public class BSTree<E extends Comparable<? super E>> implements BSTreeADT<E>{
    // Root of the tree
    private BSTreeNode<E> root;
    
    /**
     * Constructor for the tree. Sets the root to null;
     */
    public BSTree() {
        root = null;
    }
    
    /**
     * Constructor the the tree. Sets the root to the given parameter
     * @param root The root of the Binary Search Tree
     */
    public BSTree(BSTreeNode<E> root) {
        this.root = root;
    }

    @Override
    public BSTreeNode<E> getRoot() {
        return root;
    }

    @Override
    public int getHeight() {
        return root != null ? root.getHeight() : 0;
    }

    @Override
    public int size() {
        return root != null ? root.getNumberNodes() : 0;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public void clear() {
        root = null;
    }

    @Override
    public boolean contains(E entry) throws NullPointerException {
        // Null entry
        if (entry == null) throw new NullPointerException("Entry cannot be null");

        BSTreeNode<E> pointer = root;
        
        while (pointer != null) {
            E val = pointer.getElement();
            
            switch (entry.compareTo(val)) {
                // Entry is less than value
                case -1 -> pointer = pointer.getLeft();
                
                // Entry is greater than value
                case 1 -> pointer = pointer.getRight();   
                
                // Found entry
                case 0 -> {
                    return true;
                }
                   
            }
            
        }
        
        // None found
        return false;
    }

    @Override
    public BSTreeNode<E> search(E entry) throws NullPointerException {
        // Null entry
        if (entry == null) throw new NullPointerException("Entry cannot be null");
        
        BSTreeNode<E> pointer = root;
        
        while (pointer != null) {
            E val = pointer.getElement();
            
            switch (entry.compareTo(val)) {
                // Entry is less than value
                case -1 -> pointer = pointer.getLeft();
                
                // Entry is greater than value
                case 1 -> pointer = pointer.getRight();
                
                // Entry found
                case 0 -> {
                    return pointer;
                }
            }
        }
        
        // Entry not found
        return null;
    }

    @Override
    public boolean add(E newEntry) throws NullPointerException {
        if (newEntry == null) throw new NullPointerException("Entry cannot be null");
        
        if (root == null) {
            root = new BSTreeNode(newEntry);
            return true;
        }
        
        BSTreeNode<E> pointer = root;
        
        while (pointer != null ) {
            E val = pointer.getElement();
            
            switch (newEntry.compareTo(val)) {
                case 0, -1 -> {
                    if (!pointer.hasLeftChild())  {
                        pointer.setLeft(new BSTreeNode<>(newEntry));
                        return true;
                    }
                    else
                        pointer = pointer.getLeft();
                }
                case 1 -> {
                    if (!pointer.hasRightChild()) {
                        pointer.setRight(new BSTreeNode<>(newEntry));
                        return true;
                    }
                    else
                        pointer = pointer.getRight();
                }
            }
        }
        
        return false;
    }

    @Override
    public BSTreeNode<E> removeMin() {
        // Check if tree is empty
        if (isEmpty()) {
            return null;
        }

        BSTreeNode<E> pointer = root;
        BSTreeNode<E> min;

        // Check if there is no left child
        if (!pointer.hasLeftChild()) {
            min = pointer;
            root = root.getRight();
            return min;
        }

        // Find the leftmost node
        while (pointer.getLeft().hasLeftChild()) {
            pointer = pointer.getLeft();
        }

        // Remove the leftmost node
        min = pointer.getLeft();
        pointer.setLeft(min.getRight());

        return min;
    }


    @Override
    public BSTreeNode<E> removeMax() {
        // Check if tree is empty
        if (isEmpty()) {
            return null;
        }

        BSTreeNode<E> pointer = root;
        BSTreeNode<E> max;

        // Check if there is no right child
        if (!pointer.hasRightChild()) {
            max = pointer;
            root = root.getLeft();
            return max;
        }

        // Find the rightmost node
        while (pointer.getRight().hasRightChild()) {
            pointer = pointer.getRight();
        }

        // Remove the rightmost node
        max = pointer.getRight();
        pointer.setRight(max.getLeft());

        return max;
    }


    @Override
    public Iterator<E> inorderIterator() {
        return new InorderIterator<>(root);
    }

    @Override
    public Iterator<E> preorderIterator() {
        return new PreorderIterator<>(root);
    }

    @Override
    public Iterator<E> postorderIterator() {
        return new PostorderIterator<>(root);
    }
    
    
}


