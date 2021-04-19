
package com.jam.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.jam.sql.DatabaseConnector;

import javax.swing.JScrollBar;
import javax.swing.JTextPane;
import javax.swing.JButton;

public class MainGui extends JFrame {

	public static final String MaintextPane = null;
	
	private JPanel contentPane;
	public static String sqlOutput = null;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {   
				 try {
					MainGui frame = new MainGui();
					frame.setVisible(true);
					
					DatabaseConnector.allvalues();

				
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainGui() {
		
		//Connection to database // call class main or nah 
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(407, 120, 17, 99);
		contentPane.add(scrollBar);
		
		JTextPane MaintextPane = new JTextPane();
		MaintextPane.setBounds(21, 120, 376, 99);
		contentPane.add(MaintextPane);
		
		
		
		
		if  (!DatabaseConnector.getAllValues().isEmpty())  //check if the db is empty 
		{
		MaintextPane.setText(DatabaseConnector.getAllValues().toString());
		}
		
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(255, 88, 142, 23);
		contentPane.add(btnNewButton);
		
		
		
		
	}
	
	
	
	
}
