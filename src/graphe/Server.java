package graphe; 

import java.awt.Point;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import java.awt.Color;

public class Server extends JPanel{
    Point position;
    String ipAdress;
    Vector<String> listSites;

    //Constructor
    public Server(){ 

    }
    public Server(Point p,String ip, Vector<String> sites){
        this.setIpAdress(ip);
        this.setListSites(sites);
        this.setPosition(p);
        int x = (int)this.getPosition().getX();
        int y = (int)this.getPosition().getY();
        this.setBounds(x - 60,y - 60,60,60);
        this.draw();
    }

    // Draw a server
    public void draw(){
        this.setBorder(BorderFactory.createLineBorder(Color.BLUE,3,true));
        this.setBackground(Color.LIGHT_GRAY);
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