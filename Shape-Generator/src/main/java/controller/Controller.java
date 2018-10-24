package main.java.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import main.java.model.*;
import main.java.view.DrawCircle;
import main.java.view.DrawLine;
import main.java.view.DrawRectangle;
import main.java.view.Drawable;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class Controller {
    private List<Shape> list = new ArrayList<Shape>();

    @FXML
    private Canvas canvas;

    @FXML
    private ColorPicker rectangleColorPicker, lineColorPicker, circleColorPicker;
    @FXML
    private Button rectangleButton, lineButton, circleButton;
    @FXML
    private TextField recX,recY,recHeight,recWidth;
    @FXML
    private TextField circX,circY,circRadius;
    @FXML
    private TextField lineX1,lineY1,lineX2,lineY2;


    @FXML
    public void save(){
        try {
            new JsonWrite(list, new File("zapis.txt"));
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    @FXML
    public void read(){
        GraphicsContext g = canvas.getGraphicsContext2D();
        List list;
        try {
            JsonRead read = new JsonRead(new File("zapis.txt"));
            list = read.getList();
            for (Object item : list){
                if(item instanceof Rectangle){
                    Drawable draw = new DrawRectangle(((Rectangle) item).getPoint().getX(),
                            ((Rectangle) item).getPoint().getY(), ((Rectangle) item).getHeight(),
                            ((Rectangle) item).getWidth(), ((Rectangle) item).getColor(), g);
                    draw.draw();
                }
                else if(item instanceof Circle){
                    Drawable draw = new DrawCircle(((Circle) item).getPoint().getX(),
                            ((Circle) item).getPoint().getY(), ((Circle) item).getRadius(),
                            ((Circle) item).getColor(), g);
                }
                else if (item instanceof Line){
                    Drawable draw = new DrawLine(((Line) item).getPointP1().getX(),
                            ((Line) item).getPointP1().getY(), ((Line) item).getPointP2().getX(),
                            ((Line) item).getPointP2().getY(), ((Line) item).getColor(), g);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void rectangleButton(ActionEvent event){
        try{
            double x = Double.parseDouble(recX.getText());
            double y = Double.parseDouble(recY.getText());
            double height = Double.parseDouble(recHeight.getText());
            double width = Double.parseDouble(recWidth.getText());
            GraphicsContext g = canvas.getGraphicsContext2D();
            Drawable draw = new DrawRectangle(x,y,height,width,rectangleColorPicker.getValue(),g);
            draw.draw();
            list.add(new Rectangle(rectangleColorPicker.getValue(),height,width,new Point(x,y)));
        }catch (Exception e){
            System.out.println("Nieprawidlowe wartosci");
        }

    }

    @FXML
    public void lineButton(ActionEvent event){
        try{
            double x1 = Double.parseDouble(lineX1.getText());
            double y1 = Double.parseDouble(lineY1.getText());
            double x2 = Double.parseDouble(lineX2.getText());
            double y2 = Double.parseDouble(lineY2.getText());
            GraphicsContext g = canvas.getGraphicsContext2D();
            Drawable draw = new DrawLine(x1,y1,x2,y2,lineColorPicker.getValue(),g);
            draw.draw();
            list.add(new Line(lineColorPicker.getValue(),new Point(x1,y1),new Point(x2,y2)));
        }catch (Exception e){
            System.out.println("Nieprawidlowe wartosci");
        }
    }

    @FXML
    public void circleButton(ActionEvent event){
        try{
            double x = Double.parseDouble(circX.getText());
            double y = Double.parseDouble(circY.getText());
            double r = Double.parseDouble(circRadius.getText());
            GraphicsContext g = canvas.getGraphicsContext2D();
            Drawable draw = new DrawCircle(x,y,r,lineColorPicker.getValue(),g);
            draw.draw();
            list.add(new Circle(lineColorPicker.getValue(),new Point(x,y), r));
        }catch (Exception e){
            System.out.println("Nieprawidlowe wartosci");
        }
    }

    @FXML
    public void exit(){
        Platform.exit();
    }

}