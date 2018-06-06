package Monk_Order_Phoenix;

public class Node {
	private int height;
	public Node next;
	
	public Node(int height)
	{
		this.height = height;
		this.next = null;
	}
	
	
	public int getHeight()
	{
		return this.height;
	}
	
	
	
}
