package graphe; 

import java.awt.Point;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import area.Area;
import java.awt.Color;

public class Server extends JPanel{
    Point position;
    String ipAdress;
    Vector<String> listSites;
    Area area;
    private boolean isFocused;
    private boolean isInChoice;

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

    /* Check if this server has no link with the server in argument */
    public boolean isLinkedWith(Server s){
        boolean result = false;
        if(!s.equals(this)){
            Vector<Link> ls = this.getArea().getLinks();
            for(Link l : ls){
                if((l.getSource().equals(this) && l.getTarget().equals(s)) || (l.getSource().equals(s) && l.getTarget().equals(this))){
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
    // Draw a server
    public void draw(){
        /* Highlight the server to blue per default */
        Color borderColor = Color.BLUE;
        /* Highlight the server to green when another server is seeking to link */
        if(this.isInChoice)borderColor = Color.GREEN;
        /* Highlight the server to red when it's focused */
        else if(this.isFocused && !this.isInChoice())borderColor = Color.RED;
        this.setBorder(BorderFactory.createLineBorder(borderColor,3,true));
        this.setBackground(Color.LIGHT_GRAY);
    }

    /* Find a server to link with */
    public void findServerToLink(){
        Vector<Server> ls = this.getArea().getListServer();
        for(Server s : ls){
            if(!s.equals(this) && !this.isLinkedWith(s)){
                s.setInChoice(true);
            }
        }
        this.getArea().repaint();
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
    public Area getArea(){
        return this.area;
    }
    public boolean isFocused(){
        return this.isFocused;
    }
    public boolean isInChoice(){
        return this.isInChoice;
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
    public void setArea(Area a){
        this.area = a;
    }
    public void setFocused(boolean b){
        this.isFocused = b;
    }
    public void setInChoice(boolean b){
        this.isInChoice = b;
    }

    // Add new sites
    public void addSites(String siteName){
        this.getListSites().add(siteName);
    }
}