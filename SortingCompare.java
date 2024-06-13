package Sorting;
import java.util.Arrays;
import java.util.Random;

public class SortingCompare {
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 100000, 1000000, 1700000}; 
        long startTime, endTime;

        System.out.println("Array Size\tMerge Sort (ms)\tSelection Sort (ms)\tHeap Sort (ms)");
        
        	//arrayCopy
        for (int size : sizes) {
            int[] randomArray = generateRandomArray(size);
            int[] copyArray1 = Arrays.copyOf(randomArray, size);
            int[] copyArray2 = Arrays.copyOf(randomArray, size);
            
            //mergeSort
            startTime = System.nanoTime();
            MergeSort.mergeSort(copyArray1);
            endTime = System.nanoTime();
            long mergeSortTime = (endTime - startTime) / 1000000;
            
            //selectionSort
            startTime = System.nanoTime();
            SelectionSort.selectionSort(copyArray2);
            endTime = System.nanoTime();
            long selectionSortTime = (endTime - startTime) / 1000000;

            //heapSort
            startTime = System.nanoTime();
            HeapSort.heapSort(randomArray);
            endTime = System.nanoTime();
            long heapSortTime = (endTime - startTime) / 1000000;

            System.out.println(size + "\t\t" + mergeSortTime + "\t\t\t" + selectionSortTime + "\t\t\t" + heapSortTime);
        }
    }
    		//randomGenerator
    public static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(1000000); 
        }
        return arr;
    }
}
