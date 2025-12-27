package pl.lukaszjaskiewicz.heap;

public class MaxHeap {

    private final int[] items;
    private int count = 0;

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

        if(items[index] > items[parentIndex]){
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

        int largerIndex = getLargerIndex(index, count, items);

        if(index != largerIndex) {
            swap(largerIndex, index);
            bubbleDown(largerIndex);
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
            bubbleDown(i, items.length - 1, items);
        }
    }

    private static void bubbleDown(int index, int count, int[] items){

        int largerIndex = getLargerIndex(index, count, items);

        while(largerIndex != index){

            swap(index, largerIndex, items);

            index = largerIndex;
            largerIndex = getLargerIndex(index, count, items);
        };
    }

    private static void swap(int firstIndex, int secondIndex, int[] items){
        int temp = items[firstIndex];
        items[firstIndex] = items[secondIndex];
        items[secondIndex] = temp;
    }

    private static int getLargerIndex(int index, int count, int[] items){
        int leftChildIndex = index * 2 + 1;
        int rightChildIndex = index * 2 + 2;

        Integer leftChildValue = leftChildIndex <= count? items[leftChildIndex]:null;
        Integer rightChildValue = rightChildIndex <= count? items[rightChildIndex]: null;

        int larger = index;

        if(leftChildValue != null && leftChildValue > items[larger]){
            larger = leftChildIndex;
        }

        if(rightChildValue != null && rightChildValue > items[larger]){
            larger = rightChildIndex;
        }

        return larger;
    }

    public static int getKthLargest(int k, int[] items){
        if(items == null || items.length == 0){
            throw new IllegalArgumentException("Items array must contain at least one item");
        }

        if(k <= 0 || k > items.length){
            throw new IllegalStateException("The k parameter must be a positive int not larger to items array size.");
        }

        MaxHeap heap = new MaxHeap();

        for(int item: items){
            heap.insert(item);
        }

        Integer item = null;

        int counter = 0;
        while(counter++ < k){
            item = heap.remove();
        }

        return item;
    }

    public static boolean isMaxHeap(int[] input){
        if(input.length <= 1){
            return true;
        }

        MaxHeap heap = new MaxHeap(6);
        for(int item: input){
            heap.insert(item);
        }

        for(int i = 0; i < heap.items.length; i++){
            if(input[i] != heap.items[i]){
                return false;
            }
        }

        return true;
    }

}
