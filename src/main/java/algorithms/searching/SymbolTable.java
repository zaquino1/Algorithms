package algorithms.searching;

/**
 * Symbol Table Interface (Key-Value Store).
 *
 * <p><strong>Source:</strong> Algorithms 4th Edition, Sedgewick & Wayne (Section 3.1).
 *
 * <p><strong>Concept:</strong>
 * An abstract data type that associates a value with a key.
 * This is the foundation for Maps and Dictionaries.
 */
public interface SymbolTable<Key, Value> {
    void put(Key key, Value val);
    Value get(Key key);
    void delete(Key key);
    boolean contains(Key key);
    boolean isEmpty();
    int size();
    Iterable<Key> keys();
}
