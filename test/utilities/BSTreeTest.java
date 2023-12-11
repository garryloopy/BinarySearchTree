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
 * @author Garry Jr
 * @author Kevin Wong
 * @author Zackaria Osman
 */
public class BSTreeTest {
    
    //testing the utilities>BSTree file

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
        BSTree<Integer> tree = new BSTree<>();
        tree.add(10);
        assertTrue(tree.contains(10));
        assertFalse(tree.contains(5));
    }

    @Test
    public void testSearch() {
        BSTree<Integer> tree = new BSTree<>();
        tree.add(10);
        tree.add(15);
        tree.add(22);
        assertNotNull(tree.search(10));
        assertNull(tree.search(5));
    }

    @Test
    public void testAdd() {
        BSTree<Integer> tree = new BSTree<>();
        assertTrue(tree.add(10));
    }

    @Test
    public void testRemoveMin() {
        BSTree<Integer> tree = new BSTree<>();
        assertNull(tree.removeMin());
        tree.add(10);
        tree.add(5);
        assertEquals(Integer.valueOf(5), tree.removeMin().getElement());
    }

    @Test
    public void testRemoveMax() {
        BSTree<Integer> tree = new BSTree<>();
        assertNull(tree.removeMax());
        tree.add(10);
        tree.add(15);
        assertEquals(Integer.valueOf(15),tree.removeMax().getElement());
    }

    @Test
    public void testInorderIterator() {
        BSTree<Integer> tree = new BSTree<>();
        tree.add(10);
        tree.add(5);
        tree.add(15);

        Iterator<Integer> iterator = tree.inorderIterator();
        assertTrue(iterator.hasNext()); //Inorder iterator should have elements

        assertEquals(Integer.valueOf(5), iterator.next());//First element should be 5 in inorder
        assertEquals(Integer.valueOf(10), iterator.next());//Second element should be 10 in inorder
        assertEquals(Integer.valueOf(15), iterator.next());  //Third element should be 15 in inorder
    }

    @Test
    public void testPreorderIterator() {
        BSTree<Integer> tree = new BSTree<>();
        tree.add(10);
        tree.add(5);
        tree.add(15);

        Iterator<Integer> iterator = tree.preorderIterator();
        assertTrue(iterator.hasNext()); //Preorder iterator should have elements
        
        assertEquals(Integer.valueOf(10), iterator.next());//First element should be the root in preorder
        assertEquals(Integer.valueOf(5), iterator.next()); //Second element should be left child in preorder
        assertEquals(Integer.valueOf(15), iterator.next()); //Third element should be right child in preorder
        
    }

    @Test
    public void testPostorderIterator() {
        BSTree<Integer> tree = new BSTree<>();
        tree.add(10);
        tree.add(5);
        tree.add(15);

        Iterator<Integer> iterator = tree.postorderIterator();
        assertTrue(iterator.hasNext()); //"Postorder iterator should have elements
        
        assertEquals(Integer.valueOf(5), iterator.next()); //First element should be left child in postorder
        assertEquals(Integer.valueOf(15), iterator.next()); //Second element should be right child in postorder
        assertEquals(Integer.valueOf(10), iterator.next()); //Third element should be the root in postorder
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
