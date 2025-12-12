package pl.lukaszJaskiewicz.queue;

import java.util.Stack;

public class QueueReverser {

    public static void reverse(int k, Queue queue){

        if(k > queue.size()){
            throw new IllegalArgumentException("Parameter k is larger than queue size (" + queue.size() + ")");
        }

        Stack<Integer> stack = new Stack<>();

        for( int i = 0; i < k; i++){
            stack.push(queue.dequeue());
        }

        for( int i = 0; i < k; i++){
            queue.enqueue(stack.pop());
        }

        for(int i = 0; i < queue.size() - k; i++){
            queue.enqueue(queue.dequeue());
        }
    }

    public static void reverse(Queue queue) {

        Stack<Integer> stack = new Stack<>();

        while(!queue.isEmpty()) {
            stack.add(queue.dequeue());
        }

        while(!stack.isEmpty()) {
            queue.enqueue(stack.pop());
        }
    }

}
