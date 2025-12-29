package SortingAlgorithms;


public class ASort extends SortAlgorithm {
    // Set Algorithm Properties in the Constructor
    public ASort(){
        id = "aSort";
        name = "Quick";
    }


    /**
     * Overriding Base class method for processing data
     * @param array - array of numbers
     */
    @Override public void sortData(int[] array){
        // Update number of compares in the base class from the returned value
        comparesCount = doASort(array, 0, array.length - 1, 0);
    }

    /**
     * The doASort method uses the QuickSort algorithm to sort an int array.
     *
     * @param array The array to sort.
     * @param start start index
     * @param end end index
     */
    private long doASort(int array[], int start, int end, long numberOfCompares) {
        int pivotPoint;

        if (start < end) {
            // Get the pivot point.
            pivotPoint = part1(array, start, end);
            // Note - only one +/=
            numberOfCompares += (end - start);
            // Sort the first sub list.
            numberOfCompares = doASort(array, start, pivotPoint - 1, numberOfCompares);

            // Sort the second sub list.
            numberOfCompares = doASort(array, pivotPoint + 1, end, numberOfCompares);
        }
        return numberOfCompares;
    }


    /**
     * The partition method selects a pivot value in an array and arranges the
     * array into two sub lists. All the values less than the pivot will be
     * stored in the left sub list and all the values greater than or equal to
     * the pivot will be stored in the right sub list.
     *
     * @param array The array to partition.
     * @param start The starting subscript of the area to partition.
     * @param end The ending subscript of the area to partition.
     * @return The subscript of the pivot value.
     */
    private int part1(int[] array, int start, int end) {
        int pivotValue;    // To hold the pivot value
        int endOfLeftList; // Last element in the left sub list.
        int mid;           // To hold the mid-point subscript

        // see http://www.cs.cmu.edu/~fp/courses/15122-s11/lectures/08-qsort.pdf
        // for discussion of middle point - This improves the almost sorted cases
        // of using quicksort
        // Find the subscript of the middle element.
        // This will be our pivot value.
        mid = (start + end) / 2;
        // mid = start;

        // Swap the middle element with the first element.
        // This moves the pivot value to the start of
        // the list.
        swap(array, start, mid);

        // Save the pivot value for comparisons.
        pivotValue = array[start];

        // For now, the end of the left sub list is
        // the first element.
        endOfLeftList = start;

        // Scan the entire list and move any values that
        // are less than the pivot value to the left
        // sub list.
        for (int scan = start + 1; scan <= end; scan++) {
            if (array[scan] < pivotValue) {
                endOfLeftList++;
                swap(array, endOfLeftList, scan);
            }
        }

        // Move the pivot value to end of the
        // left sub list.
         swap(array, start, endOfLeftList);

        // Return the subscript of the pivot value.
        return endOfLeftList;
    }



}
