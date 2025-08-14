package Frontend;

import javax.swing.*;
import java.awt.*;

public class Paint extends JFrame {


    private JPanel panel1;
    private JButton button2;
    private JButton button4;
    private JButton button6;
    private JButton button1;
    private JComboBox comboBox1;
    private JButton button3;
    private JButton button5;

   Paint(){

       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setSize(500, 500);
       this.setLocationRelativeTo(null);
       this.setVisible(true);
   }

   static public void main(String[] args){
       Paint paint = new Paint();
   }
}


