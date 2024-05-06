package listener;

import java.awt.*;
import area.*;
import java.awt.event.*;

public class AreaListener implements MouseListener{
    Area area;

    /* Constructor */
    public AreaListener(Area a){
        this.setArea(a);
    }

    /* Overrides */
    public void mouseClicked(MouseEvent e){
        Point p = e.getPoint();
        System.out.println("Clicked on : x="+p.getX()+" , y="+p.getY());
        Form f = new Form(p);
        this.getArea().add(f);
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

    /* Setters */
    public void setArea(Area a){
        this.area = a;
    }
}