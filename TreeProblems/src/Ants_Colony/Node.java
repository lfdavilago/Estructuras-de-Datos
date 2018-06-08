package Ants_Colony;

import java.util.ArrayList;

public class Node {
	public int weight;
	public int id;
	
	public ArrayList<Node> ramas;
	public ArrayList<Integer> linkWeight;
	public Node(int id)
	{
		this.ramas = new ArrayList<>();
		this.linkWeight = new ArrayList<>();
		this.weight = 0;
		this.id = id;
	}
	
	
	
	
	
}
