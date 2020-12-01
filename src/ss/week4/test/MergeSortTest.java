package ss.week4.test;

import org.junit.jupiter.api.Test;
import ss.week4.MergeSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MergeSortTest {
    @Test
    public void testMergesortEmptyList() {
        List<Integer> sequence = new ArrayList<>(Collections.emptyList());
        MergeSort.mergesort(sequence);
        assertEquals(Collections.emptyList(), sequence);
    }

    @Test
    public void testMergesortSingleItem() {
        List<Integer> sequence = new ArrayList<>(Arrays.asList(1));
        MergeSort.mergesort(sequence);
        assertEquals(Arrays.asList(1), sequence);
    }

    @Test
    public void testMergesortSortedList() {
        List<Integer> sequence = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        MergeSort.mergesort(sequence);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5), sequence);

        sequence = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        MergeSort.mergesort(sequence);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6), sequence);
    }

    @Test
    public void testMergesortUnsortedList() {
        List<Integer> sequence = new ArrayList<>(Arrays.asList(3, 2, 1, 5, 4));
        MergeSort.mergesort(sequence);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5), sequence);

        sequence = new ArrayList<>(Arrays.asList(3, 2, 1, 6, 5, 4));
        MergeSort.mergesort(sequence);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6), sequence);
    }
}
