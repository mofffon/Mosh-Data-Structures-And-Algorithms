package pl.lukaszJaskiewicz.stack;

public class TwoStacksOneArray {

    private final int[] items = new int[10];;
    private int leftPointer = -1;
    private int rightPointer = items.length;

    public boolean is1Empty() {
        return leftPointer == -1 && !is1Full();
    }

    public boolean is2Empty(){
        return rightPointer == items.length && !is2Full();
    }

    public boolean is1Full(){
        return (leftPointer + 1) == rightPointer;
    }

    public boolean is2Full() {
        return is1Full();
    }

    public void push1(int item){
        if(is1Full()){
            throw new IllegalStateException("The left stack is full, can not push.");
        }

        items[++leftPointer] = item;
    }

    public int pop1(){
        if(is1Empty()){
            throw new IllegalStateException("The left stack is empty, can not pop.");
        }

        return items[leftPointer--];
    }

    public void push2(int item){
        if(is2Full()){
            throw new IllegalStateException("The right stack is full. Can not push.");
        }

        items[--rightPointer] = item;
    }

    public int pop2() {
        if(is2Empty()){
            throw new IllegalArgumentException("The right stack is empty. Can not pop.");
        }

        return items[rightPointer++];
    }

    @Override
    public String toString(){

        StringBuilder sb = new StringBuilder("left = [");

        for(int i = 0; i <= leftPointer; i++){
            sb.append(items[i]).append((i != leftPointer? ", ": ""));
        }

        sb.append("]\nright = [");

        for(int i = items.length - 1; i >= rightPointer; i--){
            sb.append(items[i]).append((i != rightPointer? ", ": ""));
        }

        sb.append("]");

        return sb.toString();
    }

}
