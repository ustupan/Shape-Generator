package main.java.model;

import javafx.scene.paint.Color;

public class Rectangle implements Shape2D{
    private Color color;
    private double height;
    private double width;
    private Point p;

    public Rectangle(Color color, double height, double width, Point p) {
        this.color = color;
        this.height = height;
        this.width = width;
        this.p = p;
    }

    @Override
    public Color getColor() {
        return color;
    }

    public double getHeight() {
        return height;
    }


    public double getWidth() {
        return width;
    }
    @Override
    public Point getPoint() {
        return p;
    }
}