package SortingAlgorithms;

public class GSort extends SortAlgorithm {
    // Set Algorithm Properties in the Constructor
    public GSort(){
        id = "gSort";
        name = "Radix";
    }

    /**
     * Overriding Base class method for processing data
     * @param array - array of numbers
     */
    @Override public void sortData(int[] array){
        int count = 0;

        int min = array[0];
        int max = array[0];
        // Iterate over the array and find min and max values in the array
        for (int i = 1; i < array.length; i++) {
            // *** Increment number of comparisons here
            comparesCount++;
            if (array[i] < min)
                min = array[i];
            else if (array[i] > max)
                max = array[i];
        }
        // Create the array
        int[] b = new int[max - min + 1];
        // Iterate over the array and increment number of the same elements in the "b" array
        for (int i = 0; i < array.length; i++)
        {
            b[array[i] - min]++;
        }
        // Update the initial data array
        for (int i = 0; i < b.length; i++)
            for (int j = 0; j < b[i]; j++) {
                array[count++] = i + min;
            }


    }
}
