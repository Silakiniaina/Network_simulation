package area;

import javax.swing.JPanel;
import java.util.Vector;
import graphe.Server;
import listener.AreaListener;
import listener.ServerListener;

public class Area extends JPanel{
    Vector<Server> listServer;
    ServerListener serverListener;

    /* Constructor */
    public Area(){
        this.setListServer(new Vector<Server>());
        this.setLayout(null);
        this.addMouseListener(new AreaListener(this));
        this.setServerListener(new ServerListener());
    }

    /* Getters */
    public Vector<Server> getListServer(){
        return this.listServer;
    }
    public ServerListener getServerListener(){
        return this.serverListener;
    }

    /* Setter */
    public void setListServer(Vector<Server> ls){
        this.listServer = ls;
    }
    public void setServerListener(ServerListener sl){
        this.serverListener = sl;
    }

    /* Adding new Server */
    public void addServer(Server s){
        s.addMouseListener(this.getServerListener());
        this.getServerListener().addServer(s);
        this.getListServer().add(s);
        this.add(s);
    }
}