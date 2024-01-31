package lv.rvt;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import rvt.Searcher;
import rvt.Sorter;

public class AlgorithmTest {

    @Test
    public void testLinearSearchMethod(){

        int[] numbers = {8, 3, 7, 9, 1, 2, 4};
        int result = Searcher.linearSearch(numbers, 3);
        assertEquals(1, result);
        result = Searcher.linearSearch(numbers, 7);
        assertEquals(2, result);
        result = Searcher.linearSearch(numbers, 4);
        assertEquals(6, result);
    }

    @Test
    public void testBinarySearchMethod(){

        int[] numbers = {8, 3, 7, 9, 1, 2, 4};
        Sorter.sort(numbers);
        // Sorted {1, 2, 3, 4, 7, 8, 9}
        int result = Searcher.binarySearch(numbers, 3);
        assertEquals(2, result);
        result = Searcher.binarySearch(numbers, 7);
        assertEquals(4, result);
        result = Searcher.binarySearch(numbers, 9);
        assertEquals(6, result);
    }

    @Test
    public void testSortMethod(){

        int[] numbers = {8, 3, 7, 9, 1, 2, 4};
        Sorter.sort(numbers);
        int[] numbers2 = {1, 2, 3, 4, 7, 8, 9};
        assertEquals(Arrays.toString(numbers), Arrays.toString(numbers2));

    }


}
