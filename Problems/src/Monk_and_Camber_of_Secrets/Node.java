package Monk_and_Camber_of_Secrets;

public class Node {
	
	private int power;
	private int originalIndex;
	public Node next;
	public Node(int power)
	{
		this.power = power;
		this.originalIndex = Integer.MIN_VALUE;
		this.next = null;
	}
	
	public void powerDecreased()
	{
		if(this.power > 0)
			this.power--;
	}
	public void setOriginalIndex(int Index)
	{
		this.originalIndex = Index;
	}
	public int getOriginalIndex()
	{
		return this.originalIndex;
	}
	public int getPower()
	{
		return this.power;
	}
	
}
