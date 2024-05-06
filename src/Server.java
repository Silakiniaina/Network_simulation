package graphe; 

import javax.swing.Server;

public class Server extends JPanel{
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

    // Setters
    public void setIpAdress(String newIp){
        this.ipAdress = newIp;
    }
    public void setListSites(Vector<String> list){
        this.listSites = list;
    }

    // Add new sites
    public void addSites(String siteName){
        this.getListSites().add(siteName);
    }
}