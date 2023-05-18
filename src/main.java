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

		maze.addPathToTree("SSS");
    	maze.addPathToTree("TSSSX");
    	maze.addPathToTree("TTSS");
    	maze.addPathToTree("TTTST");
    	maze.addPathToTree("TTSTTTSX");
    	
		MazeP Mp = new MazeP(frame, maze.root);
		
		frame.add(Mp);
		frame.setVisible(true);
		
	}

}
