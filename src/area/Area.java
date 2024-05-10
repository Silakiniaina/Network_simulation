package area;

import javax.swing.JPanel;

import form.LinkForm;
import form.SearchForm;
import form.ServerMenu;

import java.awt.Component;
import java.awt.Graphics;
import java.util.Vector;

import graphe.Link;
import graphe.Server;
import listener.AreaListener;
import listener.ServerListener;

public class Area extends JPanel{
    Vector<Server> listServer;
    ServerListener serverListener;
    Server serverSeeking;
    Vector<Link> links;
    LinkForm linkForm;
    private SearchForm searchForm;

    /* Constructor */
    public Area(){
        this.setListServer(new Vector<Server>());
        this.setLayout(null);
        this.addMouseListener(new AreaListener(this));
        this.setServerListener(new ServerListener());
        this.setLinks(new Vector<Link>());
        this.setSearchForm(null);
    }

    /* Finding a server having a site */
    public Vector<Server> findServersHaving(String site){
        Vector<Server> result = new Vector<Server>();
        for(Server s : this.getListServer()){
            for(String str : s.getListSites()){
                if(str.equals(site)){
                    result.add(s);
                    break;
                }
            }
        }
        return result;
    }

    /* remove focus to all servers */
    public void clearAllServerFocus(){
        for(Server s : this.getListServer()){
            s.setFocused(false);
        }
    }
    
    /* Clear focus */
    public void clearFocus(){
        this.setServerSeeking(null);
        for(Server s : this.getListServer()){
            s.setInChoice(false);
            s.setFocused(false);
        }
        if(this.getLinkForm() != null){
            this.remove(this.getLinkForm());
        }
    }
    
    /* updating all the components in the area */
    public void update(){
        this.revalidate();
        this.repaint();
    }
    
    /* Getters */
    public Vector<Server> getListServer(){
        return this.listServer;
    }
    public ServerListener getServerListener(){
        return this.serverListener;
    }
    public ServerMenu getServerMenu(){
        ServerMenu result = null;
        Component[] lsComponents = this.getComponents();
        for (Component c : lsComponents){
            if(c instanceof ServerMenu){
                result = (ServerMenu)c;
                break;
            }
        }
        return result;
    }
    public Server getServerSeeking(){
        return this.serverSeeking;
    }
    public Vector<Link> getLinks(){
        return this.links;
    }
    public LinkForm getLinkForm(){
        return this.linkForm;
    }
    public SearchForm getSearchForm(){
        return this.searchForm;
    }

    /* Setter */
    public void setListServer(Vector<Server> ls){
        this.listServer = ls;
    }
    public void setServerListener(ServerListener sl){
        this.serverListener = sl;
    }
    public void setServerSeeking(Server s){
        this.serverSeeking = s;
    }
    public void setLinks(Vector<Link> ls){
        this.links = ls;
    }
    public void setLinkForm(LinkForm lf){
        if(this.getLinkForm() != null){
            this.remove(this.getLinkForm());
        }
        this.linkForm = lf;
        this.add(this.getLinkForm());
    }
    public void setSearchForm(SearchForm sf){
        if(this.getSearchForm() != null){
            this.remove(this.getSearchForm());
        }
        this.searchForm = sf;
        if(this.getSearchForm() != null){
            this.add(this.getSearchForm());
        }
    }

    /* Adding new Server */
    public void addServer(Server s){
        s.addMouseListener(this.getServerListener());
        this.getServerListener().addServer(s);
        this.getListServer().add(s);
        this.add(s);
    }

    /* Add new link */
    public void addLink(Link l){
        this.getLinks().add(l);
        this.add(l);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        /* Drawing all the servers */
        for(Server s : this.getListServer()){
            s.draw();
        }

        /* Drawing all the links */
        for(Link l : this.getLinks()){
            l.draw(g);
        }
    }

    /* override paint function */
}