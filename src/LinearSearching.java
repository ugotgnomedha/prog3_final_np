import java.util.Scanner;

public class LinearSearching {
    public void searchCustom(int[] values, int searchValue, long[] comparisonCounts) {
        int comparisons = 0;

        for (int value : values) {
            comparisons++;
            if (value == searchValue) {
                break;
            }
        }

        comparisonCounts[0] = comparisons;
    }

    public void search() {
        int[] values = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.print("In the list are values 0, ..., 9; which value " +
                "would you like to search with linear search? ");
        Scanner scanner = new Scanner(System.in);
        int searchValue = scanner.nextInt();
        boolean found = false;

        for (int value : values) {
            if (value == searchValue) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("\nFound\n");
        } else {
            System.out.println("\nNot found\n");
        }
    }
}
