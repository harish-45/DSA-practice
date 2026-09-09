package Unit1.String;

public class ShortestPath {

    static double getShortestPath(String path) {
        int[] cord = { 0, 0 };
        for (int i = 0; i < path.length(); i++) {
            char c = path.charAt(i);
            switch (c) {
                case 'E' -> cord[0]++;
                case 'W' -> cord[0]--;
                case 'N' -> cord[1]++;
                case 'S' -> cord[1]--;
            }
        }

        double disp = Math.sqrt(cord[0] * cord[0] + cord[1] * cord[1]);
        return disp;
    }

    public static void main(String[] args) {
        String str = "WNEENESENNNNS";
        System.out.println(getShortestPath(str));
    }
}