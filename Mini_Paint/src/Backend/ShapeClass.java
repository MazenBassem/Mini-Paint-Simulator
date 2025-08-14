package Backend;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public abstract class ShapeClass {
    protected Point position;
    protected Map<String, Double> properties;
    protected Color color;
    protected Color fillColor;

    ShapeClass(){
        this.position = new Point();
        this.properties = new HashMap<>();
    }

    public void setPosition(Point point) {
        this.position = point;
    }

    public Point getPosition() {
        return position;
    }

    public Map<String, Double> getProperties() {
        return this.properties;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }

    public void setFillColor(Color color) {
        this.fillColor = color;
    }

    public Color getFillColor() {
        return this.fillColor;
    }

    abstract void setProperties(Map<String, Double> properties);

    abstract void draw(Graphics canvas);
}
