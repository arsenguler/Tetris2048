import java.util.ArrayList;
import java.util.Collections;



public class Tetriminoe {
    private static ArrayList<Integer> list = new ArrayList<Integer>();
    private int switchVar;
    private tBlock block0;
    private tBlock block1;
    private tBlock block2;
    private tBlock block3;
    private double lineWidth;
    private double halfWidth;
    private double newCanvasWidth;
    private double canvasHeight;

        public Tetriminoe(double lineWidth, double halfWidth, double newCanvasWidth, double canvasHeight){
            this.lineWidth = lineWidth;
            this.halfWidth = halfWidth;
            this.newCanvasWidth = newCanvasWidth;
            this.canvasHeight = canvasHeight;
            generateTet();
        }

        public void generateTet(){
            // 1 = I, 2 = S, 3 = Z, 4 = O, 5 = T, 6 = L, 7 = J
            for(int i = 1; i <= 7; i += 2)
                list.add(i);
            Collections.shuffle(list);
            this.switchVar = list.get(0);
            switch(switchVar){
                case 1:
                    shapeI tetI = new shapeI();
                    tetI.generateI(lineWidth, halfWidth, newCanvasWidth, canvasHeight);
                    break;
                case 2:
                    shapeS tetS = new shapeS();
                    tetS.generateS(lineWidth, halfWidth, newCanvasWidth, canvasHeight);
                    break;
                case 3:
                    shapeZ tetZ = new shapeZ();
                    tetZ.generateZ(lineWidth, halfWidth, newCanvasWidth, canvasHeight);
                    break;
                case 4:
                    shapeO tetO = new shapeO();
                    tetO.generateO(lineWidth, halfWidth, newCanvasWidth, canvasHeight);
                    break;
                case 5:
                    shapeT tetT = new shapeT();
                    tetT.generateT(lineWidth, halfWidth, newCanvasWidth, canvasHeight);
                    break;
                case 6:
                    shapeL tetL = new shapeL();
                    tetL.generateL(lineWidth, halfWidth, newCanvasWidth, canvasHeight);
                    break;
                case 7:
                    shapeJ tetJ = new shapeJ();
                    tetJ.generateJ(lineWidth, halfWidth, newCanvasWidth, canvasHeight);
                    break;
                default:
                    System.out.println("Something went wrong");
                    break;
            }
        }

    public class shapeS{
        private shapeS(){
             block0 = new tBlock();
             block1 = new tBlock();
             block2 = new tBlock();
             block3 = new tBlock();
        }
        public void generateS(double lineWidth, double halfWidth, double newCanvasWidth, double canvasHeight){
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

    public class shapeI{
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

    public class shapeZ{
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

    public class shapeO{
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

    public class shapeT{
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

    public class shapeL{
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

    public class shapeJ{
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