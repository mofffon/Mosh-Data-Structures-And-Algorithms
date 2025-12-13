import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    private BinarySearchTree tree;

    @BeforeEach
    void setUp(){
        tree = new BinarySearchTree();
    }

    @Test
    void insert_whenCalledWithAnInteger_shouldPlaceNumberInTree() {
        for(var num: new int[]{10, 5, 15, 6, 1, 8, 12, 18, 17}){
            tree.insert(num);
        }

        assertEquals("[10, 5, 1, 6, 8, 15, 12, 18, 17]", tree.toString());
    }

    @Test
    void find_whenCalledWithARandomNumberOnEmptyTree_shouldReturnFalse() {
        assertFalse(tree.find(3));
    }

    @Test
    void find_whenCalledWithANumberPresentInTree_shouldReturnTrue() {
        for(var num: new int[]{10, 5, 15, 6, 1, 8, 12, 18, 17}){
            tree.insert(num);
        }

        assertTrue(tree.find(1));
    }

    @Test
    void find_whenCalledWithANumberNotPresentInTree_shouldReturnFalse() {
        for(var num: new int[]{10, 5, 15, 6, 1, 8, 12, 18, 17}){
            tree.insert(num);
        }

        assertFalse(tree.find(13));
    }

    @Test
    void preOrderTraversal_whenCalled_shouldTraverseTheBinarySearchTreeInPreOrder() {
        for(var num: new int[]{7,4,9,1,6,8,10}){
            tree.insert(num);
        }

        assertArrayEquals(new Integer[]{7, 4, 1, 6, 9, 8, 10}, tree.preOrderTraversal());
    }

    @Test
    void preOrderTraversalIterative_whenCalled_shouldTraverseTheBinarySearchTreeInPreOrder() {
        for(var num: new int[]{7,4,9,1,6,8,10}){
            tree.insert(num);
        }

        assertArrayEquals(new Integer[]{7, 4, 1, 6, 9, 8, 10}, tree.preOrderTraversalIterative());
    }

    @Test
    void inOrderTraversal_whenCalled_shouldTraverseTheBinarySearchTreInOrder() {
        for(var num: new int[]{7,4,9,1,6,8,10}){
            tree.insert(num);
        }

        assertArrayEquals(new Integer[]{1, 4, 6, 7, 8, 9, 10}, tree.inOrderTraversal());;
    }

    @Test
    void inOrderTraversalIterative_whenCalled_shouldTraverseTheBinarySearchTreInOrder() {
        for(var num: new int[]{7,4,9,1,6,8,10}){
            tree.insert(num);
        }

        assertArrayEquals(new Integer[]{1, 4, 6, 7, 8, 9, 10}, tree.inOrderTraversalIterative());;
    }

    @Test
    void postOrderTraversal_whenCalled_shouldTraverseTheBinarySearchTreePostOrder() {
        for(var num: new int[]{7,4,9,1,6,8,10}){
            tree.insert(num);
        }

        assertArrayEquals(new Integer[]{1, 6, 4, 8, 10, 9, 7}, tree.postOrderTraversal());
    }

    @Test
    void preOrderTraversalIterative_whenCalled_shouldTraverseTheBinarySearchTreePostOrder() {
        for(var num: new int[]{7,4,9,1,6,8,10}){
            tree.insert(num);
        }

        assertArrayEquals(new Integer[]{1, 6, 4, 8, 10, 9, 7}, tree.postOrderTraversalIterative());
    }
}