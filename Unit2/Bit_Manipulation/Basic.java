package Unit2.Bit_Manipulation;

public class Basic {
    public static void main(String[] args) {
        // Binary AND
        System.out.println(5 & 6); // 4

        // Binary OR
        System.out.println(6 | 7); // 7

        // Binary XOR
        System.out.println(6 ^ 7); // 1

        // Binary ONE's Complement
        System.out.println(~0); // -1

        // Binary left Shift <<
        System.out.println(10 << 2); // 40

        // Binary Right Shift <<
        System.out.println(20 >> 2); // 40

        isOdd(4);

        getIthBiT(10, 0);

        System.out.println(setIthBit(10, 2));

        System.out.println(clearIthBit(10, 3));

        System.out.println(updateIthBit(10, 4, 1));

        System.out.println(clearLastkBit(15, 2));

        System.out.println(clearRangeOfBit(63, 1, 4));

        System.out.println(isPowerOfTwo(0));

        System.out.println(countSetBit(10));
    }

    public static int countSetBit(int n) {
        int count = 0;
        while (n != 0) {
            int bitMask = 1;
            if ((n & bitMask) == 1)
                count++;
            n = n >> 1;
        }
        return count;
    }

    public static boolean isPowerOfTwo(int n) {
        return (n & n - 1) == 0;
    }

    public static int clearRangeOfBit(int n, int i, int j) {
        int a, b;

        a = -1 << (j + 1);
        b = (1 << i) - 1;

        int bitMask = a | b;

        return n & bitMask;
    }

    public static int clearLastkBit(int n, int k) {
        // int bitMask = ~((int) Math.pow(2, k - 1) + 1);

        int bitMask = -1 << k;

        return n & bitMask;
    }

    public static int updateIthBit(int n, int i, int newBit) {

        // if (newBit == 0) {
        // clearIthBit(n, newBit);
        // } else {
        // setIthBit(n, newBit);
        // }

        n = clearIthBit(n, i);
        int bitMask = newBit << i;
        return n | bitMask;

    }

    public static int clearIthBit(int n, int i) {
        int bitMask = ~(1 << i);

        // System.out.println(n);
        return n & bitMask;

    }

    public static int setIthBit(int n, int i) {
        int bitMask = 1 << i;

        // System.out.println(n);
        return n | bitMask;
    }

    public static void getIthBiT(int n, int i) {
        int bitMask = 1 << i;
        if ((bitMask & n) == 0) {
            System.out.println("zero, 0 ");
        } else {
            System.out.println("one , 1");
        }
    }

    public static void getIthBit(int n, int i) {

        int bitMask = (int) Math.pow(2, i);
        if ((bitMask & n) == 0) {
            System.out.println("zero");
        } else {
            System.out.println("one");
        }
    }

    public static void isOdd(int n) {
        int bitMask = 1;

        if ((n & bitMask) == 1) {
            System.out.println("odd number");
        } else {
            System.out.println("Even number");
        }
    }
}