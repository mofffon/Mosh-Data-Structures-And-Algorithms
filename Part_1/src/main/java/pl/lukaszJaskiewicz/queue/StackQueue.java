package pl.lukaszJaskiewicz.queue;

import java.util.Arrays;
import java.util.Stack;

public class StackQueue implements Queue{

    private Stack<Integer> items = new Stack<>();
    private Stack<Integer> helperStack = new Stack<>();

    public int size(){
        return items.size() + helperStack.size();
    }

    public boolean isFull(){
        return false;
    }

    public boolean isEmpty(){
        return items.isEmpty() && helperStack.isEmpty();
    }

    public void enqueue(int item) {
        items.add(item);
    }

    public int dequeue() {
        if(isEmpty()){
            throw new IllegalStateException("The queue is empty. Can not dequeue.");
        }

        if(helperStack.isEmpty()){
            moveStackItemsToHelperStack();
        }

        return helperStack.pop();
    }

    public int peek() {
        if(isEmpty()){
            throw new IllegalStateException("The queue is empty. Can not peek.");
        }

        if(helperStack.isEmpty()){
            moveStackItemsToHelperStack();
        }

        return helperStack.peek();
    }

    private void moveStackItemsToHelperStack(){

        while(!items.isEmpty()){
            helperStack.push(items.pop());
        }
    }

    @Override
    public String toString() {
        Integer[] itemsArr = items.toArray(new Integer[0]);
        Integer[] helperArr = helperStack.toArray(new Integer[0]);
        reverseArr(helperArr);

        return Arrays.toString(mergeArr(itemsArr, helperArr));
    }

    private void reverseArr(Integer[] arr){

        int mid = arr.length / 2;

        for(int i = 0; i < mid; i++){
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }

    private Integer[] mergeArr(Integer[] arr1, Integer[] arr2){

        Integer[] newArr = new Integer[arr1.length + arr2.length];

        int index = 0;
        for(Integer item: arr1) {
            newArr[index++] = item;
        }

        for(Integer item: arr2) {
            newArr[index++] = item;
        }

        return newArr;
    }
}
