public class Recursion {

    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static int sum(int n) {
        if (n == 0) {
            return 0;
        }
        return n + sum(n - 1);
    }

    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static String reverse(String str) {
        if (str.isEmpty()) {
            return str;
        }
        return reverse(str.substring(1)) + str.charAt(0);
    }

    public static boolean isPalindrome(String str){
        if (str.isEmpty() || str.length() == 1) {
            return true;
        }
        char first = str.charAt(0);
        char last = str.charAt(str.length() - 1);
        if (first != last) {
            return false;
        }
        return isPalindrome(str.substring(1, str.length() - 1));
    }

    public static void main(String[] args) {
        System.out.println(factorial(5)); // 120
        System.out.println(sum(5)); // 15
        System.out.println(fibonacci(5)); // 5
        System.out.println(reverse("hello")); // olleh
        System.out.println(isPalindrome("hello")); // false
    }

}
