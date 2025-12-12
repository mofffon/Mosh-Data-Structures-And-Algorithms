package pl.lukaszJaskiewicz.hashMapHashSet;

import java.util.LinkedList;

public class HashMapChaining {

    private class Entry {
        int key;
        String value;

        public Entry(int key, String value){
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString(){
            return "<" + key + ", " + value+ ">";
        }
    }

    LinkedList<Entry>[] arr;

    public HashMapChaining(){
        arr = new LinkedList[5];
    }

    public HashMapChaining(int capacity){
        arr = new LinkedList[capacity];
    }

    public void put(int key, String value) {
        if(value == null){
            throw new IllegalArgumentException("Value can not be null.");
        }

        Entry entry = getEntry(key);
        if(entry != null){
            entry.value = value;
        }

        LinkedList<Entry> bucket = getBucket(key);

        if(bucket == null){
            bucket = createBucket(key);
        }

        bucket.add(new Entry(key, value));
    }

    public String get(int key){
        Entry entry = getEntry(key);
        return entry != null? entry.value: null;
    }

    public String remove(int key) {
        LinkedList<Entry> bucket = getBucket(key);
        Entry entry = getEntry(key);

        if (bucket == null || entry == null){
            throw new IllegalArgumentException("An item by key = " + key + " does not exist in this HashMap.");
        }

        bucket.remove(entry);
        return entry.value;
    }

    private LinkedList<Entry> createBucket(int key){
        int hash = getHash(key);
        arr[hash] = new LinkedList<Entry>();
        return arr[hash];
    }

    private LinkedList<Entry> getBucket(int key){
        if(key < 0){
            throw new IllegalArgumentException("Key must be at least 0. Key is: " + key + ".");
        }

        return arr[getHash(key)];
    }

    private Entry getEntry(int key){

        LinkedList<Entry> bucket = getBucket(key);

        if(bucket != null) {
            for (var entry: bucket) {
                if(entry.key == key) {
                    return entry;
                }
            }
        }

        return null;
    }

    private int getHash(int key){
        return key % arr.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        for(int i = 0; i < arr.length; i++){
            LinkedList<Entry> linkedList = arr[i];
            if(linkedList != null){
                for(var entry: linkedList){
                    sb.append(entry.toString()).append(entry != linkedList.getLast()? ", ": "");
                }
            }

            sb.append(i != (arr.length - 1) ? ", ": "");
        }

        return sb.append("]").toString();
    }
}
