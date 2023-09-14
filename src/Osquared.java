import java.util.Random;

public class Osquared {
    public void bubbleSortCustom(int[] arr, long[] comparisonCounts, int index) {
        int n = arr.length;
        long comparisons = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                comparisons++;
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        comparisonCounts[index] = comparisons;
    }

    public void sort() {
        int[] numbers = generateRandomNumbers();

        System.out.println("\nData set before insertion sorting:");
        printArray(numbers);

        bubbleSort(numbers);

        System.out.println("\nData set after insertion sorting:");
        printArray(numbers);
        System.out.println("\n");
    }

    private int[] generateRandomNumbers() {
        int[] randomNumbers = new int[10];
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            randomNumbers[i] = random.nextInt(100); // Generate random integers [0; 99].
        }

        return randomNumbers;
    }

    private void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        do {
            swapped = false;

            for (int i = 1; i < n; i++) {
                if (arr[i - 1] > arr[i]) {
                    // Swap arr[i-1] and arr[i].
                    int temp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
    }

    private void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
