/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

import java.util.NoSuchElementException;
import java.util.Stack;
import treeImplementation.BSTreeNode;

/**
 * An in order iteration over the contents of the tree. Elements in their natural order
 * @author Garry Jr
 * @author Kevin Wong
 * @author Zackaria Osman
 * @param <E> The type for contents of the tree
 */
public class InorderIterator<E extends Comparable<? super E>> implements Iterator<E> {
    // Main stack
    private final Stack<BSTreeNode<E>> stack;
    
    /**
     * Constructor, takes in a root
     * @param root The root of the tree
     */
    public InorderIterator(BSTreeNode<E> root) {
        stack = new Stack<>();
        pushLeftChildren(root);
    }
    
    /**
     * Helper method for pushing a node from the left sub tree onto the stack
     * @param node The node
     */
    private void pushLeftChildren(BSTreeNode<E> node) {
        while (node != null) {
            stack.push(node);
            node = node.getLeft();
        }
    } 

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public E next() throws NoSuchElementException {
        if (!hasNext()) {
            throw new NoSuchElementException("No more elements in the iteration");
        }

        BSTreeNode<E> current = stack.pop();
        pushLeftChildren(current.getRight());

        return current.getElement();
    }
}
