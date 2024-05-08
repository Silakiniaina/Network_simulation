package listener;

import java.awt.event.ActionListener;

import form.ServerMenu;

public class ServerMenuListener implements ActionListener{
    ServerMenu serverMenu;

    
    /* Constructors */
    public ServerMenuListener(ServerMenu s){
        this.setServerMenu(s);
    }
    /* Getters */
    public ServerMenu getServerMenu() {
        return serverMenu;
    }

    /* Setters */
    public void setServerMenu(ServerMenu serverMenu) {
        this.serverMenu = serverMenu;
    }
}