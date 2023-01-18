package avaswing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class InterfacemessageExit extends JFrame{
	JPanel panelExit;
	JLabel titleexit;
	JButton yesExit;
	JButton cancel;
	
	InterfacemessageExit(){

		this.getContentPane().setBackground(Color.BLACK);
		this.setTitle("You are trying to exit?");
		this.setBounds(480, 200, 350, 140);
		this.setResizable(false);
		panelExit = new JPanel(new BorderLayout());
		panelExit.setPreferredSize(new Dimension(300, 140));
		panelExit.setBackground(null);
		panelExit.setBorder(new EmptyBorder(10, 20, 20, 10));
		titleexit = new JLabel("          Are you sure you want to exit ?");
		titleexit.setFont(new Font("Arial", 1, 14));
		titleexit.setForeground(new Color(200, 182, 255));
		titleexit.setPreferredSize(new Dimension(300, 40));
		// add to header

		JLabel margin = new JLabel();
		margin.setPreferredSize(new Dimension(10, 10));
		panelExit.add(margin, BorderLayout.CENTER);

		// add to header
		panelExit.add(titleexit, BorderLayout.NORTH);
		yesExit = new JButton("Exit !");
		yesExit.setFont(new Font("Arial", 1, 13));
		yesExit.setForeground(Color.red);
		yesExit.setBackground(Color.BLACK);

		yesExit.setBorder(BorderFactory.createLineBorder(new Color(200, 182, 255), 2));
		yesExit.setFocusPainted(false);
		yesExit.setPreferredSize(new Dimension(70, 10));
		panelExit.add(yesExit, BorderLayout.EAST);
		cancel = new JButton("Cancel");

		cancel.setFont(new Font("Arial", 1, 13));
		cancel.setForeground(Color.green);
		cancel.setBackground(Color.BLACK);

		cancel.setBorder(BorderFactory.createLineBorder(new Color(200, 182, 255), 2));
		cancel.setFocusPainted(false);
		cancel.setPreferredSize(new Dimension(70, 10));
		panelExit.add(cancel, BorderLayout.WEST);
		this.add(panelExit);
		this.setVisible(false);
	}
}
