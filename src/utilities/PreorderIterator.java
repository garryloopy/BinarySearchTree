/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

import java.util.NoSuchElementException;
import java.util.Stack;
import treeImplementation.BSTreeNode;

/**
 * A pre order iteration over the contents of the tree. Elements are presented in a way that the root elements are first
 * @author Garry Jr
 * @author Kevin Wong
 * @author Zackaria Osman
 * @param <E> The type for the contents of the tree
 */
public class PreorderIterator<E extends Comparable<? super E>> implements Iterator<E> {
    // Main stack
    private final Stack<BSTreeNode<E>> stack;
    
    /**
     * Constructor, takes in root
     * @param root The root of the tree
     */
    public PreorderIterator(BSTreeNode<E> root) {
        stack = new Stack<>();
        stack.push(root);
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
        
        if (current.getRight() != null) 
            stack.push(current.getRight());
        
        if (current.getLeft() != null) 
            stack.push(current.getLeft());

        return current.getElement();
    }
}
