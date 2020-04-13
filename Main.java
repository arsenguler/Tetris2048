import edu.princeton.cs.introcs.StdDraw;

import javax.lang.model.type.ArrayType;
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

        boolean hasMoved;
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
                hasMoved = true;
            }
            else{
                // move the tetriminoe 1 block below
                hasMoved = tet.moveTet(tet, lineWidth, blockWidth/2.0, drawList);
            }
            // left-right movement and rotation
            for(int count = 0; count<10; count++){
                // check if left key pressed
                if (StdDraw.isKeyPressed(37))
                    tet.moveLeft(tet, lineWidth, blockWidth/2.0, drawList);
                // check if right key pressed
                if (StdDraw.isKeyPressed(39))
                    tet.moveRight(tet, lineWidth, blockWidth/2.0, drawList);
                /*
                // check if up key pressed
                if (StdDraw.isKeyPressed(38)){
                    String keyPressed = "up";
                    tet.rotatetTet(drawList, keyPressed);
                }
                // check if down key pressed
                if (StdDraw.isKeyPressed(40)){
                    String keyPressed = "down";
                    tet.rotatetTet(drawList, keyPressed);
                }
                 */
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
                if (!hasMoved){
                    int test = score;
                    score = mergeBlocks(drawList, score, lineWidth, blockWidth * 0.5);
                    while (test != score){
                        test = score;
                        score = mergeBlocks(drawList, score, lineWidth, blockWidth * 0.5);
                    }
                    counter = 11.0;
                }
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
            for (double x = (0.5 * lineWidth + halfWidth); x < newCanvasWidth - (100 + lineWidth); x += lineWidth + halfWidth * 2.0){
                for (tBlock t : drawList){
                    if ((t.getX() == x && t.getY() == y)){
                        counter ++;
                    }
                }
            }
            if (counter == 8) {
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

    public static int mergeBlocks(ArrayList<tBlock> drawList, int score, double lineWidth, double halfWidth) {
        boolean flag = false;
        ArrayList<tBlock> sorted = new ArrayList<>();
        ArrayList<tBlock> temp = drawList;
        ArrayList<tBlock> willRemove = new ArrayList<>();
        ArrayList<tBlock> skip = new ArrayList<>();
        // sort drawList from top to bottom
        for (tBlock tc : drawList) {
            double nibber = 0.0;
            for (tBlock t : temp) {
                if (!skip.contains(t) && t.getY() >= nibber) {
                    nibber = t.getY();
                    skip.add(t);
                }
            }
            for (tBlock tb : drawList) {
                if (tb.getY() >= nibber)
                    sorted.add(tb);
            }
        }
        for (tBlock t : sorted) {
            for (tBlock tb : sorted) {
                // if there's a block above another with the same value
                if (t.getX() == tb.getX() && t.getY() + (lineWidth + 2.0 * halfWidth) == tb.getY()) {
                    if (t.getValue() == tb.getValue()) {
                        flag = true;
                        t.setValue(t.getValue() + tb.getValue());     // sum their values
                        score += t.getValue();      // update score
                        willRemove.add(tb);
                    }
                }
            }
        }
        if (!willRemove.isEmpty()) {
            // find blocks that are not "4-connected" to any other block
            ArrayList<tBlock> workWith = new ArrayList<>();
            for (tBlock t : drawList) {
                int bool = 1;
                for (tBlock tb : drawList) {
                    if (t.getX() == tb.getX() && (t.getY() + (halfWidth * 2.0 + lineWidth) == tb.getY() || t.getY() - (halfWidth * 2.0 + lineWidth) == tb.getY()))
                        bool = 0;
                    if (t.getY() == tb.getY() && (t.getX() + (halfWidth * 2.0 + lineWidth) == tb.getX() || t.getX() - (halfWidth * 2.0 + lineWidth) == tb.getX()))
                        bool = 0;
                }
                if (bool == 1)
                    willRemove.add(t);
            }
            drawList.removeAll(willRemove);     // remove merged and "not 4-connected" blocks
        }
        return score;
    }
}

