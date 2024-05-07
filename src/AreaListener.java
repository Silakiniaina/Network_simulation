package listener;

import java.awt.*;
import area.*;
import java.awt.event.*;

import javax.swing.JButton;

public class AreaListener implements MouseListener{
    Area area;
    Form form;

    /* Constructor */
    public AreaListener(Area a){
        this.setArea(a);
        Point p = new Point(-1000,-1000);
        Form f = new Form(p);
        this.setForm(f);
    }

    /* Overrides */
    public void mouseClicked(MouseEvent e){
        Point p = e.getPoint();
        if(e.getButton() == MouseEvent.BUTTON3){
            System.out.println("Clicked RIGHT on : "+p.getX()+" , y="+p.getY());
            this.getForm().setPosition(p);
            this.getForm().update();
            this.getArea().add(this.getForm());
            this.getArea().revalidate();
        }else if(e.getButton() == MouseEvent.BUTTON1){
            System.out.println("Clicked LEFT on : "+p.getX()+" , y="+p.getY());
            this.getForm().hide();
        }
        this.getArea().revalidate();
    }

    public void mouseEntered(MouseEvent e){
        
    }
    public void mouseExited(MouseEvent e){
        
    }
    public void mousePressed(MouseEvent e){
        
    }
    public void mouseReleased(MouseEvent e){
        
    }

    /* Getters */
    public Area getArea(){
        return this.area;
    }
    public Form getForm(){
        return this.form;
    }

    /* Setters */
    public void setArea(Area a){
        this.area = a;
    }
    public void setForm(Form f){
        this.form = f;
    }
}