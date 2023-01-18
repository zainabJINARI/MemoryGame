package avaswing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.Timer;
import javax.swing.UIManager;

public class FrameDry extends JFrame {
	int counterclicks = 0;
	int counter;
	int second;
	int min;
	ScoreGame score;
	final int numberLabelsToBeCorrect = 10;
	int counterCorrectLabels = 0;
	List<myLabel> Labels;
	List<myLabel> comparedLabels = new ArrayList<myLabel>();
	Timer timer;
	JPanel panelTitle;
	JLabel title;
	JPanel footer;
	JPanel LEFT;
	JPanel RIGHT;
	JPanel imagesContainer;
	JLabel timeCounter;
	JLabel gameStatusL;
	JLabel gameStatusR;
	JLabel scoreStatus;
	String[] urls ;

	public FrameDry(int r,int col,int width,int height,int timestam ) {
		score= new ScoreGame();
		urls= new String[(r*col)/2] ;
         for(int i=0;i<((r*col)/2);i++) {
        	 urls[i]="C:\\Users\\zaina\\Desktop\\MyFile\\Me\\Java\\Workspace\\SwingInterface\\src\\avaswing\\imagedememory\\"+(i+1)+".png";
         }
		// Frame properties
		this.getContentPane().setBackground(Color.BLACK);
		this.setTitle("Memory Game");

		this.setBounds(210, 00, width, height);
		this.setResizable(false);
		// Labels header
		panelTitle = new JPanel();
		panelTitle.setPreferredSize(new Dimension(width, 70));
		panelTitle.setBackground(null);
		panelTitle.setLayout(new FlowLayout());
		// panel header
		title = new JLabel("Memory game");
		title.setFont(new Font("Verdana", 1, 30));
		title.setForeground(new Color(200, 182, 255));
		// add to header
		panelTitle.add(title);
		this.add(panelTitle, BorderLayout.NORTH);
		// icon to the header
		ImageIcon picLabel = new ImageIcon(
				"C:\\Users\\zaina\\Desktop\\MyFile\\Me\\Java\\Workspace\\SwingInterface\\src\\avaswing\\icons8-memory-game-64.png");
		Image image = picLabel.getImage(); // transform it
		Image newimg = image.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		picLabel = new ImageIcon(newimg); // transform it back
		title.setIcon(picLabel);

		// the container of all images the seond Panel
		imagesContainer = new JPanel();

		imagesContainer.setLayout(new GridLayout(r, col, 20, 20));

		Labels = new ArrayList<myLabel>();
		creatLabbels(r*col, Labels);
		{

			List<Integer> LabelItemids = new ArrayList<Integer>();
			List<Integer> randoms = new ArrayList<Integer>();

			for (int i = 0; i < urls.length; i++) {
				int randomIndex;
				int idfirst;
				int secondvalue;
				if (i == 0) {
					Random rand = new Random();
					randomIndex = rand.nextInt(urls.length);
					randoms.add(randomIndex);
					idfirst = rand.nextInt(urls.length*2); // this will choose a number between 0-19
					secondvalue = rand.nextInt(urls.length*2); // same thing but we need 2 of them since we want 2 random numbers
													// and not only 1 !

					while (idfirst == secondvalue) { // to see if the first random number = the second
						secondvalue = rand.nextInt(urls.length*2); // if so, regenerate the second randomly
					}

					LabelItemids.add(idfirst);
					LabelItemids.add(secondvalue);
					Labels.get(idfirst).setIdLabel(randomIndex);
					Labels.get(secondvalue).setIdLabel(randomIndex);

				} else {
					do {
						Random rand = new Random();
						randomIndex = rand.nextInt(urls.length);

						if (!(randoms.contains(randomIndex))) {
							break;
						}
					} while ((randoms.contains(randomIndex)));
					randoms.add(randomIndex);

					do {
						Random rand = new Random();
						idfirst = rand.nextInt(urls.length*2); // this will choose a number between 0-19
						secondvalue = rand.nextInt(urls.length*2); // same thing but we need 2 of them since we want 2 random
														// numbers and not only 1 !

						while (idfirst == secondvalue) { // to see if the first random number = the second
							secondvalue = rand.nextInt(urls.length*2); // if so, regenerate the second randomly
						}
					} while ((((LabelItemids.contains(idfirst)))) || ((LabelItemids.contains(secondvalue))));
					LabelItemids.add(idfirst);
					LabelItemids.add(secondvalue);
					Labels.get(idfirst).setIdLabel(randomIndex);
					Labels.get(secondvalue).setIdLabel(randomIndex);

				}
			}

			for (myLabel item : Labels) {
				EditJLabels(item, urls[item.getIdLabel()]);
			}
		}
		System.out.println(Labels.toString());

		imagesContainer.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

		System.out.println(imagesContainer.getComponents().length);

		// add to the big container
		for (myLabel item : Labels) {

			imagesContainer.add(item);

		}

		imagesContainer.setPreferredSize(new Dimension((width-100), 650));
		this.add(imagesContainer, BorderLayout.CENTER);
		imagesContainer.setBackground(null);

		timeCounter = new JLabel();
		timeCounter.setPreferredSize(new Dimension(width, 80));
		timeCounter.setHorizontalAlignment(SwingConstants.CENTER);
		timeCounter.setForeground(new Color(200, 182, 255));
		timeCounter.setFont(new Font("Verdanal", 1, 13));
		second = 30;
		min = 1;
		counter = 0;
		timer("Hide",timestam);
		timer.start();
		gameStatusL = new JLabel();
		gameStatusR = new JLabel();
		scoreStatus = new JLabel();
		JLabel space = new JLabel();
		scoreStatus.setText("Game Score :"+score.getScore()+"");
		scoreStatus.setForeground(new Color(200, 182, 255));
		scoreStatus.setFont(new Font("Verdanal", 1, 13));
		gameStatusR.setFont(new Font("Verdanal", 1, 13));
		gameStatusL.setFont(new Font("Verdanal", 1, 13));
		LEFT = new JPanel();
		LEFT.setBackground(null);
		LEFT.setPreferredSize(new Dimension(130, 100));
		RIGHT = new JPanel();
		RIGHT.setBackground(null);
 
		RIGHT.setPreferredSize(new Dimension(130, 100));
		LEFT.add(gameStatusL,BorderLayout.CENTER);
		LEFT.add(scoreStatus,BorderLayout.NORTH);
		LEFT.add(space,BorderLayout.SOUTH);
		RIGHT.add(gameStatusR);
		this.add(timeCounter, BorderLayout.SOUTH);
		this.add(LEFT, BorderLayout.WEST);
		this.add(RIGHT, BorderLayout.EAST);

	}

	// create the methode for timer

	public void timer(String option ,int timest) {
		timer = new Timer(timest,new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (min == 0 && second == 40) {
					timeCounter.setForeground(Color.RED);
					timeCounter.setFont(new Font("Verdanal", 2, 19));
				}
				if (second != 0) {
					second--;
					if (second >= 10) {
						timeCounter.setText("Remaining time 0" + min + ":" + second);

					} else {

						timeCounter.setText("Remaining time 0" + min + ":0" + second);
					}

				} else
					label: {

						if (second == 0) {
							counter++;
						}
						if (counter == 2) {
							timer.stop();
							timeCounter.setText("Time is up !!!");
							gameStatusL.setText("");
							gameStatusR.setText("");
							//make changes and break 
							makeChanges(option);
							break label;
						}
						
						min = 0;
						second = 59;
						timeCounter.setText("Remaining time 0" + min + ":" + second);
					}
				
			}
			
		});
	}
	void makeChanges(String typeChange) {
		if(typeChange== "Hide") {
			for (myLabel item : Labels) {
				mouselisten listen = new mouselisten();
				item.addMouseListener(listen);
				ImageIcon picLabelC9 = new ImageIcon(
						"C:\\Users\\zaina\\Desktop\\MyFile\\Me\\Java\\Workspace\\SwingInterface\\src\\avaswing\\question.jpg");
				Image imageC9 = picLabelC9.getImage(); // transform it
				Image newimgC9 = imageC9.getScaledInstance(110, 100, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
				picLabelC9 = new ImageIcon(newimgC9); // transform it back
				item.setIcon(picLabelC9);
				timeCounter.setForeground(new Color(200, 182, 255));
				timeCounter.setFont(new Font("Verdanal", 1, 13));
				counter = 0;
				second = 30;
				min = 1;
				timer.stop();
				timer("Show",500);
				timer.start();
			}
			
		}else if(typeChange=="Show") {
			for (myLabel item : Labels) {
				EditJLabels(item, urls[item.getIdLabel()]);
			}
			timer.stop();
			returnAs("Looser");
		}
	}

	private class mouselisten implements MouseListener {

		@Override

		public void mouseClicked(MouseEvent e) {
			label: if (!(((myLabel) e.getSource()).getIsClicked())) {
				if (counterclicks < 2) {
					int idLabelclicked = ((myLabel) e.getSource()).getIdLabel();
					final String myurl = urls[idLabelclicked];

					ImageIcon picLabelC9 = new ImageIcon(myurl);
					Image imageC9 = picLabelC9.getImage(); // transform it
					Image newimgC9 = imageC9.getScaledInstance(110, 100, java.awt.Image.SCALE_SMOOTH); // scale it the
																										// smooth // way
					picLabelC9 = new ImageIcon(newimgC9); // transform it back
					System.out.println("Table Clicked elments" + comparedLabels.toString());
					((myLabel) e.getSource()).setIcon(picLabelC9);
					boolean isExisted = !(comparedLabels.contains(((myLabel) e.getSource())));
					if (isExisted) {
						comparedLabels.add(((myLabel) e.getSource()));
						counterclicks += 1;
						System.out.println("Table Clicked elments" + comparedLabels.toString());
					}
				} else if (counterclicks > 2) {
					break label;
				}

				if (counterclicks == 2 && comparedLabels.size() == 2) {
					if (comparedLabels.get(0).getIdLabel() == comparedLabels.get(1).getIdLabel()) {

						counterCorrectLabels = counterCorrectLabels + 1;
						comparedLabels.get(0).setIsClicked(true);
						comparedLabels.get(1).setIsClicked(true);
						System.out.println("The counter is " + counterCorrectLabels);
						System.out.println(isAllclicked(Labels));
						label2: {
							if (isAllclicked(Labels)) {
								timer.stop();
								timeCounter.setForeground(Color.GREEN);
								timeCounter.setText("Wohooo you win Congratulation!!!!");
								gameStatusL.setText("");
								gameStatusR.setText("");
								returnAs("Winner");

								break label2;
							}

							gameStatusL.setForeground(Color.GREEN);
							gameStatusL.setText("Good Job");
							gameStatusR.setForeground(Color.GREEN);
							gameStatusR.setText("Good Job");
							comparedLabels.clear();
							counterclicks = 0;
						}
					} else {
						gameStatusL.setForeground(Color.RED);
						gameStatusL.setText("Ooops try again ");
						gameStatusR.setForeground(Color.RED);
						gameStatusR.setText("Ooops try again ");
						score.decrementScore();
						scoreStatus.setText("Score game:"+score.getScore());
						if(score.isGameOver()) {
							makeChanges("Show");
						}
						ImageIcon picLabelC9 = new ImageIcon(
								"C:\\Users\\zaina\\Desktop\\MyFile\\Me\\Java\\Workspace\\SwingInterface\\src\\avaswing\\question.jpg");
						Image imageC9 = picLabelC9.getImage(); // transform it
						Image newimgC9 = imageC9.getScaledInstance(110, 100, java.awt.Image.SCALE_SMOOTH); // scale it
																											// the
																											// smooth
																											// way
						picLabelC9 = new ImageIcon(newimgC9); // transform it back
						comparedLabels.get(0).setIcon(picLabelC9);
						comparedLabels.get(1).setIcon(picLabelC9);
						comparedLabels.clear();
						counterclicks = 0;
					}

				}
			}

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}
	public void returnAs(String endStatus) {
		String message="";
		
		if(endStatus=="Winner") {
			message="Wohoooo Gongratulation :) You Win the Game your score is"+score.getScore();
			gameStatusR.setText("Congratulation");
			gameStatusL.setText("You win");
			gameStatusL.setForeground(Color.red);
			gameStatusR.setForeground(Color.red);
		}else if(endStatus=="Looser") {
			gameStatusR.setText("Game over");
			gameStatusL.setText("Game over");
			gameStatusL.setForeground(Color.red);
			gameStatusR.setForeground(Color.red);
			message="Oooops :( Sounds like Game Over your score is "+score.getScore();
		}
		String[] options = { "Return to Game home", "Quit The Game" };
		UIManager.put("OptionPane.background", Color.decode("#000000"));
		UIManager.getLookAndFeelDefaults().put("Panel.background", Color.decode("#000000"));
		JLabel label = new JLabel(message);
		label.setFont(new Font("Arial", Font.BOLD, 20));
		label.setForeground(new Color(200, 182, 255));
		int Option = JOptionPane.showOptionDialog(null, label, "Choose what is best for you ",
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
				new ImageIcon(
						"C:\\Users\\zaina\\Desktop\\MyFile\\Me\\Java\\Workspace\\SwingInterface\\src\\avaswing\\icons8-memory-game-64.png"),
				options, options[0]);

		if (Option == 0) {
			dispose();
			Memorygame.main(null);

		} else {
			System.exit(0);
		}

		
	}
	public myLabel EditJLabels(myLabel label, String url) {
		ImageIcon picLabel = new ImageIcon(url);
		Image image = picLabel.getImage(); // transform it
		Image newimg = image.getScaledInstance(120, 100, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		picLabel = new ImageIcon(newimg); // transform it back
		label.setIcon(picLabel);
		Border border2 = BorderFactory.createLineBorder(new Color(90, 24, 154), 3);
		label.setBorder(border2);
		label.setSize(50, 50);

		return label;
	}

	public boolean isAllclicked(List<myLabel> Labelverif) {
		boolean isClicked = true;
		for (myLabel l : Labelverif) {
			if (l.getIsClicked() == false) {
				isClicked = false;
			}
		}
		return isClicked;
	}

	public void creatLabbels(int labelsNumber, List<myLabel> labels) {
		for (int i = 0; i < labelsNumber; i++) {
			myLabel item = new myLabel();
			labels.add(item);
		}

	}

}
