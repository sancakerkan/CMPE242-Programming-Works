# SortingAlgorithmsComparison

This repository contains implementations and comparisons of various sorting algorithms.

## Table of Contents

- [Overview](#overview)
- [File Structure](#file-structure)
- [How to Use](#how-to-use)
- [Classes](#classes)
- [Implementation](#implementation)
- [Data Collection and Results](#data-collection-and-results)
- [Algorithm Complexity Analysis](#algorithm-complexity-analysis)
- [Conclusion](#conclusion)
- [Testing](#testing)
- [Contributing](#contributing)
- [License](#license)

## Overview

The objective of this study is to evaluate and compare the execution times of selected sorting algorithms, including Merge Sort, Selection Sort, and Heap Sort. These algorithms are ideal candidates for comparative analysis because they have varying time and space complexities.

## File Structure

The repository is structured as follows:

- [Src](https://github.com/sancakerkan/SortingAlgorithmsComparison/tree/main/src): Contains the Java source files. (Click Src to navigate)
  - **HeapSort.java**: Contains the implementation of the heap sort algorithm.
  - **MergeSort.java**: Contains the implementation of the merge sort algorithm.
  - **SelectionSort.java**: Contains the implementation of the selection sort algorithm.
  - **SortingCompare.java**: Contains the code to compare the performance of the sorting algorithms.
## How to Use

1. Clone the repository to your local machine.
2. Navigate to the `src` directory.
3. Compile the Java source files using a Java compiler (e.g., `javac`).
4. Run `SortingCompare.java` to see the performance comparison of the sorting algorithms.

## Classes

- **HeapSort.java**
  - Implements the heap sort algorithm.
  
- **MergeSort.java**
  - Implements the merge sort algorithm.
  
- **SelectionSort.java**
  - Implements the selection sort algorithm.
  
- **SortingCompare.java**
  - Compares the performance of the implemented sorting algorithms using various input sizes and data types.
 
  

## Implementation

First, the codes of the sorting algorithms were written as classes:
- MergeSort.java
- SelectionSort.java
- HeapSort.java

In the main class, arrays of different sizes were created and filled randomly using Java’s `java.util.Random` library. Copies of arrays were created to run different sorting algorithms simultaneously. By calling the sorting methods, the elapsed time was calculated and printed as a table on the console.

```java
package Sorting;
import java.util.Arrays;
import java.util.Random;

public class SortingCompare {
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 100000, 1000000, 1700000};
        long startTime, endTime;
        System.out.println("Array Size\tMerge Sort (ms)\tSelection Sort (ms)\tHeap Sort (ms)");

        for (int size : sizes) {
            int[] randomArray = generateRandomArray(size);
            int[] copyArray1 = Arrays.copyOf(randomArray, size);
            int[] copyArray2 = Arrays.copyOf(randomArray, size);

            startTime = System.nanoTime();
            MergeSort.mergeSort(copyArray1);
            endTime = System.nanoTime();
            long mergeSortTime = (endTime - startTime) / 1000000;

            startTime = System.nanoTime();
            SelectionSort.selectionSort(copyArray2);
            endTime = System.nanoTime();
            long selectionSortTime = (endTime - startTime) / 1000000;

            startTime = System.nanoTime();
            HeapSort.heapSort(randomArray);
            endTime = System.nanoTime();
            long heapSortTime = (endTime - startTime) / 1000000;

            System.out.println(size + "\t\t" + mergeSortTime + "\t\t\t" + selectionSortTime + "\t\t\t" + heapSortTime);
        }
    }

    public static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(1000000);
        }
               return arr;
    }
}
```
## Data Collection and Results

|Array Size	   |Merge Sort (ms)	   |Selection Sort (ms)	   |Heap Sort (ms)|
|---|---|---|---|
|1000   |0   | 2  |  0 |
|10,000	   |1   | 21  |1   |
|100,000	  |14   |2263   |11   |
|1,000,000	   |169   |219527   |117   |
|1,700,000	   |264   |633029   |216   |

## Algorithm Complexity Analysis

The section above (Data Collection and Results) compares the time or operations required by three different sorting algorithms, Merge Sort, Selection Sort, and Heap Sort, for varying input sizes from 1,000 to 1,700,000.

Heap Sort performed better than Merge Sort in this specific implementation. However, this does not represent a universal trend, and the efficiency of these algorithms can differ in other scenarios.

Merge Sort typically provides the best performance among the three algorithms, especially for large input sizes. The discrepancy in this implementation may be due to various factors, including the specific implementation or the dataset used for testing.

Selection Sort exhibits significantly higher time complexity as the input size increases, making it the worst-performing algorithm among the three.

## Conclusion

The performance of Merge Sort, Selection Sort, and Heap Sort was evaluated and compared for varying input sizes. While Merge Sort generally provides stable and efficient sorting performance, Heap Sort showed surprising performance in this particular implementation. Selection Sort, on the other hand, had the highest time complexity, making it the least efficient for larger datasets.

## Testing

Specific test cases were used to validate the functionality of the sorting algorithms. The performance of each sorting algorithm was measured and compared using various input sizes and data types.

## Contributing

Contributions are welcome! If any issues are found or suggestions for improvement arise, feel free to open an issue or submit a pull request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
