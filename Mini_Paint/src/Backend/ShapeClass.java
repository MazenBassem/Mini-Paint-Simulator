package Backend;

import java.awt.*;
<<<<<<< HEAD
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.*;

public abstract class ShapeClass implements Serializable {
=======
import java.util.HashMap;
import java.util.Map;

public abstract class ShapeClass {
>>>>>>> 514fa3b6efa627bb2f691fb6eb5f89bb64ff5c43
    protected Point position;
    protected Map<String, Double> properties;
    protected Color color;
    protected Color fillColor;

    ShapeClass(){
        this.position = new Point();
        this.properties = new HashMap<>();
    }

<<<<<<< HEAD
    public static ShapeClass parseShape(String line) {
        // Patterns for different components
        Pattern shapePattern = Pattern.compile("^(Circle|Square|Rectangle|Line)\\{(.*?)}");
        Pattern positionPattern = Pattern.compile("java\\.awt\\.Point\\[x=(\\d+),y=(\\d+)]");
        Pattern colorPattern = Pattern.compile("java\\.awt\\.Color\\[r=(\\d+),g=(\\d+),b=(\\d+)]");

        Matcher shapeMatcher = shapePattern.matcher(line);
        Matcher positionMatcher = positionPattern.matcher(line);
        Matcher colorMatcher = colorPattern.matcher(line);

        ShapeClass shape = null;
        Map<String, Double> properties = new HashMap<>();
        Point position = null;
        Color color = null;
        Color fillColor = null;

        // Parse shape
        if (shapeMatcher.find()) {
            String shapeType = shapeMatcher.group(1);
            String shapeProperties = shapeMatcher.group(2);

            switch (shapeType) {
                case "Circle":
                    shape = new Circle(0);
                    properties.put("radius", Double.parseDouble(shapeProperties.split("=")[1]));
                    break;
                case "Square":
                    shape = new Square(0);
                    properties.put("side", Double.parseDouble(shapeProperties.split("=")[1]));
                    break;
                case "Rectangle":
                    shape = new Rectangle(0,0);
                    String[] dimensions = shapeProperties.split(", ");
                    properties.put("width", Double.parseDouble(dimensions[0].split("=")[1]));
                    properties.put("length", Double.parseDouble(dimensions[1].split("=")[1]));
                    break;
                case "Line":
                    String[] coordinates = shapeProperties.split(", ");
                    properties.put("x2", Double.parseDouble(coordinates[1].split("=")[1]));
                    properties.put("y2", Double.parseDouble(coordinates[0].split("=")[1]));
                    break;
            }
        }

        // Parse position
        if (positionMatcher.find()) {
            int x = Integer.parseInt(positionMatcher.group(1));
            int y = Integer.parseInt(positionMatcher.group(2));
            position = new Point(x, y);
        }

        // Parse colors
        if (colorMatcher.find()) {
            int r = Integer.parseInt(colorMatcher.group(1));
            int g = Integer.parseInt(colorMatcher.group(2));
            int b = Integer.parseInt(colorMatcher.group(3));
            color = new Color(r, g, b);

            if (colorMatcher.find()) {
                r = Integer.parseInt(colorMatcher.group(1));
                g = Integer.parseInt(colorMatcher.group(2));
                b = Integer.parseInt(colorMatcher.group(3));
                fillColor = new Color(r, g, b);
            }
        }

        // Assign properties to shape
        if (shape != null) {
            shape.setProperties(properties);
            shape.setPosition(position);
            shape.setColor(color);
            shape.setFillColor(fillColor);
        }

        return shape;
    }

=======
>>>>>>> 514fa3b6efa627bb2f691fb6eb5f89bb64ff5c43
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
