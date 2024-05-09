package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import form.LinkForm;
import graphe.Link;
import graphe.Server;

public class LinkFormListener implements ActionListener{
    LinkForm linkForm;

    /* Constructor */
    public LinkFormListener(LinkForm ls){
        this.setLinkForm(ls);
    }

    /* Manage the event when clicking to the button add  */
    
        @Override
        public void actionPerformed(ActionEvent e) {
            Server clicked = this.getLinkForm().getClickedServer();
            Server inSeek = clicked.getArea().getServerSeeking();
            int ping  = this.getLinkForm().getValues();
            Link l = new Link(inSeek, clicked, ping);
            clicked.getArea().addLink(l);
            clicked.getArea().update();
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
