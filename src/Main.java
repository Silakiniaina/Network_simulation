package test;

import javax.swing.JFrame;
import java.awt.*;
import area.Form;

public class Main{
    public static void main(String[] args){
        JFrame f = new JFrame("Test");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(new Dimension(400,400));
        f.setLocationRelativeTo(null);
        f.getContentPane().setLayout(null);

        Point p = new Point(0,0);
        Form g = new Form(p);

        f.getContentPane().add(g);

        f.setVisible(true);
    }
}