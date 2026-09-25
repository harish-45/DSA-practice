package Unit3.Recursion;

import java.util.Arrays;

public class BackTrackingBasic {
    public static void main(String[] args) {
        int[] arr = new int[5];
        changeArr(arr, 0);
        System.out.println(Arrays.toString(arr));
    }

    public static void changeArr(int[] arr, int i) {
        if (i == arr.length)
            return;
        arr[i] = i + 1;
        changeArr(arr, i + 1);

        // BackTracking Steps
        arr[i] = arr[i] - 2;
    }
}
