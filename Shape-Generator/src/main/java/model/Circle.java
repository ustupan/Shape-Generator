package main.java.model;

import javafx.scene.paint.Color;

public class Circle implements Shape2D {
    private Color color;
    private Point center;
    private double radius;

    public Circle(Color color, Point center, double radius) {
        this.color = color;
        this.center = center;
        this.radius = radius;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public Point getPoint() {
        return center;
    }

    public double getRadius() {
        return radius;
    }

}