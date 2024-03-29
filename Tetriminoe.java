import edu.princeton.cs.introcs.StdDraw;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class Tetriminoe {
    public static Shape I = new Shape("I");
    public static Shape S = new Shape("S");
    public static Shape Z = new Shape("Z");
    public static Shape L = new Shape("L");
    public static Shape J = new Shape("J");
    public static Shape O = new Shape("O");
    public static Shape T = new Shape("T");
    private static ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<tBlock> blockList = new ArrayList<>();
    private tBlock block0;
    private tBlock block1;
    private tBlock block2;
    private tBlock block3;
    private double lineWidth;
    private double halfWidth;
    private double newCanvasWidth;
    private double canvasHeight;
    private Shape shape;
    private boolean isRotated = false;

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

    public void drawTet (ArrayList < tBlock > list, double halfWidth) {
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

    public void rotatetTet(ArrayList<tBlock> drawList, String keyPressed){
        if (shape == I){
            if (!isRotated && keyPressed == "down") {
                int flag = 1;
                for (tBlock t : drawList){
                    if (t.getX() == block0.getX() && t.getY() == block0.getY() - (lineWidth + halfWidth))
                        flag = 0;
                    if (t.getX() == block0.getX() && t.getY() == block0.getY() - 2.0 *(lineWidth + halfWidth))
                        flag = 0;
                    if (t.getX() == block0.getX() && t.getY() == block0.getY() - 3.0 *(lineWidth + halfWidth))
                        flag = 0;
                }
                if (flag == 1) {
                    block0.setX(block0.getX());
                    block0.setY(block0.getY());
                    block1.setX(block0.getX());
                    block1.setY(block0.getY() - (lineWidth + halfWidth));
                    block2.setX(block1.getX());
                    block2.setY(block1.getY() - (lineWidth + halfWidth));
                    block3.setX(block2.getX());
                    block3.setY(block2.getY() - (lineWidth + halfWidth));
                    this.isRotated = true;
                }
            }
            else if (isRotated && keyPressed == "up") {
                int flag = 1;
                for (tBlock t : drawList){
                    if (t.getY() == block0.getY() && t.getX() == block0.getX() + (lineWidth + halfWidth))
                        flag = 0;
                    if (t.getY() == block0.getY() && t.getX() == block0.getX() + 2.0 *(lineWidth + halfWidth))
                        flag = 0;
                    if (t.getY() == block0.getY() && t.getX() == block0.getX() + 3.0 *(lineWidth + halfWidth))
                        flag = 0;
                }
                if (flag == 1) {
                    block0.setX(block0.getX());
                    block0.setY(block0.getY());
                    block1.setX(block0.getX() + (lineWidth + halfWidth));
                    block1.setY(block0.getY());
                    block2.setX(block1.getX() + (lineWidth + halfWidth));
                    block2.setY(block1.getY());
                    block3.setX(block2.getX() + (lineWidth + halfWidth));
                    block3.setY(block2.getY());
                    this.isRotated = false;
                }
            }
            else return;
            // Update tetriminoe's place in drawList
            drawList.get(drawList.size()-4).setX(blockList.get(0).getX());
            drawList.get(drawList.size()-4).setY(blockList.get(0).getY());
            drawList.get(drawList.size()-3).setX(blockList.get(1).getX());
            drawList.get(drawList.size()-3).setY(blockList.get(1).getY());
            drawList.get(drawList.size()-2).setX(blockList.get(2).getX());
            drawList.get(drawList.size()-2).setY(blockList.get(2).getY());
            drawList.get(drawList.size()-1).setX(blockList.get(3).getX());
            drawList.get(drawList.size()-1).setY(blockList.get(3).getY());
        }
        if (shape == S) {
            if (!isRotated && keyPressed == "down") {
                int flag = 1;
                for (tBlock t : drawList) {
                    if (t.getX() == block0.getX() && t.getY() == block0.getY() - (lineWidth + halfWidth))
                        flag = 0;
                    if (t.getX() == block0.getX() + (lineWidth + halfWidth) && t.getY() == block0.getY() - (lineWidth + halfWidth))
                        flag = 0;
                    if (t.getX() == block0.getX() + (lineWidth + halfWidth) && t.getY() == block0.getY() - 2.0 * (lineWidth + halfWidth))
                        flag = 0;
                }
                if (flag == 1) {
                    block0.setX(block0.getX());
                    block0.setY(block0.getY());
                    block1.setX(block0.getX());
                    block1.setY(block0.getY() - (lineWidth + 2.0 * halfWidth));
                    block2.setX(block1.getX() + (lineWidth + 2.0 * halfWidth));
                    block2.setY(block1.getY());
                    block3.setX(block2.getX());
                    block3.setY(block2.getY() - (lineWidth + 2.0 * halfWidth));
                    this.isRotated = true;
                }
            }
            else if (isRotated && keyPressed == "up") {
                int flag = 1;
                for (tBlock t : drawList) {
                    if (t.getX() == block0.getX() + (lineWidth + halfWidth)&& t.getY() == block0.getY() )
                        flag = 0;
                    if (t.getX() == block0.getX() + (lineWidth + halfWidth) && t.getY() == block0.getY() + (lineWidth + halfWidth))
                        flag = 0;
                    if (t.getX() == block0.getX() + 2.0*(lineWidth + halfWidth) && t.getY() == block0.getY() + (lineWidth + halfWidth) )
                        flag = 0;
                }
                if (flag == 1) {
                    block0.setX(block0.getX());
                    block0.setY(block0.getY());
                    block1.setX(block0.getX() + (lineWidth + 2.0 * halfWidth));
                    block1.setY(block0.getY());
                    block2.setX(block1.getX());
                    block2.setY(block1.getY() + (lineWidth + 2.0 * halfWidth));
                    block3.setX(block2.getX() + (lineWidth + 2.0 * halfWidth));
                    block3.setY(block2.getY());
                    this.isRotated = false;
                }
            }
            else return;
            // Update tetriminoe's place in drawList
            drawList.get(drawList.size()-4).setX(blockList.get(0).getX());
            drawList.get(drawList.size()-4).setY(blockList.get(0).getY());
            drawList.get(drawList.size()-3).setX(blockList.get(1).getX());
            drawList.get(drawList.size()-3).setY(blockList.get(1).getY());
            drawList.get(drawList.size()-2).setX(blockList.get(2).getX());
            drawList.get(drawList.size()-2).setY(blockList.get(2).getY());
            drawList.get(drawList.size()-1).setX(blockList.get(3).getX());
            drawList.get(drawList.size()-1).setY(blockList.get(3).getY());
        }
        if (shape == Z){
            if (!isRotated && keyPressed == "down") {
                int flag = 1;
                for (tBlock t : drawList){
                    if (t.getX() == block0.getX() && t.getY() == block0.getY() - (lineWidth + halfWidth))
                        flag = 0;
                    if (t.getX() == block0.getX() - (lineWidth + halfWidth) && t.getY() == block0.getY() - (lineWidth + halfWidth))
                        flag = 0;
                    if (t.getX() == block0.getX() - (lineWidth + halfWidth) && t.getY() == block0.getY() - 2.0 *(lineWidth + halfWidth))
                        flag = 0;
                }
                if (flag == 1) {
                    block0.setX(block0.getX());
                    block0.setY(block0.getY());
                    block1.setX(block0.getX());
                    block1.setY(block0.getY() - (lineWidth + halfWidth));
                    block2.setX(block1.getX() - (lineWidth + halfWidth));
                    block2.setY(block1.getY());
                    block3.setX(block2.getX());
                    block3.setY(block2.getY() - (lineWidth + halfWidth));
                    this.isRotated = true;
                }
            }
            else if (isRotated && keyPressed == "up") {
                int flag = 1;
                for (tBlock t : drawList){
                    if (t.getX() == block0.getX() + (lineWidth + halfWidth) && t.getY() == block0.getY())
                        flag = 0;
                    if (t.getX() == block0.getX() + (lineWidth + halfWidth) && t.getY() == block0.getY() - (lineWidth + halfWidth))
                        flag = 0;
                    if (t.getX() == block0.getX() + 2.0*(lineWidth + halfWidth) && t.getY() == block0.getY() - (lineWidth + halfWidth))
                        flag = 0;
                }
                if (flag == 1) {
                    block0.setX(block0.getX());
                    block0.setY(block0.getY());
                    block1.setX(block0.getX() + (lineWidth + halfWidth));
                    block1.setY(block0.getY());
                    block2.setX(block1.getX());
                    block2.setY(block1.getY() - (lineWidth + halfWidth));
                    block3.setX(block2.getX() + (lineWidth + halfWidth));
                    block3.setY(block2.getY() );
                    this.isRotated = false;
                }
            }
            else return;
            // Update tetriminoe's place in drawList
            drawList.get(drawList.size()-4).setX(blockList.get(0).getX());
            drawList.get(drawList.size()-4).setY(blockList.get(0).getY());
            drawList.get(drawList.size()-3).setX(blockList.get(1).getX());
            drawList.get(drawList.size()-3).setY(blockList.get(1).getY());
            drawList.get(drawList.size()-2).setX(blockList.get(2).getX());
            drawList.get(drawList.size()-2).setY(blockList.get(2).getY());
            drawList.get(drawList.size()-1).setX(blockList.get(3).getX());
            drawList.get(drawList.size()-1).setY(blockList.get(3).getY());
        }
        if (shape == L){
            if (!isRotated && keyPressed == "down") {
                int flag = 1;
                for (tBlock t : drawList){
                    if (t.getX() == block0.getX() + (lineWidth + halfWidth) && t.getY() == block0.getY())
                        flag = 0;
                    if (t.getX() == block0.getX() + (lineWidth + halfWidth) && t.getY() == block0.getY() - (lineWidth + halfWidth))
                        flag = 0;
                    if (t.getX() == block0.getX() + (lineWidth + halfWidth) && t.getY() == block0.getY() - 2.0 *(lineWidth + halfWidth))
                        flag = 0;
                }
                if (flag == 1) {
                    block0.setX(block0.getX());
                    block0.setY(block0.getY());
                    block1.setX(block0.getX() + (lineWidth + halfWidth));
                    block1.setY(block0.getY());
                    block2.setX(block1.getX());
                    block2.setY(block1.getY() - (lineWidth + halfWidth));
                    block3.setX(block2.getX());
                    block3.setY(block2.getY() - (lineWidth + halfWidth));
                    this.isRotated = true;
                }
            }
            else if (isRotated && keyPressed == "up") {
                int flag = 1;
                for (tBlock t : drawList){
                    if (t.getX() == block0.getX() && t.getY() == block0.getY() + (lineWidth + halfWidth))
                        flag = 0;
                    if (t.getX() == block0.getX() + (lineWidth + halfWidth) && t.getY() == block0.getY() + (lineWidth + halfWidth))
                        flag = 0;
                    if (t.getX() == block0.getX() + 2.0*(lineWidth + halfWidth) && t.getY() == block0.getY() + (lineWidth + halfWidth))
                        flag = 0;
                }
                if (flag == 1) {
                    block0.setX(block0.getX());
                    block0.setY(block0.getY());
                    block1.setX(block0.getX());
                    block1.setY(block0.getY() + (lineWidth + halfWidth));
                    block2.setX(block1.getX() + (lineWidth + halfWidth));
                    block2.setY(block1.getY());
                    block3.setX(block2.getX() + (lineWidth + halfWidth));
                    block3.setY(block2.getY());
                    this.isRotated = false;
                }
            }
            else return;
            // Update tetriminoe's place in drawList
            drawList.get(drawList.size()-4).setX(blockList.get(0).getX());
            drawList.get(drawList.size()-4).setY(blockList.get(0).getY());
            drawList.get(drawList.size()-3).setX(blockList.get(1).getX());
            drawList.get(drawList.size()-3).setY(blockList.get(1).getY());
            drawList.get(drawList.size()-2).setX(blockList.get(2).getX());
            drawList.get(drawList.size()-2).setY(blockList.get(2).getY());
            drawList.get(drawList.size()-1).setX(blockList.get(3).getX());
            drawList.get(drawList.size()-1).setY(blockList.get(3).getY());
        }
        if (shape == J){
            if (!isRotated && keyPressed == "down") {
                int flag = 1;
                for (tBlock t : drawList){
                    if (t.getX() == block0.getX() && t.getY() == block0.getY() - (lineWidth + halfWidth))
                        flag = 0;
                    if (t.getX() == block0.getX() && t.getY() == block0.getY() - 2.0 *(lineWidth + halfWidth))
                        flag = 0;
                    if (t.getX() == block0.getX() - (lineWidth + halfWidth) && t.getY() == block0.getY() - 2.0 *(lineWidth + halfWidth))
                        flag = 0;
                }
                if (flag == 1) {
                    block0.setX(block0.getX());
                    block0.setY(block0.getY());
                    block1.setX(block0.getX());
                    block1.setY(block0.getY() - (lineWidth + halfWidth));
                    block2.setX(block1.getX());
                    block2.setY(block1.getY() - (lineWidth + halfWidth));
                    block3.setX(block2.getX() - (lineWidth + halfWidth));
                    block3.setY(block2.getY() - (lineWidth + halfWidth));
                    this.isRotated = true;
                }
            }
            else if (isRotated && keyPressed == "up") {
                int flag = 1;
                for (tBlock t : drawList){
                    if (t.getX() == block0.getX() + (lineWidth + halfWidth) && t.getY() == block0.getY() )
                        flag = 0;
                    if (t.getX() == block0.getX() + (lineWidth + halfWidth) && t.getY() == block0.getY())
                        flag = 0;
                    if (t.getX() == block0.getX() + 2.0*(lineWidth + halfWidth) && t.getY() == block0.getY() - (lineWidth + halfWidth))
                        flag = 0;
                }
                if (flag == 1) {
                    block0.setX(block0.getX());
                    block0.setY(block0.getY());
                    block1.setX(block0.getX() + (lineWidth + halfWidth));
                    block1.setY(block0.getY());
                    block2.setX(block1.getX() + (lineWidth + halfWidth));
                    block2.setY(block1.getY());
                    block3.setX(block2.getX());
                    block3.setY(block2.getY() - (lineWidth + halfWidth));
                    this.isRotated = false;
                }
            }
            else return;
            // Update tetriminoe's place in drawList
            drawList.get(drawList.size()-4).setX(blockList.get(0).getX());
            drawList.get(drawList.size()-4).setY(blockList.get(0).getY());
            drawList.get(drawList.size()-3).setX(blockList.get(1).getX());
            drawList.get(drawList.size()-3).setY(blockList.get(1).getY());
            drawList.get(drawList.size()-2).setX(blockList.get(2).getX());
            drawList.get(drawList.size()-2).setY(blockList.get(2).getY());
            drawList.get(drawList.size()-1).setX(blockList.get(3).getX());
            drawList.get(drawList.size()-1).setY(blockList.get(3).getY());
        }
        if (shape == O){
            return;
        }
        if (shape == T){
            if (!isRotated && keyPressed == "down") {
                int flag = 1;
                for (tBlock t : drawList){
                    if (t.getX() == block0.getX() && t.getY() == block0.getY() - (lineWidth + halfWidth))
                        flag = 0;
                    if (t.getX() == block0.getX() - (lineWidth + halfWidth) && t.getY() == block0.getY())
                        flag = 0;
                    if (t.getX() == block0.getX() && t.getY() == block0.getY() - 2.0 *(lineWidth + halfWidth))
                        flag = 0;
                }
                if (flag == 1) {
                    block0.setX(block0.getX());
                    block0.setY(block0.getY());
                    block1.setX(block0.getX());
                    block1.setY(block0.getY() - (lineWidth + halfWidth));
                    block2.setX(block1.getX() - (lineWidth + halfWidth));
                    block2.setY(block1.getY());
                    block3.setX(block2.getX() + (lineWidth + halfWidth));
                    block3.setY(block2.getY() - (lineWidth + halfWidth));
                    this.isRotated = true;
                }
            }
            else if (isRotated && keyPressed == "up") {
                int flag = 1;
                for (tBlock t : drawList){
                    if (t.getX() == block0.getX() + (lineWidth + halfWidth) && t.getY() == block0.getY())
                        flag = 0;
                    if (t.getX() == block0.getX() + (lineWidth + halfWidth) && t.getY() == block0.getY() - (lineWidth + halfWidth))
                        flag = 0;
                    if (t.getX() == block0.getX() + 2.0 *(lineWidth + halfWidth) && t.getY() == block0.getY())
                        flag = 0;
                }
                if (flag == 1) {
                    block0.setX(block0.getX());
                    block0.setY(block0.getY());
                    block1.setX(block0.getX() + (lineWidth + halfWidth));
                    block1.setY(block0.getY());
                    block2.setX(block1.getX());
                    block2.setY(block1.getY() - (lineWidth + halfWidth));
                    block3.setX(block2.getX() + (lineWidth + halfWidth));
                    block3.setY(block2.getY() + (lineWidth + halfWidth));
                    this.isRotated = false;
                }
            }
            else return;
            // Update tetriminoe's place in drawList
            drawList.get(drawList.size()-4).setX(blockList.get(0).getX());
            drawList.get(drawList.size()-4).setY(blockList.get(0).getY());
            drawList.get(drawList.size()-3).setX(blockList.get(1).getX());
            drawList.get(drawList.size()-3).setY(blockList.get(1).getY());
            drawList.get(drawList.size()-2).setX(blockList.get(2).getX());
            drawList.get(drawList.size()-2).setY(blockList.get(2).getY());
            drawList.get(drawList.size()-1).setX(blockList.get(3).getX());
            drawList.get(drawList.size()-1).setY(blockList.get(3).getY());
        }
    }

    public boolean moveTet(Tetriminoe tet, double lineWidth, double halfWidth, ArrayList<tBlock> drawList){
        boolean answer = false;
        int flag = 1;
        ArrayList<tBlock> workWith = findBottom(tet);
        for(tBlock t : workWith) {
            // check if the tet. is out of borders
            if ((t.getY() <= lineWidth*0.5 + halfWidth)){
                flag = 0;
                break;
            }
            // check if the tetriminoe already touches any other tet. below it
            for (int i = 0; i< drawList.size()-4; i++) {
                if (t.getX() == drawList.get(i).getX() && t.getY() - (lineWidth + 2.0 * halfWidth) == drawList.get(i).getY()){
                    flag = 0;
                    break;
                }
            }
            if (flag == 0)
                break;
        }
        if (flag == 1) {
            for (tBlock t : tet.blockList) {
                answer = true;
                // move down 1 block
                t.setY(t.getY() - (lineWidth + 2.0 * halfWidth));
            }
        }
        // Update tetriminoe's place in drawList
        drawList.get(drawList.size()-4).setX(blockList.get(0).getX());
        drawList.get(drawList.size()-4).setY(blockList.get(0).getY());
        drawList.get(drawList.size()-3).setX(blockList.get(1).getX());
        drawList.get(drawList.size()-3).setY(blockList.get(1).getY());
        drawList.get(drawList.size()-2).setX(blockList.get(2).getX());
        drawList.get(drawList.size()-2).setY(blockList.get(2).getY());
        drawList.get(drawList.size()-1).setX(blockList.get(3).getX());
        drawList.get(drawList.size()-1).setY(blockList.get(3).getY());
        return answer;
    }

    public void moveLeft(Tetriminoe tet, double lineWidth, double halfWidth, ArrayList<tBlock> drawList){
        int flag = 1;
            ArrayList<tBlock> workWithLeft = findLeftward(tet);
            for(tBlock t: workWithLeft){
                // check if it exceeds borders
                if (!(t.getX() - (lineWidth + 2.0 * halfWidth) >= (0.5 * lineWidth + halfWidth))) {
                    flag = 0;
                    break;
                }
                // check if it collides with another tet.
                for (int i = 0; i< drawList.size()-4; i++) {
                    if (t.getX() - (lineWidth + 2.0 * halfWidth) == drawList.get(i).getX() && t.getY() == drawList.get(i).getY()){
                        flag = 0;
                        break;
                    }
                    if (flag == 0)
                        break;
                }
            }
        // move left 1 block
        if (flag == 1) {
            for (tBlock t : tet.blockList)
                t.setX(t.getX() - (lineWidth + 2.0 * halfWidth));
        }
        // Update tetriminoe's place in drawList
        drawList.get(drawList.size()-4).setX(blockList.get(0).getX());
        drawList.get(drawList.size()-4).setY(blockList.get(0).getY());
        drawList.get(drawList.size()-3).setX(blockList.get(1).getX());
        drawList.get(drawList.size()-3).setY(blockList.get(1).getY());
        drawList.get(drawList.size()-2).setX(blockList.get(2).getX());
        drawList.get(drawList.size()-2).setY(blockList.get(2).getY());
        drawList.get(drawList.size()-1).setX(blockList.get(3).getX());
        drawList.get(drawList.size()-1).setY(blockList.get(3).getY());

    }

    public void moveRight(Tetriminoe tet, double lineWidth, double halfWidth, ArrayList<tBlock> drawList){
        int flag = 1;
            ArrayList<tBlock> workWithRight = findRightward(tet);
            for(tBlock t: workWithRight){
                // check if it exceeds borders
                if ((t.getX() >= newCanvasWidth - (lineWidth + halfWidth + 100))) {
                    flag = 0;
                    break;
                }
                for (int i = 0; i< drawList.size()-4; i++) {
                    // check if it collides with another tet.
                    if (t.getX() + (lineWidth + 2.0 * halfWidth) == drawList.get(i).getX() && t.getY()== drawList.get(i).getY()){
                        flag = 0;
                        break;
                    }
                    if (flag == 0)
                        break;
                }
            }
            // move right 1 block
            if (flag == 1) {
                for (tBlock t : tet.blockList)
                    t.setX(t.getX() + (lineWidth + 2.0 * halfWidth));
            }
    // Update tetriminoe's place in drawList
        drawList.get(drawList.size()-4).setX(blockList.get(0).getX());
        drawList.get(drawList.size()-4).setY(blockList.get(0).getY());
        drawList.get(drawList.size()-3).setX(blockList.get(1).getX());
        drawList.get(drawList.size()-3).setY(blockList.get(1).getY());
        drawList.get(drawList.size()-2).setX(blockList.get(2).getX());
        drawList.get(drawList.size()-2).setY(blockList.get(2).getY());
        drawList.get(drawList.size()-1).setX(blockList.get(3).getX());
        drawList.get(drawList.size()-1).setY(blockList.get(3).getY());
    }

    private ArrayList<tBlock> findBottom(Tetriminoe tet){
        ArrayList<tBlock> bottom = new ArrayList<>();
        ArrayList<Double> sameX = new ArrayList<>();
        for (tBlock t : tet.blockList){
            if (sameX.isEmpty())
                sameX.add(t.getX());
            else if (!sameX.contains(t.getX()))
                sameX.add(t.getX());
        }

        ArrayList<Double> lowest = new ArrayList<>();
        for (Double d : sameX)
            lowest.add(9999999999999.9);

        for (tBlock t : tet.blockList){
            for (int i = 0 ; i<lowest.size(); i++) {
                if (t.getX() == sameX.get(i)) {
                    if (t.getY() < lowest.get(i))
                        lowest.set(i, t.getY());
                }
            }
        }

        for (tBlock t : tet.blockList){
            for ( int i = 0; i<sameX.size(); i++){
                if (t.getY() == lowest.get(i) && t.getX() == sameX.get(i))
                    bottom.add(t);
            }
        }
        return bottom;
    }

    private ArrayList<tBlock> findLeftward(Tetriminoe tet){
        ArrayList<tBlock> leftWard = new ArrayList<>();
        ArrayList<Double> sameY = new ArrayList<>();
        for (tBlock t : tet.blockList){
            if (sameY.isEmpty())
                sameY.add(t.getY());
            else if (!sameY.contains(t.getY()))
                sameY.add(t.getY());
        }
        ArrayList<Double> lowest = new ArrayList<>();
        for (Double d : sameY)
            lowest.add(9999999999999.9);

        for (tBlock t : tet.blockList){
            for (int i = 0 ; i<lowest.size(); i++) {
                if (t.getY() == sameY.get(i)) {
                    if (t.getX() < lowest.get(i))
                        lowest.set(i, t.getX());
                }
            }
        }

        for (tBlock t : tet.blockList){
            for ( int i = 0; i<sameY.size(); i++){
                if (t.getX() == lowest.get(i) && t.getY() == sameY.get(i))
                    leftWard.add(t);
            }
        }

        return leftWard;
    }

    private ArrayList<tBlock> findRightward(Tetriminoe tet){
        ArrayList<tBlock> rightWard = new ArrayList<>();
        ArrayList<Double> sameY = new ArrayList<>();
        for (tBlock t : tet.blockList){
            if (sameY.isEmpty())
                sameY.add(t.getY());
            else if (!sameY.contains(t.getY()))
                sameY.add(t.getY());
        }
        ArrayList<Double> highest = new ArrayList<>();
        for (Double d : sameY)
            highest.add(0.0);

        for (tBlock t : tet.blockList){
            for (int i = 0 ; i<highest.size(); i++) {
                if (t.getY() == sameY.get(i)) {
                    if (t.getX() > highest.get(i))
                        highest.set(i, t.getX());
                }
            }
        }

        for (tBlock t : tet.blockList){
            for ( int i = 0; i<sameY.size(); i++){
                if (t.getX() == highest.get(i) && t.getY() == sameY.get(i))
                    rightWard.add(t);
            }
        }
        return rightWard;
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

    /*
    public void deleteRows(ArrayList<tBlock> drawList, int score){
        int counter = 0;
        ArrayList<Double> rows = new ArrayList<>();
        // check occurrence of full rows
        for (double y = (0.5 * lineWidth + halfWidth); y < canvasHeight; y += halfWidth * 2.0 + lineWidth){
            for (double x = (0.5 * lineWidth + halfWidth); x < newCanvasWidth - (100 + halfWidth + lineWidth); x += lineWidth + halfWidth * 2.0){
                for (tBlock t : drawList){
                    if ((t.getX() == x && t.getY() == y)){
                        counter ++;
                    }
                }
            }
            if (counter == 8)
                rows.add(y);
            counter = 0;
        }
        // delete full rows from the drawlist
        ArrayList<tBlock> willRemove = new ArrayList<>();
        for (tBlock t : drawList){
            for (double y : rows){
                if (t.getY() == y) {
                    // update score
                    score += t.getValue();
                    willRemove.add(t);
                }
            }
        }
        drawList.removeAll(willRemove);
        // move rows which were above deleted rows 1 block down
        for (tBlock t : drawList){
            for (double y : rows){
                if (t.getY() > y) {
                    t.setY(t.getY() - (halfWidth * 2.0 + lineWidth));
                }
            }
        }
    }
    */

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
