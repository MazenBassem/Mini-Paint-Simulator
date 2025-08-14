package Backend;

import Interface.Shape;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Rectangle extends ShapeClass implements Shape {
    Rectangle(double width,double length) {
        super();
        this.properties.put("width",width);
        this.properties.put("length",length);
    }

    @Override
    public void setProperties(Map<String, Double> properties) {
        if (properties.containsKey("width") && properties.containsKey("length")) {
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

            int width = properties.getOrDefault("width", 30.0).intValue();
            int length = properties.getOrDefault("length", 15.0).intValue();
            g2D.setColor(fillCol);
            g2D.fillRect(position.x, position.y, width, length);
            g2D.setColor(outlineCol);
            g2D.drawRect(position.x, position.y, width, length);
        }
    }
    public String toString(){
        return "Rectangle" + getProperties();
    }
}