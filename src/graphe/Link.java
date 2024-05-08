package graphe;

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
