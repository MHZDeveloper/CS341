import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SortingAlgorithms {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the Array size:");
        int arraySize = scanner.nextInt();
        int[] arrayOfInt = generateRandomArray(arraySize);

        System.out.println("Original Array:");
        printArray(arrayOfInt);

        bubbleExecution(arrayOfInt);

        selectionExcecution(arrayOfInt);

        insertionExecution(arrayOfInt);
    }

    public static void insertionExecution(int[] arrayOfInt) {
        int[] insertionArray = Arrays.copyOf(arrayOfInt, arrayOfInt.length);

        long startTime = System.nanoTime();
        insertionSort(insertionArray);
        long insertionSortTime = System.nanoTime() - startTime;

        System.out.println("\nInsertion Sort:");
        printArray(insertionArray);

        System.out.println("\nInsertion Sort time: " + insertionSortTime);
    }

    public static void selectionExcecution(int[] arrayOfInt) {
        int[] selectionArray = Arrays.copyOf(arrayOfInt, arrayOfInt.length);

        long startTime = System.nanoTime();
        selectionSort(selectionArray);
        long selectionSortTime = System.nanoTime() - startTime;

        System.out.println("\nSelection Sort:");
        printArray(selectionArray);

        System.out.println("\nSelection Sort time: " + selectionSortTime);
    }

    public static void bubbleExecution(int[] arrayOfInt) {
        int[] bubbleArray = Arrays.copyOf(arrayOfInt, arrayOfInt.length);

        long startTime = System.nanoTime();
        bubbleSort(bubbleArray);
        long bubbleSortTime = System.nanoTime() - startTime;

        System.out.println("\nBubble Sort:");
        printArray(bubbleArray);

        System.out.println("Bubble Sort time: " + bubbleSortTime);
    }


    public static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }

    public static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            boolean isSorted = true;
            for (int j = 1; j < array.length - i; j++) {
                if (array[j - 1] > array[j]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                    isSorted = false;
                }
            }
            if (isSorted) {
                return;
            }
        }
    }

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIdx = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = array[minIdx];
            array[minIdx] = array[i];
            array[i] = temp;
        }
    }

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > current) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;
        }
    }

    // Additional Algorithms

    public static void mergeSort(int[] array) {
        if (array.length < 2) {
            return;
        }
        // divide
        var middle = array.length / 2;

        var left = new int[middle];
        System.arraycopy(array, 0, left, 0, middle);

        var right = new int[array.length - middle];
        System.arraycopy(array, middle, right, 0, array.length - middle);

        // sort
        mergeSort(left);
        mergeSort(right);

        // merge
        merge(left, right, array);
    }

    public static void quickSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        //partition
        var limit = partition(array, start, end);
        //sort left
        quickSort(array, start, limit - 1);
        //sort right
        quickSort(array, limit + 1, end);
    }

    private static int partition(int[] array, int start, int end) {
        var pivot = array[end];
        var limit = start - 1;
        for (var i = start; i <= end; i++) {
            if (array[i] <= pivot) {
                swap(array, i, ++limit);
            }
        }
        return limit;
    }

    private static void merge(int[] left, int[] right, int[] result) {
        var leftIndex = 0;
        var rightIndex = 0;
        var resultIndex = 0;

        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] <= right[rightIndex]) {
                result[resultIndex++] = left[leftIndex++];
            } else {
                result[resultIndex++] = right[rightIndex++];
            }
        }

        while (leftIndex < left.length) {
            result[resultIndex++] = left[leftIndex++];
        }

        while (rightIndex < right.length) {
            result[resultIndex++] = right[rightIndex++];
        }
    }

    private static void swap(int[] array, int index1, int index2) {
        var tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }
}
