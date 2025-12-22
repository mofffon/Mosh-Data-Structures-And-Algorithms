package pl.lukaszjaskiewicz.heap;

public class PriorityQueueHeapImpl {

    private final MaxHeap maxHeap = new MaxHeap();

    public void enqueue(int item){
        maxHeap.insert(item);
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty. Can not dequeue.");
        }

        return maxHeap.remove();
    }

    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    @Override
    public String toString() {
        return maxHeap.toString();
    }
}
