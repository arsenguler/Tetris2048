import edu.princeton.cs.introcs.StdDraw;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tetriminoe {
    private static ArrayList<Integer> list = new ArrayList<>();
    private tBlock block0;
    private tBlock block1;
    private tBlock block2;
    private tBlock block3;
    private double lineWidth;
    private final double halfWidth = 25;
    private double newCanvasWidth;
    private double canvasHeight;
    private Shape shape;

        public Tetriminoe(double lineWidth, double newCanvasWidth, double canvasHeight){
            ArrayList<tBlock> blockList = new ArrayList<>();
            this.lineWidth = lineWidth;
            this.newCanvasWidth = newCanvasWidth;
            this.canvasHeight = canvasHeight;
            generateTet();
            blockList.add(block0);
            blockList.add(block1);
            blockList.add(block2);
            blockList.add(block3);
            drawTet(blockList);
        }

        private void generateTet(){
            // 1 = I, 2 = S, 3 = Z, 4 = O, 5 = T, 6 = L, 7 = J
            for(int i = 1; i <= 7; i += 2)
                list.add(i);
            Collections.shuffle(list);
            int switchVar = list.get(0);
            switch(switchVar){
                case 1:
                    shapeI tetI = new shapeI();
                    this.shape = Shape.I;
                    tetI.generateI(lineWidth, halfWidth, newCanvasWidth, canvasHeight);
                    break;
                case 2:
                    shapeS tetS = new shapeS();
                    this.shape = Shape.S;
                    tetS.generateS(lineWidth, halfWidth, newCanvasWidth, canvasHeight);
                    break;
                case 3:
                    shapeZ tetZ = new shapeZ();
                    this.shape = Shape.Z;
                    tetZ.generateZ(lineWidth, halfWidth, newCanvasWidth, canvasHeight);
                    break;
                case 4:
                    shapeO tetO = new shapeO();
                    this.shape = Shape.O;
                    tetO.generateO(lineWidth, halfWidth, newCanvasWidth, canvasHeight);
                    break;
                case 5:
                    shapeT tetT = new shapeT();
                    this.shape = Shape.T;
                    tetT.generateT(lineWidth, halfWidth, newCanvasWidth, canvasHeight);
                    break;
                case 6:
                    shapeL tetL = new shapeL();
                    this.shape = Shape.L;
                    tetL.generateL(lineWidth, halfWidth, newCanvasWidth, canvasHeight);
                    break;
                case 7:
                    shapeJ tetJ = new shapeJ();
                    this.shape = Shape.J;
                    tetJ.generateJ(lineWidth, halfWidth, newCanvasWidth, canvasHeight);
                    break;
                default:
                    System.out.println("Something went wrong");
                    break;
            }
        }

        private void drawTet(ArrayList<tBlock> list){
            Font font = new Font(Font.DIALOG, Font.BOLD, 10 );
            StdDraw.setFont(font);
            for(int i=0; i<4; i++) {
                if (list.get(i).value == 2)
                    StdDraw.setPenColor(255, 229, 204);
                else
                    StdDraw.setPenColor(255, 204, 153);

                StdDraw.filledSquare(list.get(i).getX(), list.get(i).getY(), halfWidth);
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.text(list.get(i).getX(), list.get(i).getY(), String.valueOf(list.get(i).value));
            }

        }

    public Tetriminoe() {
    }

    public class shapeS extends Tetriminoe{
        private shapeS(){
             block0 = new tBlock();
             block1 = new tBlock();
             block2 = new tBlock();
             block3 = new tBlock();
        }
        public void generateS (double lineWidth, double halfWidth, double newCanvasWidth, double canvasHeight){
            block0.setX(2.5*lineWidth + 5*halfWidth);
            block0.setY(canvasHeight-(3*halfWidth + 1.5*lineWidth));
            block1.setX(block0.getX() + (lineWidth + halfWidth));
            block1.setY(block0.getY());
            block2.setX(block1.getX());
            block2.setY(block1.getY() + (lineWidth + halfWidth));
            block3.setX(block2.getX() + (lineWidth + halfWidth));
            block3.setY(block2.getY());
        }
    }

    public class shapeI extends Tetriminoe{
        private shapeI(){
            block0 = new tBlock();
            block1 = new tBlock();
            block2 = new tBlock();
            block3 = new tBlock();
        }
        public void generateI(double lineWidth, double halfWidth, double newCanvasWidth, double canvasHeight){
            block0.setX(2.5*lineWidth + 5*halfWidth);
            block0.setY(canvasHeight-(halfWidth + 0.5*lineWidth));
            block1.setX(block0.getX() + (lineWidth + 2*halfWidth));
            block1.setY(block0.getY());
            block2.setX(block1.getX() + (lineWidth + 2*halfWidth));
            block2.setY(block0.getY());
            block3.setX(block2.getX() + (lineWidth + 2*halfWidth));
            block3.setY(block0.getY());
        }
    }

    public class shapeZ extends Tetriminoe{
        private shapeZ(){
            block0 = new tBlock();
            block1 = new tBlock();
            block2 = new tBlock();
            block3 = new tBlock();
        }
        public void generateZ(double lineWidth, double halfWidth, double newCanvasWidth, double canvasHeight){
            block0.setX(2.5*lineWidth + 5*halfWidth);
            block0.setY(canvasHeight-(halfWidth + 0.5*lineWidth));
            block1.setX(block0.getX() + (lineWidth + 2*halfWidth));
            block1.setY(block0.getY());
            block2.setX(block1.getX());
            block2.setY(block1.getY() - (lineWidth + 2*halfWidth));
            block3.setX(block2.getX() + (lineWidth + 2*halfWidth));
            block3.setY(block2.getY());
        }
    }

    public class shapeO extends Tetriminoe{
        private shapeO(){
            block0 = new tBlock();
            block1 = new tBlock();
            block2 = new tBlock();
            block3 = new tBlock();
        }
        public void generateO(double lineWidth, double halfWidth, double newCanvasWidth, double canvasHeight){
            block0.setX(2.5*lineWidth + 5*halfWidth);
            block0.setY(canvasHeight-(halfWidth + 0.5*lineWidth));
            block1.setX(block0.getX() + (lineWidth + 2*halfWidth));
            block1.setY(block0.getY());
            block2.setX(block0.getX());
            block2.setY(block0.getY() - (-lineWidth + 2*halfWidth));
            block3.setX(block1.getX());
            block3.setY(block2.getY());
        }
    }

    public class shapeT extends Tetriminoe{
        private shapeT(){
            block0 = new tBlock();
            block1 = new tBlock();
            block2 = new tBlock();
            block3 = new tBlock();
        }
        public void generateT(double lineWidth, double halfWidth, double newCanvasWidth, double canvasHeight){
            block0.setX(2.5*lineWidth + 5*halfWidth);
            block0.setY(canvasHeight-(halfWidth + 0.5*lineWidth));
            block1.setX(block0.getX() + (lineWidth + 2*halfWidth));
            block1.setY(block0.getY());
            block2.setX(block1.getX());
            block2.setY(block1.getY() - (lineWidth + 2*halfWidth));
            block3.setX(block1.getX() + (lineWidth + 2*halfWidth));
            block3.setY(block0.getY());
        }
    }

    public class shapeL extends Tetriminoe{
        private shapeL(){
            block0 = new tBlock();
            block1 = new tBlock();
            block2 = new tBlock();
            block3 = new tBlock();
        }
        public void generateL(double lineWidth, double halfWidth, double newCanvasWidth, double canvasHeight){
            block0.setX(2.5*lineWidth + 5*halfWidth);
            block0.setY(canvasHeight-(3*halfWidth + 0.5*lineWidth));
            block1.setX(block0.getX());
            block1.setY(block0.getY() + (lineWidth + 2*halfWidth));
            block2.setX(block1.getX());
            block2.setY(block1.getY());
            block3.setX(block2.getX() + (lineWidth + 2*halfWidth));
            block3.setY(block0.getY());
        }
    }

    public class shapeJ extends Tetriminoe{
        private shapeJ(){
            block0 = new tBlock();
            block1 = new tBlock();
            block2 = new tBlock();
            block3 = new tBlock();
        }
        public void generateJ(double lineWidth, double halfWidth, double newCanvasWidth, double canvasHeight){
            block0.setX(2.5*lineWidth + 5*halfWidth);
            block0.setY(canvasHeight-(halfWidth + 0.5*lineWidth));
            block1.setX(block0.getX() + (lineWidth + 2*halfWidth));
            block1.setY(block0.getY());
            block2.setX(block1.getX() + (lineWidth + 2*halfWidth));
            block2.setY(block0.getY());
            block3.setX(block2.getX());
            block3.setY(block0.getY() +  + (lineWidth + 2*halfWidth));
        }
    }

}
class Shape {
    public static Shape I, S, Z, O, T, L, J;
}