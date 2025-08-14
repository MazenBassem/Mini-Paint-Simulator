package Interface;

public interface DrawingEngine {
    /* manage shapes*/
    public void addShape(Shape shapeImp);
    public void removeShape(Shape shapeImp);

    /* return all shapes*/
    public Shape[] getShapes();

    /* redraw all shapes on canvas */
    public void refresh(java.awt.Graphics canvas);
}
