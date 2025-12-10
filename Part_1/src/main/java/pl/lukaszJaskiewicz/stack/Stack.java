package pl.lukaszJaskiewicz.stack;

import java.util.Arrays;
import java.util.List;

public class Stack {

    private final int[] items;
    private int index = 0;

    public Stack(int capacity){
        if(capacity <= 0){
            throw new IllegalArgumentException("Capacity must be at least 1");
        }

        items = new int[capacity];
    }

    public boolean isEmpty() {
        return index == 0;
    }

    private boolean isFull(){
        return index == items.length;
    }

    public void push(int item) {
        if(isFull()){
            throw new StackOverflowError("The stack is full, can not push");
        }

        items[index++] = item;
    }

    public int pop() {
        if(isEmpty()) {
            throw new IllegalStateException("The stack is empty, can not pop.");
        }

        return items[--index];
    }

    public int peek() {
        if(isEmpty()) {
            throw new IllegalStateException("The stack is empty, can not peek.");
        }

        return items[index - 1];
    }

    private static final List<Character> leftBrackets = Arrays.asList('(', '[', '<', '{');
    private static final List<Character> rightBrackets = Arrays.asList(')', ']', '>', '}');

    public static String reverse(String input) {

        if(input == null){
            throw new IllegalArgumentException("Input can not be null");
        }

        java.util.Stack<Character> stack = new java.util.Stack<>();

        for(char ch: input.toCharArray()){
            stack.push(ch);
        }

        StringBuilder sb = new StringBuilder();

        while(!stack.empty()){
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    public static boolean isBalanced(String input) {

        if(input == null){
            return false;
        }

        java.util.Stack<Character> stack = new java.util.Stack<>();

        for(Character ch: input.toCharArray()){
            if(leftBrackets.contains(ch)){
                stack.push(ch);
            }else if(rightBrackets.contains(ch)){
                if(stack.empty()){
                    return false;
                }

                char left = stack.pop();
                if(leftBrackets.indexOf(left) != rightBrackets.indexOf(ch)){
                    return false;
                }
            }
        }

        return stack.empty();
    }
}
