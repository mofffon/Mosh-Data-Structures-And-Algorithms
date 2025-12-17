package pl.lukaszjaskiewicz.AVLTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AVLTree {

    private static class AVLNode{
        int value;
        int height;
        AVLNode leftChild;
        AVLNode rightChild;

        public AVLNode(int value){
            this.value = value;
        }

        @Override
        public String toString(){
            return Integer.toString(value);
        }
    }

    private AVLNode root;

    public void insert(int value) {
        root = insert(value, root);
    }

    private AVLNode insert(int value, AVLNode root){
        if(root == null){
            return new AVLNode(value);
        }

        if(value < root.value){
            root.leftChild = insert(value, root.leftChild);
        } else {
            root.rightChild = insert(value, root.rightChild);
        }

        setHeight(root);

        return balance(root);
    }

    private AVLNode balance(AVLNode root){
        if(isLeftHeavy(root)){
            if(balanceFactor(root.leftChild) == -1){
                root.leftChild = rotateLeft(root.leftChild);
            }
            root = rotateRight(root);
        }else if(isRightHeavy(root)){
            if(balanceFactor(root.rightChild) == 1){
                root.rightChild = rotateRight(root.rightChild);
            }
            root = rotateLeft(root);
        }

        return root;
    }

    private AVLNode rotateRight(AVLNode root){
        AVLNode newRoot = root.leftChild;
        root.leftChild = newRoot.rightChild;
        newRoot.rightChild = root;

        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }

    private AVLNode rotateLeft(AVLNode root){
        AVLNode newRoot = root.rightChild;
        root.rightChild = newRoot.leftChild;
        newRoot.leftChild = root;

        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }

    private void setHeight(AVLNode root){
        root.height = 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    private int balanceFactor(AVLNode root){
        return (root == null) ? 0: height(root.leftChild) - height(root.rightChild);
    }

    private boolean isLeftHeavy(AVLNode root){
        return balanceFactor(root) > 1;
    }

    private boolean isRightHeavy(AVLNode root){
        return balanceFactor(root) < -1;
    }

    private int height(AVLNode root){
        return root == null ? -1: root.height;
    }

    private boolean isLeaf(AVLNode root){
        return root.leftChild == null && root.rightChild == null;
    }

    private Integer[] preOrderTraversal(){

        List<Integer> list = new ArrayList<>();
        preOrderTraversal(root, list);

        return list.toArray(new Integer[0]);
    }

    private void preOrderTraversal(AVLNode root, List<Integer> list){

        if(root == null){
            return;
        }

        list.add(root.value);
        preOrderTraversal(root.leftChild, list);
        preOrderTraversal(root.rightChild, list);
    }

    @Override
    public String toString(){

        return Arrays.toString(preOrderTraversal());
    }

}
