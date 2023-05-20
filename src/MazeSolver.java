
/***********************************
CLASS: MazeSolver
CSC212 Data structures - Project phase I
Spring 2023

DATE:
	20-05-2023

TEAM:
	Team RED

AUTHORS:
	Osama Alajaji,       (ID443100980)
	Mohammad Alkhenizan, (ID443102405)

***********************************/


public class MazeSolver<T> {

	// we had to use (T) Character.valueOf('B') in all of the code assignment,
	// because node data is generic, and we found this way to assign value to it
    private MNode<T> root = new MNode<T>((T) Character.valueOf('B')); 

	// This method is used to construct the maze nodes inside it
	// It takes a path and traverse it while adding nodes
    public void addPathToTree(String path) {
    	String pathRL = translateToLeftRight(path);
		
    	MNode<T> tmp = root;
    	for(int i = 0; i < pathRL.length(); i++) {
    		if(pathRL.charAt(i) == 'L') {
				if (tmp.left == null)
					tmp.left = new MNode<T>((T) Character.valueOf('L'));
    			tmp = tmp.left;
    		}
    		else if(pathRL.charAt(i) == 'R'){
				if (tmp.right == null)
    				tmp.right = new MNode<T>((T) Character.valueOf('R'));
    			tmp = tmp.right;
    		}
    		else if(pathRL.charAt(i) == 'X') {
    			tmp.data = (T) Character.valueOf('X');
    		}
    	}	
    }

	// Checks if the path exsists at node t
	private boolean follow(MNode <T> t, String path){
		String pathRL = translateToLeftRight(path);

		MNode<T> tmp = t; 
		for (int i= 0; i<pathRL.length(); i++){ 
			switch (pathRL.charAt(i)){ 

				case 'R': 
					if (tmp.right == null)
						return false;
					tmp = tmp.right;
					break;

				case 'L': 
					if (tmp.left == null)
						return false;
					tmp = tmp.left;
					break;
				
				case 'X': 
					if (!tmp.data.equals('X'))
						return false;
					break;
					
				case 'B': 
					if (!tmp.data.equals('B'))
						return false;
					break;
			}
		}

		return true; 
	}
	
	// Checks if exsit exsists at node t
	private boolean escape(MNode <T> t) {
		if (t == null) return false;
		if (t.data.equals('X')) return true;
		
		return escape(t.left) || escape(t.right);
	}

	// Find shortest, using the helper method findShortest(MNode <T> t)
	// Will return path in Straight Turn format
	public String shortest() {
		if (root == null) return "";

		return findShortest(root) + 'X';
	}
	
	// Method to find shortest path using recursion and operating system stack
	// Will return path in Left Right format
	private String findShortest(MNode <T> t){
		String left = "";
		String right = "";
		
		if (!escape(t)) return "";

		if (escape(t.left))
			left = "L" + findShortest(t.left);
		
		if (escape(t.right))
			right = "R" + findShortest(t.right);
		

		if(right == "") return left;
		if(left == "") return right;

		return right.length() > left.length()? left:right; // Big brain line :)
	}
	
	// Helper static method to translate path from Left Right, to Straight Turn 
	public static String translateToStraightTurn(String path) {
		String newPath = "";
		
		if(path.charAt(0) == 'L')
		newPath += 'S';
		else
		newPath += 'T';
		
		for (int i = 1; i < path.length(); i++) {
			
			if (path.charAt(i) == 'X' || path.charAt(i) == 'B')
			newPath += path.charAt(i);
			
			else if(path.charAt(i-1) == path.charAt(i))
			newPath += 'S';
			
			else
			newPath += 'T';
		}
		return newPath;
	}
	
	// Helper static method to translate path from Straight Turn, to Left Right 
	public static String translateToLeftRight(String path) {
		String side = "left";
		String newPath = "";
		
		for (int i = 0; i < path.length(); i++) {

			if (path.charAt(i) == 'S') 

				if (side.equals("left"))
				  newPath += "L";
				else
				  newPath += "R";
				

			else if (path.charAt(i) == 'T') 
				
				if (side.equals("left")) {
				  newPath += "R";
				  side = "right";
				} else {
				  newPath += "L";
				  side = "left";
				}

			else 
				newPath += path.charAt(i);
			  
		}

		return newPath;
	}

}

