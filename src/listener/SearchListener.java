package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import form.SearchForm;
import graphe.Server;

public class SearchListener implements ActionListener{
    SearchForm searchForm;

    /* Constructors */
    public SearchListener(SearchForm sf){
        this.setSearchForm(sf);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String siteToFind = this.getSearchForm().getValues();
        Vector<Server> res = this.getSearchForm().getFinder().getArea().findServersHaving(siteToFind);
        int idShortest = 0;
        int pathLength = Integer.MAX_VALUE;
        for(int i=0; i<res.size(); i++){
            Server s = res.get(i);
            ArrayList<Server> path = this.getSearchForm().getFinder().findShortestPath(s);
            if(Server.sumDistances(path) < pathLength){
                idShortest = i;
                pathLength = Server.sumDistances(path);
            }
        }
        
        ArrayList<Server> path = this.getSearchForm().getFinder().findShortestPath(res.get(idShortest));
        this.getSearchForm().getFinder().drawPath(path);
        this.getSearchForm().getFinder().getArea().update();
    }

    /* Getters */
    public SearchForm getSearchForm() {
        return searchForm;
    }

    /* Setters */
    public void setSearchForm(SearchForm searchForm) {
        this.searchForm = searchForm;
    }
}
