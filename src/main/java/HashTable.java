import java.util.LinkedList;

public class HashTable {
    private class HashNode {
        String key;
        String value;
        HashNode(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }
    private LinkedList<HashNode>[] buckets;
    private int numBuckets;
    private int size;
    public HashTable(int capacity) {
        this.numBuckets = capacity;
        buckets = new LinkedList[numBuckets];
        for (int i = 0; i < numBuckets; i++) buckets[i] = new LinkedList<>();
        size = 0;
    }
    private int getBucketIndex(String key) {
        int hashCode = key.hashCode();
        int index = hashCode % numBuckets;
        return Math.abs(index);
    }
    public void put(String key, String value) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<HashNode> bucket = buckets[bucketIndex];
        for (HashNode node : bucket) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }
        bucket.add(new HashNode(key, value));
        size++;
    }
    public String get(String key) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<HashNode> bucket = buckets[bucketIndex];
        for (HashNode node : bucket) {
            if (node.key.equals(key)) return node.value;
        }
        return null;
    }
    public static void main(String[] args) {
        HashTable table = new HashTable(10);
        table.put("1", "First");
        table.put("2", "Second");
        System.out.println("Key 1: " + table.get("1"));
        System.out.println("Key 2: " + table.get("2"));
    }
}
