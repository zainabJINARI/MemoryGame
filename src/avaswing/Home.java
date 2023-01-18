package avaswing;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Home extends JFrame{
	JPanel panelTitle;
	JLabel title;
	JButton start ;
	JButton exit;
	JButton Instruction;
	Home(){
		this.getContentPane().setBackground(Color.BLACK);
		this.setTitle("Memory Game Home");

		this.setBounds(210, 00, 800, 700);
		this.setResizable(false);
		// Labels header
		panelTitle = new JPanel();
		panelTitle.setPreferredSize(new Dimension(700, 100));
		panelTitle.setBackground(null);
		panelTitle.setLayout(new FlowLayout());
		// panel header
		title = new JLabel("Memory game");
		title.setFont(new Font("Verdana", 1, 30));
		title.setForeground(new Color(200, 182, 255));
		// add to header
		panelTitle.add(title);
		panelTitle.setBounds(190, 10, 400, 80);
		this.add(panelTitle);
		// icon to the header
		ImageIcon picLabel = new ImageIcon(
				"C:\\Users\\zaina\\Desktop\\MyFile\\Me\\Java\\Workspace\\SwingInterface\\src\\avaswing\\icons8-memory-game-64.png");
		Image image = picLabel.getImage(); // transform it
		Image newimg = image.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		picLabel = new ImageIcon(newimg); // transform it back
		title.setIcon(picLabel);

		start = new JButton("Start New Game");
		this.setLayout(null);
		start.setFont(new Font("Arial", 1, 18));
		start.setForeground(new Color(200, 182, 255));
		start.setBackground(Color.BLACK);
		start.setBounds(280, 280, 200, 50);
		start.setBorder(BorderFactory.createLineBorder(new Color(200, 182, 255), 2));
		start.setFocusPainted(false);
		this.add(start);
		exit = new JButton("Exit The Game");

		exit.setFont(new Font("Arial", 1, 18));
		exit.setForeground(new Color(200, 182, 255));
		exit.setBackground(Color.BLACK);
		exit.setBounds(280, 370, 200, 50);
		exit.setBorder(BorderFactory.createLineBorder(new Color(200, 182, 255), 2));
		exit.setFocusPainted(false);
//		
		Instruction = new JButton("Instructions");

		Instruction.setFont(new Font("Arial", 1, 18));
		Instruction.setForeground(new Color(200, 182, 255));
		Instruction.setBackground(Color.BLACK);
		Instruction.setBounds(280, 460, 200, 50);
		Instruction.setBorder(BorderFactory.createLineBorder(new Color(200, 182, 255), 2));
		Instruction.setFocusPainted(false);
		Instruction.setVisible(true);
		this.add(Instruction);
		this.add(exit);
		this.setVisible(true); 
	}

}
