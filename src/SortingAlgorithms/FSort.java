package SortingAlgorithms;



public class FSort extends SortAlgorithm {
    // Set Algorithm Properties in the Constructor
    public FSort(){
        id = "fSort";
        name = "Shell";
    }


    /**
     * Overriding Base class method for processing data
     * @param array - array of numbers
     */
    @Override public void sortData(int[] array){
        int n = array.length;
        // Iterate over array keeping the gap
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // Iterate over each element starting from the gap right side and first element on the left side
            for (int i = gap; i < n; i++) {
                int key = array[i];
                int j = i;
                while (j >= gap && array[j - gap] > key) {
                    // *** Increment number of comparisons here
                    comparesCount++;
                    array[j] = array[j - gap];
                    j -= gap;
                }
                array[j] = key;
            }
        }

    }
}
