package Frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class open_window extends JDialog {
    private JPanel contentPane;
    private JButton buttonSameWindow;
    private JButton buttonNew;

    public open_window() {
        // Initialize contentPane with a null layout
        contentPane = new JPanel();
        contentPane.setLayout(null); // Absolute positioning
        setContentPane(contentPane);
        setModal(true);

        // Initialize buttons with proper positioning and size
        buttonSameWindow = createButton("This Window", 50, 30, 180, 40);
        buttonNew = createButton("New Window", 50, 80, 180, 40);

        // Set up button actions
        buttonSameWindow.addActionListener(e -> onSame());
        buttonNew.addActionListener(e -> onNew());

        // Handle window close action
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                JOptionPane.showMessageDialog(
                        null,
                        "Choose Window to load!",
                        "Action Required",
                        JOptionPane.WARNING_MESSAGE
                );
            }
        });

        // Add ESC key action to close the dialog
        contentPane.registerKeyboardAction(e -> onNew(),
                KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
                JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        // Set dialog properties
        setTitle("Open Window");
        setSize(300, 200);
        setLocationRelativeTo(null); // Center the dialog on screen
    }

    private void onSame() {
        // Close the current dialog
        dispose();
    }

    private void onNew() {
        // Open a new MiniPaint window (ensure MiniPaint is implemented)
        new MiniPaint().setVisible(true);
        dispose();
    }

    private JButton createButton(String text, int x, int y, int width, int height) {
        JButton button = new JButton(text);
        button.setFocusable(false);
        button.setBounds(x, y, width, height); // Position and size
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        contentPane.add(button); // Add to the panel
        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            open_window dialog = new open_window();
            dialog.setVisible(true);
            System.exit(0);
        });
    }
}
