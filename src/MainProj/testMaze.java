/***********************************
 CLASS: Main class
 CSC212 Data structures - Project phase I
 Spring 2023

 DATE:
 20-05-2023

 TEAM:
 Team RED

 AUTHORS:
 Fahad Aldakheel,     (ID439106720)
 Osama Alajaji,       (ID443100980)
 Mohammad Alkhenizan, (ID443102405)

 ***********************************/

package MainProj;

public class testMaze {
	

	public static void main(String[] args) {
		/*
		* This file is to test actual maze, the other one is for GUI
		*/

		String nn = "BTTSTTTX";
		
		System.out.println(TheMaze.translateToLeftRight(nn));
		System.out.println(TheMaze.translateToStraightTurn("RRRRX"));
		
		TheMaze<Character> maze = new TheMaze<Character>();

		maze.addPathToTree("SSS");
    	maze.addPathToTree("TSSSX");
    	maze.addPathToTree("TTSS");
    	maze.addPathToTree("TTTST");
    	maze.addPathToTree("TTSTTTSX");

		System.out.println("Shortest path: "+maze.shortest());
		System.out.println(maze.lastkey);
	}

}