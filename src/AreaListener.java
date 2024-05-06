package listener;

import java.awt.*;
import area.Area;
import java.awt.event.*;

public class AreaListener implements MouseListener{
    Area area;

    /* Constructor */
    public AreaListener(Area a){
        this.setArea(a);
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