package pl.lukaszJaskiewicz.queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class StackOfTwoQueues {

    private Queue<Integer> queue1 = new ArrayDeque<>();
    private Queue<Integer> queue2 = new ArrayDeque<>();
    private int count = 0;

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    public void push(int item){
        queue1.add(item);
        count++;
    }

    public int pop(){

        if(isEmpty()){
            throw new IllegalStateException("The stack is empty. Can not pop.");
        }

        while(queue1.size() != 1){
            queue2.add(queue1.remove());
        }

        int item = queue1.remove();

        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        count--;

        return item;
    }

    public int peek(){
        if(isEmpty()){
            throw new IllegalStateException("The stack is empty. Can not peek.");
        }

        Integer item = Integer.MIN_VALUE;

        while(!queue1.isEmpty()){
            if(queue1.size() == 1) {
                item = queue1.peek();
            }
            queue2.add(queue1.remove());
        }

        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return item;
    }
}
