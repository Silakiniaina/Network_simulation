package form;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import graphe.Server;

public class ServerMenu extends JPanel{
    JButton buttonLink;
    JButton buttonDelete;
    Server server;
    
    /* Constructors */
    public ServerMenu(Server s){
        this.setServer(s);
        this.initComponent();
    }

    /* update the position of the serverMenu */
    public void update(){
        /* Location */
        int x = (int)this.getServer().getPosition().getX();
        int y = (int)this.getServer().getPosition().getY();
        this.setBounds(x - 185, y - 90, 120, 90);
    }
    /* Get the form of the menu */
    private void initComponent(){
        /* Layout  */
        this.setLayout(null);
        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));

        /* Title */
        JLabel title = new JLabel("Server Menu");
        title.setBounds(5, 0, 110, 20);
        title.setFont(new Font("Sans serif", Font.BOLD, 16));

        /* Button link */
        this.setButtonLink(new JButton("Link"));
        this.getButtonLink().setBackground(Color.BLUE);
        this.getButtonLink().setOpaque(true);
        this.getButtonLink().setBounds(5, 22, 110, 30);
        
        /* Button remove */
        this.setButtonDelete(new JButton("Delete"));
        this.getButtonDelete().setBackground(Color.RED);
        this.getButtonDelete().setBounds(5, 55, 110, 30);
        
        this.update();

        /* Adding child */
        this.add(title);
        this.add(this.getButtonLink());
        this.add(this.getButtonDelete());
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
        this.update();
    }
}
