package pl.lukaszJaskiewicz.stack;

import java.util.LinkedList;

public class StackLinkedListImpl {

    LinkedList<Integer> items = new LinkedList<>();

    public boolean isEmpty(){
        return items.isEmpty();
    }

    public void push(int input) {

        items.addLast(input);
    }

    public int pop() {
        if(isEmpty()){
            throw new IllegalStateException("The stack is empty, can not peek");
        }

        return items.removeLast();
    }

    public int peek() {
        if(isEmpty()){
            throw new IllegalStateException("The stack is empty, can not peek");
        }

        return items.getLast();
    }

}
