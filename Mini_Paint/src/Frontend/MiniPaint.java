package Frontend;

import Backend.Engine;
import Interface.DrawingEngine;
import Interface.Shape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MiniPaint extends JFrame {

<<<<<<< HEAD
=======
    private JPanel panel;
>>>>>>> 514fa3b6efa627bb2f691fb6eb5f89bb64ff5c43
    private JButton circleButton;
    private JButton squareButton;
    private JButton recButton;
    private JButton lineButton;
    private JButton colorizeButton;
    private JButton deleteButton;
    public JComboBox<Shape> shapesCombo;
    private JLabel label;
<<<<<<< HEAD
    private Engine painter;
    private JButton resetButton;
    public JPanel drawPanel;
    private JButton resizebutton;
    private JButton move;
    private JButton save;
    private JButton load;



    public MiniPaint() {
        // Initialize JFrame
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(1200, 800));
        this.setTitle("Vector Drawing Application");
        this.setLayout(null); // Absolute positioning
        this.setBackground(Color.BLACK);

        // Initialize Engine
        painter = new Engine(this);

        // Add components directly to the JFrame
        addComponents();

        // Add the drawing panel
        addDrawPanel();

        // Finalize JFrame setup
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void addDrawPanel() {
        drawPanel = new JPanel() {
=======
    private JLabel label2;
    private Engine painter;
    private JButton resetButton;


    public MiniPaint() {
        // Initialize the panel with overridden paintComponent method
        panel = new JPanel() {
>>>>>>> 514fa3b6efa627bb2f691fb6eb5f89bb64ff5c43
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2D = (Graphics2D) g;
                g2D.setStroke(new BasicStroke(3));

<<<<<<< HEAD
                painter.refresh(g2D); // Draw shapes
            }
        };
        drawPanel.setBackground(Color.WHITE);
        drawPanel.setBounds(270, 140, 1000, 600); // Position and size of the drawing panel
        this.add(drawPanel);
    }

    private void addComponents() {
        // Initialize Engine with this JFrame (MiniPaint)
        //painter = new Engine(this);
=======
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
>>>>>>> 514fa3b6efa627bb2f691fb6eb5f89bb64ff5c43

        // Set up buttons
        circleButton = createButton("Circle", 420, 100, 150, 33);
        squareButton = createButton("Square", 620, 100, 150, 33);
        recButton = createButton("Rectangle", 820, 100, 150, 33);
        lineButton = createButton("Line", 1020, 100, 150, 33);
        colorizeButton = createButton("Colorize", 33, 450, 100, 33);
        deleteButton = createButton("Delete", 150, 450, 100, 33);
<<<<<<< HEAD
        resizebutton = createButton("Resize", 33, 490, 100, 33);
        move = createButton("Move", 150, 490, 100, 33);
        resetButton = createButton("Reset", 33, 600, 217, 33);
        save = createButton("Save", 33, 200, 100, 33);
        load = createButton("Load", 150, 200, 100, 33);

=======
        resetButton = createButton("Reset", 33, 600, 217, 33);
>>>>>>> 514fa3b6efa627bb2f691fb6eb5f89bb64ff5c43


        // Add combo box and label for shape selection
        shapesCombo = new JComboBox<>();
        shapesCombo.setBounds(33, 400, 217, 30);
<<<<<<< HEAD
        this.add(shapesCombo);

        label = new JLabel("Select Shape");
        label.setBounds(40, 370, 100, 30);
        this.add(label);

        // Add action listeners
        addActionListeners();
    }

    private void addActionListeners() {
        circleButton.addActionListener(e -> painter.drawCircle());
        squareButton.addActionListener(e -> painter.drawSquare());
        recButton.addActionListener(e -> painter.drawRect());
        lineButton.addActionListener(e -> painter.drawLine());
        colorizeButton.addActionListener(e -> painter.colorize());
        resizebutton.addActionListener(e -> painter.resize());
        move.addActionListener(e -> painter.move());
        save.addActionListener(e -> painter.save2());
        load.addActionListener(e -> painter.load2());
        deleteButton.addActionListener(e -> {
            Shape selectedShape = (Shape) shapesCombo.getSelectedItem();

            if (selectedShape == null) {
                JOptionPane.showMessageDialog(null, "No shape selected!");
                return;
            }

            painter.removeShape(selectedShape);
            shapesCombo.removeItem(selectedShape);
        });

        resetButton.addActionListener(e -> {
            painter.clearShapes();
            drawPanel.repaint(); // Clear the drawing area
        });
    }
=======
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

>>>>>>> 514fa3b6efa627bb2f691fb6eb5f89bb64ff5c43
    private JButton createButton(String text, int x, int y, int w, int h) {
        JButton button = new JButton(text);
        button.setFocusable(false);
        button.setBounds(x, y, w, h);
        button.setBackground(new Color(0,0,0));
        button.setForeground(new Color(255,255,255));
<<<<<<< HEAD
        this.add(button);
=======
        panel.add(button);
>>>>>>> 514fa3b6efa627bb2f691fb6eb5f89bb64ff5c43
        return button;
    }

    public static void main(String[] args) {
        new MiniPaint();
    }
}
