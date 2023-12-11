package utilities;

import java.util.NoSuchElementException;
import java.util.Stack;
import treeImplementation.BSTreeNode;  

/**
 * A post order iteration over the contents of the tree. Elements are in a way that the root elements is last
 * @author garry
 * @param <E> The type for the contents of the tree
 */
public class PostorderIterator<E extends Comparable<? super E>> implements Iterator<E> {
    // Main stack
    private final Stack<BSTreeNode<E>> stack;
    
    // Last visited node
    private BSTreeNode<E> lastVisited;

    /**
     * Constructor, takes in root for the tree
     * @param root The root of the tree
     */
    public PostorderIterator(BSTreeNode<E> root) {
        stack = new Stack<>();
        lastVisited = null;
        pushPostorderNodes(root);
    }

    /**
     * Helper method for pushing nodes onto the stack
     * @param node The node to be pushed
     */
    private void pushPostorderNodes(BSTreeNode<E> node) {
        while (node != null) {
            stack.push(node);
            lastVisited = node;
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

        while (true) {
            BSTreeNode<E> current = stack.peek();

            if (current.getRight() != null && lastVisited != current.getRight()) {
                // If the right child exists and hasn't been visited, go to the right subtree
                pushPostorderNodes(current.getRight());
            } else {
                // If the right child doesn't exist or has been visited, visit the current node
                lastVisited = stack.pop();
                return lastVisited.getElement();
            }
        }
    }
}
