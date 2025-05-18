import java.util.*;

class Node {
    char ch;
    int freq;
    Node left, right;

    Node(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }

    Node(int freq, Node left, Node right) {
        this.ch = '-';
        this.freq = freq;
        this.left = left;
        this.right = right;
    }

    boolean isLeaf() {
        return left == null && right == null;
    }
}

public class HuffmanBitSaving {

    static Map<Character, String> huffmanCodes = new HashMap<>();
    static Map<Character, Integer> frequencies = new HashMap<>();

    static void generateCodes(Node root, String code) {
        if (root == null) return;
        if (root.isLeaf()) {
            huffmanCodes.put(root.ch, code);
        }
        generateCodes(root.left, code + "0");
        generateCodes(root.right, code + "1");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter how many items: ");
        int n = sc.nextInt();

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.freq));

        System.out.println("Enter character and freq.");
        for (int i = 0; i < n; i++) {
            char ch = sc.next().charAt(0);
            int freq = sc.nextInt();
            frequencies.put(ch, freq);
            pq.add(new Node(ch, freq));
        }

        
        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            Node merged = new Node(left.freq + right.freq, left, right);
            pq.add(merged);
        }

        Node root = pq.poll();
        generateCodes(root, "");

        int previousBits = 0, newBits = 0;
        for (Map.Entry<Character, Integer> entry : frequencies.entrySet()) {
            char ch = entry.getKey();
            int freq = entry.getValue();
            previousBits += freq * 8; // Assuming 8 bits per char before compression
            newBits += freq * huffmanCodes.get(ch).length();
        }

        double saved = ((double) (previousBits - newBits) / previousBits) * 100;

        System.out.println("\nPrevious Required bit: " + previousBits);
        for (Map.Entry<Character, String> entry : huffmanCodes.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
        System.out.println("Now Required bit: " + newBits);
        System.out.printf("Bit Saved: %.12f%%\n", saved);
        sc.close();
    }
}
