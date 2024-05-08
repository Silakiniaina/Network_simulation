package area;

import javax.swing.JPanel;

import form.ServerMenu;

import java.awt.Component;
import java.awt.Graphics;
import java.util.Vector;

import graphe.Link;
import graphe.Server;
import listener.AreaListener;
import listener.ServerListener;

public class Area extends JPanel{
    Vector<Server> listServer;
    ServerListener serverListener;
    Server serverSeeking;
    Vector<Link> links;

    /* Constructor */
    public Area(){
        this.setListServer(new Vector<Server>());
        this.setLayout(null);
        this.addMouseListener(new AreaListener(this));
        this.setServerListener(new ServerListener());
        this.setLinks(new Vector<Link>());
    }

    /* Clear focus */
    public void clearFocus(){
        this.setServerSeeking(null);
        for(Server s : this.getListServer()){
            s.setInChoice(false);
        }
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
    public Server getServerSeeking(){
        return this.serverSeeking;
    }
    public Vector<Link> getLinks(){
        return this.links;
    }

    /* Setter */
    public void setListServer(Vector<Server> ls){
        this.listServer = ls;
    }
    public void setServerListener(ServerListener sl){
        this.serverListener = sl;
    }
    public void setServerSeeking(Server s){
        this.serverSeeking = s;
    }
    public void setLinks(Vector<Link> ls){
        this.links = ls;
    }

    /* Adding new Server */
    public void addServer(Server s){
        s.addMouseListener(this.getServerListener());
        this.getServerListener().addServer(s);
        this.getListServer().add(s);
        this.add(s);
    }

    /* Add new link */
    public void addLink(Link l){
        this.getLinks().add(l);
        this.add(l);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        /* Drawing all the servers */
        for(Server s : this.getListServer()){
            s.draw();
        }

        /* Drawing all the links */
        for(Link l : this.getLinks()){
            l.draw(g);
        }
    }

    /* override paint function */
}