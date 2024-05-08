package area;

import javax.swing.JPanel;

import form.ServerMenu;

import java.awt.Component;
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
    
    /* updating all the components in the area */
    public void update(){
        this.revalidate();
        this.repaint();
    }
    
    /* Getters */
    public Vector<Server> getListServer(){
        return this.listServer;
    }
    public ServerListener getServerListener(){
        return this.serverListener;
    }
    public ServerMenu getServerMenu(){
        ServerMenu result = null;
        Component[] lsComponents = this.getComponents();
        for (Component c : lsComponents){
            if(c instanceof ServerMenu){
                result = (ServerMenu)c;
                break;
            }
        }
        return result;
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