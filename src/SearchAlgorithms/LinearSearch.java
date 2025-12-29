package SearchAlgorithms;

public class LinearSearch extends SearchAlgorithm {
    // Set Algorithm Properties in the Constructor
    public LinearSearch(){
        name = "Linear";
    }


    /**
     * Overriding Base class method for processing data
     * @param array - array of numbers
     */
    @Override public int[] searchData(int[] array, int value){

        int count = 0;
        // Iterate over each element in the array and increment comparison count
        for (int i =0; i < array.length; i++){
            count++;
            // if the first element with the value is found return the index and number of comparisons and exit the loop
            if (array[i] == value){
                return new int[] {i, count};
            }
        }
        return new int[] {-1,count};

    }
}
