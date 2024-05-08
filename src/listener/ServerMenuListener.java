package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import form.ServerMenu;

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
            System.out.println("Btn LINK on Server IP : "+this.getServerMenu().getServer().getIpAdress());
        }else if(btnLabel.toLowerCase().equals("delete")){
            System.out.println("Btn DELETE on Server IP : "+this.getServerMenu().getServer().getIpAdress());
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