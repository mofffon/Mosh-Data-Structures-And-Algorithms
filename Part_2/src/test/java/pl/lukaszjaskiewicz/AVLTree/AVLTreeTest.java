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
}