package pl.lukaszJaskiewicz.queue;

import java.util.LinkedList;

public class LinkedListQueue implements Queue{

    LinkedList<Integer> items = new LinkedList<>();

    public int size() {
        return items.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void enqueue(int item) {
        items.add(item);
    }

    public int dequeue() {
        if(isEmpty()){
            throw new IllegalStateException("Queue is empty. Can not dequeue.");
        }

        return items.removeFirst();
    }

    public int peek() {
        if(isEmpty()){
            throw new IllegalStateException("Queue is empty. Can not peek.");
        }

        return items.getFirst();
    }

    public boolean isFull() {
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        int size = size();

        for(int i = 0; i < size; i++){
            int item = items.removeFirst();
            sb.append(item).append((i != (size - 1)? ", ":""));
            items.add(item);
        }

        sb.append("]");

        return sb.toString();
    }
}
