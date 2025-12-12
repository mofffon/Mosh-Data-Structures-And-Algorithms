package pl.lukaszJaskiewicz.queue;

public interface Queue {

    public int size();
    public void enqueue(int item);
    public int dequeue();
    public int peek();
    public boolean isEmpty();
}
