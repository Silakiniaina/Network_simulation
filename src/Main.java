package test;

import javax.swing.JFrame;
import java.awt.*;
import area.Area;

public class Main{
    public static void main(String[] args){
        JFrame f = new JFrame("Test");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(new Dimension(500,500));
        f.setLocationRelativeTo(null);
        // f.getContentPane().setLayout(null);

        Area a = new Area();

        f.getContentPane().add(a);

        f.setVisible(true);
    }
}