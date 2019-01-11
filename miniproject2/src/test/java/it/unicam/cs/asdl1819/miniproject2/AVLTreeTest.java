/**
 * 
 */
package it.unicam.cs.asdl1819.miniproject2;

import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import it.unicam.cs.asdl1819.miniproject2.AVLTree.AVLTreeNode;

/**
 * @author luca
 *
 */
public class AVLTreeTest {
   

    /**
     * @throws java.lang.Exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        
    }

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
    }

    /**
     * Test method for {@link it.unicam.cs.asdl1819.miniproject2.AVLTree#AVLTree()}.
     */
    @Test(timeout=5000)
    public final void testAVLTree() {
        AVLTree<Integer> t = new AVLTree<Integer>();
        assertEquals(true, t.isEmpty());
        assertEquals(0,t.getSize());
        assertEquals(0,t.getNumberOfNodes());
    }

    /**
     * Test method for {@link it.unicam.cs.asdl1819.miniproject2.AVLTree#AVLTree(java.lang.Comparable)}.
     */
    @Test(expected=NullPointerException.class)
    public final void testAVLTreeENull() {
        AVLTree<Integer> t = new AVLTree<Integer>(null);
        fail("AVLTree with null element created");
    }

    /**
     * Test method for {@link it.unicam.cs.asdl1819.miniproject2.AVLTree#AVLTree(java.lang.Comparable)}.
     */
    @Test(timeout=5000)
    public final void testAVLTreeE() {
        AVLTree<Integer> t = new AVLTree<Integer>(15);
        assertEquals(false,t.isEmpty());
        assertEquals(1,t.getSize());
        assertEquals(1,t.getNumberOfNodes());
        assertEquals(true,t.getRoot().getEl().equals(15));
        assertEquals(1,t.getCount(15));
    }
    
    /**
     * Test method for {@link it.unicam.cs.asdl1819.miniproject2.AVLTree#isEmpty()}.
     */
    @Test(timeout=5000)
    public final void testIsEmpty() {
        AVLTree<Integer> t = new AVLTree<Integer>(2);
        assertEquals(false, t.isEmpty());
    }

    /**
     * Test method for {@link it.unicam.cs.asdl1819.miniproject2.AVLTree#getSize()}.
     */
    @Test(timeout=5000)
    public final void testGetSize() {
        AVLTree<Integer> t = new AVLTree<Integer>(15);
        assertEquals(1,t.getSize());
        t.insert(16);
        assertEquals(2,t.getSize());
        t.insert(15);
        assertEquals(3,t.getSize());
    }

    /**
     * Test method for {@link it.unicam.cs.asdl1819.miniproject2.AVLTree#getNumberOfNodes()}.
     */
    @Test(timeout=5000)
    public final void testGetNumberOfNodes() {
        AVLTree<Integer> t = new AVLTree<Integer>(15);
        assertEquals(1,t.getNumberOfNodes());
        t.insert(16);
        assertEquals(2,t.getNumberOfNodes());
        t.insert(15);
        assertEquals(2,t.getNumberOfNodes());
    }

    /**
     * Test method for {@link it.unicam.cs.asdl1819.miniproject2.AVLTree#getHeight()}.
     */
    @Test(timeout=5000)
    public final void testGetHeight() {
        AVLTree<Integer> t = new AVLTree<Integer>(15);
        assertEquals(0,t.getHeight());
        t.insert(16);
        assertEquals(1,t.getHeight());
        t.insert(13);
        assertEquals(1,t.getHeight());
        t.insert(14);
        assertEquals(2,t.getHeight());
        t.insert(17);
        assertEquals(2,t.getHeight());
        t.insert(18);
        assertEquals(2,t.getHeight());     
    }

    /**
     * Test method for {@link it.unicam.cs.asdl1819.miniproject2.AVLTree#getRoot()}.
     */
    @Test(timeout=5000)
    public final void testGetRoot() {
        AVLTree<Integer> t = new AVLTree<Integer>(15);
        AVLTreeNode n = t.getRoot();
        assertEquals(15,n.getEl()); 
        assertEquals(null,n.getLeft());
        assertEquals(null,n.getRight());
    }

    

    /**
     * Test method for {@link it.unicam.cs.asdl1819.miniproject2.AVLTree#isBalanced()}.
     */
    @Test(timeout=5000)
    public final void testIsBalanced() {
        AVLTree<Integer> t = new AVLTree<Integer>(15);
        t.insert(16);
        t.insert(13);
        t.insert(14);
        t.insert(17);
        t.insert(18);
        assertEquals(true,t.isBalanced());
    }

    /**
     * Test method for {@link it.unicam.cs.asdl1819.miniproject2.AVLTree#insert(java.lang.Comparable)}.
     */
    @Test(timeout=5000)
    public final void testInsertDDS() {
        // Rotazione DD Semplice
        AVLTree<Integer> t = new AVLTree<Integer>(15);
        t.insert(16);
        t.insert(13);
        t.insert(14);
        t.insert(17);
        t.insert(18);
        assertEquals(2,t.getHeight());
        List<Integer> l = t.inOrderVisit();
        List<Integer> ll = new ArrayList<Integer>();
        ll.add(13);
        ll.add(14);
        ll.add(15);
        ll.add(16);
        ll.add(17);
        ll.add(18);
        assertEquals(true, l.equals(ll));
        
    }
    
    /**
     * Test method for {@link it.unicam.cs.asdl1819.miniproject2.AVLTree#insert(java.lang.Comparable)}.
     */
    @Test(timeout=5000)
    public final void testInsertDDNS() {
        // Rotazione DD non Semplice
        AVLTree<Integer> t = new AVLTree<Integer>(20);
        t.insert(16);
        t.insert(30);
        t.insert(25);
        t.insert(40);
        t.insert(15);
        t.insert(35);
        t.insert(45);
        t.insert(17);
        t.insert(24);
        t.insert(26);
        t.insert(50);
        assertEquals(3,t.getHeight());
        assertEquals(true,t.getRoot().getEl().equals(30));
        List<Integer> l = t.inOrderVisit();
        List<Integer> ll = new ArrayList<Integer>();
        ll.add(15);
        ll.add(16);
        ll.add(17);
        ll.add(20);
        ll.add(24);
        ll.add(25);
        ll.add(26);
        ll.add(30);
        ll.add(35);
        ll.add(40);
        ll.add(45);
        ll.add(50);
        assertEquals(true, l.equals(ll));       
    }
    
    /**
     * Test method for {@link it.unicam.cs.asdl1819.miniproject2.AVLTree#insert(java.lang.Comparable)}.
     */
    @Test(timeout=5000)
    public final void testInsertSSS() {
        // Rotazione SS Semplice
        AVLTree<Integer> t = new AVLTree<Integer>(40);
        t.insert(30);
        t.insert(50);
        t.insert(20);
        t.insert(15);
        assertEquals(2,t.getHeight());
        assertEquals(true,t.getRoot().getEl().equals(40));
        List<Integer> l = t.inOrderVisit();
        List<Integer> ll = new ArrayList<Integer>();
        ll.add(15);
        ll.add(20);
        ll.add(30);
        ll.add(40);
        ll.add(50);
        assertEquals(true, l.equals(ll));       
    }
    
    /**
     * Test method for {@link it.unicam.cs.asdl1819.miniproject2.AVLTree#insert(java.lang.Comparable)}.
     */
    @Test(timeout=5000)
    public final void testInsertSSNS() {
        // Rotazione SS Non Semplice
        AVLTree<Integer> t = new AVLTree<Integer>(40);
        t.insert(30);
        t.insert(50);
        t.insert(20);
        t.insert(35);
        t.insert(55);
        t.insert(34);
        t.insert(36);
        t.insert(15);
        t.insert(25);
        t.insert(10);
        assertEquals(3,t.getHeight());
        assertEquals(true,t.getRoot().getEl().equals(30));
        List<Integer> l = t.inOrderVisit();
        List<Integer> ll = new ArrayList<Integer>();
        ll.add(10);
        ll.add(15);
        ll.add(20);
        ll.add(25);
        ll.add(30);
        ll.add(34);
        ll.add(35);
        ll.add(36);
        ll.add(40);
        ll.add(50);
        ll.add(55);
        assertEquals(true, l.equals(ll));       
    }
    
    /**
     * Test method for {@link it.unicam.cs.asdl1819.miniproject2.AVLTree#insert(java.lang.Comparable)}.
     */
    @Test(timeout=5000)
    public final void testInsertSD() {
        // Rotazione SD
        AVLTree<Integer> t = new AVLTree<Integer>(40);
        t.insert(20);
        t.insert(50);
        t.insert(30);
        t.insert(10);
        t.insert(55);
        t.insert(35);
        t.insert(25);
        t.insert(15);
        t.insert(5);
        t.insert(36);
        assertEquals(3,t.getHeight());
        assertEquals(true,t.getRoot().getEl().equals(30));
        List<Integer> l = t.inOrderVisit();
        List<Integer> ll = new ArrayList<Integer>();
        ll.add(5);
        ll.add(10);
        ll.add(15);
        ll.add(20);
        ll.add(25);
        ll.add(30);
        ll.add(35);
        ll.add(36);
        ll.add(40);
        ll.add(50);
        ll.add(55);
        assertEquals(true, l.equals(ll));       
    }
    
    /**
     * Test method for {@link it.unicam.cs.asdl1819.miniproject2.AVLTree#insert(java.lang.Comparable)}.
     */
    @Test(timeout=5000)
    public final void testInsertDS() {
        // Rotazione DS
        AVLTree<Integer> t = new AVLTree<Integer>(40);
        t.insert(20);
        t.insert(60);
        t.insert(30);
        t.insert(10);
        t.insert(30);
        t.insert(50);
        t.insert(70);
        t.insert(65);
        t.insert(75);
        t.insert(64);
        assertEquals(3,t.getHeight());
        assertEquals(true,t.getRoot().getRight().
                getEl().equals(65));
        List<Integer> l = t.inOrderVisit();
        List<Integer> ll = new ArrayList<Integer>();
        ll.add(10);
        ll.add(20);
        // Forzatura necessaria al superamento del test 
        // -------------------------------------------
        ll.add(30);
        // -------------------------------------------
        ll.add(30);
        ll.add(40);
        ll.add(50);
        ll.add(60);
        ll.add(64);
        ll.add(65);
        ll.add(70);
        ll.add(75);
        assertEquals(true, l.equals(ll));       
    }

    /**
     * Test method for {@link it.unicam.cs.asdl1819.miniproject2.AVLTree#contains(java.lang.Comparable)}.
     */
    @Test(timeout=5000)
    public final void testContains() {
        AVLTree<Integer> t = new AVLTree<Integer>(40);
        t.insert(20);
        t.insert(60);
        t.insert(10);
        t.insert(15);
        t.insert(30);
        t.insert(50);
        t.insert(60);
        t.insert(65);
        t.insert(75);
        t.insert(64);
        assertEquals(true,t.contains(50));
        assertEquals(true,t.contains(60));
        assertEquals(false,t.contains(5));
    }
    
    /**
     * Test method for {@link it.unicam.cs.asdl1819.miniproject2.AVLTree#contains(java.lang.Comparable)}.
     */
    @Test(timeout=5000,expected=NullPointerException.class)
    public final void testContainsNull() {
        AVLTree<Integer> t = new AVLTree<Integer>(40);
        t.insert(20);
        t.insert(60);
        t.insert(10);
        t.insert(15);
        t.insert(30);
        t.insert(50);
        t.insert(60);
        t.insert(65);
        t.insert(75);
        t.insert(null);
        fail("Eccezione NullPointer non lanciata");
    }

    /**
     * Test method for {@link it.unicam.cs.asdl1819.miniproject2.AVLTree#getNodeOf(java.lang.Comparable)}.
     */
    @Test(timeout=5000)
    public final void testGetNodeOf() {
        AVLTree<Integer> t = new AVLTree<Integer>(40);
        t.insert(20);
        t.insert(60);
        t.insert(25);
        t.insert(65);
        t.insert(60);
        AVLTreeNode n = t.getNodeOf(60);
        assertNotEquals(null,n);
        assertEquals(true,n.getEl().equals(60));
        assertEquals(2,n.getCount());
        assertEquals(true,n.getParent().getEl().equals(40));
        assertEquals(null,n.getLeft());
        assertEquals(true,n.getRight().getEl().equals(65));
        n = t.getNodeOf(10);
        assertEquals(null,n);
    }
    
    /**
     * Test method for {@link it.unicam.cs.asdl1819.miniproject2.AVLTree#getNodeOf(java.lang.Comparable)}.
     */
    @Test(timeout=5000,expected=NullPointerException.class)
    public final void testGetNodeOfNull() {
        AVLTree<Integer> t = new AVLTree<Integer>(40);
        t.insert(20);
        t.insert(60);
        t.insert(25);
        t.insert(65);
        t.insert(60);
        AVLTreeNode n = t.getNodeOf(null);
        fail("Eccezione Null Pointer non lanciata");
    }

    /**
     * Test method for {@link it.unicam.cs.asdl1819.miniproject2.AVLTree#getCount(java.lang.Comparable)}.
     */
    @Test(timeout=5000)
    public final void testGetCount() {
        AVLTree<Integer> t = new AVLTree<Integer>(40);
        t.insert(20);
        t.insert(60);
        t.insert(25);
        t.insert(65);
        assertEquals(0,t.getCount(0));
        assertEquals(1,t.getCount(60));
        t.insert(60);
        assertEquals(2,t.getCount(60));
    }

    /**
     * Test method for {@link it.unicam.cs.asdl1819.miniproject2.AVLTree#inOrderVisit()}.
     */
    @Test(timeout=5000)
    public final void testInOrderVisit() {
        AVLTree<Integer> t = new AVLTree<Integer>(40);
        t.insert(20);
        t.insert(60);
        t.insert(10);
        t.insert(15);
        t.insert(30);
        t.insert(50);
        t.insert(60);
        t.insert(65);
        t.insert(75);
        t.insert(64);
        List<Integer> l = t.inOrderVisit();
        List<Integer> ll = new ArrayList<Integer>();
        ll.add(10);
        ll.add(15);
        ll.add(20);
        ll.add(30);
        ll.add(40);
        ll.add(50);
        ll.add(60);
        ll.add(60);
        ll.add(64);
        ll.add(65);
        ll.add(75);
        assertEquals(true, l.equals(ll));    
    }

    /**
     * Test method for {@link it.unicam.cs.asdl1819.miniproject2.AVLTree#getMinimum()}.
     */
    @Test(timeout=5000)
    public final void testGetMinimum() {
        AVLTree<Integer> t = new AVLTree<Integer>(40);
        t.insert(20);
        t.insert(60);
        t.insert(10);
        t.insert(15);
        t.insert(30);
        t.insert(50);
        t.insert(60);
        t.insert(65);
        t.insert(75);
        t.insert(64);
        assertEquals(true,t.getMinimum().equals(10));
    }
    
    /**
     * Test method for {@link it.unicam.cs.asdl1819.miniproject2.AVLTree#getMinimum()}.
     */
    @Test(timeout=5000)
    public final void testGetMinimumMaximumNull() {
        AVLTree<Integer> t = new AVLTree<Integer>();
        assertEquals(null,t.getMinimum());
        assertEquals(null,t.getMaximum());
    }

    /**
     * Test method for {@link it.unicam.cs.asdl1819.miniproject2.AVLTree#getMaximum()}.
     */
    @Test(timeout=5000)
    public final void testGetMaximum() {
        AVLTree<Integer> t = new AVLTree<Integer>(40);
        t.insert(20);
        t.insert(60);
        t.insert(10);
        t.insert(15);
        t.insert(30);
        t.insert(50);
        t.insert(60);
        t.insert(65);
        t.insert(75);
        t.insert(64);
        assertEquals(true,t.getMaximum().equals(75));
    }

    /**
     * Test method for {@link it.unicam.cs.asdl1819.miniproject2.AVLTree#getSuccessor(java.lang.Comparable)}.
     */
    @Test(timeout=5000,expected=NullPointerException.class)
    public final void testGetSuccessorNull() {
        AVLTree<Integer> t = new AVLTree<Integer>(40);
        t.insert(20);
        t.getSuccessor(null);
        fail("Eccezione Null Pointer non lanciata"); 
    }
    
    /**
     * Test method for {@link it.unicam.cs.asdl1819.miniproject2.AVLTree#getSuccessor(java.lang.Comparable)}.
     */
    @Test(timeout=5000,expected=IllegalArgumentException.class)
    public final void testGetSuccessorIllegal() {
        AVLTree<Integer> t = new AVLTree<Integer>(40);
        t.insert(20);
        t.getSuccessor(25);
        fail("Eccezione Illegal Argument non lanciata");
    }
    
    /**
     * Test method for {@link it.unicam.cs.asdl1819.miniproject2.AVLTree#getSuccessor(java.lang.Comparable)}.
     */
    @Test(timeout=5000)
    public final void testGetSuccessor() {
        AVLTree<Integer> t = new AVLTree<Integer>(40);
        t.insert(20);
        t.insert(60);
        t.insert(10);
        t.insert(25);
        t.insert(50);
        t.insert(65);
        t.insert(60);
        t.insert(65);
        t.insert(75);
        t.insert(64);
        assertEquals(true,t.getSuccessor(60).equals(64));
        assertEquals(true,t.getSuccessor(25).equals(40));
        assertEquals(true,t.getSuccessor(40).equals(50));
    }
    
    /**
     * Test method for {@link it.unicam.cs.asdl1819.miniproject2.AVLTree#getSuccessor(java.lang.Comparable)}.
     */
    @Test(timeout=5000)
    public final void testGetSuccessorMaximum() {
        AVLTree<Integer> t = new AVLTree<Integer>(40);
        t.insert(20);
        t.insert(60);
        t.insert(10);
        t.insert(25);
        t.insert(50);
        t.insert(65);
        t.insert(60);
        t.insert(65);
        t.insert(75);
        t.insert(64);
        assertEquals(null,t.getSuccessor(75));
    }

    /**
     * Test method for {@link it.unicam.cs.asdl1819.miniproject2.AVLTree#getPredecessor(java.lang.Comparable)}.
     */
    @Test(timeout=5000,expected=NullPointerException.class)
    public final void testGetPredecessorNull() {
        AVLTree<Integer> t = new AVLTree<Integer>(40);
        t.insert(20);
        t.getPredecessor(null);
        fail("Eccezione Null Pointer non lanciata"); 
    }
    
    /**
     * Test method for {@link it.unicam.cs.asdl1819.miniproject2.AVLTree#getPredecessor(java.lang.Comparable)}.
     */
    @Test(timeout=5000,expected=IllegalArgumentException.class)
    public final void testGetPredecessorIllegal() {
        AVLTree<Integer> t = new AVLTree<Integer>(40);
        t.insert(20);
        t.getPredecessor(25);
        fail("Eccezione Illegal Argument non lanciata");
    }
    
    /**
     * Test method for {@link it.unicam.cs.asdl1819.miniproject2.AVLTree#getPredecessor(java.lang.Comparable)}.
     */
    @Test(timeout=5000)
    public final void testGetPredecessor() {
        AVLTree<Integer> t = new AVLTree<Integer>(40);
        t.insert(20);
        t.insert(60);
        t.insert(10);
        t.insert(25);
        t.insert(50);
        t.insert(65);
        t.insert(60);
        t.insert(65);
        t.insert(75);
        t.insert(64);
        assertEquals(true,t.getPredecessor(25).equals(20));
        assertEquals(true,t.getPredecessor(50).equals(40));
        assertEquals(true,t.getPredecessor(40).equals(25));
    }
    
    /**
     * Test method for {@link it.unicam.cs.asdl1819.miniproject2.AVLTree#getPredecessor(java.lang.Comparable)}.
     */
    @Test(timeout=5000)
    public final void testGetPredecessorMinimum() {
        AVLTree<Integer> t = new AVLTree<Integer>(40);
        t.insert(20);
        t.insert(60);
        t.insert(10);
        t.insert(25);
        t.insert(50);
        t.insert(65);
        t.insert(60);
        t.insert(65);
        t.insert(75);
        t.insert(64);
        assertEquals(null,t.getPredecessor(10));
    }

}
