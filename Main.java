import edu.princeton.cs.introcs.StdDraw;
import java.awt.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // 12 rows, 8 columns.
        // Each block is 50, 50 pixels.
        // Each block is separated by a line with width 5pixels.(Height is 50).
        double blockWidth = 50, blockHeight = 50;
        double rows = 12, cols = 8;
        double lineWidth = 5;
        double canvasWidth = blockWidth*cols + (cols)*lineWidth, canvasHeight = blockHeight*rows + (rows)*lineWidth;
        // Side area showing score and next tetriminoe with width=100 and height=previousCanvasHeight
        double newCanvasWidth = canvasWidth+100;
        // Initializing canvas w/ param. newCanvasWidth and canvasHeight
        StdDraw.setCanvasSize((int)newCanvasWidth, (int)canvasHeight);
        StdDraw.setXscale(0,newCanvasWidth);   StdDraw.setYscale(0, canvasHeight);
        StdDraw.setPenRadius(lineWidth/canvasHeight);
        StdDraw.setPenColor(StdDraw.BLACK);
        // Every block that needs to be drawn
        ArrayList<tBlock> drawList = new ArrayList<>();
        StdDraw.enableDoubleBuffering();

        Shape shape = null;
        ArrayList<tBlock> blockList = new ArrayList<>();
        double counter = 0.0;
        while (true)  {

            StdDraw.clear();

            for(double i = 0; i<=rows; i++)
                StdDraw.line(0.0, i*(blockHeight + lineWidth), canvasWidth, i*(blockHeight + lineWidth));
            for(double i = 0; i<=cols; i++)
                StdDraw.line(i*(blockWidth + lineWidth), 0.0, i*(blockWidth + lineWidth), canvasHeight);
            Font font = new Font(Font.DIALOG, Font.BOLD, 15 );
            StdDraw.setFont(font);
            StdDraw.text(newCanvasWidth-50, canvasHeight-50,"SCORE");
            StdDraw.text(newCanvasWidth-50, 200,"NEXT");

            // New tetriminoe every 10 cycles
            if(counter % 2 == 0.0) {
                if(null == shape) {
                    Tetriminoe tet = new Tetriminoe(null, lineWidth, blockWidth / 2.0, newCanvasWidth, canvasHeight, null);
                    shape = new Shape();
                    blockList = tet.drawNext(shape, newCanvasWidth, canvasHeight, (blockWidth/2.0)*0.3, lineWidth*0.3);
                }
                else{
                    Tetriminoe tet = new Tetriminoe(shape, lineWidth, blockWidth / 2.0, newCanvasWidth, canvasHeight, blockList);
                    shape = new Shape();
                    blockList = tet.drawNext(shape, newCanvasWidth, canvasHeight, (blockWidth/2.0)*0.3, lineWidth*0.3);
                }
            }

            StdDraw.show();
            StdDraw.pause((int) (2* Math.pow(10, 3)));
            // Wait 0.5 sec to run again
            counter++;
        }
    }
}

