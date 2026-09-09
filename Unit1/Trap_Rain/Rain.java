package Unit1.Trap_Rain;

// Problem 42.
public class Rain {
    public static void main(String[] args) {
        int[] arr = { 10, 6, 2, 8, 10 };
        System.out.println(new Rain().trap(arr));
    }

    public int trap(int[] height) {
        int n = height.length;
        if (n < 3)
            return 0;

        int[] left_max = new int[n];
        left_max[0] = height[0];
        for (int i = 1; i < n; i++) {
            left_max[i] = left_max[i - 1] > height[i] ? left_max[i - 1] : height[i];
        }

        int[] right_max = new int[n];
        right_max[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right_max[i] = right_max[i + 1] > height[i] ? right_max[i + 1] : height[i];
        }

        int trappedWater = 0;
        for (int i = 1; i < n - 1; i++) {
            int water = (left_max[i] < right_max[i] ? left_max[i] : right_max[i]) - height[i];
            trappedWater += water;
        }

        return trappedWater;
    }

    // Brute force
    static int calc(int[] heights, int nextMax, int i) {
        for (int j = i; j < heights.length; j++) {
            nextMax = nextMax < heights[j] ? heights[j] : nextMax;
        }
        return nextMax;
    }

    static int trappedWater(int[] heights) {
        int n = heights.length;
        if (n < 2)
            return 0;
        int[] water = new int[n];

        int prevMax = 0;
        int nextMaxIdx = -1;
        for (int i = 1; i < n - 1; i++) {
            prevMax = prevMax >= heights[i - 1] ? prevMax : heights[i - 1];
            int nextMax = 0;
            nextMax = (nextMaxIdx > 0 && nextMaxIdx > i) ? heights[nextMaxIdx] : calc(heights, nextMaxIdx, i);

            int lvl = Math.min(prevMax, nextMax);
            water[i] = lvl < heights[i] ? 0 : lvl - heights[i];
        }

        int ans = 0;
        for (int lvl : water) {
            ans += lvl;
        }
        return ans;
    }

}
