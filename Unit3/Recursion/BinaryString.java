package Unit3.Recursion;

public class BinaryString {
    public static void main(String[] args) {
        printBinStr(5);
    }

    // print binary string without consecutive ones
    public static void printBinStr(int n) {
        printBinStr(n, 0, "");
    }

    public static void printBinStr(int n, int lastPlace, String str) {

        if (n == 0) {
            System.out.println(str);
            return;
        }

        printBinStr(n - 1, 0, str + '0');

        if (lastPlace == 0) {
            printBinStr(n - 1, 1, str + '1');
        }
    }
}