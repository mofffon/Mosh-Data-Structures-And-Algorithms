package pl.lukaszJaskiewicz;

public class Array {

    private int[] items;
    private int currentSize;

    public Array(int size) {
        items = new int[size];
        currentSize = 0;
    }

    public void add(int item){
        items[currentSize++] = item;
        resize();
    }

    public int getCurrentSize(){
        return currentSize;
    }

    public int max(){
        if(currentSize == 0){
            throw new IllegalStateException("There are no items in the code.Array.");
        }

        int max = items[0];

        for(int i = 0; i < getCurrentSize(); i++){
            if(max < items[i]){
                max = items[i];
            }
        }

        return max;
    }

    public void reverse(){

        for(int i = 0; i < getCurrentSize() / 2; i++){
            swap(i, getCurrentSize() - 1 - i);
        }
    }

    public Array intersect(Array other){

        Array common = new Array(1);

        Array searched;
        Array targets;

        if(this.getCurrentSize() < other.getCurrentSize()){
            searched = this;
            targets = other;
        }else{
            searched = other;
            targets = this;
        }

        for(int i = 0 ; i < targets.getCurrentSize(); i++){
            int item = targets.items[i];
            if(searched.indexOf(item) != -1 && common.indexOf(item) == -1){
                common.add(item);
            }
        }

        return common;
    }

    public int removeAt(int index){

        if(index < 0 || index >= getCurrentSize()){
            throw new  IllegalArgumentException("Index out of range (0: " + (getCurrentSize() -1) +")");
        }

        int counter = 0;
        int[] newItems = new int[items.length];
        int item = items[index];

        for(int i = 0 ; i < currentSize; i++){
            if(i == index){
                continue;
            }

            newItems[counter++] = items[i];
        }

        currentSize--;
        items = newItems;
        resize();

        return item;
    }

    public void insertAt(int item, int index){
        if(index < 0 || index > getCurrentSize()){
            throw new IllegalArgumentException("Index is out of range (0: " + (getCurrentSize() - 1) + ")");
        }

        if(getCurrentSize() == 0){
            items[0] = item;
        }else if(index == getCurrentSize()){
            items[getCurrentSize()] = item;
        }else{
            for(int i = getCurrentSize() - 1; i>=0; i--){
                items[i + 1] = items[i];
                if(i == index){
                    items[i] = item;
                    break;
                }
            }
        }

        currentSize++;
        resize();
    }

    public int indexOf(int item){

        for(int i = 0; i < currentSize; i++){
            if(items[i] == item){
                return i;
            }
        }

        return -1;
    }

    private void swap(int index1, int index2){
        int temp = items[index1];
        items[index1] = items[index2];
        items[index2] = temp;
    }

    private void resize(){
        int[] newItems;
        if(currentSize < items.length / 4){
            newItems = new int[items.length / 2];
        }else if(currentSize == items.length){
            newItems = new int[items.length * 2];
        }else{
            return;
        }

        System.arraycopy(items, 0, newItems, 0, currentSize);

        items = newItems;
    }

    public void print(){

        System.out.println(this.toString());
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("[");

        String delimiter = ", ";

        for(int i = 0; i < currentSize; i++){
            if(i == currentSize - 1){
                delimiter = "";
            }

            sb.append(items[i]).append(delimiter);
        }

        sb.append("]");

        return sb.toString();
    }
}
