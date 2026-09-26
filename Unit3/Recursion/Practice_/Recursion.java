package Unit3.Recursion.Practice_;

import java.util.HashMap;

public class Recursion {
    public static void main(String[] args) {
        int[] arr = new int[] { 3, 2, 4, 5, 6, 2, 7, 2, 2 };
        int key = 2;
        findIndices(arr, key, 0);

        System.out.println(countSubString("abcab"));

    }

    public static int countSubString(String string) {
        int[] freq = new int[26];
        return countSubString(string, freq, 0);
    }

    private static int countSubString(String s, int[] freq, int i) {
        if (i == s.length()) {
            return 0;
        }

        char ch = s.charAt(i);
        int currCount = freq[ch - 'a']++ + 1;

        return currCount + countSubString(s, freq, i + 1);
    }

    // if we have to count distinct substring in terms of index;
    public static int substring(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        int count = 0;

        for (char ch : str.toCharArray()) {
            count += map.getOrDefault(ch, 1);
            map.put(ch, map.getOrDefault(map, 0) + 1);

            // if (!map.containsKey(ch)) {
            // count++;
            // map.put(ch, 1);
            // } else {
            // count += map.get(ch);
            // map.put(ch, map.get(ch) + 1);
            // }
        }
        return count;
    }

    public static void findIndices(int[] nums, int key, int i) {
        if (i == nums.length) {
            System.out.println();
            return;
        }

        if (nums[i] == key) {
            System.out.print(i + " ");
        }

        findIndices(nums, key, i + 1);
    }
}
