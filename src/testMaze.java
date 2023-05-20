
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


public class testMaze {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String nn = "BTTSTTTX";
		
		System.out.println(MazeSolver.translateToLeftRight(nn));
		System.out.println(MazeSolver.translateToStraightTurn("RRRR"));

		MazeSolver<Character> maze = new MazeSolver<Character>();

		maze.addPathToTree("SSS");
    	maze.addPathToTree("TSSX");
    	maze.addPathToTree("TTSS");
    	maze.addPathToTree("TTTST");
    	maze.addPathToTree("TTSTTTSX");

		System.out.println("Shortest path: "+maze.shortest());
		System.out.println("Shortest path: "+MazeSolver.translateToStraightTurn(maze.shortest()));
	}

}
