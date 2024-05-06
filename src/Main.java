package test;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import area.Area;

public class Main{
    public static void main(String[] args){
        JFrame f = new JFrame("Test");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(new Dimension(400,400));
        f.setLocationRelativeTo(null);

        Area a = new Area();
        a.setBackground(Color.RED);

        f.getContentPane().add(a);

        f.setVisible(true);
    }
}