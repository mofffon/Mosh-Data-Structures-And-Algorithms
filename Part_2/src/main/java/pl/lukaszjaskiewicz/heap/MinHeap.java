package pl.lukaszjaskiewicz.heap;

public class MinHeap {

    private class Node{

        int key;
        String value;

        public Node(int key, String value){
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString(){
            return "key: " + key + " value: " + value;
        }
    }


    private int count = 0;
    private Node[] items;

    public MinHeap(){
        items = new Node[10];
    }

    public MinHeap(int capacity){
        items = new Node[capacity];
    }

    public int getCount(){
        return count;
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public boolean isFull() {
        return count == items.length;
    }

    public void insert(int key, String value){
        if (isFull()) {
            throw new IllegalStateException("Heap is full. Can not insert.");
        }

        Node node = new Node(key, value);
        items[count] = node;
        bubbleUp(count++);
    }

    private void bubbleUp(int index){
        int parentIndex = (index - 1) / 2;

        if(items[index].key < items[parentIndex].key){
            swap(index, parentIndex, items);
            bubbleUp(parentIndex);
        }
    }

    public String remove(){
        if (isEmpty()) {
            throw new IllegalStateException("The heap is empty. Can not remove");
        }

        Node item = items[0];

        items[0] = items[--count];
        items[count] = null;
        bubbleDown(0);
        return item.value;
    }

    private void bubbleDown(int index){

        int smallerChildIndex = getSmallerIndex(index, count);

        if(index != smallerChildIndex){
            swap(index, smallerChildIndex, items);
            bubbleDown(smallerChildIndex);
        }
    }

    private int getSmallerIndex(int index, int bound){
        int leftChildIndex = index * 2 + 1;
        int rightChildIndex = index * 2 + 2;

        Node leftChildNode = leftChildIndex <= bound? items[leftChildIndex]: null;
        Node rightChildNode = rightChildIndex <= bound? items[rightChildIndex]: null;

        int smaller = index;

        if(leftChildNode != null && leftChildNode.key < items[smaller].key){
            smaller = leftChildIndex;
        }

        if(rightChildNode != null && rightChildNode.key < items[smaller].key){
            smaller = rightChildIndex;
        }

        return smaller;
    }

    private static void swap(int first, int second, Node[] arr){
        Node temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
