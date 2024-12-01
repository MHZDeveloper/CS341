import java.util.Arrays;

public class ArrayUtils {
    public static void main(String[] args) {
        String[] strings = {"a", "b", "c"};
        System.out.println(find(strings, "b")); // true
        System.out.println(find(strings, "d")); // false

        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println(max(numbers)); // 5
        System.out.println(max(new int[] {})); // 0

        int[] reversed = reverse(numbers);
        System.out.println(Arrays.toString(reversed)); // [5, 4, 3, 2, 1]

        int[] numbers1 = {1, 2, 3, 4, 5, 6};
        int[] numbers2 = {4, 5, 6, 7, 8};
        int[] intersection = intersection(numbers1, numbers2);
        System.out.println(Arrays.toString(intersection)); // [4, 5, 6]

        System.out.println(evenProduct(numbers1)); // 48

        int[] merged = mergeSortedArrays(numbers1, numbers2);
        System.out.println(Arrays.toString(merged)); // [1, 2, 3, 4, 4, 5, 5, 6, 6, 7, 8]
    }

    static boolean find(String[] array, String item) {
        for (String str : array) {
            if (str.equals(item)) {
                return true;
            }
        }
        return false;
    }

    static int max(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int num : array) {
            if (max < num) {
                max = num;
            }
        }
        return max;
    }

    static int[] reverse(int[] array) {
        int[] reversedArray = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            int index = array.length - i - 1;
            reversedArray[index] = array[i];
        }
        return reversedArray;
    }

    static int[] intersection(int[] array1, int[] array2) {
        int[] intersection = new int[Math.min(array1.length, array2.length)];
        int index = 0;
        for (int num1 : array1) {
            for (int num2 : array2) {
                if (num1 == num2) {
                    intersection[index++] = num1;
                }
            }
        }
        return Arrays.copyOf(intersection, index);
    }

    static int evenProduct(int[] array) {
        int product = 1;
        for (int num : array) {
            if (num % 2 == 0) {
                product *= num;
            }
        }
        return product;
    }

    static int[] mergeSortedArrays(int[] array1, int[] array2) {
        int length = array1.length + array2.length;
        int[] mergedArray = new int[length];
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < length; i++) {
            if (index1 == array1.length) {
                mergedArray[i] = array2[index2++];
            } else if (index2 == array2.length) {
                mergedArray[i] = array1[index1++];
            } else if (array1[index1] < array2[index2]) {
                mergedArray[i] = array1[index1++];
            } else {
                mergedArray[i] = array2[index2++];
            }
        }
        return mergedArray;
    }
}
