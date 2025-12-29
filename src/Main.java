/*
 Assignment 2
 Author: Serhii Ivanchuk
 Date: October 5, 2023

 I, Serhii Ivanchuk, student number 000818168, certify that this material is
 my original work. No other person's work has been used without due acknowledgment
 and I have not made my work available to anyone else.



For this assignment I decided not to use Interface as it was suggested (optionally) in the assignment description.
Using a separate classes gives more flexibility for the assignment task.

ANSWERS:

PART 1
_______________________________________________________________________________________________________________________________________________________________
a. Based on the results that fluctuate each Test for an array of size 20:
The slowest one, regardless is Radix
The fastest one sometimes Insertion, sometimes Shell


Test 1
fSort (Shell)        3300                      33             72.7
bSort (Selection)    5040                      190            24.7
dSort (Merge)        5620                      63             65.1
eSort (Bubble)       6440                      190            31.6
aSort (Quick)        7980                      80             57.5
cSort (Insertion)    8560                      113            243.4
gSort (Radix)        104980                    19             4700.0



Test 2
cSort (Insertion)    2700                      66             28.8
fSort (Shell)        2900                      36             63.9
bSort (Selection)    4580                      190            23.2
dSort (Merge)        5760                      64             60.9
eSort (Bubble)       6040                      190            28.4
aSort (Quick)        7960                      69             295.7
gSort (Radix)        79520                     19             4084.2



b. When sorting 50000 numbers, the results were constant with Radix being the Fastest one and Bubble Sort - the slowest one

Test 1
gSort (Radix)        677440                    49999          7.50
aSort (Quick)        4198840                   985797         2.91
dSort (Merge)        4724480                   718308         5.03
fSort (Shell)        5452940                   1131389        4.36
cSort (Insertion)    325281760                 624954147      0.56
bSort (Selection)    561764600                 1249975000     0.48
eSort (Bubble)       3192568620                1249975000     2.43


Test 2
gSort (Radix)        698080                    49999          7.99
aSort (Quick)        3643480                   981342         2.84
dSort (Merge)        4212460                   718440         5.32
fSort (Shell)        5487440                   1155272        4.85
cSort (Insertion)    314021740                 625098684      0.50
bSort (Selection)    425996020                 1249975000     0.23
eSort (Bubble)       3005829620                1249975000     2.40



c. At 50000 items the lowest basic instruction set time was for Selection Sort - 0.48 and 0.23
It does not impact the selection of the fastest algorithm as number of comparisons is much higher than the fastest algorithms



d.
=========================================================================
Sort Algorithm     Sort Algorithm Name     Big O(time AVG)  Big O(space WORST)
-------------------------------------------------------------------------
aSort              Quick                   O(n log(n))      O(log(n))
bSort              Selection               O(n^2)           O(1)
cSort              Insertion               O(n^2)           O(1)
dSort              Merge                   O(n log(n))      O(n)
eSort              Bubble                  O(n^2)           O(1)
fSort              Shell                   O(n(log(n))^2)   O(1)
gSort              Radix                   O(nk)            O(n+k)
------------------------------------------------------------------------



PART 2
_________________________________________________________________________

According to results, Binary search is much faster than Linear search.
However, if we add time required for sorting the data first to the search time, the number is quiet high, depending on the sorting algorithm used.
If a data can be sorted somewhere separately than it makes sense to prefer BINARY SEARCH over LINEAR.

But if a search has to be executed on some data that is changing every second, then performing SORT + BINARY SEARCH will take much more time,
even when compared to Linear Search on unsorted data.
For EX: Sorting (276138100 ns)  + Binary Search (6300 ns) = 276144400 ns
While simply using Linear search without sorting will result in  5318000 ns which is 51.9 times faster.

So the use depends on the situation.


Test 1
Linear               5318000                   1000000        5.32
Linear (Sorted)      1243600                   1000000        1.24
Binary (Sorted)      6300                      19             331.58


Test 2
Linear               5289400                   1000000        5.29
Linear (Sorted)      1322000                   1000000        1.32
Binary (Sorted)      8900                      19             468.42

 */


import SearchAlgorithms.BinarySearch;
import SearchAlgorithms.LinearSearch;
import SortingAlgorithms.*;
import java.util.Random;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {


    /**
     * Generates an array of positive numbers based on the provided dataSize
     * @param dataSize - size of an array to be created
     * @return and array of positive numbers
     */
    public static int[] generateData(int dataSize){
        // initialize a new random number generator
        Random rand = new Random();
        // initialize result array of provided size
        int[] result = new int[dataSize];

        // populate the result array with random numbers in a range 0 - 10000
        for (int i = 0; i < dataSize; i++) {
            result[i] = rand.nextInt(10000) + 1;
           // System.out.println(result[i] );
        }
        return result;
    }


    /**
     * Prints a result header for Sorting Algorithms
     * @param dataSize - size of the data processed
     * @param runCount - number of runs
     */
    public static void printSortHeader(int dataSize, int runCount){
        System.out.println("\nComparison Table for array size of " + dataSize + " (Averaged over " + runCount + " runs)");
        System.out.println("=".repeat(77));
        System.out.printf("%-20s %-25s %-14s %-14s", "Sort Algorithm", "Execution Time (ns)", "Compares", "Basic Step (ns)");
        System.out.println("\n" + "=".repeat(77));
    }



    /**
     * Prints a result header for Search Algorithms
     * @param dataSize - size of the data processed
     */
    public static void printSearchHeader(int dataSize){
        System.out.println("\nComparison Table of Search Algorithms for array size of " + dataSize);
        System.out.println("=".repeat(77));
        System.out.printf("%-20s %-25s %-14s %-14s", "Search Algorithm", "Execution Time (ns)", "Compares", "Basic Step (ns)");
        System.out.println("\n" + "=".repeat(77));
    }




    /**
     * Main method
     * @param args - arguments
     */
    public static void main(String[] args) {
        System.out.print("\n# PART 1: Sorting Algorithms");

        // an array of data sizes to process
        int[] dataSizes = new int[]{20, 100, 10000, 50000};//
        // An array of the Sorting Algorithms that have to be executed one by one
        SortAlgorithm[] sortAlgorithms = new SortAlgorithm[]{new ASort(), new BSort(), new CSort(), new DSort(), new ESort(), new FSort(), new GSort()};
       // a variable to define number of desired runs
        int runCount = 5;

        // First iterate over each data size
        for (int size : dataSizes) {
            // Print header for with the information about the Data size processed
            printSortHeader(size, runCount);
            // Generate array of data (numbers) of the data size being processed
            int[] data = generateData(size);

            // iterate over each Sorting algorithm
            for (SortAlgorithm sortingAlgorithm : sortAlgorithms) {

                // Add total executionTime and stepTime each run to later calculate average time for each value
                long executionTime = 0;
                float stepTime = 0;
                 // As requested in the assignment, need to perform a number of runs for each algorithm and get an average time
                for (int run = 0; run < runCount; run++) {
                    // Call the Sort method of a Sorting algorithm, passing the data. NOTE - A copy of the data is created inside the Sort method, so original data is passed
                    sortingAlgorithm.sort(data);
                    // Each new run, add the value of executionTime and stepTime from the current algorithm object
                    executionTime += sortingAlgorithm.executionTime;
                    stepTime+= sortingAlgorithm.stepTime;
                }
                 // once all the runs for the same algorithm are done, just divide the total processing time by the number of runs to get an average time for the algorithm to sort the data over N runs
                System.out.printf("%-20s %-25s %-14s %-14.2f\n", sortingAlgorithm.id + " ("+sortingAlgorithm.name+")", executionTime / runCount, sortingAlgorithm.comparesCount, stepTime / runCount);

            }
            System.out.println("=".repeat(77) + "\n\n");
        }






        System.out.print("# PART 2: Searching");

        // Set what number to look for
        int searchValue = -1;

        // Define Data Size
        int dataSize = 1000000;
        // Creating an array of numbers of dataSize
        int[] data = generateData(dataSize);

        // Initialize sort algorithm and call Sort method to return a sorted array of integers
        SortAlgorithm sortAlgorithm = new FSort(); // Can be set to any of available sort algorithms
        int[] sortedData = sortAlgorithm.sort(data);
        System.out.println("\nData was sorted using " + sortAlgorithm.name + " algorithm in " + sortAlgorithm.executionTime + " ns");

        // Print header for the table
        printSearchHeader(dataSize);

        // Initialize Linear Search
        LinearSearch linearSearch =  new LinearSearch();
        // Perform search
        linearSearch.search(data, searchValue);
        linearSearch.printResults();
        // Just keep the time for processing unsorted data
        long linearUnsortedTime = linearSearch.executionTime;

        // Call the same linear search but on Sorted array
        linearSearch.name += " (Sorted)";
        linearSearch.search(sortedData, searchValue);
        linearSearch.printResults();


        // Initialize Binary Search
        BinarySearch binarySearch =  new BinarySearch();
        binarySearch.name += " (Sorted)";
        binarySearch.search(sortedData, searchValue);
        binarySearch.printResults();

        // Print additional comparison information
        System.out.println("\nLinear Search on SORTED data is approximately " + (linearUnsortedTime / linearSearch.executionTime) + " times faster than Linear Search on UNSORTED data.");
        System.out.println("Binary Search is approximately " + (linearUnsortedTime / binarySearch.executionTime) + " times faster than UNSORTED Linear Search.");
        System.out.println("Binary Search is approximately " + (linearSearch.executionTime / binarySearch.executionTime) + " times faster than SORTED Linear Search.");

        long totalLinearTime = linearSearch.executionTime + sortAlgorithm.executionTime;
        System.out.println("Total time including Sorting Time for Linear is: " + totalLinearTime);

        long totalBinaryTime = binarySearch.executionTime + sortAlgorithm.executionTime;
        System.out.println("Total time including Sorting Time for Binary is: " + totalBinaryTime);

        System.out.println("Taking into account time spent for sorting the data, Binary Search + Sorting data ("+ totalBinaryTime +" ns.) is " + (totalBinaryTime / linearUnsortedTime)
                + " times slower than performing simple Linear search on NOT Sorted data ("+ linearUnsortedTime +" ns.)");


    }
}