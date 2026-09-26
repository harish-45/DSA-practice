package Unit3.Recursion.Practice_;

public class Test {
    public static void main(String[] args) {
        String str = "appnacollege";

        removeDuplicates(str, 0, new boolean[26], new StringBuilder());

        System.out.println(getString(1234567890));

        System.out.println(lenOfStr(str));
    }

    public static int lenOfStr(String str) {
        if (str == "")
            return 0;

        return 1 + lenOfStr(str.substring(1));
    }

    public static String getString(int n) {
        String[] nums = new String[] {
                "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
        };
        StringBuilder sb = new StringBuilder();
        return getBuilder(n, sb, nums).toString();
    }

    public static StringBuilder getBuilder(int n, StringBuilder sb, String[] nums) {
        if (n / 10 == 0) {
            String s = nums[n % 10];
            return sb.append(s);
        }

        getBuilder(n / 10, sb, nums);

        return sb.append(" " + nums[n % 10]);
    }

    public static void removeDuplicates(String str, int idx, boolean[] isOccour, StringBuilder sb) {
        if (idx == str.length()) {
            System.out.println(sb);
            return;
        }

        char curr = str.charAt(idx);
        if (!isOccour[curr - 'a']) {
            sb.append(curr);
            isOccour[curr - 'a'] = true;
        }

        removeDuplicates(str, idx + 1, isOccour, sb);
    }

}