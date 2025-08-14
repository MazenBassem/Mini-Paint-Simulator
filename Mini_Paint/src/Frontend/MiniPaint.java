package Frontend;

import Backend.Engine;
import Interface.DrawingEngine;
import Interface.Shape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MiniPaint extends JFrame {

    private JPanel panel;
    private JButton circleButton;
    private JButton squareButton;
    private JButton recButton;
    private JButton lineButton;
    private JButton colorizeButton;
    private JButton deleteButton;
    public JComboBox<Shape> shapesCombo;
    private JLabel label;
    private JLabel label2;
    private Engine painter;
    private JButton resetButton;


    public MiniPaint() {
        // Initialize the panel with overridden paintComponent method
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2D = (Graphics2D) g;
                g2D.setStroke(new BasicStroke(3));

                painter.refresh(g2D);  // Use g2D directly for drawing shapes
            }
        };

        // Initialize Engine with this JFrame (MiniPaint)
        painter = new Engine(this);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(1200, 800));
        this.setTitle("Vector Drawing Application");

        // Add the panel to the JFrame and set the layout to null for absolute positioning
        panel.setLayout(null);
        this.add(panel);

        label2 = new JLabel();
        label2.setBackground(new Color(0x52534E));
        label2.setBounds(420,100,800,33);
        panel.add(label2);

        // Set up buttons
        circleButton = createButton("Circle", 420, 100, 150, 33);
        squareButton = createButton("Square", 620, 100, 150, 33);
        recButton = createButton("Rectangle", 820, 100, 150, 33);
        lineButton = createButton("Line", 1020, 100, 150, 33);
        colorizeButton = createButton("Colorize", 33, 450, 100, 33);
        deleteButton = createButton("Delete", 150, 450, 100, 33);
        resetButton = createButton("Reset", 33, 600, 217, 33);


        // Add combo box and label for shape selection
        shapesCombo = new JComboBox<>();
        shapesCombo.setBounds(33, 400, 217, 30);
        panel.add(shapesCombo);

        label = new JLabel("Select Shape");
        label.setBounds(40, 370, 100, 30);
        panel.add(label);


        // Button action listeners
        circleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                painter.drawCircle();
            }
        });

        recButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                painter.drawRect();
            }
        });

        lineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                painter.drawLine();
            }
        });

        squareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                painter.drawSquare();
            }
        });

        colorizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                painter.colorize();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                painter.removeShape((Shape) shapesCombo.getSelectedItem());
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shapesCombo.removeAllItems();
                for(Shape shape : painter.getShapes()){
                    painter.removeShape(shape);
                }
            }
        });

        // Pack, set location, and make visible
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private JButton createButton(String text, int x, int y, int w, int h) {
        JButton button = new JButton(text);
        button.setFocusable(false);
        button.setBounds(x, y, w, h);
        button.setBackground(new Color(0,0,0));
        button.setForeground(new Color(255,255,255));
        panel.add(button);
        return button;
    }

    public static void main(String[] args) {
        new MiniPaint();
    }
}
