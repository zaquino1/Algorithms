package datastructures.arrays;

/**
 * Dynamic Array (ArrayList Implementation).
 *
 * <p><strong>Best Use Case:</strong>
 * When you need random access (O(1)) but don't know the size of the data upfront.
 *
 * <p><strong>Time Complexity:</strong>
 * <ul>
 *   <li>Access: O(1)</li>
 *   <li>Insert (Amortized): O(1)</li>
 *   <li>Resize: O(n)</li>
 * </ul>
 */
public class DynamicArray<T> {
    private Object[] data;
    private int size;
    private int capacity;

    public DynamicArray(int initialCapacity) {
        capacity = initialCapacity;
        data = new Object[capacity];
        size = 0;
    }

    public T get(int index) {
        return (T) data[index];
    }

    public void add(T value) {
        if (size == capacity) {
            resize();
        }
        data[size++] = value;
    }

    private void resize() {
        capacity *= 2;
        Object[] newData = new Object[capacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public int size() {
        return size;
    }
}
