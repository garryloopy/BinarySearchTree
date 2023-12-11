/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package utilities;

import org.junit.Test;
import static org.junit.Assert.*;
import treeImplementation.BSTreeNode;

/**
 *
 * @author osman
 */
public class BSTreeTest {

    @Test
    public void testGetRoot() {

        BSTree<Integer> tree = new BSTree<>();
        assertNull(tree.getRoot());
        tree.add(10);
        assertNotNull(tree.getRoot());

    }

    @Test
    public void testGetHeight() {
        BSTree<Integer> tree = new BSTree<>();
        assertEquals(0, tree.getHeight());
        tree.add(10);
        assertTrue(tree.getHeight() > 0);
    }

    @Test
    public void testSize() {
        BSTree<Integer> tree = new BSTree<>();
        assertEquals(0, tree.size());
        tree.add(10);
        assertEquals(1, tree.size());
    }

    @Test
    public void testIsEmpty() {
        BSTree<Integer> tree = new BSTree<>();
        assertTrue(tree.isEmpty());
        tree.add(10);
        assertFalse(tree.isEmpty());  
    }

    @Test
    public void testClear() {
        BSTree<Integer> tree = new BSTree<>();
        tree.add(10);
        tree.clear();
        assertTrue(tree.isEmpty());
    }

    @Test
    public void testContains() {
    }

    @Test
    public void testSearch() {
    }

    @Test
    public void testAdd() {
    }

    @Test
    public void testRemoveMin() {
    }

    @Test
    public void testRemoveMax() {
    }

    @Test
    public void testInorderIterator() {
    }

    @Test
    public void testPreorderIterator() {
    }

    @Test
    public void testPostorderIterator() {
    }

//    public class BSTreeADTImpl<E> implements BSTreeADT {
//
//        private BSTreeNode<E> root;
//
//        @Override
//        public BSTreeNode getRoot() {
//            return root;
//        }
//
//        @Override
//        public int getHeight() {
//            return root != null ? root.getHeight() : 0;
//        }
//
//        @Override
//        public int size() {
//            return root != null ? root.getNumberNodes() : 0;
//        }
//
//        @Override
//        public boolean isEmpty() {
//            return root == null;
//        }
//
//        @Override
//        public void clear() {
//            root = null;
//        }
//
//        @Override
//        public boolean contains(Comparable entry) throws NullPointerException {
//            // Null entry
//            if (entry == null) {
//                throw new NullPointerException("Entry cannot be null");
//            }
//
//            BSTreeNode<E> pointer = root;
//
//            while (pointer != null) {
//                E val = pointer.getElement();
//
//                switch (entry.compareTo(val)) {
//                    // Entry is less than value
//                    case -1 ->
//                        pointer = pointer.getLeft();
//
//                    // Entry is greater than value
//                    case 1 ->
//                        pointer = pointer.getRight();
//
//                    // Found entry
//                    case 0 -> {
//                        return true;
//                    }
//
//                }
//
//            }
//
//            // None found
//            return false;
//        }
//
//        @Override
//        public BSTreeNode search(Comparable entry) throws NullPointerException {
//            // Null entry
//            if (entry == null) {
//                throw new NullPointerException("Entry cannot be null");
//            }
//
//            BSTreeNode<E> pointer = root;
//
//            while (pointer != null) {
//                E val = pointer.getElement();
//
//                switch (entry.compareTo(val)) {
//                    // Entry is less than value
//                    case -1 ->
//                        pointer = pointer.getLeft();
//
//                    // Entry is greater than value
//                    case 1 ->
//                        pointer = pointer.getRight();
//
//                    // Entry found
//                    case 0 -> {
//                        return pointer;
//                    }
//                }
//            }
//
//            // Entry not found
//            return null;
//        }
//
//        @Override
//        public boolean add(Comparable newEntry) throws NullPointerException {
//            if (newEntry == null) {
//                throw new NullPointerException("Entry cannot be null");
//            }
//
//            if (root == null) {
//                root = new BSTreeNode(newEntry);
//                return true;
//            }
//
//            BSTreeNode<E> pointer = root;
//
//            while (pointer != null) {
//                E val = pointer.getElement();
//
//                switch (newEntry.compareTo(val)) {
//                    case 0, -1 -> {
//                        if (!pointer.hasLeftChild()) {
//                            pointer.setLeft(new BSTreeNode<E>(newEntry));
//                            return true;
//                        } else {
//                            pointer = pointer.getLeft();
//                        }
//                    }
//                    case 1 -> {
//                        if (!pointer.hasRightChild()) {
//                            pointer.setRight(new BSTreeNode<>(newEntry));
//                            return true;
//                        } else {
//                            pointer = pointer.getRight();
//                        }
//                    }
//                }
//            }
//
//            return false;
//
//        }
//
//        @Override
//        public BSTreeNode removeMin() {
//            // Check if tree is empty
//            if (isEmpty()) {
//                return null;
//            }
//
//            BSTreeNode<E> pointer = root;
//            BSTreeNode<E> min;
//
//            // Check if there is no left child
//            if (!pointer.hasLeftChild()) {
//                min = pointer;
//                root = root.getRight();
//                return min;
//            }
//
//            // Find the leftmost node
//            while (pointer.getLeft().hasLeftChild()) {
//                pointer = pointer.getLeft();
//            }
//
//            // Remove the leftmost node
//            min = pointer.getLeft();
//            pointer.setLeft(min.getRight());
//
//            return min;
//
//        }
//
//        @Override
//        public BSTreeNode removeMax() {
//
//            // Check if tree is empty
//            if (isEmpty()) {
//                return null;
//            }
//
//            BSTreeNode<E> pointer = root;
//            BSTreeNode<E> max;
//
//            // Check if there is no right child
//            if (!pointer.hasRightChild()) {
//                max = pointer;
//                root = root.getLeft();
//                return max;
//            }
//
//            // Find the rightmost node
//            while (pointer.getRight().hasRightChild()) {
//                pointer = pointer.getRight();
//            }
//
//            // Remove the rightmost node
//            max = pointer.getRight();
//            pointer.setRight(max.getLeft());
//
//            return max;
//
//        }
//
//        @Override
//        public Iterator inorderIterator() {
//
//            return new InorderIterator<>(root);
//
//        }
//
//        @Override
//        public Iterator preorderIterator() {
//
//            return new PreorderIterator<>(root);
//
//        }
//
//        @Override
//        public Iterator postorderIterator() {
//
//            return new PostorderIterator<>(root);
//
//        }
//
//    }
}
