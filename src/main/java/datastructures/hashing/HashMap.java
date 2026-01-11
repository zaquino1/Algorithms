package datastructures.hashing;

import java.util.LinkedList;

/**
 * Hash Map (Custom Implementation).
 *
 * <p><strong>Best Use Case:</strong>
 * Fast data retrieval based on keys (caching, indexing, counting frequencies).
 *
 * <p><strong>Time Complexity:</strong>
 * <ul>
 *   <li>Insert/Delete/Search: O(1) average, O(n) worst case (collisions)</li>
 * </ul>
 *
 * <p><strong>Space Complexity:</strong> O(n)
 */
public class HashMap<K, V> {
    private class HashNode<K, V> {
        K key;
        V value;
        HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<HashNode<K, V>>[] buckets;
    private int numBuckets;
    private int size;

    public HashMap(int capacity) {
        this.numBuckets = capacity;
        buckets = new LinkedList[numBuckets];
        for (int i = 0; i < numBuckets; i++) buckets[i] = new LinkedList<>();
        size = 0;
    }

    private int getBucketIndex(K key) {
        int hashCode = key.hashCode();
        int index = hashCode % numBuckets;
        return Math.abs(index);
    }

    public void put(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<HashNode<K, V>> bucket = buckets[bucketIndex];
        for (HashNode<K, V> node : bucket) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }
        bucket.add(new HashNode<>(key, value));
        size++;
    }

    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<HashNode<K, V>> bucket = buckets[bucketIndex];
        for (HashNode<K, V> node : bucket) {
            if (node.key.equals(key)) return node.value;
        }
        return null;
    }
    
    public boolean containsKey(K key) {
        return get(key) != null;
    }
}
