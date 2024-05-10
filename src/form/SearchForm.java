package form;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SearchForm extends JPanel{
    JTextField inputSite;

    /* Constructors */
    public SearchForm(){
        initComponent();
    }

    /* Getting the values */
    public String getValues(){
        return this.getInputSite().getText();
    }

    /* init component */
    public void initComponent(){
        this.setBounds(20, 20, 100, 50);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

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
    }

    /* Getters */
    public JTextField getInputSite() {
        return inputSite;
    }

    /* Setters */
    public void setInputSite(JTextField inputSite) {
        this.inputSite = inputSite;
    }
    
}
