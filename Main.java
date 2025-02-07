public class Main {
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
        // Define the array sizes and k value to test
        int[] sizes = {100, 500, 1000, 2000, 5000, 10000, 20000, 75000, 150000};
        int k = 10;
        // Run performance tests for each algorithm
        System.out.println("Bubble Sort Performance:");
        for (int size : sizes) {
            bubbleTester.test(5, size, k);
        }
        System.out.println("\nInsertion Sort Performance:");
        for (int size : sizes) {
            insertionTester.test(5, size, k);
        }
        System.out.println("\nSelection Sort Performance:");
        for (int size : sizes) {
            selectionTester.test(5, size, k);
        }
        System.out.println("\nShell Sort Performance:");
        for (int size : sizes) {
            shellTester.test(5, size, k);
        }
        System.out.println("\nQuick Sort Performance:");
        for (int size : sizes) {
            quickTester.test(5, size, k);
        }
        System.out.println("\nMerge Sort Performance:");
        for (int size : sizes) {
            mergeTester.test(5, size, k);
        }
    }
}