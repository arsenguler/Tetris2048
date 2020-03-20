import java.util.ArrayList;
import java.util.Collections;

public class tBlock {

    public double halfWidth = 25;
    public int value;
    private static ArrayList<Integer> list = new ArrayList<Integer>();
    public double x, y;

    public tBlock() {
        for(int i = 2; i <= 4; i += 2)
            list.add(i);
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
