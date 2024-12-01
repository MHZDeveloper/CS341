public class BigONotation {

    public static void main(String[] args) {
        int[] bigArray = initArray(1000000);

        // O(1)
        firstItemExecution(bigArray);

        // O(n)
        linearSearchExecution(bigArray, 500000);

        // O(log n)
        binarySearchExecution(bigArray, 500000);
    }

    static int[] initArray(int size) {
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = i;
        }
        return numbers;
    }

    public static void firstItemExecution(int[] arrayOfInt) {
        long startTime = System.nanoTime();

        firstItem(arrayOfInt);

        long executionTime = System.nanoTime() - startTime;

        System.out.println("first item execution time: " + executionTime + " nanoseconds");
    }

    public static void linearSearchExecution(int[] arrayOfInt, int item) {
        long startTime = System.nanoTime();

        linearSearch(arrayOfInt, item);

        long executionTime = System.nanoTime() - startTime;

        System.out.println("linear search execution time: " + executionTime + " nanoseconds");
    }

    public static void binarySearchExecution(int[] arrayOfInt, int item) {
        long startTime = System.nanoTime();

        binarySearch(arrayOfInt, item);

        long executionTime = System.nanoTime() - startTime;

        System.out.println("binary search execution time: " + executionTime + " nanoseconds");
    }

    static int firstItem(int[] array) {
        return array[0];
    }

    static boolean linearSearch(int[] array, int item) {
        for (int i : array) {
            if (i == item) {
                return true;
            }
        }
        return false;
    }

    static boolean binarySearch(int[] array, int item) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == item) {
                return true;
            }
            if (array[mid] < item) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    static boolean binarySearchRecursive(int[] array, int item, int left, int right) {
        if (left > right) {
            return false;
        }
        int mid = (left + right) / 2;
        if (array[mid] == item) {
            return true;
        }
        if (array[mid] < item) {
            return binarySearchRecursive(array, item, mid + 1, right);
        } else {
            return binarySearchRecursive(array, item, left, mid - 1);
        }
    }
}
