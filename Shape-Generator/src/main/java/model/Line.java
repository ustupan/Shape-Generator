package main.java.model;
import javafx.scene.paint.Color;

public class Line implements Shape1D {

    private Color color;
    private Point P1;
    private Point P2;

    public Line(Color color, Point p1, Point p2) {
        this.color = color;
        P1 = p1;
        P2 = p2;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public Point getPointP1() {
        return P1;
    }

    public Point getPointP2() {
        return P2;
    }
}