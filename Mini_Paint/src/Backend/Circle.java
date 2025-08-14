package Backend;

import Interface.Shape;

import java.awt.*;
import java.util.Map;

public class Circle extends ShapeClass implements Shape {

    Circle(double radius){
        super();
        this.properties.put("radius", radius);
    }

    @Override
    public void setProperties(Map<String, Double> properties) {
        if (properties.containsKey("radius")) {
            this.properties = properties;
        }
    }

    @Override
    public void draw(Graphics canvas) {
        if (canvas instanceof Graphics2D) {
            Graphics2D g2D = (Graphics2D) canvas;
            //g2D.setStroke(new BasicStroke(10));

            // Fill and outline colors (default to white and black if not set)
            Color fillCol = fillColor != null ? fillColor : Color.WHITE;
            Color outlineCol = color != null ? color : Color.BLACK;

            int radius = properties.getOrDefault("radius", 10.0).intValue();
            g2D.setColor(fillCol);
            g2D.fillOval(position.x, position.y, radius * 2, radius * 2);
            g2D.setColor(outlineCol);
            g2D.drawOval(position.x, position.y, radius * 2, radius * 2);
        }
    }

    @Override
    public String toString(){
        return "Circle" + getProperties();
    }
}
