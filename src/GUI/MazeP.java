/***********************************
 CLASS: Maze class
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
	int door[];
	int xball = width / 2 - 11;
	int yball = 65;
	boolean isLeft;;
	boolean isRight;;
	int countDown = 76;
	public TheMaze<Character> maze;
	private MNode<Character> tmp;

	public MazeP(JFrame frame, TheMaze<Character> Maze) {
		super(frame);
		maze = Maze;
		tmp = Maze.root;

		door = new int[maze.lastkey];
	}

	public void maze(int x, int y, MNode<Character> root, Graphics g) {
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		MNode<Character> tmp = root;
		for (int i = 0; i < 40; i++) {
			g.fillOval(x - i, y + i, 5, 5);
			g.fillOval(x + i, y + i, 5, 5);
		}
		dataAdder(x, y, tmp, g);
		for (int i = 0; i < 40; i++) {
			helperMaze(x, y, tmp, g, i);
		}
	}

	private void helperMaze(int x, int y, MNode<Character> node, Graphics g, int i) {
		if (node.left != null) {
			g.fillOval(x - 40 - i, y + 40 + i, 5, 5);
			g.setColor(new Color(205, 133, 63));
			g.fillOval(x - 40 - door[node.left.key] + i, y + 40 - door[node.left.key] + i, 5, 5);
			g.setColor(Color.black);
			helperMaze(x - 40, y + 40, node.left, g, i);
		} else {
			g.fillOval(x - 40 + i, y + 40 + i, 5, 5);
		}
		if (node.right != null) {
			g.fillOval(x + 40 + i, y + 40 + i, 5, 5);
			g.setColor(new Color(205, 133, 63));
			g.fillOval(x + 40 + door[node.right.key] - i, y + 40 - door[node.right.key] + i, 5, 5);
			g.setColor(Color.black);
			helperMaze(x + 40, y + 40, node.right, g, i);
		} else {
			if (node.data != 'X')
				g.fillOval(x + 40 - i, y + 40 + i, 5, 5);
			if (node.data == 'X') {
				g.fillOval(x + 40, y + 40 + i, 5, 5);
				g.fillOval(x + 40, y + 55 + i, 5, 5);
			}
		}
	}

	private void dataAdder(int x, int y, MNode<Character> node, Graphics g) {
		if (node == null)
			return;

		String CharToString = "";
		CharToString += node.data;
		g.drawString(CharToString, x - 9, y + 42);
		g.drawString(Integer.toString(node.key), x - 1, y + 60);
		dataAdder(x - 40, y + 40, node.left, g);
		dataAdder(x + 40, y + 40, node.right, g);
	}

	@Override
	public void draw(Graphics g) {

		if (!startMenu) {

			g.setColor(new Color(250, 235, 215));
			g.fillRect(0, 0, width, high);
			g.setColor(Color.black);
			maze(x, y, maze.root, g);
			g.setColor(Color.red);
			g.fillOval(xball, yball, 30, 30);
		} else {
			g.setColor(new Color(250, 235, 215));
			g.fillRect(0, 0, width, high);
			g.setColor(new Color(205, 133, 63));
			g.fillRoundRect(50, 50, width - 100, high - 100, 30, 30);
			g.setColor(Color.red);
			g.fillOval(350, 20, 30, 30);
			g.setColor(Color.white);
			g.setFont(new Font(Font.SERIF, Font.BOLD, 50));
			g.drawString("The Maze", width / 2 - 110, high / 2 - 110);
			g.setFont(new Font(Font.SERIF, Font.BOLD, 25));
			g.drawString("إعداد:", width / 2 + 90, high / 2 - 70);
			g.setFont(new Font(Font.SERIF, Font.BOLD, 20));
			g.drawString("- أسامة بن محمد العجاجي", width / 2 - 20, high / 2 - 40);
			g.drawString("- محمد بن حمد الخنيزان", width / 2 - 12, high / 2 - 10);
			g.drawString("- فهد بن محمد بن دخيل", width / 2 - 8, high / 2 + 20);
			g.setColor(Color.black);
			g.setFont(new Font(Font.SERIF, Font.BOLD, 25));
			g.drawString("إشراف الدكتور: محمد الزيد", width / 2 - 110, high / 2 + 60);
			g.setColor(Color.white);
			g.setFont(new Font(Font.SERIF, Font.BOLD, 20));
			g.drawString("(اضغط اي زر للبدء)", width / 2 - 70, high / 2 + 100);
			g.setColor(new Color(0, 255, 127));
			g.drawString("(اضغط [R] لإعادة اللعب)", width / 2 - 90, high / 2 + 140);
		}
	}

	@Override
	public void action() {
		if (!startMenu) {
			if (countDown < 76) {

				if (countDown < 40)
					door[tmp.key]++;
				if (countDown >= 16 && countDown < 56) {
					if (isRight) {
						xball++;
						yball++;
					}
					if (isLeft) {
						if (tmp.data != 'X') {
							xball--;
							yball++;
						} else if (tmp.data == 'X' && countDown < 36) {
							xball--;
							yball++;
						}
					}
				}
				if (countDown >= 56 && tmp.data == 'X') {
					yball++;
					if (isRight)
						xball++;
				}
				countDown++;
			} else {
				isRight = false;
				isLeft = false;

				if (input.KeyIsDown(KeyEvent.VK_D) || input.KeyIsDown(KeyEvent.VK_RIGHT)) {
					if (tmp.right != null) {
						isRight = true;
						countDown = 0;
						tmp = tmp.right;
					}
				} else if (input.KeyIsDown(KeyEvent.VK_A) || input.KeyIsDown(KeyEvent.VK_LEFT))
					if (tmp.left != null) {
						isLeft = true;
						countDown = 0;
						tmp = tmp.left;
					}
				if (tmp.data == 'X' && yball < high)
					yball++;
				if (yball >= high || input.KeyIsDown(KeyEvent.VK_R)) {
					startMenu = true;
					tmp = maze.root;
					xball = width / 2 - 11;
					yball = 65;
					door = new int[maze.lastkey];
					countDown = 0;
				}
			}
		} else {
			if (input.anykeypressed() && !input.KeyIsDown(KeyEvent.VK_R) && !input.KeyIsDown(KeyEvent.VK_A)
					&& !input.KeyIsDown(KeyEvent.VK_D))
				startMenu = false;
		}
	}

}
