import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Test1 extends JFrame {
	
	
    JButton Abutton; // Main Clicking Button   
    JButton Bbutton; // Button to purchase upgrades
    JButton Cbutton; // Button used to upgrade clicks per clicks
    JButton Dbutton;
    
    JLabel Alabel; // Label to display Clicks
    JLabel Blabel; // Label to display CPS
    

    int clicks = 0;
    
    int clickspersecond = 0;
    int buttonprice = 10;
    
    int clicksperclick = 1;
    int clicksprice = 15;
    
    Timer timer;

    public Test1() {
        // Set frame properties
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        // Panel for center components (click counter and CPS)
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Margin around components

        // Initialize button and labels
        Abutton = new JButton("Click me!");
        Bbutton = new JButton("Upgrade CPS, Price: " + buttonprice);
        
        Cbutton = new JButton("Increase Clicks per Click, Current price: " + clicksprice);
        
        Blabel = new JLabel("CPS: " + clickspersecond);
        Alabel = new JLabel("Number Of Clicks: 0");

        // Set up center layout (click counter + CPS label + click button)
        gbc.gridx = 0; gbc.gridy = 0; // Row 0, column 0
        centerPanel.add(Alabel, gbc);

        gbc.gridx = 1; gbc.gridy = 0; // Row 0, column 1
        centerPanel.add(Blabel, gbc);

        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 2; // Row 1, spans two columns
        centerPanel.add(Abutton, gbc);

        this.add(centerPanel, BorderLayout.CENTER); // Center the panel in the middle of the window

        // Panel for the right-side menu (Upgrade button and Clicksperclick Button)
        JPanel topRightPanel = new JPanel();
        topRightPanel.setLayout(new BoxLayout(topRightPanel, BoxLayout.Y_AXIS)); // Vertical layout

        JPanel upgradePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        upgradePanel.add(Bbutton);

        JPanel newButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        newButtonPanel.add(Cbutton);
        

        topRightPanel.add(upgradePanel);
        topRightPanel.add(newButtonPanel);

        // Add the topRightPanel to the top
        this.add(topRightPanel, BorderLayout.NORTH);

        // Add action listener to the buttons
        Abutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clicks += clicksperclick;
                Alabel.setText("Number Of Clicks: " + clicks);
            }
        });

        Bbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (clicks >= buttonprice) {
                    clicks -= buttonprice;
                    buttonprice *= 1.1;
                    clickspersecond += 1;
                    
                    Bbutton.setText("Upgrade CPS, Price: " + buttonprice);
                    Blabel.setText("CPS: " + clickspersecond);
                } else {
                    JOptionPane.showMessageDialog(null, "Not enough clicks!");
                }
                Alabel.setText("Number Of Clicks: " + clicks); // Update label to display proper amount of clicks after
        		
            }
        });
        
        // Logic for new button
        Cbutton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (clicks >= clicksprice) {
        			clicks -= clicksprice;
        			clicksprice *= 1.15;
            		clicksperclick += 1;
            		Cbutton.setText("Increase Clicks per Click, Price: " + clicksprice);
            		Abutton.setText("Click me!: " + clicksperclick);
            		
        			
        		} else {
        			JOptionPane.showMessageDialog(null, "Not enough clicks!");
        		}
        		Alabel.setText("Number Of Clicks: " + clicks); // Update label to display proper amount of clicks after
        		
        		
        	}
        	
        	
        	
        });
     // Timer to increase clicks per second
        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clicks += clickspersecond;
            }
        });
        timer.start();

        this.setVisible(true);
    }
    
    

    public static void main(String[] args) {
       
            new Test1().setVisible(true);
        
    }
}
