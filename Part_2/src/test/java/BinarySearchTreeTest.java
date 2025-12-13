import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

    @Test
    void height_whenCalledOnEmptyBinarySearchTree_shouldReturnZero() {
        assertEquals(-1, tree.height());
    }

    @Test
    void height_whenCalled_shouldReturnHeightOfTheBinarySearchTree(){
        for(var num: new int[]{7,4,9,1,6,8,10}){
            tree.insert(num);
        }

        assertEquals(2, tree.height());
    }

    @Test
    void min_whenCalledOnEmptyBinarySearchTre_shouldThrowIllegalStateException(){
        assertThrows(IllegalStateException.class, () -> tree.min());
    }

    @Test
    void min_whenCalled_shouldReturnMinValueOfTheBinarySearchTree() {
        for(var num: new int[]{7,4,9,1,6,8,10}){
            tree.insert(num);
        }

        assertEquals(1, tree.min());
    }

    @Test
    void min2_whenCalledOnEmptyBinarySearchTre_shouldThrowIllegalStateException(){
        assertThrows(IllegalStateException.class, () -> tree.min2());
    }

    @Test
    void min2_whenCalled_shouldReturnMinValueOfBinarySearchTree() {
        for(var num: new int[]{7,4,9,1,6,8,10}){
            tree.insert(num);
        }

        assertEquals(1, tree.min2());
    }

    @Test
    void max_whenCalledOnEmptyTree_shouldThrowIllegalStateException() {
        assertThrows(IllegalStateException.class, () -> tree.max());
    }

    @Test
    void max_whenCalled_shouldReturnMaxValueOfBinarySearchTree(){
        for(var num: new int[]{7,4,9,1,6,8,10}){
            tree.insert(num);
        }

        assertEquals(10, tree.max());
    }

    @Test
    void max2_whenCalledOnEmptyTree_shouldThrowIllegalStateException() {
        assertThrows(IllegalStateException.class, () -> tree.max2());
    }

    @Test
    void max2_whenCalled_shouldReturnMaxValueOfBinarySearchTree(){
        for(var num: new int[]{7,4,9,1,6,8,10}){
            tree.insert(num);
        }

        assertEquals(10, tree.max2());
    }

    @Test
    void equals_whenCalledOnIdenticalTrees_shouldReturnTrue() {
        for(var num: new int[]{7,4,9,1,6,8,10}){
            tree.insert(num);
        }

        BinarySearchTree other = new BinarySearchTree();
        for(var num: new int[]{7,4,9,1,6,8,10}){
            other.insert(num);
        }

        assertTrue(tree.equals(other));
    }

    @Test
    void equals_whenCalledOnOneOrBothEmptyTrees_shouldReturnFalse() {
        for(var num: new int[]{7,4,9,1,6,8,10}){
            tree.insert(num);
        }

        assertFalse(tree.equals(new BinarySearchTree()));
        assertFalse(new BinarySearchTree().equals(tree));
        assertFalse(new BinarySearchTree().equals(new BinarySearchTree()));
    }

    @Test
    void equals_whenCalledOnNonIdenticalTrees_shouldReturnFalse() {
        for(var num: new int[]{7,4,9,1,6,8,10}){
            tree.insert(num);
        }

        BinarySearchTree other = new BinarySearchTree();
        for(var num: new int[]{7,4,9,1,6,11}){
            other.insert(num);
        }

        assertFalse(tree.equals(other));
    }

    @Test
    void isValid_whenCalledOnEmptyTree_shouldReturnFalse(){
        assertFalse(new BinarySearchTree().isValid());
    }

    @Test
    void isValid_whenCalledOnProperTree_shouldReturnTrue() {
        for(var num: new int[]{7,4,9,1,6,8,10}){
            tree.insert(num);
        }

        assertTrue(tree.isValid());
    }

    @Test
    void isValid_whenCalledOnInProperTree_shouldReturnFalse() {
        for(var num: new int[]{7,4,9,1,6,8,10}){
            tree.insert(num);
        }

        tree.swapLeftSubTreeWithRightSubTreeOnRoot();
        assertFalse(tree.isValid());
    }
}