package Unit2.Bit_Manipulation;

public class Test {
    public static void main(String[] args) {
        System.out.println(fastExponention(5, 3));

        int x = 5;
        System.out.println(x ^ x);

        swap();

        System.out.println(hammingDistance(10, 5));

        System.out.println(plusOne1(5));

        System.out.println(plusOne2(5));

        // for (char i = 'A'; 'A' <= 'Z'; i++) {
        // System.out.println(toLowerCase(i));
        // }

        for (char ch = 'A'; ch <= 'Z'; ch++) {
            System.out.println(toLowerCase(ch));
        }
    }

    public static char toLowerCase(char c) {
        int bitMask = 32; // 1 << 5

        // -A : 01000001
        // 32 : 00100000
        // -a : 01100001

        return (char) (c | bitMask);

    }

    public static int plusOne2(int n) {
        int m = 1;

        while ((n & m) != 0) {
            n = n ^ m;
            m = m << 1;
        }
        n = n ^ m;
        return n;
    }

    public static int plusOne1(int n) {
        return -~n;
    }

    public static int hammingDistance(int x, int y) {
        int distance = 0;
        // assume :
        // x = 1010;
        // y = 0101; then XOR
        // res = 1111
        int res = x ^ y;

        // count set bit of res is answer
        while (res > 0) {
            distance += (res & 1);
            res >>>= 1;
        }
        return distance;
    }

    public static void swap() {
        int x = 10;
        int y = 5;

        System.out.println("Before Swap => " + "X : " + x + " Y : " + y);

        x = x ^ y;
        System.out.println(x);
        y = x ^ y;
        x = x ^ y;

        System.out.println("After  Swap => " + "X : " + x + " Y : " + y);
    }

    public static int fastExponention(int a, int n) {
        int ans = 1;

        while (a > 0) {
            if ((a & n) != 0) {
                ans = ans * a;
            }
            a = a * a;
            n = n >> 1;
        }
        return ans;
    }

}
