package SortingAlgorithms;

public class DSort extends SortAlgorithm {

    // Set Algorithm Properties in the Constructor
    public DSort(){
        id = "dSort";
        name = "Merge";
    }



    /**
     * Overriding Base class method for processing data
     * @param array - array of numbers
     */
    @Override public void sortData(int[] array){
        int length = array.length;
        // Create array only once for merging
        int[] workingArray = new int[array.length];
        //*** Update number of compares in the base class from the returned value
        comparesCount = doDSort(array, workingArray, 0, length - 1, comparesCount);
    }


    /**
     * The doDSort method uses the Merge algorithm to sort an int array.
     * @param inputArray The array to sort.
     * @param workingArray temporary array
     * @param lowerIndex start element index
     * @param higherIndex end element index
     * @param count recursive variable to keep the number of counts
     * @return number of counts
     */
    private  long doDSort(int[] inputArray, int[] workingArray, int lowerIndex, int higherIndex, long count) {
        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            // Below step sorts the left side of the array
            count = doDSort(inputArray, workingArray, lowerIndex, middle, count);
            // Below step sorts the right side of the array
            count = doDSort(inputArray, workingArray, middle + 1, higherIndex, count);
            // Now merge both sides
            count += part2(inputArray, workingArray, lowerIndex, middle, higherIndex);
        }
        return count;
    }


    /**
     * Merge sides of the array
     * @param inputArray array of data
     * @param workingArray temporary array
     * @param lowerIndex start element index
     * @param middle index of the middle element
     * @param higherIndex end element index
     * @return number of comparisons
     */

    private long part2(int[] inputArray, int[] workingArray, int lowerIndex, int middle, int higherIndex) {

        long count = 0;
        // Copy values from input array ro working arrau
        for (int i = lowerIndex; i <= higherIndex; i++) {
            workingArray[i] = inputArray[i];
        }
        int i1 = lowerIndex;
        int i2 = middle + 1;
        int newIndex = lowerIndex;
        // Perform swapping
        while (i1 <= middle && i2 <= higherIndex) {
            count++;
            if (workingArray[i1] <= workingArray[i2]) {
                inputArray[newIndex] = workingArray[i1];
                i1++;
            } else {
                inputArray[newIndex] = workingArray[i2];
                i2++;
            }
            newIndex++;
        }
        // Copy back to input array
        while (i1 <= middle) {
            inputArray[newIndex] = workingArray[i1];
            newIndex++;
            i1++;
        }
        return count;
    }

}
