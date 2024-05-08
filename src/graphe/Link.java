package graphe;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Link extends JPanel{
    Server source; 
    Server target;
    int ping;

    /* Constructors */
    public Link(Server source, Server target, int ping){
        this.setSource(source);
        this.setTarget(target);
        this.setPing(ping);
    }

    /* Draw link */
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.BLACK);
        int x1 = (int)this.getSource().getPosition().getX();
        int y1 = (int)this.getSource().getPosition().getY();
        int x2 = (int)this.getTarget().getPosition().getX();
        int y2= (int)this.getTarget().getPosition().getX();
        g2d.drawLine(x1, y1, x2, y2);
    }

    /* Getters */
    public Server getSource() {
        return source;
    }
    public Server getTarget() {
        return target;
    }
    public int getPing() {
        return ping;
    }

    /* Setters */
    public void setSource(Server source) {
        this.source = source;
    }
    public void setTarget(Server target) {
        this.target = target;
    }
    public void setPing(int ping) {
        this.ping = ping;
    }
}
