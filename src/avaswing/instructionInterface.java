package avaswing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;


import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.border.Border;

public class instructionInterface extends JFrame {
	JPanel panelTitle;
	JLabel title;
	JPanel instructions;
	JButton returnBack;
   
	instructionInterface(){
		this.getContentPane().setBackground(Color.BLACK);
		this.setTitle("Memory Game Instructions");

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
		this.add(panelTitle,BorderLayout.NORTH);
		// icon to the header
		ImageIcon picLabel = new ImageIcon(
				"C:\\Users\\zaina\\Desktop\\MyFile\\Me\\Java\\Workspace\\SwingInterface\\src\\avaswing\\icons8-memory-game-64.png");
		Image image = picLabel.getImage(); // transform it
		Image newimg = image.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		picLabel = new ImageIcon(newimg); // transform it back
		title.setIcon(picLabel);
		instructions = new JPanel();
		Border border = BorderFactory.createLineBorder(new Color(200, 182, 255), 3);
		instructions.setBorder(border);
		instructions.setBackground(Color.BLACK);
			
		 JPanel left= new JPanel();
		 JPanel right= new JPanel();
		 JPanel foot= new JPanel();

		 JLabel instruction = new JLabel();
		 instruction.setText("<html><body><h2 style=\"color:red;\"><strong>Instructions of the Game :</strong></h2> <p>*We have some main points which are needed for you to know in order to win the game</p>"
		 		+ "<ul>"
		 		+ "<li> 1.Once you click the start button you will need to choose the level in which you want to play "
		 		+ "</li>"
		 		+ "<li>2.Each level has its own featues number of icons changes and also the time you are given to remember icons </li>"
		 		+ "<li>3.If you are not sure about your choice you can choose the default player mode or just click the X button that will dive you in the default mode</li>"
		 		+ "<li>4.Once the step of choosing the level is finished the timer starts counting  </li>"
		 		+ "<li>5.You need to set all the couples correctly before the times ends once the time is up all the images are shown and your game is over </li>"
		 		+ "<li>6.If you get to allocate all the matches before the time finishes it show you a congratulation message</li>"
		 		+ "<li>7.If the timer ends before completing the allocation a message decaring the end of the game pops up.</li>"
		 		+ "<li>8.The final point is the score : score decrements on all levels by 10 at the start of the game it's 100 and then it decrements when it arrives to 0 the game ends</li>"
		 		+ "<li>9. In both cases you are welcome to start a new game by returning to the home page</li></ul></body></html>");
		 instruction.setPreferredSize(new Dimension(600,500));
		 instruction.setFont((new Font("Verdana", 1, 13)));
		 instruction.setBackground(Color.BLACK);
		 instruction.setForeground(new Color(200, 182, 255));
		 instructions.add(instruction,BorderLayout.CENTER);
		 right.setPreferredSize(new Dimension(80, 80));
		 right.setBackground(Color.BLACK);
		 left.setPreferredSize(new Dimension(80, 80));
		 left.setBackground(Color.BLACK);
		 foot.setPreferredSize(new Dimension(700,80));
		 foot.setBackground(Color.BLACK);
	     returnBack = new JButton("Return");
		 returnBack.setForeground(new Color(200, 182, 255));
		 returnBack.setBorder(border);
		 returnBack.setBackground(Color.BLACK);
		 returnBack.setFocusPainted(false);
		 returnBack.setPreferredSize(new Dimension(80,30));
		 foot.add(returnBack,BorderLayout.CENTER);
		 this.add(instructions,BorderLayout.CENTER);	
		 this.add(right,BorderLayout.EAST);
		 this.add(left,BorderLayout.WEST);
		 this.add(foot,BorderLayout.SOUTH);
		this.setVisible(true);
	}
}
