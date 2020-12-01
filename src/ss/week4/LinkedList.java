package ss.week4;

public class LinkedList<Element> {

    private int size;
    private Node first;

    /**
     * @ensures the list is empty
     */
    public LinkedList () {
        size = 0;
        first = null;
    }

    public void add(int index, Element element) {
        Node newNode = new Node(element);
        if (index == 0) {
            newNode.next = first;
            first = newNode;
        } else {
            Node p = getNode(index-1);
            newNode.next = p.next;
            p.next = newNode;
        }
        size = size + 1;
    }

    /**
     * @ensures the size of the list has decreased by one
     * @param element the Element to remove
     */
    public void remove(Element element) {
        Node beforeCurrent = findBefore(element); // Gets node before

        if (beforeCurrent != null) { // If the node before isn't null
            beforeCurrent.next = beforeCurrent.next.next; // Set the node before to point to the node after next one
        } else { // If the node at question is the first node
            first = getNode(1); // Set the new head to be the node after first node
        }
        size--; // Decrease collection size by 1
    }

    public Node findBefore(Element element) {
        Node foundNode = null;

        if (first.element.equals(element)) {
            return null;
        }

        for (int i = 0; i < size; i++) {
            if (getNode(i).element.equals(element)) {
                foundNode = getNode(i-1);
            }
        }
        return foundNode;
    }


    /**
     * @requires the index to be within the bounds of the list
     * @param index the index to get the element at 
     * @return the element at index index
     */
    public Element get(int index) {
        Node p = getNode(index);
        return p.element;
    }

    /**
     * @requires i to be within the bounds of the list
     * @param i the index to get the Node at
     * @return the Node at index i
     */
    private Node getNode(int i) {
        Node p = first;
        int pos = 0;
        while (pos != i) {
            p = p.next;
            pos = pos + 1;
        }
        return p;
    }

    /**
     * @ensures the result to be 0 or greater
     * @return the size of the list
     */
    public int size() {
        return size;
    }

    public class Node {
        private Element element;
        public Node next;

        public Node(Element element) {
            this.element = element;
            this.next = null;
        }

        public Element getElement() {
            return element;
        }
    }
}
