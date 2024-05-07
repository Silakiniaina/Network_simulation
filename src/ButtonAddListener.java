package listener;

import java.awt.event.ActionListener;
import area.Form;

public class ButtonAddListener implements ActionListener{
    Form form;

    /* Constructor */
    public ButtonAddListener(Form f){
        this.setForm(f);
    }

    /* Getters */
    public Form getForm(){
        return this.form;
    }

    /* Setters */
    public void setForm(Form f){
        this.form = f;
    }
}
