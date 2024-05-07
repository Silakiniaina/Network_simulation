package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
      Vector<String> data = this.getForm().getValues();
      System.out.println("Creation of new Server");
      for(int i=0; i<data.size(); i++){
        System.out.println("data"+i+" : "+data.get(i));
      }
        
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
