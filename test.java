import edu.princeton.cs.introcs.StdDraw;

public class test {
    public static void main(String[] args) {
        StdDraw.setScale(0, 512);
        double a = 216.0/512.0;
        StdDraw.setPenRadius(a);
        StdDraw.setPenColor(StdDraw.MAGENTA);
        double[] x = { 100, 200, 300, 200 };
        double[] y = { 200, 300, 200, 100 };
        StdDraw.filledPolygon(x, y);
    }
}
