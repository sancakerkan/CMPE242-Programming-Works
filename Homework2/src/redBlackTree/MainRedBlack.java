package redBlackTree;

import java.util.Random;

public class MainRedBlack {
    public static void main(String[] args) {
        RedBlackTree redBlackTree = new RedBlackTree();
        Random rand = new Random();
        int[] sizes = { 10000, 100000, 1000000, 25000000 }; //  sizes

        System.out.printf("%-15s %-20s %-20s%n", "Size of RBT", "Insertion Time(ms)", "Search Time(ms)");
        System.out.println(String.format("%0" + 55 + "d", 0).replace("0", "-"));

        for (int size : sizes) {
            // Insert into Red-Black Tree
        
            long startInsert = System.currentTimeMillis();
            for (int i = 0; i < size; i++) {
                redBlackTree.insert(rand.nextInt());
            }
            long timeElapsedInsert = System.currentTimeMillis() - startInsert;
            System.out.printf("%-15d %-20d", size, timeElapsedInsert);

            // Searching in Red-Black Tree
          
            long startSearch = System.currentTimeMillis();
            for (int i = 0; i < size; i++) {
                redBlackTree.search(rand.nextInt());
            }
            long timeElapsedSearch = System.currentTimeMillis() - startSearch;
            System.out.printf("%-20d%n", timeElapsedSearch);
        }
    }
}
