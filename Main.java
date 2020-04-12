import edu.princeton.cs.introcs.StdDraw;
import java.awt.*;
import java.util.ArrayList;
import java.util.*;

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
        StdDraw.setCanvasSize((int)newCanvasWidth, (int)canvasHeight);
        StdDraw.setXscale(0,newCanvasWidth);   StdDraw.setYscale(0, canvasHeight);
        StdDraw.setPenRadius(lineWidth/canvasHeight);
        StdDraw.setPenColor(StdDraw.BLACK);

        // Every block that needs to be drawn
        ArrayList<tBlock> drawList = new ArrayList<>();
        StdDraw.enableDoubleBuffering();

        Tetriminoe tet = null;
        Shape shape = null;
        ArrayList<tBlock> blockList = new ArrayList<>();
        double counter = 0.0;
        while (true)  {
            drawGameEnvironment(newCanvasWidth, canvasHeight, lineWidth, rows, cols, blockHeight, canvasWidth, blockWidth);
            StdDraw.clear();

            // New tetriminoe every 12 cycles
            if(counter % 12 == 0.0) {
                if(null == shape) {
                    tet = new Tetriminoe(null, lineWidth, blockWidth / 2.0, newCanvasWidth, canvasHeight, null);
                    shape = new Shape();
                    blockList = tet.drawNext(shape, newCanvasWidth, canvasHeight, (blockWidth/2.0)*0.3, lineWidth*0.3);
                    for(tBlock t : tet.blockList) {
                        drawList.add(t);
                    }
                }
                else{
                    tet = new Tetriminoe(shape, lineWidth, blockWidth / 2.0, newCanvasWidth, canvasHeight, blockList);
                    shape = new Shape();
                    blockList = tet.drawNext(shape, newCanvasWidth, canvasHeight, (blockWidth/2.0)*0.3, lineWidth*0.3);
                    for(tBlock t : tet.blockList) {
                        drawList.add(t);
                    }
                }
            }
            else{
                // move the tetriminoe 1 block below
                tet.moveTet(tet, lineWidth, blockWidth/2.0, drawList);
            }
            for(int count = 0; count<10; count++){
                // check if left key pressed
                if (StdDraw.isKeyPressed(37))
                    tet.moveLeft(tet, lineWidth, blockWidth/2.0, drawList);
                // check if right key pressed
                if (StdDraw.isKeyPressed(39))
                    tet.moveRight(tet, lineWidth, blockWidth/2.0, drawList);
                StdDraw.clear();
                drawGameEnvironment(newCanvasWidth, canvasHeight, lineWidth, rows, cols, blockHeight, canvasWidth, blockWidth);
                tet.drawTet(drawList, blockWidth/2.0);
                tet.drawTet(blockList, (blockWidth/2.0)*0.3);
                StdDraw.show();
                StdDraw.pause((int) (0.1 * Math.pow(10, 3)));
                count++;
            }
                StdDraw.clear();
                drawGameEnvironment(newCanvasWidth, canvasHeight, lineWidth, rows, cols, blockHeight, canvasWidth, blockWidth);
                tet.drawTet(drawList, blockWidth/2.0);
                tet.drawTet(blockList, (blockWidth/2.0)*0.3);
                StdDraw.show();
                // Wait a certain amount of time to run again
                StdDraw.pause((int) (0.5 * Math.pow(10, 3)));
                counter++;
        }
    }
    public static void drawGameEnvironment(double newCanvasWidth, double canvasHeight, double lineWidth, double rows, double cols, double blockHeight, double canvasWidth, double blockWidth){
        for(double i = 0; i<=rows; i++)
            StdDraw.line(0.0, i*(blockHeight + lineWidth), canvasWidth, i*(blockHeight + lineWidth));
        for(double i = 0; i<=cols; i++)
            StdDraw.line(i*(blockWidth + lineWidth), 0.0, i*(blockWidth + lineWidth), canvasHeight);
        Font font = new Font(Font.DIALOG, Font.BOLD, 15 );
        StdDraw.setFont(font);
        StdDraw.text(newCanvasWidth-50, canvasHeight-50,"SCORE");
        StdDraw.text(newCanvasWidth-50, 200,"NEXT");
    }

}

