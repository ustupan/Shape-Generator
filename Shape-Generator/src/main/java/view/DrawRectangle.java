package main.java.view;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class DrawRectangle implements Drawable {
    private double x;
    private double y;
    private double height;
    private double width;
    private Color color;
    private GraphicsContext g;

    public DrawRectangle(double x, double y, double height, double width, Color color, GraphicsContext g) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.color = color;
        this.g = g;
    }

    @Override
    public void draw() {
        g.setFill(color);
        g.fillRect(x,y,height,width);
    }
}
