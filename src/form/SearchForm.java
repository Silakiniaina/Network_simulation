package form;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import graphe.Server;
import listener.SearchListener;

public class SearchForm extends JPanel{
    JTextField inputSite;
    Server finder;

    /* Constructors */
    public SearchForm(Server s){
        this.setFinder(s);
        initComponent();
    }
    
    /* Getting the values */
    public String getValues(){
        return this.getInputSite().getText();
    }

    /* init component */
    public void initComponent(){
        this.setBounds(20, 20, 100, 80);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));

        /* Title */
        JLabel title = new JLabel("Search");
        title.setPreferredSize(new Dimension(100,20));
        title.setFont(new Font("Sans Serif", Font.BOLD, 16));
        
        /* tInput for the site Name */
        JTextField input = new JTextField(10);
        this.setInputSite(input);
        this.getInputSite().setPreferredSize(new Dimension(100,20));
        
        /* Button search  */
        JButton btnSearch = new JButton("Search");
        btnSearch.addActionListener(new SearchListener(this));

        /* Adding all the components */
        this.add(title);
        this.add(this.getInputSite());
        this.add(btnSearch);
    }
    
    /* Getters */
    public JTextField getInputSite() {
        return inputSite;
    }
    public Server getFinder() {
        return finder;
    }
    
    /* Setters */
    public void setInputSite(JTextField inputSite) {
        this.inputSite = inputSite;
    }
    
    public void setFinder(Server finder) {
        this.finder = finder;
    }
    
}
