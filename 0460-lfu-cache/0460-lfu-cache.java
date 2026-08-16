import java.util.HashMap;

class LFUCache {

    class Node {
        int key, value, freq;
        Node prev, next;

        Node(int key, int value, int freq) {
            this.key = key;
            this.value = value;
            this.freq = freq;
        }
    }

    class DoublyLinkedList {

        Node head, tail;
        int size;

        DoublyLinkedList() {
            head = new Node(-1, -1, -1);
            tail = new Node(-1, -1, -1);

            head.next = tail;
            tail.prev = head;

            size = 0;
        }

        // Add node after head (Most Recently Used)
        void addFirst(Node node) {

            Node nextNode = head.next;

            head.next = node;
            node.prev = head;

            node.next = nextNode;
            nextNode.prev = node;

            size++;
        }

        // Remove a specific node
        void remove(Node node) {

            node.prev.next = node.next;
            node.next.prev = node.prev;

            size--;
        }

        // Remove Least Recently Used node from this frequency list
        Node removeLast() {

            if (size == 0) {
                return null;
            }

            Node node = tail.prev;

            remove(node);

            return node;
        }
    }


    private int capacity;
    private int minFreq;

    // key -> Node
    private HashMap<Integer, Node> map;

    // frequency -> DoublyLinkedList
    private HashMap<Integer, DoublyLinkedList> freqMap;


    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;

        map = new HashMap<>();
        freqMap = new HashMap<>();
    }


    // Increase frequency of a node
    private void updateFreq(Node node) {

        int oldFreq = node.freq;

        DoublyLinkedList oldList = freqMap.get(oldFreq);

        // Remove node from old frequency list
        oldList.remove(node);

        // If old frequency was minimum and its list is now empty
        if (oldFreq == minFreq && oldList.size == 0) {
            minFreq++;
        }

        // Increase frequency
        node.freq++;

        // Create DLL for new frequency if needed
        freqMap.putIfAbsent(node.freq, new DoublyLinkedList());

        // Add node to new frequency list
        freqMap.get(node.freq).addFirst(node);
    }


    public int get(int key) {

        // Key does not exist
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);

        // Accessing the node increases its frequency
        updateFreq(node);

        return node.value;
    }


    public void put(int key, int value) {

        // Edge case
        if (capacity == 0) {
            return;
        }

        // Key already exists
        if (map.containsKey(key)) {

            Node node = map.get(key);

            // Update value
            node.value = value;

            // Increase frequency
            updateFreq(node);

            return;
        }


        // Cache is full
        if (map.size() == capacity) {

            // Get the list with minimum frequency
            DoublyLinkedList minFreqList = freqMap.get(minFreq);

            // Remove LRU node from that list
            Node nodeToRemove = minFreqList.removeLast();

            // Remove from HashMap
            map.remove(nodeToRemove.key);
        }


        // Create new node with frequency = 1
        Node newNode = new Node(key, value, 1);

        // Add to key map
        map.put(key, newNode);

        // Create frequency 1 list if needed
        freqMap.putIfAbsent(1, new DoublyLinkedList());

        // Add new node to frequency 1 list
        freqMap.get(1).addFirst(newNode);

        // A new node always has minimum frequency
        minFreq = 1;
    }
}