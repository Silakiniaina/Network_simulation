package listener;

import form.SearchForm;

public class SearchListener {
    SearchForm searchForm;

    /* Constructors */
    public SearchListener(SearchForm sf){
        this.setSearchForm(sf);
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
