package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import form.SearchForm;
import form.ServerMenu;
import graphe.Server;

public class ServerMenuListener implements ActionListener{
    ServerMenu serverMenu;

    
    /* Constructors */
    public ServerMenuListener(ServerMenu s){
        this.setServerMenu(s);
    }
    /* Managing the event when the button Link or Delete is clicked */
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btnClicked = (JButton)e.getSource();
        String btnLabel = btnClicked.getText();
        if(btnLabel.toLowerCase().equals("link")){
            this.getServerMenu().getServer().findServerToLink();
            this.getServerMenu().getServer().getArea().setServerSeeking(this.getServerMenu().getServer());
        }else if(btnLabel.toLowerCase().equals("search")){
            Server finder = this.getServerMenu().getServer();
            finder.getArea().setSearchForm(new SearchForm(finder));
            finder.getArea().update();
        }     
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