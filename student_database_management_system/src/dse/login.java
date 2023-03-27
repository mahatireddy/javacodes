package dse;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class login implements ActionListener {
	
	
	private static JLabel ulabel;
	private static JTextField uText;
	private static JLabel plabel;
	private static JPasswordField pText;
	private static JButton lbutton;
	private static JLabel correct;
	public static JPanel panel;
	public static JFrame frame;
	public static JPanel panel2;
	public static JFrame frame2;
	

	public static void main(String[] args) {
		
		panel = new JPanel ();                 // Creating Layout 1
		frame = new JFrame();                  // Creating Window 1
		
		frame.setSize(400,200);              // dimensions of the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setBackground(Color.cyan);
		frame.add(panel);
		
		panel.setLayout(null);
		
		ulabel = new JLabel("Username:");      // Creating Username
		ulabel.setBounds(10, 20, 80, 25);      // (x,y,width,heigght)
		panel.add(ulabel);
		
		uText = new JTextField();              // Entering Username
		uText.setBounds(100,20,165,25);
		panel.add(uText);
		
		plabel = new JLabel("Password:");      // Creating Password
		plabel.setBounds(10, 50, 80, 25);
		panel.add(plabel);
		
		pText = new JPasswordField();          //Entering Password
		pText.setBounds(100,50,165,25);
		panel.add(pText);
		
		lbutton = new JButton("Login");
		lbutton.setBounds(140,80,80,25);
		lbutton.addActionListener(new login());     
		panel.add(lbutton);
		
		correct = new JLabel("");
		correct.setBounds(10,110,300,25);
		panel.add(correct);
		
		
		
		
		frame.setVisible(true);

	}


	public void actionPerformed(ActionEvent e) {       // new method, this code runs when correct log in credentials are written
		String user = uText.getText();
		String pass = pText.getText();
		System.out.println(user+" "+ pass);
		
		if(user.equals("dsa") && pass.equals("endsem")) {
			correct.setText("Successfull login");
			gui GUI = new gui();
			
			
			frame.dispose();
				
			}
		else {
			correct.setText("Wrong Password");
			
		}
			
		}
		 
		
	}


