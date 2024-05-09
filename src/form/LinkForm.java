package form;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;

public class LinkForm extends JPanel{
    JSpinner inputPing;
    Point position;

    /* Constructor */
    public LinkForm(Point p){
        this.setInputPing(new JSpinner());
        this.initComponent(p);
    }

    /* init component */
    private void initComponent(Point p){
        this.setBounds((int)p.getX(), (int)p.getY(), 100, 70);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));

        /* Title */
        JLabel title = new JLabel("Ping");
        title.setPreferredSize(new Dimension(90,20));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("Sans Serif",Font.BOLD, 14));

        /* Input ping */
        this.getInputPing().setPreferredSize(new Dimension(90,20));

        /* Button add */
        JButton btn = new JButton("Link");
        btn.setPreferredSize(new Dimension(90,20));

        this.add(title);
        this.add(this.getInputPing());
        this.add(btn);
    }

    /* geting the ping values */
    public int getValues(){
        return (int)this.getInputPing().getValue();
    }
    /* Getters */
    public JSpinner getInputPing(){
        return this.inputPing;
    }

    /* Setters */
    public void setInputPing(JSpinner s){
        this.inputPing = s;
    }
}
