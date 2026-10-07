package Unit4.Stack.nextGreaterELem;

import java.util.Arrays;
import java.util.Stack;

public class BruteForce {
    public static void main(String[] args) {
        int[] arr = { 6, 8, 0, 1, 3 };
        System.out.println(Arrays.toString(nextGreaterELem(arr)));
        System.out.println(Arrays.toString(nextGreaterELemStack(arr)));
    }

    public static int[] nextGreaterELemStack(int[] nums) {
        int n = nums.length;

        if (n == 0) {
            return new int[] {};
        }

        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            int elem = nums[i];
            int nextGreater = -1;

            while (!stack.isEmpty() && stack.peek() <= elem) {
                if (stack.peek() > elem) {
                    nextGreater = stack.peek();
                    break;
                } else {
                    stack.pop();
                }
            }
            stack.push(elem);
            ans[i] = nextGreater;
        }
        return ans;
    }

    public static int[] nextGreaterELem(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int elem = nums[i];
            int nextGreater = -1;
            for (int j = i + 1; j < n; j++) {
                if (elem < nums[j]) {
                    nextGreater = nums[j];
                    break;
                }
            }
            ans[i] = nextGreater;
        }
        return ans;
    }
}
