public class QueueArray {
    int front, rear, size;
    int capacity;
    int array[];
    public QueueArray(int capacity) {
        this.capacity = capacity;
        front = this.size = 0;
        rear = capacity - 1;
        array = new int[this.capacity];
    }
    void enqueue(int item) {
        if (size == capacity) return;
        rear = (rear + 1) % capacity;
        array[rear] = item;
        size = size + 1;
        System.out.println(item + " enqueued to queue");
    }
    int dequeue() {
        if (size == 0) return Integer.MIN_VALUE;
        int item = array[front];
        front = (front + 1) % capacity;
        size = size - 1;
        return item;
    }
    public static void main(String[] args) {
        QueueArray queue = new QueueArray(1000);
        queue.enqueue(10); queue.enqueue(20); queue.enqueue(30); queue.enqueue(40);
        System.out.println(queue.dequeue() + " dequeued from queue");
    }
}
