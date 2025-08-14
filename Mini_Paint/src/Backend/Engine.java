package Backend;

import Frontend.MiniPaint;
import Interface.DrawingEngine;
import Interface.Shape;

import javax.swing.*;
import java.awt.*;
import java.lang.System;
import java.util.ArrayList;

public class Engine implements DrawingEngine {
    private ArrayList<Shape> shapes;
    private MiniPaint mini;

    public Engine(MiniPaint mini){
        shapes = new ArrayList<>();
        this.mini = mini;
    }

    @Override
    public void addShape(Shape shape) {
        if(shape != null) {
            shapes.add(shape);
            mini.shapesCombo.addItem(shape);
            refresh(mini.getGraphics());
        }
    }

    @Override
    public void removeShape(Shape shape) {
        if(shape != null && shapes.contains(shape)){
            shapes.remove(shape);
            mini.shapesCombo.removeItem(shape);
            mini.repaint();
        }
    }

    @Override
    public Shape[] getShapes() {
        return shapes.toArray(new Shape[0]);
    }

    @Override
    public void refresh(Graphics canvas) {
        for (Shape shape : shapes){
            shape.draw(canvas);
        }
    }

    public void drawCircle(){
        String input = JOptionPane.showInputDialog("Enter radius:");
        try {
            double radius = Double.parseDouble(input);
            double side = Double.parseDouble(input);
            if(radius < 0) {
                JOptionPane.showMessageDialog(null, "Radius cannot be negative!");
                return;
            }

            if(input.isEmpty()){
                JOptionPane.showMessageDialog(null, "Radius cannot be empty!");
                return;
            }

            Circle circle = new Circle(radius);

            // Set position using method
            circle.setPosition(getPosition());

            // Draw the circle on the canvas
            circle.draw(mini.getGraphics());

            // Add Shape to list of shapes
            addShape(circle);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter a valid number for radius.");
        }
    }

    public void drawSquare(){
        String input = JOptionPane.showInputDialog("Enter side length:");
        try {
            double side = Double.parseDouble(input);
            if(side < 0) {
                JOptionPane.showMessageDialog(null, "Side cannot be negative!");
                return;
            }

            if(input.isEmpty()){
                JOptionPane.showMessageDialog(null, "Side cannot be empty!");
                return;
            }

            Shape square = new Square(side);

            // Set position using method
            square.setPosition(getPosition());

            // Draw the circle on the canvas
            square.draw(mini.getGraphics());

            // Add Shape to list of shapes
            addShape(square);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter a valid number for side length");
        }
    }

    public void drawRect(){
        String inp1 = JOptionPane.showInputDialog("Enter width:");
        String inp2 = JOptionPane.showInputDialog("Enter length:");
        try {
            double width = Double.parseDouble(inp1);
            double length = Double.parseDouble(inp2);

            if(width < 0 || length < 0) {
                JOptionPane.showMessageDialog(null, "Dimensions cannot be negative!");
                return;
            }

            if(inp1.isEmpty() || inp2.isEmpty()){
                JOptionPane.showMessageDialog(null, "Dimensions cannot be empty!");
                return;
            }
            Shape rectangle = new Rectangle(width,length);

            // Set position using method
            rectangle.setPosition(getPosition());

            // Draw the circle on the canvas
            rectangle.draw(mini.getGraphics());

            // Add Shape to list of shapes
            addShape(rectangle);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter a valid number for side length");
        }
    }

    public void drawLine(){
        Point point = getPosition();

        if(point == null)
            return;

        String inp1 = JOptionPane.showInputDialog("Enter x2:");
        String inp2 = JOptionPane.showInputDialog("Enter y2:");
        try {
            double x2 = Double.parseDouble(inp1);
            double y2 = Double.parseDouble(inp2);

            if(x2 < 0 || y2 < 0) {
                JOptionPane.showMessageDialog(null, "co-ordinates cannot be negative!");
                return;
            }

            if(inp1.isEmpty() || inp2.isEmpty()){
                JOptionPane.showMessageDialog(null, "inputs cannot be empty!");
                return;
            }

            Shape line = new Line(x2,y2);

            // Set position using method
            line.setPosition(point);

            // Draw the circle on the canvas
            line.draw(mini.getGraphics());

            // Add Shape to list of shapes
            addShape(line);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter a valid number for side length");
        }
    }

    public void colorize() {
        Shape shape = (Shape) mini.shapesCombo.getSelectedItem();
        if (shape == null)
            return;

        Color outlineCol = JColorChooser.showDialog(null, "pick a frame color", null);
        if (outlineCol != null) {
            shape.setColor(outlineCol);
            refresh(mini.getGraphics());
        }

        Color fillColor = JColorChooser.showDialog(null, "pick a fill color", null);
        if (fillColor != null) {
            shape.setFillColor(fillColor);
            refresh(mini.getGraphics());
        }

    }

    public Point getPosition(){
        String inp1 = JOptionPane.showInputDialog("Enter x.co-ordinate");
        String inp2 = JOptionPane.showInputDialog("Enter y.co-ordinate");
        try{
            if(inp1.isEmpty() || inp2.isEmpty()){
                JOptionPane.showMessageDialog(null, "inputs cannot be empty!");
                return null;
            }

            int x = Integer.parseInt(inp1);
            int y = Integer.parseInt(inp2);

            if(x < 0 || y < 0) {
                JOptionPane.showMessageDialog(null, "co-ordinates cannot be negative!");
                return null;
            }

            return new Point(x,y);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,"Invalid input");
            return null;
        }
    }

    public static void main(String[] args) {
        MiniPaint mini = new MiniPaint();
        Engine eng = new Engine(mini);


        if(!mini.isActive()) {
            for (Shape shape : eng.getShapes()) {
                String string = shape.toString();
                System.out.println(string);
            }
        }
    }


}
