import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Performance {
    public static void main(String[] args) {
        // Define the sorting algorithms to test
        SortingAlgorithms bubbleSort = new BubbleSort();
        SortingAlgorithms insertionSort = new InsertionSort();
        SortingAlgorithms selectionSort = new SelectionSort();
        SortingAlgorithms shellSort = new ShellSort();
        SortingAlgorithms quickSort = new QuickSort();
        SortingAlgorithms mergeSort = new MergeSort();

        // Create Tester objects for each algorithm
        Tester bubbleTester = new Tester(bubbleSort);
        Tester insertionTester = new Tester(insertionSort);
        Tester selectionTester = new Tester(selectionSort);
        Tester shellTester = new Tester(shellSort);
        Tester quickTester = new Tester(quickSort);
        Tester mergeTester = new Tester(mergeSort);

        // Define the array sizes to test and the k value for k-sorted data
        int[] sizes = {100, 500, 1000, 2000, 5000, 10000, 20000, 75000, 150000};
        int k = 10;  // For 10-sorted data

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("sorting_performance_report.txt"))) {
            // Run performance tests for each algorithm and write results to the file
            testAlgorithmPerformance(writer, "Bubble Sort", bubbleTester, sizes, k);
            testAlgorithmPerformance(writer, "Insertion Sort", insertionTester, sizes, k);
            testAlgorithmPerformance(writer, "Selection Sort", selectionTester, sizes, k);
            testAlgorithmPerformance(writer, "Shell Sort", shellTester, sizes, k);
            testAlgorithmPerformance(writer, "Quick Sort", quickTester, sizes, k);
            testAlgorithmPerformance(writer, "Merge Sort", mergeTester, sizes, k);

            System.out.println("Performance report generated in 'sorting_performance_report.txt'.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Helper method to run performance tests for each algorithm and write the results to the file
    private static void testAlgorithmPerformance(BufferedWriter writer, String algorithmName, Tester tester, int[] sizes, int k) throws IOException {
        writer.write("Sorting algorithm – " + algorithmName + "\n");

        for (int size : sizes) {
            System.out.println("Running test for " + size + " elements...");  // Print progress
            double avgTime = tester.singleTest(size, k);
            writer.write("Sorted " + size + " elements in " + avgTime + " ms (avg)\n");
        }

        writer.write("\n");
    }
}