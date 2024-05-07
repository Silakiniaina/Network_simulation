package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Vector;

import form.ServerForm;
import graphe.Server;

public class ButtonAddListener implements ActionListener{
    ServerForm form;

    /* Constructor */
    public ButtonAddListener(ServerForm f){
        this.setForm(f);
    }

    /* Override of the actionPerformed function to manage the creation of new Server */
    @Override
    public void actionPerformed(ActionEvent arg0) {
        if(!this.getForm().isOkay()){
            System.out.println("Please fill the IP input");
        }else{
            HashMap<String,Object> data = this.getForm().getValues();
            Server s = new Server(this.getForm().getPosition(),(String)data.get("ip"), (Vector<String>)data.get("sites"));
            s.setArea(this.getForm().getArea());
            this.getForm().getArea().addServer(s);
            this.getForm().hide();
            this.getForm().getArea().revalidate();
            this.getForm().getArea().repaint();
        }
    }

    /* Getters */
    public ServerForm getForm(){
        return this.form;
    }

    /* Setters */
    public void setForm(ServerForm f){
        this.form = f;
    }

}
