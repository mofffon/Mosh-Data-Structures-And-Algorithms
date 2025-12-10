package pl.lukaszJaskiewicz.linkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class LinkedList {

    private static class Node {
        int item;
        Node next;

        public Node (int item){
            this.item = item;
        }

        public Node(int item, Node next){
            this. item = item;
            this.next = next;
        }

        @Override
        public String toString(){
            return Integer.toString(item);
        }
    }

    private Node first;
    private Node last;
    private int size = 0;

    public void addFirst(int item){

        Node newNode = new Node(item);
        newNode.next = first;

        if(isEmpty()) {
            last = newNode;
        }

        first = newNode;
        size++;
    }

    public void addLast(int item) {

        if(isEmpty()){
            addFirst(item);
            return;
        }

        Node newNode = new Node(item);

        last.next = newNode;
        last = newNode;
        size++;
    }

    public void deleteFirst() {

        if(isEmpty()) {
            throw new NoSuchElementException("Can not deleteFirst() out of empty list.");
        }

        var current = first;
        first = first.next;
        current.next = null;
        size--;
    }

    public void deleteLast() {
        if (isEmpty()) {
             throw new NoSuchElementException("Can not deleteLast() out of empty list.");
        }

        if(size == 1){
            deleteFirst();
            return;
        }

        last = getPrevious(last);

        assert last != null;
        last.next = null;
        size--;
    }

    public int indexOf(int item){
        Node current = first;

        for(int i = 0; i < size; i++) {
            if(current.item == item){
                return i;
            }

            current = current.next;
        }

        return -1;
    }

    public boolean contains(int item) {
        return indexOf(item) >= 0;
    }

    public int getKthFromTheEnd(int k){

        int lSize = 0;;
        if( k <= lSize){
            return last.item;
        }

        if(isEmpty()){
            throw new IllegalStateException("The list is empty.");
        }

        Node start = first;
        Node end = first;
        int counter = 0;


        while(end != null){
            lSize++;

            if(counter < k){
                counter++;
            }else{
                start = start.next;
            }

            end = end.next;
        }

        if(k > lSize){
            throw new IllegalArgumentException("the k parameter is greater than list size (" + size + ")");
        }

        assert start != null;
        return start.item;
    }

    public void reverse() {
        if(isEmpty()){
            return;
        }

        Node current = first;
        Node previous = null;

        while(current != null){
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        Node temp = first;
        first = last;
        last = temp;

        assert last != null;
        last.next = null;
    }

    public int[] toArray() {
        int[] array = new int[size];
        var current = first;
        for(int i = 0; i < size; i++){
            array[i] = current.item;
            current = current.next;
        }

        return array;
    }

    public void printMiddle() {
        Integer[] middle = getMiddle();
        System.out.println(Arrays.toString(middle));
    }

    public Integer[] getMiddle(){
        Node fasterPointer = first;
        Node slowerPointer = first;
        Node slowerSlowerPointer = null;

        int counter = 0;

        while(fasterPointer != null){
            if(counter % 2 == 1){
                slowerSlowerPointer = slowerPointer;
                slowerPointer = slowerPointer.next;
            }

            fasterPointer = fasterPointer.next;
            counter++;
        }

        if(counter == 0){
            return new Integer[]{};
        }

        ArrayList<Integer> arrList = new ArrayList<>();
        if(counter % 2 == 0){
            arrList.add(slowerSlowerPointer.item);
        }

        arrList.add(slowerPointer.item);

        return arrList.toArray(new Integer[0]);
    }

    private Node getPrevious(Node node) {
        Node current = first;

        while(current != null){
            if(current.next == node){
                return current;
            }

            current = current.next;
        }

        return null;
    }

    private boolean isEmpty(){
        return size == 0;
    }

    public boolean hasLoop() {

        Node slow = first;
        Node fast = first;

        do {

            if(fast == null){
                break;
            }

            fast = fast.next;

            if(fast == slow){
                break;
            }

            if(fast != null){
                fast = fast.next;
            }
            slow = slow.next;

        }while(fast != null || slow != fast);

        return slow == fast;
    }

    public void addLoop(int from, int to){

        if(isEmpty()){
            throw new IllegalStateException("Can not set a loop in an empty  list.");
        }

        if(from < 0 || to < 0){
            throw new IllegalArgumentException("From or to less than 0.");
        }

        if(from < to){
            throw new IllegalArgumentException("'From' is less than 'to'");
        }

        if(from >= size){
            throw new IllegalArgumentException("from is larger or equal to list size (" + size + ")");
        }

        int index = 0;
        Node fromNode = null;
        Node toNode = null;

        Node current = first;

        while((fromNode == null && toNode == null) || current != null){

            if(index == from){
                fromNode = current;
            }

            if(index == to){
                toNode = current;
            }

            index++;
            current = current.next;
        }

        size = index + 1;
        fromNode.next = toNode;
        last = null;
    }

    @Override
    public String toString(){

        StringBuilder sb = new StringBuilder("[");

        Node current = first;

        while(current != null){

            sb.append(current);
            sb.append(current != last? ", ": "");
            current = current.next;
        }

        sb.append("]");

        return sb.toString();
    }
}