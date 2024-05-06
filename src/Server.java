package graphe; 

import java.awt.Point;
import java.util.Vector;
import javax.swing.JPanel;
import java.awt.Graphics2d;
import java.awt.Graphics;
import java.awt.Color;

public class Server extends JPanel{
    Point position;
    String ipAdress;
    Vector<String> listSites;

    //Constructor
    public Server(){ 

    }
    public Server(String ip, Vector<String> sites){
        this.setIpAdress(ip);
        this.setListSites(sites);
    }

    // Draw a server
    public void draw(Graphics g){
        g.setColor(Color.BLUE);
        int x = (int)this.getPosition().getX();
        int y = (int)this.getPosition().getY();
        g.fillRect(x,y,100,100);
    }

    // Getters
    public String getIpAdress(){
        return this.ipAdress;
    } 
    public Vector<String> getListSites(){
        return this.listSites;
    }
    public Point getPosition(){
        return this.position;
    }

    // Setters
    public void setIpAdress(String newIp){
        this.ipAdress = newIp;
    }
    public void setListSites(Vector<String> list){
        this.listSites = list;
    }
    public void setPosition(Point p){
        this.position = p;
    }

    // Add new sites
    public void addSites(String siteName){
        this.getListSites().add(siteName);
    }
}