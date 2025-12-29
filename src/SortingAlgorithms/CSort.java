package SortingAlgorithms;

public class CSort extends SortAlgorithm {
    // Set Algorithm Properties in the Constructor
    public CSort(){
        id = "cSort";
        name = "Insertion";
    }


    /**
     * Overriding Base class method for processing data
     * @param array - array of numbers
     */
    @Override public void sortData(int[] array){
        int unsortedValue;  // The first unsorted value
        int scan;           // Used to scan the array

        // The outer loop steps the index variable through
        // each subscript in the array, starting at 1. The portion of
        // the array containing element 0  by itself is already sorted.
        for (int index = 1; index < array.length; index++) {
            // The first element outside the sorted portion is
            // array[index]. Store the value of this element
            // in unsortedValue.
            unsortedValue = array[index];

            // Start scan at the subscript of the first element
            // outside the sorted part.
            scan = index;

            // Move the first element in the still unsorted part
            // into its proper position within the sorted part.
            while (scan > 0 && array[scan - 1] > unsortedValue) {
                // *** Increment number of comparisons here
                comparesCount++;
                array[scan] = array[scan - 1];
                scan--;
            }

            // Insert the unsorted value in its proper position
            // within the sorted subset.
            array[scan] = unsortedValue;
        }

    }
}
