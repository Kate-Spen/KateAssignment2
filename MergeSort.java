public class MergeSort implements SortingAlgorithms {
    @Override
    public int[] sort(int[] input) {
        if (input.length <= 1) {
            return input;
        }
        int mid = input.length / 2;
        int[] left = new int[mid];
        int[] right = new int[input.length - mid];

        System.arraycopy(input, 0, left, 0, mid);
        System.arraycopy(input, mid, right, 0, input.length - mid);

        sort(left);
        sort(right);
        return merge(left, right);
    }

    private int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }
        while (i < left.length) {
            result[k++] = left[i++];
        }
        while (j < right.length) {
            result[k++] = right[j++];
        }
        return result;
    }
}
