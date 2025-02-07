public class SelectionSort implements SortingAlgorithms {
    @Override
    public int[] sort(int[] input) {
        int n = input.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (input[j] < input[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = input[minIdx];
            input[minIdx] = input[i];
            input[i] = temp;
        }
        return input;
    }
}