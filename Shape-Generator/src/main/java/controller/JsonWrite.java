package main.java.controller;
import main.java.model.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.File;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import javafx.scene.paint.Color;
import java.io.PrintWriter;



public class JsonWrite {
    public JsonWrite(List<Shape> List, File file) throws FileNotFoundException {
        JSONObject json = new JSONObject();
        JSONArray rec = new JSONArray();
        JSONArray cir = new JSONArray();
        JSONArray lin = new JSONArray();

        for(Shape item : List) {
            if(item instanceof Rectangle){
                LinkedHashMap<String, String> map = new LinkedHashMap<String,String>();
                map.put("color",toRGBCode(item.getColor()));
                map.put("height",Double.toString(((Rectangle) item).getHeight()));
                map.put("width",Double.toString(((Rectangle) item).getWidth()));
                map.put("x",Double.toString(((Rectangle) item).getPoint().getX()));
                map.put("y",Double.toString(((Rectangle) item).getPoint().getY()));
                rec.add(map);
            }
            else if(item instanceof Circle){
                LinkedHashMap<String, String> map = new LinkedHashMap<String,String>();
                map.put("color",toRGBCode(item.getColor()));
                map.put("x",Double.toString(((Circle) item).getPoint().getX()));
                map.put("y",Double.toString(((Circle) item).getPoint().getY()));
                map.put("radius", Double.toString(((Circle) item).getRadius()));
                cir.add(map);
            }
            else{
                LinkedHashMap<String, String> map = new LinkedHashMap<String,String>();
                map.put("color",toRGBCode(item.getColor()));
                map.put("x1",Double.toString(((Line) item).getPointP1().getX()));
                map.put("y1",Double.toString(((Line) item).getPointP1().getY()));
                map.put("x2",Double.toString(((Line) item).getPointP2().getX()));
                map.put("y2",Double.toString(((Line) item).getPointP2().getY()));
                lin.add(map);
            }
        }
        json.put("Line", lin);
        json.put("Circle", cir);
        json.put("Rectangle", rec);


        PrintWriter pw = new PrintWriter(file);
        pw.write(json.toJSONString());

        pw.flush();
        pw.close();
        System.out.print("Zapisano");

    }

    private static String toRGBCode(Color color)
    {
        return String.format( "%d,%d,%d",
                (int)( color.getRed() * 255 ),
                (int)( color.getGreen() * 255 ),
                (int)( color.getBlue() * 255 ) );
    }

}



