package listener;

import java.awt.*;
import area.*;
import form.ServerForm;
import form.ServerMenu;

import java.awt.event.*;

public class AreaListener implements MouseListener{
    Area area;
    ServerForm form;

    /* Constructor */
    public AreaListener(Area a){
        this.setArea(a);
        Point p = new Point(-1000,-1000);
        ServerForm f = new ServerForm(p);
        f.setArea(a);
        this.setForm(f);
    }

    /* Overrides for managing the form event */
    public void mouseClicked(MouseEvent e){
        Point p = e.getPoint();
        if(e.getButton() == MouseEvent.BUTTON3){
            this.getForm().setPosition(p);
            this.getForm().update();
            this.getArea().add(this.getForm());
        }else if(e.getButton() == MouseEvent.BUTTON1){
            this.getForm().hide();
            ServerMenu s = this.getArea().getServerMenu();
            if(s != null)s.hide();
            this.getArea().clearFocus();
        }
        this.getArea().update();
    }

    
    /* Getters */
    public Area getArea(){
        return this.area;
    }
    public ServerForm getForm(){
        return this.form;
    }

    /* Setters */
    public void setArea(Area a){
        this.area = a;
    }
    public void setForm(ServerForm f){
        this.form = f;
    }

    public void mouseEntered(MouseEvent e){
        
    }
    public void mouseExited(MouseEvent e){
        
    }
    public void mousePressed(MouseEvent e){
        
    }
    public void mouseReleased(MouseEvent e){
        
    }
}