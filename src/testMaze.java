
public class testMaze {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String nn = "BTTSTTTX";
		
		System.out.println(MazeSolver.translateToLeftRight(nn));
		System.out.println(MazeSolver.TranslateToST("RRRR"));

		MazeSolver<Character> maze = new MazeSolver<Character>();

		maze.addPathToTree("SSS");
    	maze.addPathToTree("TSSSX");
    	maze.addPathToTree("TTSS");
    	maze.addPathToTree("TTTST");
    	maze.addPathToTree("TTSTTTSX");

		System.out.println("Shortest path: "+maze.shortest());
	}

}
