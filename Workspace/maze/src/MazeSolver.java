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


public class MazeSolver<T> {

    private MNode<T> root;

    public MazeSolver(MNode<T> root) {
        this.root = root;
    }

    private boolean follow(MNode<T> t, String path) {
        if (t == null) {
            return false;
        }
        if (path.length() == 0) {
            return true;
        }
        char direction = path.charAt(0);
        if (direction == 'L') {
            return follow(t.left, path.substring(1));
        } else if (direction == 'R') {
            return follow(t.right, path.substring(1));
        }
        return false;
    }

    private boolean escape(MNode<T> t) {
        if (t == null) {
            return false;
        }
        if (t.data.equals('X')) {
            return true;
        }
        return escape(t.left) || escape(t.right);
    }

    private String shortestPathHelper(MNode<T> t, String pathSoFar) {
        if (t == null) {
            return null;
        }
        if (t.data.equals('X')) {
            return pathSoFar;
        }
        String leftPath = shortestPathHelper(t.left, pathSoFar + "L");
        String rightPath = shortestPathHelper(t.right, pathSoFar + "R");
        if (leftPath == null) {
            return rightPath;
        } else if (rightPath == null) {
            return leftPath;
        } else {
            return leftPath.length() < rightPath.length() ? leftPath : rightPath;
        }
    }

    private String shortestPath() {
        return shortestPathHelper(root, "");
    }

}

