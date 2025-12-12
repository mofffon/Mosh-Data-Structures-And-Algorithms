package pl.lukaszJaskiewicz.hashMapHashSet;

public class HashMapLinearProbing {

    private static class Entry {
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

    private final Entry[] entries;

    public HashMapLinearProbing(){
        entries = new Entry[10];
    }

    public HashMapLinearProbing(int capacity){
        entries = new Entry[capacity];
    }

    public boolean isFull(){
        for (Entry entry : entries) {
            if (entry == null) {
                return false;
            }
        }

        return true;
    }

    public void put(int key, String value){
        if(value == null){
            throw new IllegalArgumentException("The value can not be null.");
        }

        if(isFull()) {
            throw new IllegalStateException("The Hash Map is full. Can not put.");
        }

        int index = getHash(key);

        do{
            if(entries[index] == null){
                entries[index] = new Entry(key, value);
                return;
            }

        }while(index != getHash(key));
    }

    public String get(int key) {
        return getOrRemoveItem(key, false);
    }

    public String remove(int key) {
        String value = getOrRemoveItem(key, true);

        if(value == null){
            throw new IllegalArgumentException("The Hash Map does not contain entry by key = " + key);
        }

        return value;
    }

    private String getOrRemoveItem(int key, boolean doRemove){
        int index = getHash(key);

        do{
            Entry entry = entries[index];
            if(entry != null && entry.key == key){
                if(doRemove){
                    entries[index] = null;
                }
                return entry.value;
            }

            index = getHash(++index);

        }while(index != getHash(key));

        return null;
    }


    private int getHash(int key){
        if(key < 0){
            throw new IllegalArgumentException("Key can not be less than zero.");
        }
        return key % entries.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        for (Entry entry : entries) {
            if (entry != null) {
                sb.append(" ").append(entry).append(" ");
            }
        }

        sb.append("]");

        return sb.toString();
    }
}
