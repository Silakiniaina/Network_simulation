package area;

import javax.swing.JPanel;
import java.util.Vector;
import graphe.Server;
import listener.AreaListener;

public class Area extends JPanel{
    Vector<Server> listServer;

    /* Constructor */
    public Area(){
        this.setListServer(new Vector<Server>());
        this.setLayout(null);
        this.addMouseListener(new AreaListener(this));
    }

    /* Getters */
    public Vector<Server> getListServer(){
        return this.listServer;
    }

    /* Setter */
    public void setListServer(Vector<Server> ls){
        this.listServer = ls;
    }

    /* Adding new Server */
    public void addServer(Server s){
        this.getListServer().add(s);
        this.add(s);
        System.out.println("Adding server...");
        System.out.println("Size vector server : "+this.getListServer().size());
    }
}