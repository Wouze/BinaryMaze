package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import MainProj.*;

public class MazeP extends Panel {

	boolean pause = true;
	boolean startMenu = true;

	int x = width / 2;
	int y = 20;
	public MNode<Character> root;

	public MazeP(JFrame frame, MNode<Character> Root) {
		super(frame);
		root = Root;
	}

	public void maze(int x, int y, MNode<Character> root, Graphics g) {
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		MNode<Character> tmp = root;
		//g.drawLine(x, y, x - 10, y + 10);
		//g.drawLine(x, y, x + 10, y + 10);
		//helperMaze(x, y, tmp, g);
		for (int i = 0; i < 40; i++) {
			g.fillOval(x - i, y + i, 5, 5);
			g.fillOval(x + i, y + i, 5, 5);
		}
		for (int i = 0; i < 40; i++)
			helperMaze(x, y, tmp, g, i);
		dataAdder(x, y, tmp, g);
	}
	private void helperMaze(int x, int y, MNode<Character> node, Graphics g, int i) {
		if (node.left != null) {
			g.fillOval(x - 40 - i, y + 40 + i, 5, 5);
			helperMaze(x - 40, y + 40, node.left, g,i);
		}
		else{
			g.fillOval(x - 40 + i, y + 40 + i, 5, 5);
		}
		if (node.right != null) {
			g.fillOval(x + 40 + i, y + 40 + i, 5, 5);
			helperMaze(x + 40, y + 40, node.right, g, i);
		}
		else{
			g.fillOval(x + 40 - i, y + 40 + i, 5, 5);
		}
	}
	private void dataAdder(int x, int y, MNode<Character> node, Graphics g) {
		if(node == null)
			return;
		String CharToString = "";
		CharToString += node.data;
		g.drawString(CharToString, x - 9 , y+42);
		g.drawString(Integer.toString(node.key), x-1 , y+60);
		dataAdder(x - 40, y + 40, node.left, g);
		dataAdder(x + 40, y + 40, node.right, g);
	}
	
	/*private void helperMaze(int x, int y, MNode<Character> node, Graphics g) {
		if (node.left != null) {
			g.drawLine(x-10, y + 10, x - 20, y + 20);
			helperMaze(x - 10, y + 10, node.left, g);
		}
		else{
			g.drawLine(x - 10, y + 10, x , y + 20);
		}
		if (node.right != null) {
			g.drawLine(x + 10, y + 10, x + 20, y + 20);
			helperMaze(x + 10, y + 10, node.right, g);
		}
		else{
			g.drawLine(x + 10, y + 10, x , y + 20);
		}
	}*/

	@Override
	public void draw(Graphics g) {

		if (!startMenu) {
			
			maze(x,y,root,g);
			
			g.setColor(Color.lightGray);
			g.fillRect(0, 0, width, high);
			g.setColor(Color.black);
			maze(x,y,root,g);
			
			/*g.drawString("Score: " + score, 10, 20);
			g.drawString("Level: " + (Math.abs(xspeed) - 1), width - 50, 20);

			if (yball <= 0) {
				g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
				g.drawString("الفائز عبدالله !", width / 2 - 75, high / 2);
			}
			if (yball >= high) {
				g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
				g.drawString("الفائز عبدالعزيز!", width / 2 - 75, high / 2);
			}*/
		} else {
			g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
			g.drawString("اهلا!", width / 2 + 100, high / 2 - 50);
			g.drawString("اضغط اي زر للبدء", width / 2 - 75, high / 2);
		}
	}

	@Override
	public void action() {
		if (!startMenu) {
			/*if (input.KeyIsDown(KeyEvent.VK_D) && xboard1 + 50 <= width)
				xboard1 += Math.abs(xspeed);
			if (input.KeyIsDown(KeyEvent.VK_A) && xboard1 >= 0)
				xboard1 -= Math.abs(xspeed);
			if (input.KeyIsDown(KeyEvent.VK_RIGHT) && xboard2 + 50 <= width)
				xboard2 += Math.abs(xspeed);
			if (input.KeyIsDown(KeyEvent.VK_LEFT) && xboard2 >= 0)
				xboard2 -= Math.abs(xspeed); */
		} else {
			if (input.anykeypressed())
				startMenu = false;
		}
	}

}
