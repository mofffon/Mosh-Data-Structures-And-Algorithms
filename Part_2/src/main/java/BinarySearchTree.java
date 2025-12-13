import java.util.ArrayList;
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

    @Override
    public String toString(){
        if(root == null){
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while(!stack.empty()){
            var current = stack.pop();
            sb.append(current.value);

            if(current.rightChild != null){
                stack.push(current.rightChild);
            }
            if(current.leftChild != null){
                stack.push(current.leftChild);
            }

            sb.append(!stack.empty() ? ", " : "");
        }

        return sb.append("]").toString();
    }
}
