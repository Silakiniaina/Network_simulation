package test;

import java.awt.List;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Vector;

import area.Area;
import graphe.Link;
import graphe.Server;

public class Test {
    public static void main(String[] args) {
        /* Points */
        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, 1);
        Point p3 = new Point(2, 2);
        Point p4 = new Point(3, 3);

        /* Servers */
        Server s1 = new Server(p1, "1", null);
        Server s2 = new Server(p2, "2", null);
        Server s3 = new Server(p3, "3", null);
        Server s4 = new Server(p4, "4", null);

        Vector<Server> servers = new Vector<Server>();
        servers.add(s1);
        servers.add(s2);
        servers.add(s3);
        servers.add(s4);

        /* Links */
        Link l1 = new Link(s1,s2,1);
        Link l2 = new Link(s2,s3,1);
        Link l3 = new Link(s3,s4,9);
        Link l5 = new Link(s1,s3,5);
        Link l6 = new Link(s2,s4,5);

        Vector<Link> links = new Vector<Link>();
        links.add(l1);
        links.add(l2);
        links.add(l3);
        links.add(l5);
        links.add(l6);

        Area a =  new Area();
        for(int i=0; i<servers.size(); i++){
            a.addServer(servers.get(i));
            servers.get(i).setArea(a);
        }
        a.setLinks(links);

        ArrayList<Server> path = (ArrayList)s4.findShortestPath(s1);
        for(int i=0; i<path.size(); i++){
            System.out.println(path.get(i).getIpAdress()+">>>");
        }

    }
}
