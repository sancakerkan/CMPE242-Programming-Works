package avlTree;

import java.util.Random;

public class MainAVL {
    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();
        Random rand = new Random();
        int[] sizes = {10000, 100000, 1000000, 25000000}; // sizes

        // Table header
        System.out.printf("%-15s %-20s %-20s%n", "Size of AVL", "Insertion Time(ms)", "Search Time(ms)");
        System.out.println(String.format("%0" + 55 + "d", 0).replace("0", "-"));

        for (int size : sizes) {
          
            // Calculate insertion time in msec.
            long startInsert = System.currentTimeMillis();
            for (int i = 0; i < size; i++) {
                avlTree.insert(rand.nextInt());
            }
            long timeElapsedInsert = System.currentTimeMillis() - startInsert;
           

            
            // Calculate search time in msec.
            long startSearch = System.currentTimeMillis();
            for (int i = 0; i < size; i++) {
                avlTree.search(rand.nextInt());
            }
            long timeElapsedSearch = System.currentTimeMillis() - startSearch;
            System.out.printf("%-15d %-20d %-20d%n", size, timeElapsedInsert, timeElapsedSearch);
        }
        
        // Calculate deletion time in msec.
        int[] deletionSizes = {10000, 100000}; // Sizes for which to measure deletion
        for (int size : deletionSizes) {
            avlTree = new AVLTree(); // Reset and fill the tree for deletion because of size changes.
            for (int i = 0; i < size; i++) {
                avlTree.insert(rand.nextInt());
            }
            
            long startDelete = System.currentTimeMillis();
            for (int i = 0; i < size; i++) {
                avlTree.delete(rand.nextInt());
            }
            long timeElapsedDelete = System.currentTimeMillis() - startDelete;
        	// Print the results for deletion.
        	System.out.printf("%nDeletion Time for %d elements: %d ms%n", size, timeElapsedDelete);
        }
    }
}
