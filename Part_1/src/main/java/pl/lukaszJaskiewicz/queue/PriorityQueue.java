package pl.lukaszJaskiewicz.queue;

public class PriorityQueue implements FullQueue {

    private final int[] items;
    private int backPointer = 0;
    private int frontPointer = 0;
    private int count = 0;

    public PriorityQueue() {
        items = new int[5];
    }

    public PriorityQueue(int capacity) {
        items = new int[capacity];
    }

    public int size() {
        return count;
    }

    public boolean isFull() {
        return count == items.length;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void enqueue(int item){

        if (isFull()) {
            throw new IllegalStateException("Queue is full. Can not enqueue.");
        }

        if(isEmpty()){
            items[backPointer] = item;
            backPointer = (backPointer + 1) % items.length;
            count++;
            return;
        }

        int back = backPointer <= frontPointer? backPointer + items.length: backPointer;

        int index = back - 1;
        while(index >= frontPointer){
            if(items[index % items.length] > item) {
                items[(index + 1) % items.length] = items[index % items.length];
            }else{
                break;
            }
            index--;
        }

        items[(index + 1) % items.length] = item;

        count++;
        backPointer = (backPointer + 1) % items.length;
    }

    public int dequeue() {
        if(isEmpty()){
            throw new IllegalStateException("Queue is empty. Can not dequeue.");
        }

        int item = items[frontPointer];
        count--;
        frontPointer = (frontPointer + 1) % items.length;
        return item;
    }

    public int peek() {
        if(isEmpty()){
            throw new IllegalStateException("Queue is empty. Can not peek.");
        }

        return items[frontPointer];
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("[");

        int back = backPointer <= frontPointer? frontPointer + count: backPointer;

        for(int i = frontPointer; i < back; i++) {
            sb.append(items[i % items.length]).append( i != (back - 1)? ", ": "");
        }

        sb.append("]");
        return sb.toString();
    }
}
