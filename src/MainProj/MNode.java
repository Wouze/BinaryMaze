/***********************************
 CLASS: Node class
 CSC212 Data structures - Project phase I
 Spring 2023

 DATE:
 20-05-2023

 TEAM:
 Team RED

 AUTHORS:
 Mohammad Alkhenizan, (ID443102405)

 ***********************************/

package MainProj;

public class MNode<T> {
	public int key;
	public T data;
	public MNode<T> left, right;

	public MNode() {
	}

	public MNode(T data, int key) {
		this.data = data;
		this.key = key;
	}
}