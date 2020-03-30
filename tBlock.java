import java.util.ArrayList;
import java.util.Collections;

public class tBlock {

    public double halfWidth = 25;
    public int value;
    private static ArrayList<Integer> list = new ArrayList<>();
    public double x, y;

    public tBlock() {
        if(list.isEmpty()) {
            list.add(2);
            list.add(4);
        }
        Collections.shuffle(list);
        this.value = list.get(0);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getHalfWidth() {
        return halfWidth;
    }

    public void setHalfWidth(double halfWidth) {
        this.halfWidth = halfWidth;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
