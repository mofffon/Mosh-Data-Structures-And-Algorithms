package pl.lukaszjaskiewicz.heap;

public class MaxHeap {

    private final int[] items;
    private int count =0;

    public MaxHeap(){
        items = new int[10];
    }

    public MaxHeap(int capacity){
        items = new int[capacity];
    }

    public void insert(int item){
        if(isFull()){
            throw new IllegalStateException("The heap is full. Can not insert.");
        }
        items[count] = item;

        bubbleUp(count++);
    }

    private void bubbleUp(int index){

        int parentIndex = (index - 1) / 2;

        if(items[parentIndex] < items[index]){
            swap(parentIndex, index);
            bubbleUp(parentIndex);
        }
    }

    public int remove(){
        if(isEmpty()){
            throw new IllegalStateException("The heap is empty. Can not remove.");
        }

        int root = items[0];
        items[0] = items[--count];

        bubbleDown(0);

        return root;
    }

    private void bubbleDown(int index){
        if(index > count - 1){
            return;
        }

        int largerChildIndex = getLargerChildIndex(index, items);

        if(items[largerChildIndex] > items[index]) {
            swap(largerChildIndex, index);
            bubbleDown(largerChildIndex);
        }
    }

    private void swap(int index1, int index2){
        int temp = items[index1];
        items[index1] = items[index2];
        items[index2] = temp;
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public boolean isFull(){
        return count == items.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        for(int i = 0 ; i < count; i++){
            sb.append(" ").append(items[i]).append(" ");
        }

        return sb.append("]").toString();
    }

    public static void heapify(int[] items) {

        int upperBound = items.length / 2 - 1;

        for (int i = upperBound; i >= 0; i--) {
            bubbleDown(i, items);
        }
    }

    private static void bubbleDown(int index, int[] items){

        int largerChildIndex = getLargerChildIndex(index, items);

        while(largerChildIndex != index){

            swap(index, largerChildIndex, items);

            index = largerChildIndex;
            largerChildIndex = getLargerChildIndex(index, items);
        };
    }

    private static void swap(int firstIndex, int secondIndex, int[] items){
        int temp = items[firstIndex];
        items[firstIndex] = items[secondIndex];
        items[secondIndex] = temp;
    }

    private static int getLargerChildIndex(int index, int[] items){
        int leftChildIndex = index * 2 + 1;
        int rightChildIndex = index * 2 + 2;

        Integer leftChildValue = leftChildIndex < items.length? items[leftChildIndex]: null;
        Integer rightChildValue = rightChildIndex < items.length? items[rightChildIndex]: null;

        if(leftChildValue == null && rightChildValue != null){
            return rightChildIndex;
        }

        if(leftChildValue != null && rightChildValue == null){
            return leftChildIndex;
        }

        if(leftChildValue == null & rightChildValue == null){
            return index;
        }

        return leftChildValue > rightChildValue? leftChildIndex: rightChildIndex;
    }

    public static int kthLargest(int k, int[] items){
        if(k <= 0 || k >= items.length){
            throw new IllegalStateException("The k parameter must be a positive int not larger or equal to array size.");
        }

        MaxHeap heap = new MaxHeap();

        for(int item: items){
            heap.insert(item);
        }

        Integer item = null;

        for (int i= 0; i < k; i++){
            item = heap.remove();
        }

        return item;
    }

}
