import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import javax.swing.JLabel; 

// Fun imports yay!


public class Test1 extends JFrame {
    JButton Abutton;
    JLabel Alabel;
    
    int clicks = 0;  // Added this in the public Test1() on accident :(

    public Test1() {
        // Set frame properties
        this.setSize(800, 600);
        this.setLayout(null);
        this.setVisible(true);
        this.setResizable(false);
        
        // Initialize button
        Abutton = new JButton("Hi vro");
        
        
        // Set button position and size
        Abutton.setBounds(350, 400, 100, 50); // (x, y, width, height)
        // Initialize label
        Alabel = new JLabel("Number Of Clicks: 0");
        
        // Set label position and size
        Alabel.setBounds(350, 250, 200, 50); // (x, y, width, height)
        
        // Add button to the frame
        this.add(Abutton);
        this.add(Alabel);
        
        // Add action listener to the button
        Abutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Increment the click counter
                 clicks = clicks + 1;
                
                // System.out.println("Clicked " + clicks + " times");
                Alabel.setText("Number Of Clicks: " + clicks);
            }
        });
    }

    public static void main(String[] args) {
        // Create a JFrame (window)
        new Test1();
    }
}
