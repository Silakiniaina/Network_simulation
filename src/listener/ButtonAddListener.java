package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Vector;

import area.Form;

public class ButtonAddListener implements ActionListener{
    Form form;

    /* Constructor */
    public ButtonAddListener(Form f){
        this.setForm(f);
    }

    /* Override of the actionPerformed function to manage the creation of new Server */
    @Override
    public void actionPerformed(ActionEvent arg0) {
        if(!this.getForm().isOkay()){
            System.out.println("Please fill the IP input");
        }
        HashMap<String,Object> data = this.getForm().getValues();
        System.out.println(data.size());
        
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
