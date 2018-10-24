package main.java.view;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class DrawLine implements Drawable {

    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private Color color;
    private GraphicsContext g;

    public DrawLine(double x1, double y1, double x2, double y2, Color color, GraphicsContext g) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
        this.g=g;
    }

    @Override
    public void draw() {
        g.setFill(color);
        g.strokeLine(x1,y1,x2,y2);
    }
}
