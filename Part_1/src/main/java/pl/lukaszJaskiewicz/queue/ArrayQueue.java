package pl.lukaszJaskiewicz.queue;
import java.util.Stack;


public class ArrayQueue implements FullQueue {

    private final Integer[] items;
    private int front = 0;
    private int count = 0;

    public ArrayQueue(int capacity){
        items = new Integer[capacity];
    }

    public int size() {
        return count;
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public boolean isFull() {
        return count == items.length;
    }

    public void enqueue(int item){
        if(isFull()){
            throw new IllegalStateException("Queue is full. Can not enqueue new items.");
        }

        int back = (front + count) % items.length;
        items[back] = item;
        count++;
    }

    public int dequeue() {
        if(isEmpty()){
            throw new IllegalStateException("Queue is empty. Can not dequeue items.");
        }

        int item = items[front];
        front = (front + 1) % items.length;
        count--;
        return item;
    }

    public int peek() {
        if(isEmpty()){
            throw new IllegalStateException("Queue is empty. Can not peek items.");
        }

        return items[front];
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("[");

        int start = front;
        int stop = (start + count) < start ? (start + count) % items.length: start + count;

        for(int i = start; i < stop; i++) {
            sb.append(items[i % items.length]).append(i < (stop - 1)? ", ": "");
        }

        return sb.append("]").toString();
    }

}
