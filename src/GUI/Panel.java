/***********************************
 CLASS: Panel class
 CSC212 Data structures - Project phase I
 Spring 2023

 DATE:
 20-05-2023

 TEAM:
 Team RED

 AUTHORS:
 Osama Alajaji,       (ID443100980)

 ***********************************/

package GUI;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public abstract class Panel extends JPanel{
	
	protected int width = 486;
	protected int high = 463;
	protected input input;
	protected Timer timer;
	
	public Panel(JFrame frame) {
		input = new input(frame);
		
		timer = new Timer(1,null);
		timer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				action();
				repaint();
			}
		});
		timer.start();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}
	public abstract void draw(Graphics g);
	public abstract void action();
}
