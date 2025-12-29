package SortingAlgorithms;

import java.util.Arrays;

/**
 * The base class for all Sorting Algorithms Classes
 * Holds built in information for the algorithm processing
 */
public class SortAlgorithm {
    // all properties are self-explanatory
    public long executionTime = 0;
    public long comparesCount = 0;
    public float stepTime = 0;
    public String id = "";
    public String name = "Unknown";


    /**
     * main method to execute a sorting algorithm
     * @param array - array of numbers, won't be changed as a copy of the array is passed and returned
     */
    public int[] sort (int[] array){
        // clear number of comparisons
        comparesCount = 0;
        // save start time
        long startTime = System.nanoTime();
        // create a copy of the array as a result array
        int[] result = Arrays.copyOf(array, array.length);
        // perform sorting on the copy of the array
        sortData(result);
        // calculate and save execution time
        executionTime = System.nanoTime() - startTime;
        // calculate step execition time
        stepTime = comparesCount > 0? (float) executionTime / comparesCount: 0;
        // return a sorted copy of the original array
        return result;
    }


    /**
     * Base class method for processing data
     * @param array - array of numbers
     */
    public void sortData(int[] array){

    }

    /**
     * Swaps data values with each other in the array
     * @param array - array of numbers
     * @param a - First array item Index
     * @param b - Second array item Index
     */
    public void swap(int[] array, int a, int b) {
        int temp;

        temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }



}
