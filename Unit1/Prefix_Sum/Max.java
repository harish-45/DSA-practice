package Unit1.Prefix_Sum;

public class Max {
    
    public static int maxSum(int[] numbers) {
        
        int n = numbers.length;
        int[] prefix = new int[n];
        prefix[0] = numbers[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + numbers[i];
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            int start = i;
            for (int j = i; j < n; j++) {
                sum = start == 0 ? prefix[i] : prefix[j] - prefix[start - 1];
                if (max < sum) {
                    max = sum;
                }
            }
        }
        
        return max;
    }
    public static void main(String[] args) {
        int[] numbers = { 4, -9, -4, 5, 7, 8 };
        System.out.println(maxSum(numbers));
    }
}
