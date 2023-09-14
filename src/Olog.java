import java.util.Arrays;
import java.util.Random;

public class Olog {
    public void mergeSort(int[] arr, long[] comparisonCounts, int index) {
        int n = arr.length;
        long comparisons = 0;

        if (n < 2) {
            return;
        }

        int mid = n / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, n);

        mergeSort(left, comparisonCounts, index); // Recursive call with the same index
        mergeSort(right, comparisonCounts, index); // Recursive call with the same index

        merge(arr, left, right, comparisons);
        comparisonCounts[index] = comparisons;
    }

    private void merge(int[] arr, int[] left, int[] right, long comparisons) {
        int n1 = left.length;
        int n2 = right.length;
        int i = 0, j = 0, k = 0;

        while (i < n1 && j < n2) {
            comparisons++;
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < n1) {
            arr[k++] = left[i++];
        }

        while (j < n2) {
            arr[k++] = right[j++];
        }
    }
    public void sort() {
        int[] numbers = generateRandomNumbers();

        System.out.println("\nData set before quicksort:");
        printArray(numbers);

        quickSort(numbers, 0, numbers.length - 1);

        System.out.println("\nData set after quicksort:");
        printArray(numbers);
        System.out.println("\n");
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // Swap arr[i] and arr[j].
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i+1] and arr[high].
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    private int[] generateRandomNumbers() {
        int[] randomNumbers = new int[10];
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            randomNumbers[i] = random.nextInt(100); // Generate random integers [0; 99].
        }

        return randomNumbers;
    }

    private void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
