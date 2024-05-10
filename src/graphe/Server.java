package graphe;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import area.Area;
import java.awt.Color;

public class Server extends JPanel {
    Point position;
    String ipAdress;
    Vector<String> listSites;
    Area area;
    private boolean isFocused;
    private boolean isInChoice;
    private int distance;
    private boolean isPath;

    // Constructor
    public Server() {

    }

    public Server(Point p, String ip, Vector<String> sites) {
        this.setIpAdress(ip);
        this.setListSites(sites);
        this.setPosition(p);
        int x = (int) this.getPosition().getX();
        int y = (int) this.getPosition().getY();
        this.setBounds(x - 60, y - 60, 60, 60);
        this.draw();
    }

    /* Remove all path */
    public void removeAllPath(){
        Vector<Link> links = this.getArea().getLinks();
        for(Server s : this.getArea().getListServer()){
            s.setIsPath(false);
        }
        for(Link l : links){
                l.setIsPath(false);
        }
        this.getArea().update();
    }

    /* Draw the path */
    public void drawPath(ArrayList<Server> ls) {
        this.removeAllPath();
        Vector<Link> links = this.getArea().getLinks();
        Server source = ls.get(0);
        source.setIsPath(true);
        for(int i=1; i<ls.size(); i++){
            ls.get(i).setIsPath(true);
            for(Link l : links){
                if((l.getSource().equals(source) && l.getTarget().equals(ls.get(i))) || (l.getSource().equals(ls.get(i)) && l.getTarget().equals(source))){
                    l.setIsPath(true);
                    source = ls.get(i);
                }
            }
        }
        
    }

    /* Finding the shortest way to a server */
    public ArrayList<Server> findShortestPath(Server target) {
        // Initialize distances and previous nodes
        Map<Server, Integer> distances = new HashMap<>();
        Map<Server, Server> previous = new HashMap<>();
        PriorityQueue<Server> queue = new PriorityQueue<>(Comparator.comparingInt(distances::get));

        for (Server server : this.getArea().getListServer()) {
            distances.put(server, server == this ? 0 : Integer.MAX_VALUE);
            server.setDistance(server == this ? 0 : Integer.MAX_VALUE);
            queue.add(server);
        }

        while (!queue.isEmpty()) {
            Server current = queue.poll();
            if (current == target) {
                break; // Found the target server
            }

            for (Link link : current.getLinks()) {
                Server neighbor = link.getOtherServer(current);
                int distanceThroughCurrent = distances.get(current) + link.getPing();

                if (distanceThroughCurrent < distances.get(neighbor)) {
                    distances.put(neighbor, distanceThroughCurrent);
                    neighbor.setDistance(distanceThroughCurrent);
                    previous.put(neighbor, current);
                    queue.remove(neighbor); // Re-add to update priority
                    queue.add(neighbor);
                }
            }
        }

        // Build the path from target to source
        ArrayList<Server> path = new ArrayList<>();
        Server current = target;
        while (current != null) {
            path.add(current);
            current = previous.get(current);
        }
        Collections.reverse(path);

        return path;
    }

    /* sum the distance of the paht */
    public static int sumDistances(ArrayList<Server> ls){
        int sum = 0; 
        String str = "Sum : ";
        for(Server s : ls){
            sum += s.getDistance();
            str += s.getDistance()+" + ";
        }
        System.out.println(str);
        return sum;
    }

    /* Getting all the links of a server */
    public Vector<Link> getLinks() {
        Vector<Link> result = new Vector<Link>();
        Vector<Link> ls = this.getArea().getLinks();
        for (Link l : ls) {
            if (l.getSource().equals(this) || l.getTarget().equals(this)) {
                result.add(l);
            }
        }
        return result;
    }

    /* Check if this server has no link with the server in argument */
    public boolean isLinkedWith(Server s) {
        boolean result = false;
        if (!s.equals(this)) {
            Vector<Link> ls = this.getArea().getLinks();
            for (Link l : ls) {
                if ((l.getSource().equals(this) && l.getTarget().equals(s))
                        || (l.getSource().equals(s) && l.getTarget().equals(this))) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    // Draw a server
    public void draw() {
        /* Highlight the server to blue per default */
        Color borderColor = Color.BLUE;
        /* Highlight the server to green when another server is seeking to link */
        if (this.isInChoice)
            borderColor = Color.GREEN;
        /* Highlight the server to red when it's focused */
        else if (this.isFocused && !this.isInChoice())
            borderColor = Color.RED;
        this.setBorder(BorderFactory.createLineBorder(borderColor, 3, true));
        if(this.getIsPath()){
            this.setBackground(Color.RED);
        }else{
            this.setBackground(Color.LIGHT_GRAY);
        }
    }

    /* Find a server to link with */
    public void findServerToLink() {
        Vector<Server> ls = this.getArea().getListServer();
        for (Server s : ls) {
            if (!s.equals(this) && !this.isLinkedWith(s)) {
                s.setInChoice(true);
            }
        }
        this.getArea().repaint();
    }

    /* find the middle middle point between two server */
    public Point getMiddlePoint(Server s) {
        int x1 = (int) this.getPosition().getX();
        int y1 = (int) this.getPosition().getY();
        int x2 = (int) s.getPosition().getX();
        int y2 = (int) s.getPosition().getY();

        return new Point((int) ((x1 + x2) / 2), (int) ((y1 + y2) / 2));
    }

    // Getters
    public String getIpAdress() {
        return this.ipAdress;
    }

    public Vector<String> getListSites() {
        return this.listSites;
    }

    public Point getPosition() {
        return this.position;
    }

    public Area getArea() {
        return this.area;
    }

    public boolean isFocused() {
        return this.isFocused;
    }

    public boolean isInChoice() {
        return this.isInChoice;
    }

    public int getDistance() {
        return this.distance;
    }

    public boolean getIsPath(){
        return this.isPath;
    }

    // Setters
    public void setIpAdress(String newIp) {
        this.ipAdress = newIp;
    }

    public void setListSites(Vector<String> list) {
        this.listSites = list;
    }

    public void setPosition(Point p) {
        this.position = p;
    }

    public void setArea(Area a) {
        this.area = a;
    }

    public void setFocused(boolean b) {
        this.isFocused = b;
    }

    public void setInChoice(boolean b) {
        this.isInChoice = b;
    }

    public void setDistance(int d) {
        this.distance = d;
    }

    public void setIsPath(boolean b){
        this.isPath = b;
    }

    // Add new sites
    public void addSites(String siteName) {
        this.getListSites().add(siteName);
    }
}