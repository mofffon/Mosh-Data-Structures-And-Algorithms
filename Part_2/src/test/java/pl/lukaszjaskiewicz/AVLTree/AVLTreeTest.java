package pl.lukaszjaskiewicz.AVLTree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AVLTreeTest {

    AVLTree aVLTree;

    @BeforeEach
    void setUp(){
        aVLTree = new AVLTree();
    }

    @Test
    void insert_whenCalledLeftHeavyTree_shouldBeBalanced() {
        aVLTree.insert(30);
        aVLTree.insert(20);
        aVLTree.insert(10);

        assertEquals("[20, 10, 30]", aVLTree.toString());
    }

    @Test
    void insert_whenCalledRightHeavyTree_shouldBeBalanced() {
        aVLTree.insert(10);
        aVLTree.insert(20);
        aVLTree.insert(30);

        assertEquals("[20, 10, 30]", aVLTree.toString());
    }

    @Test
    void insert_whenCalledLeftRightHeavyTree_shouldBeBalanced() {
        aVLTree.insert(30);
        aVLTree.insert(10);
        aVLTree.insert(20);

        assertEquals("[20, 10, 30]", aVLTree.toString());
    }

    @Test
    void insert_whenCalledRightLeftHeavyTree_shouldBeBalanced() {
        aVLTree.insert(10);
        aVLTree.insert(30);
        aVLTree.insert(20);

        assertEquals("[20, 10, 30]", aVLTree.toString());
    }

    @Test
    void isBalanced_whenCalledOnEmptyAVLTree_shouldReturnTrue(){
        assertTrue(aVLTree.isBalanced());
    }

    @Test
    void isBalanced_whenCalledOnAVLTree_shouldReturnTrue(){
        aVLTree.insert(12);
        aVLTree.insert(3);
        aVLTree.insert(9);
        aVLTree.insert(4);
        aVLTree.insert(6);
        aVLTree.insert(2);

        assertTrue(aVLTree.isBalanced());
    }

    @Test
    void size_whenCalledOnEmptyTree_shouldReturnZero() {
        assertEquals(0, aVLTree.size());
    }

    @Test
    void size_whenCalled_shouldReturnCountOfNodesInAVLTree(){
        aVLTree.insert(12);
        aVLTree.insert(3);
        aVLTree.insert(9);
        aVLTree.insert(4);
        aVLTree.insert(6);
        aVLTree.insert(2);

        assertEquals(6, aVLTree.size());
    }

    @Test
    void isPerfect_henCalledOnPerfectTree_shouldReturnTrue() {
        aVLTree.insert(10);
        aVLTree.insert(30);
        aVLTree.insert(20);

        assertTrue(aVLTree.isPerfect());
    }

    @Test void isPerfect_whenCalledONNotPerfectAVLTree_shouldReturnFalse() {
        aVLTree.insert(12);
        aVLTree.insert(3);
        aVLTree.insert(9);
        aVLTree.insert(4);
        aVLTree.insert(6);
        aVLTree.insert(2);

        assertFalse(aVLTree.isPerfect());
    }
}