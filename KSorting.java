import java.util.Random;

public class KSorting {
    public static void generateKSorted(int[] my_array) {
        Random random = new Random();
        int n = my_array.length;
        // Fill the array with random numbers
        for (int i = 0; i < n; i++) {
            my_array[i] = random.nextInt(1000);
        }
        for (int i = 1; i < n; i++) {
            int current = my_array[i];
            int j = i;
            while (j > 10 && my_array[j - 10] > current) {
                my_array[j] = my_array[j - 10];
                j -= 10;
            }
            my_array[j] = current;
        }
    }
}