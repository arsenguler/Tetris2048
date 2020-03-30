import edu.princeton.cs.introcs.StdDraw;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class Tetriminoe {
    public static Shape I = new Shape("I");
    public static Shape S = new Shape("S");
    public static Shape Z = new Shape("Z");
    public static Shape L = new Shape("L");
    public static Shape J = new Shape("J");
    public static Shape O = new Shape("O");
    public static Shape T = new Shape("T");
    private static ArrayList<Integer> list = new ArrayList<>();
    private ArrayList<tBlock> blockList = new ArrayList<>();
    private tBlock block0;
    private tBlock block1;
    private tBlock block2;
    private tBlock block3;
    private double lineWidth;
    private double halfWidth;
    private double newCanvasWidth;
    private double canvasHeight;
    private Shape shape;

    /*
    public Tetriminoe(double lineWidth, double halfWidth, double newCanvasWidth, double canvasHeight) {
        this.halfWidth = halfWidth;
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
    */

    public Tetriminoe(Shape type, double lineWidth, double halfWidth, double newCanvasWidth, double canvasHeight, ArrayList<tBlock> blocks) {
        if (list.isEmpty()) {
            for (int i = 1; i <= 7; i ++)
                list.add(i);
        }
        this.halfWidth = halfWidth;
        this.lineWidth = lineWidth;
        this.newCanvasWidth = newCanvasWidth;
        this.canvasHeight = canvasHeight;
        if(null != type) {
            this.shape = new Shape(type.toString());
            generateTet(shape);
        }
        else {
            generateTet();
        }
        if(null != blocks){
            block0.setValue(blocks.get(0).getValue());
            block1.setValue(blocks.get(1).getValue());
            block2.setValue(blocks.get(2).getValue());
            block3.setValue(blocks.get(3).getValue());
        }
        this.blockList.add(block0);
        this.blockList.add(block1);
        this.blockList.add(block2);
        this.blockList.add(block3);
        drawTet(this.blockList, halfWidth);
    }

    private void generateTet(Shape type) {
        String switchVar = type.toString();
        switch (switchVar) {
            case "I":
                shapeI tetI = new shapeI();
                this.shape = I;
                tetI.generateI(lineWidth, halfWidth, newCanvasWidth, canvasHeight);
                break;
            case "S":
                shapeS tetS = new shapeS();
                this.shape = S;
                tetS.generateS(lineWidth, halfWidth, newCanvasWidth, canvasHeight);
                break;
            case "Z":
                shapeZ tetZ = new shapeZ();
                this.shape = Z;
                tetZ.generateZ(lineWidth, halfWidth, newCanvasWidth, canvasHeight);
                break;
            case "O":
                shapeO tetO = new shapeO();
                this.shape = O;
                tetO.generateO(lineWidth, halfWidth, newCanvasWidth, canvasHeight);
                break;
            case "T":
                shapeT tetT = new shapeT();
                this.shape = T;
                tetT.generateT(lineWidth, halfWidth, newCanvasWidth, canvasHeight);
                break;
            case "L":
                shapeL tetL = new shapeL();
                this.shape = L;
                tetL.generateL(lineWidth, halfWidth, newCanvasWidth, canvasHeight);
                break;
            case "J":
                shapeJ tetJ = new shapeJ();
                this.shape = J;
                tetJ.generateJ(lineWidth, halfWidth, newCanvasWidth, canvasHeight);
                break;
            default:
                System.out.println("Something went wrong");
                break;
        }
    }

    private void generateTet () {
            // 1 = I, 2 = S, 3 = Z, 4 = O, 5 = T, 6 = L, 7 = J
            Collections.shuffle(list);
            int switchVar = list.get(0);
            switch (switchVar) {
                case 1:
                    shapeI tetI = new shapeI();
                    this.shape = new Shape("I");
                    tetI.generateI(lineWidth, halfWidth, newCanvasWidth, canvasHeight);
                    break;
                case 2:
                    shapeS tetS = new shapeS();
                    this.shape = new Shape("S");
                    tetS.generateS(lineWidth, halfWidth, newCanvasWidth, canvasHeight);
                    break;
                case 3:
                    shapeZ tetZ = new shapeZ();
                    this.shape = new Shape("Z");
                    tetZ.generateZ(lineWidth, halfWidth, newCanvasWidth, canvasHeight);
                    break;
                case 4:
                    shapeO tetO = new shapeO();
                    this.shape = new Shape("O");
                    tetO.generateO(lineWidth, halfWidth, newCanvasWidth, canvasHeight);
                    break;
                case 5:
                    shapeT tetT = new shapeT();
                    this.shape = new Shape("T");
                    tetT.generateT(lineWidth, halfWidth, newCanvasWidth, canvasHeight);
                    break;
                case 6:
                    shapeL tetL = new shapeL();
                    this.shape = new Shape("L");
                    tetL.generateL(lineWidth, halfWidth, newCanvasWidth, canvasHeight);
                    break;
                case 7:
                    shapeJ tetJ = new shapeJ();
                    this.shape = new Shape("J");
                    tetJ.generateJ(lineWidth, halfWidth, newCanvasWidth, canvasHeight);
                    break;
                default:
                    System.out.println("Something went wrong");
                    break;
            }
        }

    private void drawTet (ArrayList < tBlock > list, double halfWidth) {
            Font font = new Font(Font.DIALOG, Font.BOLD, 10);
            StdDraw.setFont(font);
            for (tBlock t : list) {
                if (t.value == 2)
                    StdDraw.setPenColor(255, 229, 204);
                else
                    StdDraw.setPenColor(255, 204, 153);

                StdDraw.filledSquare(t.getX(), t.getY(), halfWidth);
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.text(t.getX(), t.getY(),String.valueOf(t.getValue()));
            }

        }

    public Tetriminoe() {
        }

    public class shapeS extends Tetriminoe {
            public ArrayList<tBlock> blockList = new ArrayList<>();
            private shapeS() {
                blockList.add(block0 = new tBlock());
                blockList.add(block1 = new tBlock());
                blockList.add(block2 = new tBlock());
                blockList.add(block3 = new tBlock());
            }

            public void generateS(double lineWidth, double halfWidth, double newCanvasWidth, double canvasHeight) {
                block0.setX(2.5 * lineWidth + 5 * halfWidth);
                block0.setY(canvasHeight - (3 * halfWidth + 1.5 * lineWidth));
                block1.setX(block0.getX() + (lineWidth + 2.0*halfWidth));
                block1.setY(block0.getY());
                block2.setX(block1.getX());
                block2.setY(block1.getY() + (lineWidth + 2.0*halfWidth));
                block3.setX(block2.getX() + (lineWidth + 2.0*halfWidth));
                block3.setY(block2.getY());
            }

            public void generateS_next(double lineWidth, double halfWidth, double newCanvasWidth, double canvasHeight) {
                block0.setX(newCanvasWidth-100+halfWidth*2.5);
                block0.setY(150.0);
                block1.setX(block0.getX() + (lineWidth + 2.0*halfWidth));
                block1.setY(block0.getY());
                block2.setX(block1.getX());
                block2.setY(block1.getY() + (lineWidth + 2.0*halfWidth));
                block3.setX(block2.getX() + (lineWidth + 2.0*halfWidth));
                block3.setY(block2.getY());
            }
        }

    public class shapeI extends Tetriminoe {
            public ArrayList<tBlock> blockList = new ArrayList<>();
            private shapeI() {
                blockList.add(block0 = new tBlock());
                blockList.add(block1 = new tBlock());
                blockList.add(block2 = new tBlock());
                blockList.add(block3 = new tBlock());
            }

            public void generateI(double lineWidth, double halfWidth, double newCanvasWidth, double canvasHeight) {
                block0.setX(2.5 * lineWidth + 5 * halfWidth);
                block0.setY(canvasHeight - (halfWidth + 0.5 * lineWidth));
                block1.setX(block0.getX() + (lineWidth + 2 * halfWidth));
                block1.setY(block0.getY());
                block2.setX(block1.getX() + (lineWidth + 2 * halfWidth));
                block2.setY(block0.getY());
                block3.setX(block2.getX() + (lineWidth + 2 * halfWidth));
                block3.setY(block0.getY());
            }

            public void generateI_next(double lineWidth, double halfWidth, double newCanvasWidth, double canvasHeight) {
                block0.setX(newCanvasWidth-100+halfWidth*2.0);
                block0.setY(150.0);
                block1.setX(block0.getX() + (lineWidth + 2 * halfWidth));
                block1.setY(block0.getY());
                block2.setX(block1.getX() + (lineWidth + 2 * halfWidth));
                block2.setY(block0.getY());
                block3.setX(block2.getX() + (lineWidth + 2 * halfWidth));
                block3.setY(block0.getY());
            }
        }

    public class shapeZ extends Tetriminoe {
            public ArrayList<tBlock> blockList = new ArrayList<>();
            private shapeZ() {
                blockList.add(block0 = new tBlock());
                blockList.add(block1 = new tBlock());
                blockList.add(block2 = new tBlock());
                blockList.add(block3 = new tBlock());
            }

            public void generateZ(double lineWidth, double halfWidth, double newCanvasWidth, double canvasHeight) {
                block0.setX(2.5 * lineWidth + 5 * halfWidth);
                block0.setY(canvasHeight - (halfWidth + 0.5 * lineWidth));
                block1.setX(block0.getX() + (lineWidth + 2 * halfWidth));
                block1.setY(block0.getY());
                block2.setX(block1.getX());
                block2.setY(block1.getY() - (lineWidth + 2 * halfWidth));
                block3.setX(block2.getX() + (lineWidth + 2 * halfWidth));
                block3.setY(block2.getY());
            }

            public void generateZ_next(double lineWidth, double halfWidth, double newCanvasWidth, double canvasHeight) {
                block0.setX(newCanvasWidth-100+halfWidth*2.5);
                block0.setY(150.0);
                block1.setX(block0.getX() + (lineWidth + 2 * halfWidth));
                block1.setY(block0.getY());
                block2.setX(block1.getX());
                block2.setY(block1.getY() - (lineWidth + 2 * halfWidth));
                block3.setX(block2.getX() + (lineWidth + 2 * halfWidth));
                block3.setY(block2.getY());
            }
        }

    public class shapeO extends Tetriminoe {
        public ArrayList<tBlock> blockList = new ArrayList<>();
        private shapeO() {
            blockList.add(block0 = new tBlock());
            blockList.add(block1 = new tBlock());
            blockList.add(block2 = new tBlock());
            blockList.add(block3 = new tBlock());
        }

        public void generateO(double lineWidth, double halfWidth, double newCanvasWidth, double canvasHeight) {
            block0.setX(3.5 * lineWidth + 7 * halfWidth);
            block0.setY(canvasHeight - (halfWidth + 0.5 * lineWidth));
            block1.setX(block0.getX() + (lineWidth + 2 * halfWidth));
            block1.setY(block0.getY());
            block2.setX(block1.getX());
            block2.setY(block1.getY() - (lineWidth + 2 * halfWidth));
            block3.setX(block2.getX() - (lineWidth + 2.0 * halfWidth));
            block3.setY(block2.getY());
        }

        public void generateO_next(double lineWidth, double halfWidth, double newCanvasWidth, double canvasHeight) {
            block0.setX(newCanvasWidth-100+halfWidth*2.5);
            block0.setY(150.0);
            block1.setX(block0.getX() + (lineWidth + 2 * halfWidth));
            block1.setY(block0.getY());
            block2.setX(block1.getX());
            block2.setY(block1.getY() - (lineWidth + 2 * halfWidth));
            block3.setX(block2.getX() - (lineWidth + 2.0 * halfWidth));
            block3.setY(block2.getY());
        }
    }

    public class shapeT extends Tetriminoe {
            public ArrayList<tBlock> blockList = new ArrayList<>();
            private shapeT() {
                blockList.add(block0 = new tBlock());
                blockList.add(block1 = new tBlock());
                blockList.add(block2 = new tBlock());
                blockList.add(block3 = new tBlock());
            }

            public void generateT(double lineWidth, double halfWidth, double newCanvasWidth, double canvasHeight) {
                block0.setX(2.5 * lineWidth + 5 * halfWidth);
                block0.setY(canvasHeight - (halfWidth + 0.5 * lineWidth));
                block1.setX(block0.getX() + (lineWidth + 2 * halfWidth));
                block1.setY(block0.getY());
                block2.setX(block1.getX());
                block2.setY(block1.getY() - (lineWidth + 2 * halfWidth));
                block3.setX(block1.getX() + (lineWidth + 2 * halfWidth));
                block3.setY(block1.getY());
            }

            public void generateT_next(double lineWidth, double halfWidth, double newCanvasWidth, double canvasHeight) {
                block0.setX(newCanvasWidth-100+halfWidth*2.5);
                block0.setY(150.0);
                block1.setX(block0.getX() + (lineWidth + 2 * halfWidth));
                block1.setY(block0.getY());
                block2.setX(block1.getX());
                block2.setY(block1.getY() - (lineWidth + 2 * halfWidth));
                block3.setX(block1.getX() + (lineWidth + 2 * halfWidth));
                block3.setY(block1.getY());
            }
        }

    public class shapeL extends Tetriminoe {
            public ArrayList<tBlock> blockList = new ArrayList<>();
            private shapeL() {
                blockList.add(block0 = new tBlock());
                blockList.add(block1 = new tBlock());
                blockList.add(block2 = new tBlock());
                blockList.add(block3 = new tBlock());
            }

            public void generateL(double lineWidth, double halfWidth, double newCanvasWidth, double canvasHeight) {
                block0.setX(2.5 * lineWidth + 5 * halfWidth);
                block0.setY(canvasHeight - (3 * halfWidth + 1.5 * lineWidth));
                block1.setX(block0.getX());
                block1.setY(block0.getY() + (lineWidth + 2 * halfWidth));
                block2.setX(block1.getX() + (lineWidth + 2 * halfWidth));
                block2.setY(block1.getY());
                block3.setX(block2.getX() + (lineWidth + 2 * halfWidth));
                block3.setY(block2.getY());
            }

            public void generateL_next(double lineWidth, double halfWidth, double newCanvasWidth, double canvasHeight) {
                block0.setX(newCanvasWidth-100+halfWidth*2.5);
                block0.setY(150.0);
                block1.setX(block0.getX());
                block1.setY(block0.getY() + (lineWidth + 2 * halfWidth));
                block2.setX(block1.getX() + (lineWidth + 2 * halfWidth));
                block2.setY(block1.getY());
                block3.setX(block2.getX() + (lineWidth + 2 * halfWidth));
                block3.setY(block2.getY());
            }
        }

    public class shapeJ extends Tetriminoe {
            public ArrayList<tBlock> blockList = new ArrayList<>();
            private shapeJ() {
                blockList.add(block0 = new tBlock());
                blockList.add(block1 = new tBlock());
                blockList.add(block2 = new tBlock());
                blockList.add(block3 = new tBlock());
            }

            public void generateJ(double lineWidth, double halfWidth, double newCanvasWidth, double canvasHeight) {
                block0.setX(2.5 * lineWidth + 5 * halfWidth);
                block0.setY(canvasHeight - (halfWidth + 0.5 * lineWidth));
                block1.setX(block0.getX() + (lineWidth + 2 * halfWidth));
                block1.setY(block0.getY());
                block2.setX(block1.getX() + (lineWidth + 2 * halfWidth));
                block2.setY(block1.getY());
                block3.setX(block2.getX());
                block3.setY(block2.getY() - (lineWidth + 2 * halfWidth));
            }

            public void generateJ_next(double lineWidth, double halfWidth, double newCanvasWidth, double canvasHeight) {
                block0.setX(newCanvasWidth-100+halfWidth*2.5);
                block0.setY(150.0);
                block1.setX(block0.getX() + (lineWidth + 2 * halfWidth));
                block1.setY(block0.getY());
                block2.setX(block1.getX() + (lineWidth + 2 * halfWidth));
                block2.setY(block1.getY());
                block3.setX(block2.getX());
                block3.setY(block2.getY() - (lineWidth + 2 * halfWidth));
            }
        }

    public ArrayList<tBlock> drawNext(Shape type, double width, double height, double halfW, double lineW){
        String switchVar = type.toString();
        switch (switchVar) {
            case "I":
                shapeI tetI = new shapeI();
                this.shape = I;
                tetI.generateI_next(lineW, halfW, width, height);
                drawTet(tetI.blockList, halfWidth*0.3);
                return tetI.blockList;
            case "S":
                shapeS tetS = new shapeS();
                this.shape = S;
                tetS.generateS_next(lineW, halfW, width, height);
                drawTet(tetS.blockList, halfWidth*0.3);
                return tetS.blockList;
            case "Z":
                shapeZ tetZ = new shapeZ();
                this.shape = Z;
                tetZ.generateZ_next(lineW, halfW, width, height);
                drawTet(tetZ.blockList, halfWidth*0.3);
                return tetZ.blockList;
            case "O":
                shapeO tetO = new shapeO();
                this.shape = O;
                tetO.generateO_next(lineW, halfW, width, height);
                drawTet(tetO.blockList, halfWidth*0.3);
                return tetO.blockList;
            case "T":
                shapeT tetT = new shapeT();
                this.shape = T;
                tetT.generateT_next(lineW, halfW, width, height);
                drawTet(tetT.blockList, halfWidth*0.3);
                return tetT.blockList;
            case "L":
                shapeL tetL = new shapeL();
                this.shape = L;
                tetL.generateL_next(lineW, halfW, width, height);
                drawTet(tetL.blockList, halfWidth*0.3);
                return tetL.blockList;
            case "J":
                shapeJ tetJ = new shapeJ();
                this.shape = J;
                tetJ.generateJ_next(lineW, halfW, width, height);
                drawTet(tetJ.blockList, halfWidth*0.3);
                return tetJ.blockList;
            default:
                System.out.println("Something went wrong");
                return null;
        }

        }
    }

class Shape {

    private static ArrayList<Integer> list = new ArrayList<>();
    public Shape shape;
    private String toString;
    public Shape(String shape){
        if(shape == "I")
            this.shape = Tetriminoe.I;
        if(shape == "S")
            this.shape = Tetriminoe.S;
        if(shape == "Z")
            this.shape = Tetriminoe.Z;
        if(shape == "O")
            this.shape = Tetriminoe.O;
        if(shape == "T")
            this.shape = Tetriminoe.T;
        if(shape == "L")
            this.shape = Tetriminoe.L;
        if(shape == "J")
            this.shape = Tetriminoe.J;
        toString = shape;
    }
    public Shape() {
        if (list.isEmpty()) {
            // 1 = I, 2 = S, 3 = Z, 4 = O, 5 = T, 6 = L, 7 = J
            for (int i = 1; i <= 7; i ++)
                list.add(i);
        }
        Collections.shuffle(list);
        int switchVar = list.get(0);
        switch (switchVar) {
            case 1:
                shape = Tetriminoe.I;
                toString = "I";
                break;
            case 2:
                shape = Tetriminoe.S;
                toString = "S";
                break;
            case 3:
                shape = Tetriminoe.Z;
                toString = "Z";
                break;
            case 4:
                shape = Tetriminoe.O;
                toString = "O";
                break;
            case 5:
                shape = Tetriminoe.T;
                toString = "T";
                break;
            case 6:
                shape = Tetriminoe.L;
                toString = "L";
                break;
            case 7:
                shape = Tetriminoe.J;
                toString = "J";
                break;
        }
    }
    public String toString(){
        return toString;
    }
    }
