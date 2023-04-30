
public class MazeSolver<T> {

    private MNode root;

//	Write the method private boolean follow(MNode <T> t, String path), which tests
//	if the path indicated by path and starting from t is valid. A path is valid if its
//	directions are available (not necessarily leading to an exit).
//	For example, In the maze shown above, the paths: "T-T", "T-T-X", "S-T" are valid,
//	whereas the paths "S-T-X" and "S-T-S" are not valid.
	private boolean follow(MNode <T> t, String path)
	{return true;}
	
	
//	Write the method private boolean escape(MNode <T> t), which searches for an
//	exit starting at t using preorder traversal and returns true if it finds one. 
	private boolean escape(MNode <T> t)
	{return true;}
	
//	Write the method private String short(), which returns the shortest path to an exit
//	starting at the root.
//	For example, In the maze shown above, the shortest path is: “B-T-S-S-X”
	private String shortest() {return null;}
	
	public static String translateToLeftRight(String path) {
		StringBuilder newPath = new StringBuilder();
		String side = "left";

		for (int i = 0; i < path.length(); i++) {
			switch (path.charAt(i)) {
				case 'S': {
					if (side.equals("left")) {
						newPath.append("L");
					} else {
						newPath.append("R");
					}
					break;
				}

				case 'T': {
					if (side.equals("left")) {
						newPath.append("R");
						side = "right";
					} else {
						newPath.append("L");
						side = "left";
					}
					break;
				}
				default:{
					newPath.append(path.charAt(i));
				}
			}
		}

		return newPath.toString();
	}

}




//class MNode<T> {
//    public T data;
//    public MNode<T> left, right;
//
//    public MNode(T data) {
//        this.data = data;
//        this.left = null;
//        this.right = null;
//    }
//}
//
//
//public class MazeSolver<T> {
//
//    private MNode<T> root;
//
//    public MazeSolver(MNode<T> root) {
//        this.root = root;
//    }
//
//    private boolean follow(MNode<T> t, String path) {
//        if (t == null) {
//            return false;
//        }
//        if (path.length() == 0) {
//            return true;
//        }
//        char direction = path.charAt(0);
//        if (direction == 'L') {
//            return follow(t.left, path.substring(1));
//        } else if (direction == 'R') {
//            return follow(t.right, path.substring(1));
//        }
//        return false;
//    }
//
//    private boolean escape(MNode<T> t) {
//        if (t == null) {
//            return false;
//        }
//        if (t.data.equals('X')) {
//            return true;
//        }
//        return escape(t.left) || escape(t.right);
//    }
//
//    private String shortestPathHelper(MNode<T> t, String pathSoFar) {
//        if (t == null) {
//            return null;
//        }
//        if (t.data.equals('X')) {
//            return pathSoFar;
//        }
//        String leftPath = shortestPathHelper(t.left, pathSoFar + "L");
//        String rightPath = shortestPathHelper(t.right, pathSoFar + "R");
//        if (leftPath == null) {
//            return rightPath;
//        } else if (rightPath == null) {
//            return leftPath;
//        } else {
//            return leftPath.length() < rightPath.length() ? leftPath : rightPath;
//        }
//    }
//
//    private String shortestPath() {
//        return shortestPathHelper(root, "");
//    }
//
//}
//
