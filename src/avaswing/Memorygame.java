package avaswing;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Memorygame {
//	static classMemorygameFrame f1 ;
	static instructionInterface instructionInterf;
	static FrameDry ff;
	static Home interfaceHome;
	public static void main(String[] args) {
		//Views creation 
		//Main game interface
		interfaceHome = new Home();
		//Exit message interface.
		InterfacemessageExit message = new InterfacemessageExit();
		// event listeners
	
	
		interfaceHome.start.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				interfaceHome.setVisible(false);
				String[] options = { "Easy", "Medium" ,"Hard","Very Hard","Default"};
				UIManager.put("OptionPane.background", Color.decode("#000000"));
				UIManager.getLookAndFeelDefaults().put("Panel.background", Color.decode("#000000"));
				JLabel label = new JLabel("Choose which level you want to play ");
				label.setFont(new Font("Arial", Font.BOLD, 20));
				label.setForeground(new Color(200, 182, 255));
				int Option = JOptionPane.showOptionDialog(null, label, "Choose what level suits your memory",
						JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
						new ImageIcon(
								"C:\\Users\\zaina\\Desktop\\MyFile\\Me\\Java\\Workspace\\SwingInterface\\src\\avaswing\\icons8-memory-game-64.png"),
						options, options[0]);

				if (Option == 0) {
					ff = new FrameDry(6,3,700,700,700);
					ff.setVisible(true);

				} else if(Option ==1){
					ff = new FrameDry(6,4,800,700,600);
					ff.setVisible(true);
				}else if(Option==2) {
					ff = new FrameDry(6,5,900,700,500);
					ff.setVisible(true);
				}else if(Option ==3){
					ff = new FrameDry(6,6,950,710,500);
					ff.setVisible(true);
				}
				else if(Option ==4){
					//je penx utiliser classMempryFrame aussi mais c'est le default si on veut specifier le nbr d'icones ainsi que le temps 
					//de mémorisations on doit utiliser la class FrameDry car c'est là ou j'ai fait les mofification pour
					//créer les niveux de jeux
//					f1 = new classMemorygameFrame();
//					f1.setVisible(true);
					ff = new FrameDry(5,4,800,710,650);
					ff.setVisible(true);
				}else {
					interfaceHome.setVisible(true);
				}
				

			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				interfaceHome.start.setForeground(Color.black);
				interfaceHome.start.setBackground(new Color(200, 182, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				interfaceHome.start.setBorder(BorderFactory.createLineBorder(new Color(200, 182, 255), 2));
				interfaceHome.start.setForeground(new Color(200, 182, 255));
				interfaceHome.start.setBackground(Color.BLACK);
			}

		});
		interfaceHome.Instruction.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				instructionInterf = new instructionInterface();
				interfaceHome.setVisible(false);
				instructionInterf.returnBack.addMouseListener(new MouseListener() {
					
					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						interfaceHome.setVisible(true);
						instructionInterf.setVisible(false);
					}

					@Override
					public void mousePressed(MouseEvent e) {
						
						
					}

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						instructionInterf.returnBack.setForeground(Color.black);
						instructionInterf.returnBack.setBackground(new Color(200, 182, 255));
						
					}

					@Override
					public void mouseExited(MouseEvent e) {
						instructionInterf.returnBack.setBorder(BorderFactory.createLineBorder(new Color(200, 182, 255), 2));
						instructionInterf.returnBack.setForeground(new Color(200, 182, 255));
						instructionInterf.returnBack.setBackground(Color.BLACK);
						
					}});
				
				
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
				interfaceHome.Instruction.setForeground(Color.black);
				interfaceHome.Instruction.setBackground(new Color(200, 182, 255));
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				interfaceHome.Instruction.setBorder(BorderFactory.createLineBorder(new Color(200, 182, 255), 2));
				interfaceHome.Instruction.setForeground(new Color(200, 182, 255));
				interfaceHome.Instruction.setBackground(Color.BLACK);
				
			}
			
		});
		interfaceHome.exit.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				message.setVisible(true);
				interfaceHome.setVisible(false);

			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				interfaceHome.exit.setForeground(Color.black);
				interfaceHome.exit.setBackground(new Color(200, 182, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				interfaceHome.exit.setBorder(BorderFactory.createLineBorder(new Color(200, 182, 255), 2));
				interfaceHome.exit.setForeground(new Color(200, 182, 255));
				interfaceHome.exit.setBackground(Color.BLACK);
			}

		});

		message.cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				message.setVisible(false);
				interfaceHome.setVisible(true);
			}
		});
		message.yesExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

	}
}