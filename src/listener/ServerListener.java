package listener;

import java.awt.event.*;

import graphe.Server;

public class ServerListener implements MouseListener{
    Server server;

    /* Constructors */
    public ServerListener(Server s){
        this.setServer(s);
    }
    
    /* Managing the event when clicking to a server */
    @Override
    public void mouseClicked(MouseEvent arg0) {
        System.out.println("Clicked to a server");
    }

    /* Getters */
    public Server getServer() {
        return server;
    }
    
    /* Setters */
    public void setServer(Server server) {
        this.server = server;
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