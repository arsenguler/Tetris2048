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
        int score = 0;
        // Every block that needs to be drawn
        ArrayList<tBlock> drawList = new ArrayList<>();
        StdDraw.enableDoubleBuffering();

        Tetriminoe tet = null;
        Shape shape = null;
        ArrayList<tBlock> blockList = new ArrayList<>();
        double counter = 0.0;
        while (true)  {
            drawGameEnvironment(newCanvasWidth, canvasHeight, lineWidth, rows, cols, blockHeight, canvasWidth, blockWidth, score);
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
                drawGameEnvironment(newCanvasWidth, canvasHeight, lineWidth, rows, cols, blockHeight, canvasWidth, blockWidth, score);
                tet.drawTet(drawList, blockWidth/2.0);
                tet.drawTet(blockList, (blockWidth/2.0)*0.3);
                StdDraw.show();
                StdDraw.pause((int) (0.1 * Math.pow(10, 3)));
                count++;
            }
                StdDraw.clear();
                score = deleteRows(drawList, score, lineWidth, blockWidth * 0.5, canvasHeight, newCanvasWidth);
                drawGameEnvironment(newCanvasWidth, canvasHeight, lineWidth, rows, cols, blockHeight, canvasWidth, blockWidth, score);
                tet.drawTet(drawList, blockWidth/2.0);
                tet.drawTet(blockList, (blockWidth/2.0)*0.3);
                StdDraw.show();
                // Wait a certain amount of time to run again
                StdDraw.pause((int) (0.2 * Math.pow(10, 3)));
                counter++;
        }
    }
    public static void drawGameEnvironment(double newCanvasWidth, double canvasHeight, double lineWidth, double rows, double cols, double blockHeight, double canvasWidth, double blockWidth, int score){
        for(double i = 0; i<=rows; i++)
            StdDraw.line(0.0, i*(blockHeight + lineWidth), canvasWidth, i*(blockHeight + lineWidth));
        for(double i = 0; i<=cols; i++)
            StdDraw.line(i*(blockWidth + lineWidth), 0.0, i*(blockWidth + lineWidth), canvasHeight);
        Font font = new Font(Font.DIALOG, Font.BOLD, 15 );
        StdDraw.setFont(font);
        StdDraw.text(newCanvasWidth-50, canvasHeight-50,"SCORE");
        StdDraw.text(newCanvasWidth-50, canvasHeight-75,String.valueOf(score));
        StdDraw.text(newCanvasWidth-50, 200,"NEXT");
    }

    public static int deleteRows(ArrayList<tBlock> drawList, int score, double lineWidth, double halfWidth, double canvasHeight, double newCanvasWidth){
        boolean flag = false;
        ArrayList<Double> rows = new ArrayList<>();
        // check occurrence of full rows
        for (double y = (0.5 * lineWidth + halfWidth); y < canvasHeight; y += halfWidth * 2.0 + lineWidth){
            int counter = 0;
            for (double x = (0.5 * lineWidth + halfWidth); x <= newCanvasWidth - (100 + halfWidth + lineWidth); x += lineWidth + halfWidth * 2.0){
                for (tBlock t : drawList){
                    if ((t.getX() == x && t.getY() == y)){
                        counter ++;
                    }
                }
            }
            if (counter == 7) {
                rows.add(y);
                flag = true;
            }
        }
        if (flag) {
            // delete full rows from the drawlist
            ArrayList<tBlock> willRemove = new ArrayList<>();
            for (tBlock t : drawList) {
                for (double y : rows) {
                    if (t.getY() == y) {
                        // update score
                        score += t.getValue();
                        willRemove.add(t);
                    }
                }
            }
            drawList.removeAll(willRemove);
            // move rows which were above deleted rows 1 block down
            for (tBlock t : drawList) {
                for (double y : rows) {
                    if (t.getY() > y) {
                        t.setY(t.getY() - (halfWidth * 2.0 + lineWidth));
                    }
                }
            }
        }
        else return score;
        return score;
    }
}

