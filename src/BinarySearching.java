import java.util.Scanner;

public class BinarySearching {
    private final int[] values = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    public long searchCustom(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        long comparisons = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                comparisons++;
                return comparisons; // Element found
            } else if (arr[mid] < target) {
                comparisons++;
                left = mid + 1; // Search in the right half
            } else {
                comparisons++;
                right = mid - 1; // Search in the left half
            }
        }

        return comparisons; // Element not found
    }

    public void search() {
        System.out.print("In the list are values 0, ..., 9; which value " +
                "would you like to search with binary search? ");
        Scanner scanner = new Scanner(System.in);
        int searchValue = scanner.nextInt();
        boolean found = binarySearch(searchValue);
        ;

        if (found) {
            System.out.println("\nFound\n");
        } else {
            System.out.println("\nNot found\n");
        }
    }

    private boolean binarySearch(int searchValue) {
        int left = 0;
        int right = values.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (values[mid] == searchValue) {
                return true; // Value found
            }

            if (values[mid] < searchValue) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false; // Value not found
    }
}
