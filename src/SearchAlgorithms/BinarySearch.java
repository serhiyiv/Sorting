package SearchAlgorithms;

import java.util.Arrays;

public class BinarySearch extends SearchAlgorithm {
    // Set Algorithm Properties in the Constructor
    public BinarySearch(){
        name = "Binary";
    }


    /**
     * Overriding Base class method for processing data
     * @param array - array of numbers
     */
    @Override public int[] searchData(int[] array, int value){
        return binarySearchR(array, 0, array.length, value, 0);
    }



    private static int[] binarySearchR(int[] array, int low, int high, int value, int count)
    {
        int middle;     // Mid point of search

        // Test for the base case where the value is not found.
        if (low > high)
            return new int[] {-1,count};

        // Calculate the middle position.
        middle = (low + high) / 2;

        // Search for the value.
        if (array[middle] == value)
            // Found match return the index
            return new int[] {middle, count};
        else if (value > array[middle])
            // Recursive method call here (Upper half of remaining data)
            return binarySearchR(array, middle + 1, high, value, count+1);
        else
            // Recursive method call here (Lower half of remaining data)
            return binarySearchR(array, low, middle - 1, value, count+1);
    }









}
