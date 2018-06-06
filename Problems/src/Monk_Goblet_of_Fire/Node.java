package Monk_Goblet_of_Fire;

public class Node {
	private int X;
	private int Y;
	public Node next;
	
	public Node(int x, int y)
	{
		this.X = x;
		this.Y = y;
		this.next = null;
	}
	
	public int getX()
	{
		return this.X;
	}
	
	public int getY()
	{
		return this.Y;
	}
	
	public String toString()
	{
		return this.X + " " + this.Y + "\n";
	}
	
}
