package pl.lukaszjaskiewicz.heap;

public class MinPriorityQueue {

    private MinHeap heap;

    public MinPriorityQueue(){
        heap = new MinHeap();
    }

    public MinPriorityQueue(int capacity) {
        heap = new MinHeap(capacity);
    }

    public boolean isEmpty(){
        return heap.isEmpty();
    }

    public void enqueue(int key, String value){
        if(heap.isFull()){
            throw new IllegalStateException("The queue is full. Can not enqueue.");
        }

        heap.insert(key, value);
    }

    public String dequeue(){
        if(isEmpty()){
            throw new IllegalStateException("The queue is empty. Can not dequeue.");
        }

        return heap.remove();
    }

}
