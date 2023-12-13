package project.core;

public class Point {

    private int pointX;
    private int pointY;
    private int IndexI;
    private int IndexJ;

    public Point() {
    }

    public Point(int pointX, int pointY) {
        this.pointX = pointX;
        this.pointY = pointY;
    }

    public Point(int pointX, int pointY, int IndexI, int IndexJ) {
        this.pointX = pointX;
        this.pointY = pointY;
        this.IndexI = IndexI;
        this.IndexJ = IndexJ;
    }
    
    

    public int getPointX() {
        return pointX;
    }

    public void setPointX(int pointX) {
        this.pointX = pointX;
    }

    public int getPointY() {
        return pointY;
    }

    public void setPointY(int pointY) {
        this.pointY = pointY;
    }

    public int getIndexI() {
        return IndexI;
    }

    public void setIndexI(int IndexI) {
        this.IndexI = IndexI;
    }

    public int getIndexJ() {
        return IndexJ;
    }

    public void setIndexJ(int IndexJ) {
        this.IndexJ = IndexJ;
    }



}
