package graphe; 

import javax.swing.Server;
import java.awt.Point;

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