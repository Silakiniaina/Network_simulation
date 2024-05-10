package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import form.SearchForm;

public class SearchListener implements ActionListener{
    SearchForm searchForm;

    /* Constructors */
    public SearchListener(SearchForm sf){
        this.setSearchForm(sf);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String ip = this.getSearchForm().getFinder().getIpAdress();
        System.out.println("Find : "+ip);
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
