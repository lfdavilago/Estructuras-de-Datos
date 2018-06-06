package BinaryTree;

public class Node {
	 
	 public int value;
	 public String str;
	 public Node right;
	 public Node left;
	 public int altulra;
	 public Node(int value)
	 {
		 this.right = null;
		 this.left = null;
		 this.value = value;
		 this.altulra = 1;
	 }
	 
	 public Node(String stirng)
	 {
		 this.str = stirng;
	 }
	 
	 public String toString()
	 {
		 return "Value : " + str + "\n";
	 }
	 
	 public Node clone()
	 {
		 return new Node(this.value);
	 }
	 
	 
}
