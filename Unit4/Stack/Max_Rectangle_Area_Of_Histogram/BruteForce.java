package Unit4.Stack.Max_Rectangle_Area_Of_Histogram;

public class BruteForce {
    public static void main(String[] args) {
        int[] heights = { 2, 1, 5, 6, 2, 3 };
        int maxArea = maxArea(heights);
        System.out.println(maxArea);
    }

    public static int maxArea(int[] heights) {
        int max = 0;
        int n = heights.length;
        for (int i = 0; i < n; i++) {
            int curr = heights[i];
            int area = curr;
            int j = i - 1, k = i + 1;
            while (j >= 0 && heights[j] >= curr) {
                area += curr;
                j--;
            }

            while (k < n && heights[k] >= curr) {
                area += curr;
                k++;
            }

            if (area > max) {
                max = area;
            }
        }
        return max;
    }
}
