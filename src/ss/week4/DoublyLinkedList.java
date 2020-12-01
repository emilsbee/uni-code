package ss.week4;

public class DoublyLinkedList<Element> {

    private int size;
    private Node head;

    /**
     * @ensures the list is empty (size is 0)
     */
    public DoublyLinkedList() {
        size = 0;
        head = new Node(null);
        head.next = head;
        head.previous = head;
    }

    /**
     * Inserts a new Element at a given index in the list.
     * @requires element is not null
     * @requires the index to be within the bounds of the list
     * @ensures the size of the list to increase by one
     * @ensures the Element in the list at index index to be element
     * @param index The index at which to insert the Element
     * @param element The element to add
     */
    public void add(int index, Element element) {
        Node newNode = new Node(element); // Creates new node to be inserted

        Node currentNodeInIndex = getNode(index); // Gets the node currently in the index
        Node previousIndexNode = currentNodeInIndex.previous;  // Gets the node that's before the index

        previousIndexNode.next = newNode; // Sets the next node of the previous index node to be the newly created one

        newNode.previous = previousIndexNode; // Sets the new node's previous to be the previous index node
        newNode.next = currentNodeInIndex; // Sets the new node's next to be the current node that is in the index

        currentNodeInIndex.previous = newNode; // Sets the previous of the node that is currently in the index to be the new node

        size++; // Increases the collection size
    }

    /**
     * Removes an element at a given index
     * @requires the index to be within the bounds of the list
     * @ensures the size of the list to decrease by one
     * @param index the index to remove the element at 
     */
    public void remove(int index) {
        Node indexNode = getNode(index); // Gets node to be removed
        Node beforeIndex = indexNode.previous; // Gets node before the index node
        Node afterIndex = indexNode.next; // Gets the node after index node

        beforeIndex.next = afterIndex;
        afterIndex.previous = beforeIndex;
        size--; // Decreases collection size
    }

    /**
     * @requires the index to be within the bounds of the list
     */
    public Element get(int index) {
        Node p = getNode(index);
        return p.element;
    }

    /**
     * The node containing the element with the specified index.
     * The head node if the specified index is -1.
     * @requires i to be between -1 and the size of the list
     */
    public Node getNode(int i) {
        Node p = head;
        int pos = -1;
        while (pos < i) {
            p = p.next;
            pos = pos + 1;
        }
        return p;
    }

    public int size() {
        return this.size;
    }
    public class Node {
        public Node(Element element) {
            this.element = element;
            this.next = null;
            this.previous = null;
        }

        private Element element;
        public Node next;
        public Node previous;

        public Element getElement() {
            return element;
        }
    }
}
