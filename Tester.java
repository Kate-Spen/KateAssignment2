import java.util.*;
public class Tester {
    private SortingAlgorithms sortingAlgorithm;
    public Tester(SortingAlgorithms sortingAlgorithm) {
        this.sortingAlgorithm = sortingAlgorithm;
    }
    public double singleTest(int size, int k) {
        int[] array = generateKSorted(size, k);
        long startTime = System.nanoTime();
        sortingAlgorithm.sort(array);
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1_000_000.0;
    }
    public void test(int iterations, int size, int k) {
        double totalTime = 0;
        for (int i = 0; i < iterations; i++) {
            totalTime += singleTest(size, k);
        }
        double avgTime = totalTime / iterations;
        System.out.println("Average time for " + iterations + " tests with array size " + size + ": " + avgTime + " ms");
    }
    private int[] generateKSorted(int size, int k) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * 10000);
        }
        Arrays.sort(array);  // Sort the array to get the correct positions
        for (int i = 0; i < size; i++) {
            int swapIdx = Math.max(0, i - k) + (int) (Math.random() * (Math.min(k, size - i)));
            int temp = array[i];
            array[i] = array[swapIdx];
            array[swapIdx] = temp;
        }
        return array;
    }
}