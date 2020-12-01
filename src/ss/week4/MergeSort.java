package ss.week4;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    public static <E extends Comparable<E>>
       void mergesort(List<E> list) {
            sort(list, 0, list.size()-1); // Calls the recursive sort method
    }

    // Recursive merge sort method that performs splitting up list into sub-lists and calling merge for each pair
    public static <E extends Comparable<E>>
        void sort(List<E> list, int first, int last) {

            if (first < last) { // If the index of initial element is smaller than the last
                int middle = ((first + last) /2); // Finds middle index for the sub-list

                sort(list, first, middle); // Sorts left side of the two lists from the main list
                sort(list, middle+1, last); // Sorts right side of the two lists from the main list

                merge(list, first, last, middle); // Merges the two organized lists into the main list
            }

    }

    // Merge method that compares two lists and merges them into one organized list
    public static <E extends Comparable<E>>
        void merge(List<E> list, int first, int last, int middle) {

            // Temporary copies of the two sub-lists. They are used as a reference
            // since the original list is being manipulated as the merge goes on.
            List<E> list1Temp = new ArrayList<>(list.subList(first, middle+1));
            List<E> list2Temp = new ArrayList<>(list.subList(middle+1, last+1));

            // Indices of first and second sub-lists
            int list1Index = 0, list2Index = 0;
            // Index of merged sub-list
            int mergedArrIndex = first;

            while(list1Index < list1Temp.size() && list2Index < list2Temp.size()) { // While both sub-lists still have at least 1 un-ordered element


                if (
                        list1Temp.get(list1Index).compareTo(list2Temp.get(list2Index)) == 0 || // If list1 element is equal to list2 element
                        list1Temp.get(list1Index).compareTo(list2Temp.get(list2Index)) < 0  // If list1 element is smaller than list2 element
                ) {

                    list.set(mergedArrIndex, list1Temp.get(list1Index)); // Set the merged list element from list1
                    list1Index++;

                } else { // If list2 element is smaller than list1 element

                    list.set(mergedArrIndex, list2Temp.get(list2Index)); // Set the merged list element from list2
                    list2Index++;

                }
                mergedArrIndex++;
            }

            // Following two while loops are necessary because the merging while loop can
            // stop when one list is fully organized but the other one isn't. So any leftover elements
            // can easily be copied over to the main list.
            // Copy any remaining elements from list1
            while (list1Index < list1Temp.size()) {
                list.set(mergedArrIndex, list1Temp.get(list1Index));
                list1Index++;
                mergedArrIndex++;
            }

            // Copy any remaining elements from list2
            while (list2Index < list2Temp.size()) {
                list.set(mergedArrIndex, list2Temp.get(list2Index));
                list2Index++;
                mergedArrIndex++;
            }

    }

}
