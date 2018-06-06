package Monk_and_Filosofer_Stone;

public class Node {
	private int coinValue;
	public Node next;
	public Node(int value)
	{
		this.coinValue = value;
		this.next = null;
	}
	
	public int getCoinValue()
	{
		return this.coinValue;
	}


}
