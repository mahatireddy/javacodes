package dse;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class gui extends JFrame {

	JPanel flowpanel = new JPanel();
	JFrame frame = new JFrame();
	public static JLabel label;

	JTextArea stTextArea = new JTextArea(
			"                                                                                                                                                                                                                     Welcome to Student Managment System \n\n\nName               Reg.No             Course               Marks                         \n");

	JLabel namelabel = new JLabel("Name:");
	JTextField nameTextField = new JTextField(10);

	JLabel regnolabel = new JLabel("Reg No.:");
	JTextField regnoTextField = new JTextField(10);

	JLabel courselabel = new JLabel("Course:");
	JTextField courseTextField = new JTextField(10);

	JLabel markslabel = new JLabel("Marks:");
	JTextField marksTextField = new JTextField(10);

	JButton addButton = new JButton("Add");
	JButton delButton = new JButton("Delete");
	JButton dispButton = new JButton("Display");
	JButton searchButton = new JButton("Search");
	JButton lineButton = new JButton("Margin");
	// JButton clearButton = new JButton("Clear");
	// JButton exitButton = new JButton ("Exit");

	public gui() {

		stTextArea.setEditable(false);

		JPanel flow1panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel flow2panel = new JPanel(new FlowLayout(FlowLayout.CENTER));

		JPanel gridPanel = new JPanel(new GridLayout(2, 1));

		
		flow1panel.add(namelabel);
		flow1panel.add(nameTextField);

		
		flow1panel.add(regnolabel);
		flow1panel.add(regnoTextField);

		
		flow1panel.add(courselabel);
		flow1panel.add(courseTextField);

		
		flow1panel.add(markslabel);
		flow1panel.add(marksTextField);

		
		flow2panel.add(addButton);
		flow2panel.add(delButton);
		flow2panel.add(dispButton);
		flow2panel.add(lineButton);
		// flow2panel.add(clearButton);
		// flow2panel.add(exitButton);
		flow2panel.add(searchButton);

		
		gridPanel.add(flow1panel);
		gridPanel.add(flow2panel);

		
		add(stTextArea, BorderLayout.CENTER);
		add(gridPanel, BorderLayout.SOUTH);

		
		addButton.addActionListener(event -> addStudent());
		dispButton.addActionListener(event -> disp());
		delButton.addActionListener(event -> del());
		searchButton.addActionListener(event -> search());
		lineButton.addActionListener(event -> line());
		// clearButton.addActionListener(event -> clear());

		// exitButton.addActionListener (event -> exit());

		// frame.setVisible(true);
	}

	/*
	 * public void clear() { stTextArea.removeAll();
	 * 
	 * 	
	 * }
	 */

	public void line() {
		stTextArea.append("\n-----------------------------------------------------------------------\n");

	}

	
	/*
	 * public void exit() { frame.dispose();
	 * 
	 * }
	 */

	
	class Node {
		String stname, Regno, Course;
		String mks;
		Node next;

		Node(String stname, String Regno, String Course, String mks2) {
			this.stname = stname;
			this.Regno = Regno;
			this.Course = Course;
			this.mks = mks2;
			this.next = null;
		}
	}

	
	public void addStudent() {
		Node newNode1 = new Node(nameTextField.getText(), regnoTextField.getText(), courseTextField.getText(),
				marksTextField.getText());
		if (head == null) {
			head = newNode1;
			return;
		} else {

			newNode1.next = head;
			head = newNode1;
		}

	}

	
	public void search() {
		int a = 1;
		Node ptr = head;
		while (!ptr.Regno.equals(regnoTextField.getText())) {
			if (ptr.next == null) {
				stTextArea.append("\n No match Found \n");
				a = 0;
				break;
			}
			ptr = ptr.next;
		}

		if (a == 0)
			return;
		stTextArea.append("\nThe details of the Searched Student\n");
    	stTextArea.append("\nThe Name of the Student : \n" + ptr.stname);
		stTextArea.append("\nThe Registration Number : \n" + ptr.Regno);
		stTextArea.append("\nThe Course of the student :\n " + ptr.Course);
		stTextArea.append("\nThe Marks obtained by the student : \n" + ptr.mks);

	}

	
	public void del() {
		if (head == null) {
			System.out.println("List is Empty");
		} else if (head.Regno.equals(regnoTextField.getText())) {
			if (head.next == null) {
				head = null;
			} else {
				head = head.next;
			}
		}

		else {
			Node ptr = head;
			while (!ptr.next.Regno.equals(regnoTextField.getText())) {
				ptr = ptr.next;
			}
			ptr.next = ptr.next.next;

		}

	}

	
	public Node head = null;

	public void disp() {
		if (head == null) {
			System.out.println("List is Empty");
		}
		// stTextArea.append(" ");
		Node tempnode = head;
		while (tempnode != null) {

			stTextArea.append(tempnode.stname + "\t");
			stTextArea.append(tempnode.Regno + "\t");
			stTextArea.append(tempnode.Course + "\t");
			stTextArea.append(tempnode.mks + "\t\n");
			// stTextArea.append(" ");

			tempnode = tempnode.next;

		}
	}

	
	public static void main(String[] args) {
		gui frame = new gui();
		frame.setVisible(true);
		frame.setSize(1000, 1000);
		frame.setLocation(200, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
