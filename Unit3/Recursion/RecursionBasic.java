package Unit3.Recursion;

public class RecursionBasic {
    public static void main(String[] args) {
        printInc(10);

        System.out.println(factorial(5));

        System.out.println(sum(10));

        System.out.println(fiboonacii(2));

        int[] arr = { 1, 2, 3, 4, 5, 6 };
        System.out.println(isSorted(arr, 0));

        System.out.println(firstOccurence(arr, 15, 0));

        System.out.println(power(10, -2));
    }

    public static double power(double x, int n) {

        if (n < 0) {
            n *= -1;
            x = 1 / x;
        }

        return myPower(x, n);
    }

    public static double myPower(double x, int n) {
        if (n == 0)
            return 1;

        double half = power(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    public static int firstOccurence(int[] arr, int key, int i) {
        if (i == arr.length)
            return -1;

        if (arr[i] == key) {
            return i;
        } else {
            return firstOccurence(arr, key, ++i);
        }
    }

    public static boolean isSorted(int[] arr, int i) {
        if (i == arr.length - 1)
            return true;

        if (arr[i] <= arr[i + 1]) {
            return isSorted(arr, ++i);
        } else {
            return false;
        }
    }

    public static int fiboonacii(int n) {
        if (n < 2) {
            return 1;
        }

        return fiboonacii(n - 1) + fiboonacii(n - 2);
    }

    public static int sum(int n) {
        if (n == 1)
            return 1;
        return sum(n - 1) + n;
    }

    public static int factorial(int n) {
        if (n == 0)
            return 1;

        return factorial(n - 1) * n;
    }

    public static void printInc(int n) {
        if (n == 0)
            return;
        printInc(n - 1);
        System.out.println(n);
    }

    public static void printDec(int n) {
        if (n == 0)
            return;

        System.out.println(n);

        printDec(n - 1);
    }
}
