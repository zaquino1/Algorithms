package algorithms.strings;

import java.util.PriorityQueue;

/**
 * Huffman Compression Algorithm.
 *
 * <p><strong>Source:</strong> Algorithms 4th Edition, Sedgewick & Wayne (Section 5.5).
 *
 * <p><strong>Best Use Case:</strong>
 * Lossless data compression. It assigns variable-length codes to input characters,
 * with shorter codes for more frequent characters.
 *
 * <p><strong>Time Complexity:</strong> O(N log N) where N is the number of unique characters.
 */
public class Huffman {
    private static final int R = 256; // ASCII alphabet size

    private static class Node implements Comparable<Node> {
        private final char ch;
        private final int freq;
        private final Node left, right;

        Node(char ch, int freq, Node left, Node right) {
            this.ch = ch;
            this.freq = freq;
            this.left = left;
            this.right = right;
        }

        private boolean isLeaf() {
            return (left == null) && (right == null);
        }

        public int compareTo(Node that) {
            return this.freq - that.freq;
        }
    }

    public static void compress(String s) {
        char[] input = s.toCharArray();

        // tabulate frequency counts
        int[] freq = new int[R];
        for (char c : input)
            freq[c]++;

        // build Huffman trie
        Node root = buildTrie(freq);

        // build code table
        String[] st = new String[R];
        buildCode(st, root, "");

        // print trie for decoder (omitted for brevity in this demo)
        
        // print number of bytes in original uncompressed message
        System.out.println("Original size: " + input.length * 8 + " bits");

        // use Huffman code to encode input
        StringBuilder encoded = new StringBuilder();
        for (char c : input) {
            encoded.append(st[c]);
        }
        
        System.out.println("Compressed size: " + encoded.length() + " bits");
        System.out.println("Encoded string: " + encoded.toString());
        System.out.println("Compression ratio: " + (float)encoded.length() / (input.length * 8));
    }

    private static Node buildTrie(int[] freq) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (char c = 0; c < R; c++)
            if (freq[c] > 0)
                pq.add(new Node(c, freq[c], null, null));

        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            Node parent = new Node('\0', left.freq + right.freq, left, right);
            pq.add(parent);
        }
        return pq.poll();
    }

    private static void buildCode(String[] st, Node x, String s) {
        if (!x.isLeaf()) {
            buildCode(st, x.left, s + '0');
            buildCode(st, x.right, s + '1');
        } else {
            st[x.ch] = s;
            System.out.println("Code for " + x.ch + ": " + s);
        }
    }
}
