package Backend;

import Interface.Shape;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Line extends ShapeClass implements Shape {
    private Point position;
    private Map<String, Double> properties;
    private Color color;
    private Color fillColor;

    Line(double x2, double y2) {
        this.position = new Point();
        this.properties = new HashMap<>();
        this.properties.put("x2",x2);
        this.properties.put("y2",y2);
    }

    @Override
    public void setPosition(Point point) {
        this.position = point;
    }

    @Override
    public Point getPosition() {
        return position;
    }

    @Override
    public void setProperties(Map<String, Double> properties) {
        if (properties.containsKey("x2") && properties.containsKey("y2")) {
            this.properties = properties;
        }
    }

    @Override
    public Map<String, Double> getProperties() {
        return this.properties;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public void setFillColor(Color color) {
        this.fillColor = color;
    }

    @Override
    public Color getFillColor() {
        return this.fillColor;
    }


    @Override
    public void draw(Graphics canvas) {
        if (canvas instanceof Graphics2D) {
            Graphics2D g2D = (Graphics2D) canvas;

            // Fill and outline colors (default to white and black if not set)
            Color fillCol = fillColor != null ? fillColor : Color.WHITE;
            Color outlineCol = color != null ? color : Color.BLACK;

            int x2 = properties.getOrDefault("x2", (double) position.x + 10).intValue();
            int y2 = properties.getOrDefault("y2", (double) position.y + 10).intValue();
            g2D.setColor(outlineCol);  // Only outline color for line
            g2D.drawLine(position.x, position.y, x2, y2);
        }
    }
    public String toString(){
        return "Line" + getProperties() ;
    }
}
