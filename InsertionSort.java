public class InsertionSort implements SortingAlgorithms {
    @Override
    public int[] sort(int[] input) {
        int n = input.length;
        for (int i = 1; i < n; i++) {
            int current = input[i];
            int j = i - 1;
            while (j >= 0 && input[j] > current) {
                input[j + 1] = input[j];
                j--;
            }
            input[j + 1] = current;
        }
        return input;
    }
}