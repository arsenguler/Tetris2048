import edu.princeton.cs.introcs.StdDraw;

import java.awt.*;



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
        for(double i = 0; i<=rows; i++)
            StdDraw.line(0.0, i*(blockHeight + lineWidth), canvasWidth, i*(blockHeight + lineWidth));
        for(double i = 0; i<=cols; i++)
            StdDraw.line(i*(blockWidth + lineWidth), 0.0, i*(blockWidth + lineWidth), canvasHeight);
        Font font = new Font(Font.DIALOG, Font.BOLD, 15 );
        StdDraw.setFont(font);
        StdDraw.text(newCanvasWidth-50, canvasHeight-50,"SCORE");
        StdDraw.text(newCanvasWidth-50, 200,"NEXT");



    /*
        // main animation loop
        while (true)  {

            // clear the background
            StdDraw.clear(StdDraw.WHITE);

            // draw ball on the screen
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledCircle(rx, ry, radius);

            // copy offscreen buffer to onscreen
            StdDraw.show();

            // pause for 20 ms
            StdDraw.pause(20);

        }

         */
    }
}
