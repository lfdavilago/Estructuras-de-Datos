package Graphs;

import java.util.ArrayList;

public class Node {

	public int value;
	public ArrayList<Node> adyacentes;
	public Node(int value)
	{
		this.value = value;
		this.adyacentes = new ArrayList<>();
	}
	
	public String toString()
	{
		return "" + this.value;
	}
}
