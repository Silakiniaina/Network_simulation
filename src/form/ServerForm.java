package form;

import javax.swing.*;

import area.Area;

import java.awt.*;
import java.util.HashMap;
import java.util.Vector;

import listener.ButtonAddListener;;

public class ServerForm extends JPanel{
    Area area;
    JTextField inputIp;
    JTextField inputSites;
    Point position;

    /* Constructors */
    public ServerForm(Point position){
        this.setPosition(position);
        this.setBackground(Color.WHITE);
        this.initComponent();
        this.update();
    }

    /* update the position of a form */
    public void update(){
        this.setBounds((int)this.getPosition().getX(),(int)this.getPosition().getY(),150,120);
        this.getInputIp().setText("");
        this.getInputSites().setText("");
    }

    /* Init component */
    private void initComponent(){
        this.setLayout(new FlowLayout());
        Color c = Color.WHITE;
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2,true));
        this.setBackground(c);

        /* Title */
        JLabel title = new JLabel("New Server");
        title.setFont(new Font("Sans Serif", Font.BOLD, 16));

        /* Input IP */
        JPanel panel_ip = new JPanel();
        panel_ip.setLayout(new FlowLayout(FlowLayout.LEFT,1,1));
        JLabel label_ip = new JLabel("IP Adr :");
        this.setInputIp(new JTextField(8));
        panel_ip.add(label_ip);
        panel_ip.add(this.getInputIp());
        panel_ip.setBackground(c);

        /* Input Sites */
        JPanel panel_sites = new JPanel();
        panel_sites.setLayout(new FlowLayout(FlowLayout.LEFT,1,1));
        JLabel label_sites = new JLabel("Sites  : ");
        this.setInputSites(new JTextField(8));
        panel_sites.add(label_sites);
        panel_sites.add(this.getInputSites());
        panel_sites.setBackground(c);

        /* Button */
        JButton btn = new JButton("Add");
        btn.addActionListener(new ButtonAddListener(this));
        
        this.add(title);
        this.add(panel_ip);
        this.add(panel_sites);
        this.add(btn);
    }

    /* Disappear the form */
    public void hide(){
        this.setPosition(new Point(-1000,-1000));
        this.update();
    }

    /* Fetching the entered data from the form */
    public HashMap<String,Object> getValues(){
        HashMap<String,Object> result = new HashMap<String,Object>();
        /* the IP */
        result.put("IP",this.getInputIp().getText());

        /* List of the sites */
        Vector<String> ls_sites = new Vector<String>();
        String sites = this.getInputSites().getText();
        String[] ls = sites.split(";");
        for(int i=0; i<ls.length; i++){
            ls_sites.add(ls[i]);
        }
        result.put("sites", ls_sites);

        return result;
    }

    /* Check if the form is valid (there is no empty input) */
    public boolean isOkay(){
        boolean result = true;
        String inputText = this.getInputIp().getText();
        if(inputText == null || inputText.trim().equalsIgnoreCase("")){
            result = false;
        }
        return result;
    }

    /* Getters */
    public JTextField getInputIp(){
        return this.inputIp;
    }
    public JTextField getInputSites(){
        return this.inputSites;
    }
    public Point getPosition(){
        return this.position;
    }
    public Area getArea(){
        return this.area;
    }

    /* Setters */
    public void setInputIp(JTextField t){
        this.inputIp = t;
    }
    public void setInputSites(JTextField t){
        this.inputSites = t;
    }
    public void setPosition(Point p){
        this.position = p;
    }
    public void setArea(Area a){
        this.area = a;
    }
}