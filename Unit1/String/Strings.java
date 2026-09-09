package Unit1.String;


public class Strings {

    static String reverseWords(String s) {
        String[] str = s.trim().split("\\s+");

        int l = 0;
        int h = str.length - 1;
        while (l < h) {
            String temp = str[l];
            str[l] = str[h];
            str[h] = temp;
            l++;
            h--;
        }
        
        return String.join(" ",  str);

    }

    static void printSubStr(String str, int s, int e) {

        while (s < e) {
            System.out.print(str.charAt(s) + " ");
            s++;
        }
    }

    static boolean isPallindrome(String str) {
        int l = 0;
        int r = str.length() - 1;

        while (l < r) {
            while (l < r && !Character.isLetterOrDigit(str.charAt(l))) {
                l++;
            }
            while (l < r && !Character.isLetterOrDigit(str.charAt(r))) {
                r--;
            }

            if (l < r && Character.toLowerCase(str.charAt(l)) != Character.toLowerCase(str.charAt(r)))
                return false;
            l++;
            r--;

        }
        return true;
    }

    static void printStr(String str) {
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i));
        }

    }

    public static void main(String[] args) {
        String str = "Harish";
        String str2 = "k!a||_/n@a^k";

        String neW = str + str2;
        System.out.println(neW);
        printStr(neW);

        System.out.println(isPallindrome(str2));

        System.out.println();

        // SubString
        System.out.println(str.substring(0,4));
        printSubStr(str, 0, 4);

        System.out.println(str.compareTo(str2));

        String name1 = "ApnaCollege pgl from youe fjf".replace("l", "");
        System.out.println(name1);

        System.out.println(reverseWords(name1));
    }
}