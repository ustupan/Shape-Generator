package main.java.view;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class DrawCircle implements Drawable{
    private double x;
    private double y;
    private double r;
    private Color color;
    private GraphicsContext g;

    public DrawCircle(double x, double y, double r, Color color, GraphicsContext g) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.color = color;
        this.g = g;
    }

    @Override
    public void draw() {
        g.setFill(color);
        g.fillOval(x,y,r,r);
    }
}
