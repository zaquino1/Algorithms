package algorithms.strings;

/**
 * Trie (Prefix Tree) Data Structure.
 *
 * <p><strong>Best Use Case:</strong>
 * Autocomplete, spell checking, IP routing, longest prefix matching.
 *
 * <p><strong>Time Complexity:</strong>
 * <ul>
 *   <li>Insert: O(L) where L is length of key</li>
 *   <li>Search: O(L)</li>
 * </ul>
 *
 * <p><strong>Space Complexity:</strong> O(ALPHABET_SIZE * L * N)
 */
public class Trie {
    static final int ALPHABET_SIZE = 26;

    static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        boolean isEndOfWord;

        TrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++)
                children[i] = null;
        }
    }

    static TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String key) {
        int level;
        int length = key.length();
        int index;

        TrieNode pCrawl = root;

        for (level = 0; level < length; level++) {
            index = key.charAt(level) - 'a';
            if (pCrawl.children[index] == null)
                pCrawl.children[index] = new TrieNode();

            pCrawl = pCrawl.children[index];
        }

        pCrawl.isEndOfWord = true;
    }

    public boolean search(String key) {
        int level;
        int length = key.length();
        int index;
        TrieNode pCrawl = root;

        for (level = 0; level < length; level++) {
            index = key.charAt(level) - 'a';

            if (pCrawl.children[index] == null)
                return false;

            pCrawl = pCrawl.children[index];
        }

        return (pCrawl != null && pCrawl.isEndOfWord);
    }
}
