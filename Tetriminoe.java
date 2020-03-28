import edu.princeton.cs.introcs.StdDraw;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class Tetriminoe {
    private static ArrayList<Integer> list = new ArrayList<>();
    private tBlock block0;
    private tBlock block1;
    private tBlock block2;
    private tBlock block3;
    private double lineWidth;
    private double halfWidth;
    private double newCanvasWidth;
    private double canvasHeight;
    private Shape shape;
    private Tetriminoe next;

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

    public Tetriminoe(Shape type, double lineWidth, double halfWidth, double newCanvasWidth, double canvasHeight) {
        this.shape = type;
        this.halfWidth = halfWidth;
        ArrayList<tBlock> blockList = new ArrayList<>();
        this.lineWidth = lineWidth;
        this.newCanvasWidth = newCanvasWidth;
        this.canvasHeight = canvasHeight;
        if(null != type)
            generateTet(type);
        else {
            generateTet();
        }
        blockList.add(block0);
        blockList.add(block1);
        blockList.add(block2);
        blockList.add(block3);
        drawTet(blockList, halfWidth);
    }

    private void generateTet(Shape type) {
        String switchVar = type.toString();
        switch (switchVar) {
            case "I":
                shapeI tetI = new shapeI();
                this.shape = Shape.I;
                tetI.generateI(lineWidth, halfWidth, newCanvasWidth, canvasHeight);
                break;
            case "S":
                shapeS tetS = new shapeS();
                this.shape = Shape.S;
                tetS.generateS(lineWidth, halfWidth, newCanvasWidth, canvasHeight);
                break;
            case "Z":
                shapeZ tetZ = new shapeZ();
                this.shape = Shape.Z;
                tetZ.generateZ(lineWidth, halfWidth, newCanvasWidth, canvasHeight);
                break;
            case "O":
                shapeO tetO = new shapeO();
                this.shape = Shape.O;
                tetO.generateO(lineWidth, halfWidth, newCanvasWidth, canvasHeight);
                break;
            case "T":
                shapeT tetT = new shapeT();
                this.shape = Shape.T;
                tetT.generateT(lineWidth, halfWidth, newCanvasWidth, canvasHeight);
                break;
            case "L":
                shapeL tetL = new shapeL();
                this.shape = Shape.L;
                tetL.generateL(lineWidth, halfWidth, newCanvasWidth, canvasHeight);
                break;
            case "J":
                shapeJ tetJ = new shapeJ();
                this.shape = Shape.J;
                tetJ.generateJ(lineWidth, halfWidth, newCanvasWidth, canvasHeight);
                break;
            default:
                System.out.println("Something went wrong");
                break;
        }
    }

    private void generateTet () {
            // 1 = I, 2 = S, 3 = Z, 4 = O, 5 = T, 6 = L, 7 = J
            for (int i = 1; i <= 7; i += 2)
                list.add(i);
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
            for (int i = 0; i < 4; i++) {
                if (list.get(i).value == 2)
                    StdDraw.setPenColor(255, 229, 204);
                else
                    StdDraw.setPenColor(255, 204, 153);

                StdDraw.filledSquare(list.get(i).getX(), list.get(i).getY(), halfWidth);
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.text(list.get(i).getX(), list.get(i).getY(),String.valueOf(list.get(i).getValue()));
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
                block1.setX(block0.getX() + (lineWidth + halfWidth));
                block1.setY(block0.getY());
                block2.setX(block1.getX());
                block2.setY(block1.getY() + (lineWidth + halfWidth));
                block3.setX(block2.getX() + (lineWidth + halfWidth));
                block3.setY(block2.getY());
            }

            public void generateS_next(double lineWidth, double halfWidth, double newCanvasWidth, double canvasHeight) {
                block0.setX(newCanvasWidth-100+halfWidth*2.5);
                block0.setY(150.0);
                block1.setX(block0.getX() + (lineWidth + halfWidth));
                block1.setY(block0.getY());
                block2.setX(block1.getX());
                block2.setY(block1.getY() + (lineWidth + halfWidth));
                block3.setX(block2.getX() + (lineWidth + halfWidth));
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
            block0.setX(2.5 * lineWidth + 5 * halfWidth);
            block0.setY(canvasHeight - (halfWidth + 0.5 * lineWidth));
            block1.setX(block0.getX() + (lineWidth + 2 * halfWidth));
            block1.setY(block0.getY());
            block2.setX(block0.getX());
            block2.setY(block0.getY() - (-lineWidth + 2 * halfWidth));
            block3.setX(block1.getX());
            block3.setY(block2.getY());
        }

        public void generateO_next(double lineWidth, double halfWidth, double newCanvasWidth, double canvasHeight) {
            block0.setX(newCanvasWidth-100+halfWidth*2.5);
            block0.setY(150.0);
            block1.setX(block0.getX() + (lineWidth + 2 * halfWidth));
            block1.setY(block0.getY());
            block2.setX(block0.getX());
            block2.setY(block0.getY() - (-lineWidth + 2 * halfWidth));
            block3.setX(block1.getX());
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
                block3.setY(block0.getY());
            }

            public void generateT_next(double lineWidth, double halfWidth, double newCanvasWidth, double canvasHeight) {
                block0.setX(newCanvasWidth-100+halfWidth*2.5);
                block0.setY(150.0);
                block1.setX(block0.getX() + (lineWidth + 2 * halfWidth));
                block1.setY(block0.getY());
                block2.setX(block1.getX());
                block2.setY(block1.getY() - (lineWidth + 2 * halfWidth));
                block3.setX(block1.getX() + (lineWidth + 2 * halfWidth));
                block3.setY(block0.getY());
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
                block0.setY(canvasHeight - (3 * halfWidth + 0.5 * lineWidth));
                block1.setX(block0.getX());
                block1.setY(block0.getY() + (lineWidth + 2 * halfWidth));
                block2.setX(block1.getX());
                block2.setY(block1.getY());
                block3.setX(block2.getX() + (lineWidth + 2 * halfWidth));
                block3.setY(block0.getY());
            }

            public void generateL_next(double lineWidth, double halfWidth, double newCanvasWidth, double canvasHeight) {
                block0.setX(newCanvasWidth-100+halfWidth*2.5);
                block0.setY(150.0);
                block1.setX(block0.getX());
                block1.setY(block0.getY() + (lineWidth + 2 * halfWidth));
                block2.setX(block1.getX());
                block2.setY(block1.getY());
                block3.setX(block2.getX() + (lineWidth + 2 * halfWidth));
                block3.setY(block0.getY());
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
                block2.setY(block0.getY());
                block3.setX(block2.getX());
                block3.setY(block0.getY() + +(lineWidth + 2 * halfWidth));
            }

            public void generateJ_next(double lineWidth, double halfWidth, double newCanvasWidth, double canvasHeight) {
                block0.setX(newCanvasWidth-100+halfWidth*2.5);
                block0.setY(150.0);
                block1.setX(block0.getX() + (lineWidth + 2 * halfWidth));
                block1.setY(block0.getY());
                block2.setX(block1.getX() + (lineWidth + 2 * halfWidth));
                block2.setY(block0.getY());
                block3.setX(block2.getX());
                block3.setY(block0.getY() + +(lineWidth + 2 * halfWidth));
            }
        }

    public void drawNext(Shape type, double width, double height, double halfW, double lineW){
        String switchVar = type.toString();
        switch (switchVar) {
            case "I":
                shapeI tetI = new shapeI();
                this.shape = Shape.I;
                tetI.generateI_next(lineW, halfW, width, height);
                drawTet(tetI.blockList, halfWidth/2.0);
                break;
            case "S":
                shapeS tetS = new shapeS();
                this.shape = Shape.S;
                tetS.generateS_next(lineW, halfW, width, height);
                drawTet(tetS.blockList, halfWidth/2.0);
                break;
            case "Z":
                shapeZ tetZ = new shapeZ();
                this.shape = Shape.Z;
                tetZ.generateZ_next(lineW, halfW, width, height);
                drawTet(tetZ.blockList, halfWidth/2.0);
                break;
            case "O":
                shapeO tetO = new shapeO();
                this.shape = Shape.O;
                tetO.generateO_next(lineW, halfW, width, height);
                drawTet(tetO.blockList, halfWidth/2.0);
                break;
            case "T":
                shapeT tetT = new shapeT();
                this.shape = Shape.T;
                tetT.generateT_next(lineW, halfW, width, height);
                drawTet(tetT.blockList, halfWidth/2.0);
                break;
            case "L":
                shapeL tetL = new shapeL();
                this.shape = Shape.L;
                tetL.generateL_next(lineW, halfW, width, height);
                drawTet(tetL.blockList, halfWidth/2.0);
                break;
            case "J":
                shapeJ tetJ = new shapeJ();
                this.shape = Shape.J;
                tetJ.generateJ_next(lineW, halfW, width, height);
                drawTet(tetJ.blockList, halfWidth/2.0);
                break;
            default:
                System.out.println("Something went wrong");
                break;
        }

        }
    }

class Shape {
    public static Shape I, S, Z, O, T, L, J;
    private static ArrayList<Integer> list = new ArrayList<>();
    public Shape shape;
    private String toString;
    public Shape(String shape){
        if(shape == "I")
            this.shape = Shape.I;
        if(shape == "S")
            this.shape = Shape.S;
        if(shape == "Z")
            this.shape = Shape.Z;
        if(shape == "O")
            this.shape = Shape.O;
        if(shape == "T")
            this.shape = Shape.T;
        if(shape == "L")
            this.shape = Shape.L;
        if(shape == "J")
            this.shape = Shape.J;
        toString = shape;
    }
    public Shape() {
        if (list.isEmpty()) {
            // 1 = I, 2 = S, 3 = Z, 4 = O, 5 = T, 6 = L, 7 = J
            for (int i = 1; i <= 7; i += 2)
                list.add(i);
            Collections.shuffle(list);
        }
        int switchVar = list.get(0);
        switch (switchVar) {
            case 1:
                shape = Shape.I;
                toString = "I";
                break;
            case 2:
                shape = Shape.S;
                toString = "S";
                break;
            case 3:
                shape = Shape.Z;
                toString = "Z";
                break;
            case 4:
                shape = Shape.O;
                toString = "O";
                break;
            case 5:
                shape = Shape.T;
                toString = "T";
                break;
            case 6:
                shape = Shape.L;
                toString = "L";
                break;
            case 7:
                shape = Shape.J;
                toString = "J";
                break;
        }
    }
    public String toString(){
        return toString;
    }
    }
