import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean quit = false;

        while (!quit) {
            System.out.println("Menu of Searching and Sorting Testbed.\n");
            String[] typesOfSorting = {"Linear searching", "Binary searching", "O(n^2) type of sorting",
                    "O(n*log(n)) type of sorting", "Sorting performance"};

            for (int i = 1; i <= typesOfSorting.length; i++) {
                System.out.println(i + ")   " + typesOfSorting[i - 1]);
            }

            System.out.println("\nq/Q) Quit\n");

            System.out.print("Your choice: ");
            Scanner scan = new Scanner(System.in);
            String option = scan.nextLine();

            switch (option) {
                case "1":
                    // Linear searching
                    LinearSearching linearSearching = new LinearSearching();
                    linearSearching.search();
                    break;
                case "2":
                    // Binary searching
                    BinarySearching binarySearching = new BinarySearching();
                    binarySearching.search();
                    break;
                case "3":
                    // O(n^2) type of sorting
                    Osquared osquared = new Osquared();
                    osquared.sort();
                    break;
                case "4":
                    // O(n*log(n)) type of sorting
                    Olog olog = new Olog();
                    olog.sort();
                    break;
                case "5":
                    // Sorting performance
                    SortingPerformance sortingPerformance = new SortingPerformance();
                    sortingPerformance.check();
                    break;
                case "q":
                case "Q":
                    quit = true; // Exit the loop and terminate the program
                    break;
                default:
                    System.out.println("Incorrect option choice.");
            }
        }
    }
}
