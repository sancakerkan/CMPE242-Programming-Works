package circularSinglyLinkedList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        CircularSinglyLinkedList list;
        Random random = new Random();
        int[] sizes = {10000, 100000, 1000000, 25000000};

        // Print the table header for insertion and search times
        System.out.printf("%-15s %-20s %-20s%n", "Size of List", "Insertion Time(ms)", "Search Time(ms)");
        System.out.println(String.format("%0" + 55 + "d", 0).replace("0", "-"));

        for (int size : sizes) {
            list = new CircularSinglyLinkedList(); // Initialize a new list for each size

            // Calculate insertion time in msec.
            long startInsert = System.currentTimeMillis();
            for (int i = 0; i < size; i++) {
                list.insert(random.nextInt()); // Insert values
            }
            long timeElapsedInsert = System.currentTimeMillis() - startInsert;

            // Calculate search time in msec.
            long startSearch = System.currentTimeMillis();
            for (int i = 0; i < size; i++) {
                list.search(random.nextInt()); // Search values
            }
            long timeElapsedSearch = System.currentTimeMillis() - startSearch;

            // Print the results for insertion and search
            System.out.printf("%-15d %-20d %-20d%n", size, timeElapsedInsert, timeElapsedSearch);
        }

  
        for (int size : sizes) {
            list = new CircularSinglyLinkedList(); // Re-initialize the list for deletion operations

            // Fill the linkedlist
            for (int i = 0; i < size; i++) {
                list.insert(random.nextInt());
            }

            // Calculate deletion time in msec.
            long startDelete = System.currentTimeMillis();
            for (int i = 0; i < size; i++) {
                list.deleteRandom(); // Call the deleteRandom method
            }
            long timeElapsedDelete = System.currentTimeMillis() - startDelete;

            // Print the results for deletion.
            System.out.printf("%nDeletion Time for %d elements: %d ms%n", size, timeElapsedDelete);
        }
    }
}
