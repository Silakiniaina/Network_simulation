package listener;

import java.awt.event.*;
import java.util.Vector;

import form.ServerMenu;
import graphe.Server;

public class ServerListener implements MouseListener{
    Vector<Server> listServers;
    ServerMenu serverMenu;

    /* Constructors */
    public ServerListener(){
        this.setListServer(new Vector<Server>());
    }
    
    /* Managing the event when clicking to a server */
    @Override
    public void mouseClicked(MouseEvent e) {
        Server clicked = (Server)e.getComponent();
        for(Server s : this.getListServer()){
            if(s.equals(clicked)){
                if(this.getServerMenu() == null){
                    this.setServerMenu(new ServerMenu(s));
                    s.getArea().add(this.getServerMenu());
                }else{
                    // s.getArea().remove(this.getServerMenu());
                    this.getServerMenu().setServer(s);
                }
                s.getArea().update();

            }
        }
    }

    /* Getters */
    public Vector<Server> getListServer() {
        return listServers;
    }
    public ServerMenu getServerMenu(){
        return this.serverMenu;
    }
    
    /* Setters */
    public void setListServer(Vector<Server> ls) {
        this.listServers = ls;
    }
    public void setServerMenu(ServerMenu s){
        this.serverMenu = s;
    }

    /* Adding a server */
    public void addServer(Server s){
        this.getListServer().add(s);
    }


    @Override
    public void mouseEntered(MouseEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        // TODO Auto-generated method stub
        
    }
}