package pl.lukaszjaskiewicz.trie;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class Trie {

    public static int ALPHABET_SIZE = 26;

    private class Node{

        char value;
        HashMap<Character, Node> children = new HashMap<>();
        boolean isEndOfWord = false;

        public Node(char ch){
            value = ch;
        }

        public boolean contains(char ch){
            return children.containsKey(ch);
        }

        public Node getChild(char ch){
            return children.get(ch);
        }

        public void addChild(char ch){
            children.put(ch, new Node(ch));
        }

        public Node[] getAllChildren() {
            return children.values().toArray(new Node[0]);
        }

        public void remove(char ch){
            children.remove(ch);
        }

        public boolean hasChildren(){
            return !children.isEmpty();
        }

        public int childrenCount(){
            return children.size();
        }

        @Override
        public String toString(){
            return "" + value;
        }
    }

    private final Node root = new Node(' ');

    public void insert(String word){
        if(word == null){
            return;
        }

        char[] split = word.toCharArray();
        insert(0, root, split);
    }

    private void insert(int index, Node root, char[] splitWord){
        char ch = splitWord[index];

        if(!root.contains(ch)){
            root.addChild(ch);
        }

        Node child = root.getChild(ch);

        if(index == splitWord.length - 1){
            child.isEndOfWord = true;
            return;
        }

        insert(index + 1, child, splitWord);
    }

    public boolean contains(String word){
        if(word == null){
            return false;
        }

        Node current = root;

        for (char ch: word.toCharArray()) {
            if(!current.contains(ch)){
                return false;
            }
            current = current.getChild(ch);
        }

        return current.isEndOfWord;
    }

    public boolean containsRec(String word){
        if(word == null){
            return false;
        }

        return containsRec(0, word, root);
    }

    private boolean containsRec(int index, String word, Node root){

        char ch = word.charAt(index);

        if(!root.contains(ch)){
            return false;
        }

        Node child = root.getChild(ch);

        if(index == (word.length() - 1)){
            return child.isEndOfWord;
        }

        return containsRec(index + 1, word, child);

    }

    public String traverse(){
        List<Character> list = new ArrayList<>();
        traverse(root, list);
        StringBuilder sb = new StringBuilder();

        for (var item: list) {
            sb.append(item);
        }

        return sb.toString();
    }

    private void traverse(Node root, List<Character> list){
        for(var node: root.getAllChildren()){
            list.add(node.value);
            traverse(node, list);
        }
    }

    public void remove(String word){
        if(word == null || !contains(word)){
            return;
        }

        remove(0, root, word.toCharArray());
    }

    private void remove(int index, Node root, char[] splitWord){

        if(index == splitWord.length){
            root.isEndOfWord = false;
            return;
        }

        char ch = splitWord[index];
        var node = root.getChild(ch);
        remove(index + 1, node, splitWord);

        if(!node.isEndOfWord && !node.hasChildren()){
            root.remove(ch);
        }
    }

    public List<String> autoComplete(String word){
        List<String> list = new ArrayList<>();
        if(word == null){
            return list;
        }

        Node node = root;

        int index = 0;
        while(index < word.length()){
            char ch = word.charAt(index++);
            if(!node.contains(ch)){
                return list;
            }
            node = node.getChild(ch);
        }

        autoComplete(word, node, list);

        return list;
    }

    private void autoComplete(String word, Node root, List<String> list){
        if(root.isEndOfWord){
            list.add(word);
        }

        for(var child : root.getAllChildren()){
            autoComplete(word + child.value, child, list);
        }
    }

    public int countWords(){
        return countWords(root);
    }

    private int countWords( Node root){

        int count = 0;

        if(root.isEndOfWord){
            count++;
        }

        for(var child: root.getAllChildren()){
            count += countWords(child);
        }

        return count;
    }

    public String getLongestPrefix(){
        StringBuilder sb = new StringBuilder();

        var current = root;

        while(!current.isEndOfWord && current.childrenCount() == 1){
            char ch = current.getAllChildren()[0].value;
            sb.append(ch);
            current = current.getAllChildren()[0];
        }

        return sb.toString();
    }
}
