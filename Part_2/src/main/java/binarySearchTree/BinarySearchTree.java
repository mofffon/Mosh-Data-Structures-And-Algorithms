package binarySearchTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BinarySearchTree {

    private class Node{
        int value;
        Node leftChild;
        Node rightChild;

        public Node(int value){
            this.value = value;
        }

        @Override
        public String toString(){
            return Integer.toString(value);
        }
    }

    private Node root;

    public void insert(int value){

        var newNode = new Node(value);

        if(root == null){
            root = newNode;
            return;
        }

        Node previous = null;
        Node current = root;

        while(current != null){
            previous = current;
            if(value < current.value){
                current = current.leftChild;
            }else{
                current = current.rightChild;
            }
        }

        if(value < previous.value){
            previous.leftChild = newNode;
        }else{
            previous.rightChild = newNode;
        }
    }

    public boolean find(int searched){

        var current = root;

        while(current != null){
            if(searched < current.value){
                current = current.leftChild;
            }else if(searched > current.value){
                current = current.rightChild;
            }else{
                return true;
            }
        }

        return false;
    }

    public Integer[] preOrderTraversal(){

        List<Integer> list = new ArrayList<>();
        preOrderTraversal(root, list);

        return list.toArray(new Integer[0]);
    }

    private void preOrderTraversal(Node root, List<Integer> list){

        if(root == null){
            return;
        }

        list.add(root.value);
        preOrderTraversal(root.leftChild, list);
        preOrderTraversal(root.rightChild, list);
    }

    public Integer[] preOrderTraversalIterative(){

        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();

        if(root != null){
            stack.push(root);
        }

        while(!stack.empty()) {
            Node current = stack.pop();
            list.add(current.value);

            if(current.rightChild != null){
                stack.push(current.rightChild);
            }

            if(current.leftChild != null){
                stack.push(current.leftChild);
            }
        }

        return list.toArray(new Integer[0]);
    }

    public Integer[] inOrderTraversal(){
        List<Integer> list = new ArrayList<>();
        inOrderTraversal(root, list);

        return list.toArray(new Integer[0]);
    }

    private void inOrderTraversal(Node root, List<Integer> list){
        if(root == null){
            return;
        }

        inOrderTraversal(root.leftChild, list);
        list.add(root.value);
        inOrderTraversal(root.rightChild, list);
    }

    public Integer[] inOrderTraversalIterative() {
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();

        Node current = root;

        while(!stack.empty() || current != null) {

            if(current != null){
                stack.push(current);
                current = current.leftChild;
            }else{
                current = stack.pop();
                list.add(current.value);
                current = current.rightChild;
            }
        }

        return list.toArray(new Integer[0]);
    }

    public Integer[] postOrderTraversal() {
        List<Integer> list = new ArrayList<>();
        postOrderTraversal(root, list);

        return list.toArray(new Integer[0]);
    }

    private void postOrderTraversal(Node root, List<Integer> list) {
        if(root == null){
            return;
        }

        postOrderTraversal(root.leftChild, list);
        postOrderTraversal(root.rightChild, list);
        list.add(root.value);
    }

    public Integer[] postOrderTraversalIterative() {
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        if(root != null){
            stack.push(root);
        }

        while(!stack.empty()){
            Node current = stack.pop();

            stack2.push(current);

            if(current.leftChild != null){
                stack.push(current.leftChild);
            }

            if(current.rightChild != null){
                stack.push(current.rightChild);
            }
        }

        while(!stack2.empty()){
            list.add(stack2.pop().value);
        }

        return list.toArray(new Integer[0]);
    }

    public int height(){
        return height(root);
    }

    private int height(Node root){
        if(root == null){
            return -1;
        }

        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    public int min(){
        if(root == null){
            throw new IllegalStateException("Tree is empty, can not calculate min.");
        }

        return min(root);
    }

    private int min(Node root){
        if(root == null){
            return Integer.MAX_VALUE;
        }

        int leftMin = min(root.leftChild);
        int rightMin = min(root.rightChild);

        return Math.min(root.value, Math.min(leftMin, rightMin));
    }

    public int min2(){
        if(root == null){
            throw new IllegalStateException("Tree is empty, can not calculate min.");
        }

        var current = root;
        while(current.leftChild != null){
            current = current.leftChild;
        }

        return current.value;
    }

    public int max() {
        if(root == null){
            throw new IllegalStateException("Tree is empty, can not calculate max.");
        }

        return max(root);
    }

    private int max(Node root) {
        if(root == null){
            return Integer.MIN_VALUE;
        }

        int leftMin = max(root.leftChild);
        int rightMin = max(root.rightChild);

        return Math.max(root.value, Math.max(leftMin, rightMin));
    }

    public int max2() {
        if(root == null){
            throw new IllegalStateException("Tree is empty, can not calculate max.");
        }

        var current = root;
        while(current.rightChild != null){
            current = current.rightChild;
        }

        return current.value;
    }

    public boolean equals(BinarySearchTree other) {
        if(other.root == null){
            return false;
        }

        return equals(this.root, other.root);
    }

    private boolean equals(Node thisNode, Node otherNode){
        if(thisNode == null && otherNode == null){
            return true;
        }

        if((thisNode != null && otherNode == null) || (thisNode == null && otherNode != null)){
            return false;
        }

        return thisNode.value == otherNode.value && equals(thisNode.leftChild, otherNode.leftChild) && equals(thisNode.rightChild, otherNode.rightChild);
    }

    public boolean isValid(){
        if(root == null){
            return false;
        }

        return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValid(Node root, int minVal, int maxVal){
        if(root == null){
            return true;
        }

        return root.value > minVal && root.value < maxVal
                && isValid(root.leftChild, minVal, root.value)
                && isValid(root.rightChild, root.value, maxVal);
    }

    public void swapLeftSubTreeWithRightSubTreeOnRoot(){
        Node temp = root.leftChild;
        root.leftChild = root.rightChild;
        root.rightChild = temp;
    }

    @Override
    public String toString(){
        if(root == null){
            return "[]";
        }

        Integer[] nodes = preOrderTraversal();

        return Arrays.toString(nodes);
    }
}
