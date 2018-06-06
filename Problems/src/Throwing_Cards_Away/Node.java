package Throwing_Cards_Away;

public class Node {
	int numero;
	Node next;
	
	public Node(int numero)
	{
		this.numero = numero;
		this.next = null;
	}
	
	public String toString()
	{
		return ""+ this.numero;
	}
	
	public Node clone()
	{
		return new Node(this.numero);
	}
	
}
