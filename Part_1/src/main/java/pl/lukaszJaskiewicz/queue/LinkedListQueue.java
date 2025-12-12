package pl.lukaszJaskiewicz.queue;

public class LinkedListQueue implements Queue{

    private class Node {
        int item;
        Node next;

        public Node(int item){
            this.item = item;
        }

        @Override
        public String toString(){
            return Integer.toString(item);
        }
    }

    private Node first;
    private Node last;
    private int count = 0;

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void enqueue(int item) {

        Node newNode = new Node(item);

        if (isEmpty()) {
            first = last = newNode;
        }else{
            last.next = newNode;
            last = newNode;
        }

        count++;
    }

    public int dequeue() {

        if(isEmpty()){
            throw new IllegalStateException("Queue is empty. Can not dequeue.");
        }

        int item;

        if(size() == 1){
            item = last.item;
            first = last = null;
        }else{
            item = first.item;
            Node temp = first.next;
            first.next = null;
            first = temp;
        }

        count--;
        return item;
    }

    public int peek() {

        if(isEmpty()){
            throw new IllegalStateException("Queue is empty. Can not peek.");
        }

        return first.item;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("[");
        Node current = first;

        while(current != null){
            sb.append(current).append(current != last? ", ": "");
            current = current.next;
        }

        return sb.append("]").toString();
    }
}
