package Interface;

import java.awt.*;
import java.util.Map;

public interface Shape {
    /*set position*/
    public void setPosition(Point point);
    public Point getPosition();

    /* update properties*/
    public void setProperties(Map<String, Double> properties);
    public Map<String, Double> getProperties();

    /* Colorize */
    public void setColor(Color color);
    public Color getColor();
    public void setFillColor(Color color);
    public Color getFillColor();

    /* redraw on canvas */
    public void draw(java.awt.Graphics canvas);
}
