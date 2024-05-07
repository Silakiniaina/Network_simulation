package form;

import javax.swing.JButton;
import javax.swing.JPanel;

import graphe.Server;

public class ServerMenu extends JPanel{
    JButton buttonLink;
    JButton buttonDelete;
    Server server;
    
    /* Constructors */
    public ServerMenu(Server s){
        this.setServer(s);
    }
    
    /* Getters */
    public JButton getButtonLink() {
        return buttonLink;
    }
    public JButton getButtonDelete() {
        return buttonDelete;
    }
    public Server getServer(){
        return this.server;
    }
    
    /* Setters */
    public void setButtonLink(JButton buttonLink) {
        this.buttonLink = buttonLink;
    }
    public void setButtonDelete(JButton buttonDelete) {
        this.buttonDelete = buttonDelete;
    }
    public void setServer(Server s){
        this.server = s;
    }
}
