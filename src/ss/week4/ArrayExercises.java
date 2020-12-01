package ss.week4;

public class ArrayExercises {
    public static int countNegativeNumbers(int[] arr) {
        int negativeCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                negativeCount += 1;
            }
        }
        return negativeCount;
    }

    public static void reverseArray(int[] ints) {

        int temp; // Variable to store temporary value when switching values within ints

        for (int i = 0; i < ints.length / 2; i++) { // Iterate over half of the ints array

            temp = ints[i]; // Temporary save the value of i

            ints[i] = ints[ints.length - 1 - i]; // Replace i with the respective element from array end

            ints[ints.length - 1 - i] = temp; // Replace the element from array end with i
        }
    }

    class SimpleList {
        public class Element {}

        public class Node {
            public Node next;
            public Element element;
        }

        private Node first;

        private Node find(Element element) {
            Node p = first;
            if (p == null) {
                return null;
            }
            while (p.next != null && !p.next.element.equals(element)) {
                p = p.next;
            }
            if (p.next == null) {
                return null;
            } else {
                return p;
            }
        }

        public void remove(Element element) {
            Node p = find(element);
            if (p != null) {
                p.next = p.next.next;
            }
        }
    }
}
