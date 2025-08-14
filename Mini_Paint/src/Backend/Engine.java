package Backend;

import Frontend.MiniPaint;
<<<<<<< HEAD
import Frontend.open_window;
=======
>>>>>>> 514fa3b6efa627bb2f691fb6eb5f89bb64ff5c43
import Interface.DrawingEngine;
import Interface.Shape;

import javax.swing.*;
import java.awt.*;
<<<<<<< HEAD
import java.io.*;
import java.lang.System;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
=======
import java.lang.System;
import java.util.ArrayList;
>>>>>>> 514fa3b6efa627bb2f691fb6eb5f89bb64ff5c43

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
<<<<<<< HEAD
            mini.repaint();
=======
            refresh(mini.getGraphics());
>>>>>>> 514fa3b6efa627bb2f691fb6eb5f89bb64ff5c43
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
<<<<<<< HEAD
=======
            double side = Double.parseDouble(input);
>>>>>>> 514fa3b6efa627bb2f691fb6eb5f89bb64ff5c43
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

<<<<<<< HEAD
=======
            // Draw the circle on the canvas
            circle.draw(mini.getGraphics());

>>>>>>> 514fa3b6efa627bb2f691fb6eb5f89bb64ff5c43
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

<<<<<<< HEAD
=======
            // Draw the circle on the canvas
            square.draw(mini.getGraphics());

>>>>>>> 514fa3b6efa627bb2f691fb6eb5f89bb64ff5c43
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

<<<<<<< HEAD
=======
            // Draw the circle on the canvas
            rectangle.draw(mini.getGraphics());

>>>>>>> 514fa3b6efa627bb2f691fb6eb5f89bb64ff5c43
            // Add Shape to list of shapes
            addShape(rectangle);

        } catch (NumberFormatException e) {
<<<<<<< HEAD
            JOptionPane.showMessageDialog(null, "Please enter a valid number for dimensions");
=======
            JOptionPane.showMessageDialog(null, "Please enter a valid number for side length");
>>>>>>> 514fa3b6efa627bb2f691fb6eb5f89bb64ff5c43
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

<<<<<<< HEAD
=======
            // Draw the circle on the canvas
            line.draw(mini.getGraphics());

>>>>>>> 514fa3b6efa627bb2f691fb6eb5f89bb64ff5c43
            // Add Shape to list of shapes
            addShape(line);

        } catch (NumberFormatException e) {
<<<<<<< HEAD
            JOptionPane.showMessageDialog(null, "Please enter valid co-ordinates");
=======
            JOptionPane.showMessageDialog(null, "Please enter a valid number for side length");
>>>>>>> 514fa3b6efa627bb2f691fb6eb5f89bb64ff5c43
        }
    }

    public void colorize() {
        Shape shape = (Shape) mini.shapesCombo.getSelectedItem();
<<<<<<< HEAD
        if (shape == null) {
            JOptionPane.showMessageDialog(null, "No shape selected!");
            return;
        }

        Color outlineCol = JColorChooser.showDialog(null, "Pick a frame color", null);
        if (outlineCol != null) {
            shape.setColor(outlineCol);
            mini.repaint();
        }

        Color fillColor = JColorChooser.showDialog(null, "Pick a fill color", null);
        if (fillColor != null) {
            shape.setFillColor(fillColor);
            mini.repaint();
        }
    }

    public void clearShapes() {
        if (shapes.isEmpty()){
            JOptionPane.showMessageDialog(null, "Canvas Already Clear!");
            return;
        }
        mini.shapesCombo.removeAllItems();
        shapes.clear();
        mini.repaint();
    }

    public void resize(){
        Shape shape = (Shape) mini.shapesCombo.getSelectedItem();
        Map<String, Double> properties = new HashMap<>();

        if (shape == null) {
            JOptionPane.showMessageDialog(null, "No shape selected!");
            return;
        }

        if (shape instanceof Circle){
            String input = JOptionPane.showInputDialog("Enter New Radius:");
            try {
                double radius = Double.parseDouble(input);
                if(radius < 0) {
                    JOptionPane.showMessageDialog(null, "Radius cannot be negative!");
                    return;
                }

                if(input.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Radius cannot be empty!");
                    return;
                }

                properties.put("radius",radius);
                ((Circle)shape).setProperties(properties);
                mini.repaint();

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number for radius.");
            }
        }

        if (shape instanceof Square){
            String input = JOptionPane.showInputDialog("Enter new side length:");
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

                properties.put("side",side);
                ((Square)shape).setProperties(properties);
                mini.repaint();

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number for side length");
            }
        }

        if(shape instanceof Rectangle){
            String inp1 = JOptionPane.showInputDialog("Enter new width:");
            String inp2 = JOptionPane.showInputDialog("Enter new length:");
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

                properties.put("width",width);
                properties.put("length",length);
                ((Rectangle)shape).setProperties(properties);
                mini.repaint();

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number for dimensions");
            }
        }

        if (shape instanceof Line){
            String inp1 = JOptionPane.showInputDialog("Enter new x2:");
            String inp2 = JOptionPane.showInputDialog("Enter new y2:");
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

                properties.put("x2",x2);
                properties.put("y2",y2);
                ((Line)shape).setProperties(properties);
                mini.repaint();

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter valid co-ordinates");
            }
        }

    }

    public void move(){
        Shape shape = (Shape) mini.shapesCombo.getSelectedItem();
        if (shape == null) {
            JOptionPane.showMessageDialog(null, "No shape selected!");
            return;
        }

        shape.setPosition(getPosition());
        mini.repaint();
=======
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

>>>>>>> 514fa3b6efa627bb2f691fb6eb5f89bb64ff5c43
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

<<<<<<< HEAD
    public void load2() {
        File filename = selectFile();
        ArrayList<Shape> shapes_copy;

        if (filename == null) {
            JOptionPane.showMessageDialog(null, "No file selected.");
            return;
        }

        open_window dialog = new open_window();
        dialog.setVisible(true);

        try (ObjectInputStream load = new ObjectInputStream(new FileInputStream(filename))) {
            shapes_copy = (ArrayList<Shape>) load.readObject();

            if (shapes_copy.isEmpty()) {
                JOptionPane.showMessageDialog(null, "The file is empty.");
            } else {
                for (Shape shape : shapes_copy) {
                    shapes.add(shape);
                    mini.shapesCombo.addItem(shape);
                }
                mini.repaint(); // Repaint once after all shapes are added
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error loading file: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error: File contains unsupported objects.");
        }
    }

    public void save2() {
        if (shapes.isEmpty()){
            JOptionPane.showMessageDialog(null, "No Shapes to save!");
            return;
        }

        File filename = selectFile();
        if (filename == null) {
            JOptionPane.showMessageDialog(null, "No file selected.");
            return;
        }

        try (ObjectOutputStream load = new ObjectOutputStream(new FileOutputStream(filename))) {
            load.writeObject(shapes);
            load.close();
            JOptionPane.showMessageDialog(null, "Shapes saved successfully!");


        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error loading file: " + e.getMessage());
        }
    }

    public void load(){
        File filename = selectFile();

        if (filename == null){
            return;
        }

        //ask this window or new window
        shapes.clear();
        mini.shapesCombo.removeAllItems();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Shape shape = (Shape)ShapeClass.parseShape(line);
                shapes.add(shape);
                mini.shapesCombo.addItem(shape);
            }
            mini.repaint();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void save(){
        if (shapes.isEmpty()){
            JOptionPane.showMessageDialog(null, "No Shapes to save!");
            return;
        }

        File filename = selectFile();


        if (filename == null){
            return;
        }

        try (FileWriter writer = new FileWriter(filename.getAbsolutePath())) {
            for (Shape shape : shapes) {
                writer.write(shape.toString() + System.lineSeparator());
            }
            JOptionPane.showMessageDialog(null, "File Saved Successfully!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private File selectFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select location to save file");

        // Set the file chooser to SAVE mode
        fileChooser.setDialogType(JFileChooser.SAVE_DIALOG);

        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            // Get the selected file
            File fileName = fileChooser.getSelectedFile();

            // Print the chosen file's path (or save it in your application)
            System.out.println("File to save: " + fileName.getAbsolutePath());

            // If you want to enforce a file extension, you can do something like this:
            if (!fileName.getName().endsWith(".txt")) {
                fileName = new File(fileName.getAbsolutePath() + ".txt");
            }

            // Here you can write the logic to save the file
            System.out.println("Final file name: " + fileName.getAbsolutePath());
            return fileName;
        } else {
            System.out.println("Save command cancelled by user.");
            return null;
        }
    }

=======
>>>>>>> 514fa3b6efa627bb2f691fb6eb5f89bb64ff5c43
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


<<<<<<< HEAD

=======
>>>>>>> 514fa3b6efa627bb2f691fb6eb5f89bb64ff5c43
}
