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

    public int indexOf(int item){

        for(int i = 0; i < currentSize; i++){
            if(items[i] == item){
                return i;
            }
        }

        return -1;
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
