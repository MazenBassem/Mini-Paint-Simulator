package Backend;

import Interface.Shape;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Square extends ShapeClass implements Shape {
    Square(double side) {
        super();
        this.properties.put("side",side);
    }

    @Override
    public void setProperties(Map<String, Double> properties) {
        if (properties.containsKey("side")) {
            this.properties = properties;
        }
    }


    @Override
    public void draw(Graphics canvas) {
        if (canvas instanceof Graphics2D) {
            Graphics2D g2D = (Graphics2D) canvas;

            // Fill and outline colors (default to white and black if not set)
            Color fillCol = fillColor != null ? fillColor : Color.WHITE;
            Color outlineCol = color != null ? color : Color.BLACK;

            int side = properties.getOrDefault("side", 10.0).intValue();
            g2D.setColor(fillCol);
            g2D.fillRect(position.x, position.y,side ,side);
            g2D.setColor(outlineCol);
            g2D.drawRect(position.x, position.y,side ,side);
        }
    }
    public String toString(){
<<<<<<< HEAD
        return "Square" +getProperties() ;
=======
        return "Square" + getProperties();
>>>>>>> 514fa3b6efa627bb2f691fb6eb5f89bb64ff5c43
    }
}
