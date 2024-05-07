package listener;

import java.awt.event.*;

import graphe.Server;

public class ServerListener implements MouseListener{
    Server server;

    /* Constructors */
    public ServerListener(Server s){
        this.setServer(s);
    }

    /* Getters */
    public Server getServer() {
        return server;
    }
    
    /* Setters */
    public void setServer(Server server) {
        this.server = server;
    }
}