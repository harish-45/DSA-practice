package Unit3.Recursion;

public class PrintSubSets {
    public static void main(String[] args) {
        // print("abc");

        print("abc", "", 0);
    }

    public static void print(String str, String subSet, int i) {
        if (i == str.length()) {
            System.out.println(subSet);
            return;
        }

        // NO choice
        print(str, subSet, i + 1);

        // YES choice
        print(str, subSet + str.charAt(i), i + 1);

    }

    // Using bit Manipulation
    public static void print(String str) {
        int n = str.length();

        for (int mask = 0; mask < (1 << n); mask++) {
            String subSet = "";

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    subSet += str.charAt(i);
                }
            }

            System.out.println(subSet);
        }
    }
}
