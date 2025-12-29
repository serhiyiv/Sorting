package SearchAlgorithms;

import java.util.Arrays;

/**
 * The base class for all Search Algorithms Classes
 * Holds built in information for the algorithm processing
 */
public class SearchAlgorithm {
    // all properties are self-explanatory
    public long executionTime = 0;
    public long comparesCount = 0;
    public float stepTime = 0;
    public String name = "Unknown";


    /**
     * main method to execute the search algorithm
     * @param array - array of numbers
     * @param value - value to look for
     */
    public int[] search(int[] array, int value){
        // clear number of comparisons
        comparesCount = 0;
        // save start time
        long startTime = System.nanoTime();
        // perform sorting
        int[] searchResult = searchData(array, value);
        // calculate and save execution time
        executionTime = System.nanoTime() - startTime;
        // calculate step execution time
        comparesCount = searchResult[1];
        stepTime = searchResult[1] > 0? (float) executionTime / searchResult[1]: 0;
        return searchResult;
    }






    /**
     * Base class method for processing data
     * @param array - array of numbers
     */
    public int[] searchData(int[] array, int value){
        return new int[]{-1, 0};
    }


public void printResults(){
    System.out.printf("%-20s %-25s %-14s %-14.2f\n", name, executionTime, comparesCount, stepTime );
}



}
