package Unit1.String;

public class StrBuilder {
    public static void main(String[] args) {
        StringBuilder s = new StringBuilder("abcdefghijklmnopqrstuvwxyz");
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = sb;
        System.out.println(sb1 == sb);

        for (char ch = 'a'; ch <= 'z'; ch++) {
            sb.append(ch);
            System.out.println(sb);
        }
        // System.out.println(s.equals(sb));
        // System.out.println(s.compareTo(sb) == 0);
        // System.out.println(s.toString().equals(sb.toString()));
        System.out.println(sb1 == sb);

        System.out.println(sb);
        System.out.println(sb1);

        System.out.println(capaString("hello in world "));
    }

    public static String capaString(String s) {
        StringBuilder sb = new StringBuilder(s);
        char c = Character.toUpperCase(sb.charAt(0));
        StringBuilder ans = new StringBuilder();
        ans.append(c);

        int n = sb.length();
        for (int i = 1; i < n; i++) {
            if (sb.charAt(i) == ' ' && i < n - 1) {
                ans.append(sb.charAt(i));
                i++;
                ans.append(Character.toUpperCase(sb.charAt(i)));
            } else {
                ans.append(sb.charAt(i));
            }
        }

        return ans.toString();
    }

    public static String capitalizeTitle(String title) {
        String[] arr = title.trim().split("\\s+");

        for (int i = 0; i < arr.length; i++) {
            String str = arr[i].toLowerCase();
            if (str.length() > 2) {
                str = Character.toUpperCase(str.charAt(0)) + str.substring(1);
            }
            arr[i] = str;
        }
        return String.join(" ", arr);
    }
}