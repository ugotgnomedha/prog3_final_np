import java.util.Arrays;
import java.util.Random;

public class SortingPerformance {
    private final int[] datasetSizes = {10000, 20000, 30000, 40000, 50000, 60000, 70000, 80000, 90000, 100000};

    public void check() {
        long startTime, endTime;
        long[] comparisonCounts = new long[4]; // Adjust the array size for the number of search types

        System.out.println("\nSorting Performance Test\n");

        for (int datasetSize : datasetSizes) {
            int[][] dataSets = generateDataSets(datasetSize);

            for (int i = 0; i < 4; i++) {
                int[] dataSet = Arrays.copyOf(dataSets[i], dataSets[i].length);

                switch (i) {
                    case 0:
                        System.out.println("Linear search (Dataset Size: " + datasetSize + "):");
                        startTime = System.currentTimeMillis();
                        LinearSearching linearSearch = new LinearSearching();
                        int lastElement = dataSet[dataSet.length - 1]; // Get the last element
                        linearSearch.searchCustom(dataSet, lastElement, comparisonCounts);
                        endTime = System.currentTimeMillis();
                        break;
                    case 1:
                        System.out.println("Binary search (Dataset Size: " + datasetSize + "):");
                        startTime = System.currentTimeMillis();
                        BinarySearching binarySearch = new BinarySearching();
                        lastElement = dataSet[dataSet.length - 1]; // Get the last element
                        comparisonCounts[i] = binarySearch.searchCustom(dataSet, lastElement);
                        endTime = System.currentTimeMillis();
                        break;
                    case 2:
                        System.out.println("Bubble Sort (Dataset Size: " + datasetSize + "):");
                        startTime = System.currentTimeMillis();
                        Osquared osquared = new Osquared();
                        osquared.bubbleSortCustom(dataSet, comparisonCounts, i);
                        endTime = System.currentTimeMillis();
                        break;
                    case 3:
                        System.out.println("Merge Sort (Dataset Size: " + datasetSize + "):");
                        startTime = System.currentTimeMillis();
                        Olog olog = new Olog();
                        olog.mergeSort(dataSet, comparisonCounts, i);
                        endTime = System.currentTimeMillis();
                        break;
                    default:
                        startTime = endTime = 0;
                        break;
                }

                long executionTime = endTime - startTime;
                System.out.println("Execution Time: " + executionTime + " ms");
                System.out.println("Comparisons: " + comparisonCounts[i]);
                System.out.println();
            }
        }
    }

    private int[][] generateDataSets(int n) {
        Random random = new Random();
        int[][] dataSets = new int[4][n];

        for (int i = 0; i < 4; i++) {
            dataSets[i] = random.ints(n).toArray();
        }

        return dataSets;
    }
}
