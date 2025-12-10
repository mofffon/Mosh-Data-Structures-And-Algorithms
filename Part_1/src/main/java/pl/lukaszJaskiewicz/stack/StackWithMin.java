package pl.lukaszJaskiewicz.stack;

public class StackWithMin {

    private final Stack min;
    private final Stack items;
    private int count = 0;
    private final int capacity;

    public StackWithMin(int capacity){
        items = new Stack(capacity);
        min = new Stack(capacity);
        this.capacity = capacity;
    }

    public void push(int item){
        if(count == capacity){
            throw new IllegalStateException("The stack is full. Can not push.");
        }

        if(min.isEmpty() || min.peek() > item){
            min.push(item);
        }

        count++;
        items.push(item);
    }

    public int pop() {
        if(items.isEmpty()){
            throw new IllegalStateException("The stack is empty, can not pop.");
        }

        int item = items.pop();

        if(item == min.peek()){
            min.pop();
        }

        count--;
        return item;
    }

    public int peek() {
        if(items.isEmpty()){
            throw new IllegalStateException("The stack is empty, can not peek.");
        }

        return items.peek();
    }

    public boolean isEmpty(){
        return items.isEmpty();
    }

    public int min(){
        if(isEmpty()){
            throw new IllegalStateException("Stack is empty, no min value");
        }

        return min.peek();
    }

}
