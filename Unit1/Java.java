package Unit1;

public class Java {

    public static int maxSum(int arr[]) {
        int max= Integer.MIN_VALUE;
        int sum = 0;

        for (int n : arr) {
            sum += n;
            if (sum > max)
                max = sum;
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }

    public static int minSum(int[] arr) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
                if (sum < min)
                    min = sum;
                if(sum > 0)
                    sum = 0;
            }
        return min;
    }
    
    public static void printSubArrays(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            String curr = "" + arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                System.out.print("(" + curr + ") ");
                curr += "," + arr[j];
            }
             System.out.print("(" + curr + ") ");
            System.out.println();
        }
    }
    
    public static void printPairs(int arr[]) {
        for (int i = 0; i < arr.length; i++) {

            for (int j = i + 1; j < arr.length; j++) {
                System.out.print("(" + arr[i] + "," + arr[j] + ") ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] arr = { -2,-4,5,-6,-7 };
        // printSubArrays(arr);
        System.out.println(minSum(arr));
    }
    
}
