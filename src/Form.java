package area;

import javax.swing.*;
import java.awt.*;

public class Form extends JPanel{
    JTextField inputeIp;
    JTextField inputSites;

    /* Constructors */
    public Form(Point position){
        this.setBackground(Color.WHITE);
        this.setBounds((int)position.getX(),(int)position.getY(),170,100);
        this.initComponent();
    }

    /* Init component */
    public void initComponent(){
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        Color c = Color.RED;
        this.setBackground(c);

        JPanel panel_ip = new JPanel();
        panel_ip.setLayout(new FlowLayout());
        JLabel label_ip = new JLabel("IP Adr :");
        this.setInputeIp(new JTextField(10));
        panel_ip.add(label_ip);
        panel_ip.add(this.getInputeIp());
        panel_ip.setBackground(c);

        JPanel panel_sites = new JPanel();
        panel_sites.setLayout(new FlowLayout());
        JLabel label_sites = new JLabel("Sites  : ");
        this.setInputSites(new JTextField(10));
        panel_sites.add(label_sites);
        panel_sites.add(this.getInputSites());
        panel_sites.setBackground(c);

        JButton btn = new JButton("Add");
        
        this.add(panel_ip);
        this.add(panel_sites);
        this.add(btn);
    }

    /* Getters */
    public JTextField getInputeIp(){
        return this.inputeIp;
    }
    public JTextField getInputSites(){
        return this.inputSites;
    }

    /* Setters */
    public void setInputeIp(JTextField t){
        this.inputeIp = t;
    }
    public void setInputSites(JTextField t){
        this.inputSites = t;
    }
}