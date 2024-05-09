package listener;

import java.awt.event.ActionListener;

import form.LinkForm;

public class LinkFormListener implements ActionListener{
    LinkForm linkForm;

    /* Constructor */
    public LinkFormListener(LinkForm ls){
        this.setLinkForm(ls);
    }
    
    /* Getters */
    public LinkForm getLinkForm() {
        return linkForm;
    }

    /* Setters */
    public void setLinkForm(LinkForm linkForm) {
        this.linkForm = linkForm;
    }
}
