/***********************************
 CLASS: Main class
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

import javax.swing.JFrame;

import MainProj.TheMaze;

public class main {

	public static void main(String[] args) {

		JFrame frame = new JFrame("Test game");
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		TheMaze<Character> maze = new TheMaze<Character>();

		maze.addPathToTree("SSSS");
		maze.addPathToTree("TSSSX");
		maze.addPathToTree("TTSSST");
		maze.addPathToTree("TTTSTT");
		maze.addPathToTree("TTTSS");
		maze.addPathToTree("TTSTTTSX");
		maze.addPathToTree("TTSTTTT");
    	
		MazeP Mp = new MazeP(frame, maze);
		
		frame.add(Mp);
		frame.setVisible(true);
		
	}

}
