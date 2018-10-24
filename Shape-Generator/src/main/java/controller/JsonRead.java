package main.java.controller;
import javafx.scene.paint.Color;
import main.java.model.*;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;


public class JsonRead {

    private List list = new ArrayList<Shape>();

    public List getList() {
        return list;
    }

    public JsonRead(File file) throws Exception {
        Object obj = new JSONParser().parse(new FileReader(file));
        JSONObject jsonObject = (JSONObject) obj;
        JSONArray rec = (JSONArray) jsonObject.get("Rectangle");
        getRectangle(rec);
        JSONArray circ = (JSONArray) jsonObject.get("Circle");
        getCircle(circ);
        JSONArray line = (JSONArray) jsonObject.get("Line");
        getLine(line);
    }

    private void getRectangle(JSONArray rec){
        Color color = null;
        double height = 0, width = 0;
        double x1 = 0, y1 = 0;
        Point point = null;
        Iterator iterator = rec.iterator();
        while (iterator.hasNext()) {
            Iterator<Map.Entry> iterator1;
            iterator1 = ((Map) iterator.next()).entrySet().iterator();
            while (iterator1.hasNext()) {
                Map.Entry entry = iterator1.next();
                if (entry.getKey().equals("color")) {
                    color = getColor((String) entry.getValue());
                }
                if (entry.getKey().equals("height")) {
                    height = Double.parseDouble((String) entry.getValue());
                }
                if (entry.getKey().equals("width")) {
                    width = Double.parseDouble((String) entry.getValue());
                }
                if (entry.getKey().equals("x")) {
                    x1 = Double.parseDouble((String) entry.getValue());
                }
                if (entry.getKey().equals("y")) {
                    y1 = Double.parseDouble((String) entry.getValue());
                }
                point= new Point(x1,y1);
            }
            list.add(new Rectangle(color,height,width,point));
        }
    }

    private void getCircle(JSONArray circ){
        Color color = null;
        double radius=0;
        double x1 = 0, y1 = 0;
        Point point = null;
        Iterator iterator = circ.iterator();
        while (iterator.hasNext()) {
            Iterator<Map.Entry> iterator1;
            iterator1 = ((Map) iterator.next()).entrySet().iterator();
            while (iterator1.hasNext()) {
                Map.Entry entry = iterator1.next();
                if (entry.getKey().equals("color")) {
                    color = getColor((String) entry.getValue());
                }
                if (entry.getKey().equals("radius")) {
                    radius = Double.parseDouble((String) entry.getValue());
                }
                if (entry.getKey().equals("x")) {
                    x1 = Double.parseDouble((String) entry.getValue());
                }
                if (entry.getKey().equals("y")) {
                    y1 = Double.parseDouble((String) entry.getValue());
                }
                point= new Point(x1,y1);
            }
            list.add(new Circle(color,point,radius));
        }
    }

    private void getLine(JSONArray line){
        Color color = null;
        double height = 0, width = 0;
        double x1 = 0, y1 = 0;
        double x2 = 0, y2 = 0;
        Point point1 = null;
        Point point2 = null;
        Iterator iterator = line.iterator();
        while (iterator.hasNext()) {
            Iterator<Map.Entry> iterator1;
            iterator1 = ((Map) iterator.next()).entrySet().iterator();
            while (iterator1.hasNext()) {
                Map.Entry entry = iterator1.next();
                if (entry.getKey().equals("color")) {
                    color = getColor((String) entry.getValue());
                }
                if (entry.getKey().equals("x1")) {
                    x1 = Double.parseDouble((String) entry.getValue());
                }
                if (entry.getKey().equals("y1")) {
                    y1 = Double.parseDouble((String) entry.getValue());
                }
                if (entry.getKey().equals("x2")) {
                    x2 = Double.parseDouble((String) entry.getValue());
                }
                if (entry.getKey().equals("y2")) {
                    y2 = Double.parseDouble((String) entry.getValue());
                }
                point1= new Point(x1,y1);
                point2= new Point(x2,y2);
            }
            list.add(new Line(color,point1,point2));
        }
    }

    private Color getColor(String color) {
        String[] strArray = color.split(",");
        int[] ints = new int[3];
        for (int i = 0; i < 3; i++) {
            ints[i] = Integer.parseInt(strArray[i]);
        }
        return Color.rgb(ints[0], ints[1], ints[2]);
    }
}
