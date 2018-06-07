package Hashing;

import java.io.IOException;

public class HashTable {
	public List[] hash;
	
	public HashTable()
	{
		this.hash = new List[10];
		for(int i = 0; i < this.hash.length ; i++)
			this.hash[i] = new List();
	}
	
	public int hashfunction(int i)
	{
		return i%10;
	}
	
	public void addNewNode(Node newNode) 
	{
		this.hash[this.hashfunction(newNode.value)].insertAtEnd(newNode);
	}
	
	public void delete(int toDelete)
	{
		if(this.hash[this.hashfunction(toDelete)].head.value == toDelete)
			this.hash[this.hashfunction(toDelete)].deleteAtBegin();
		else
		{	
			Node temp = this.hash[this.hashfunction(toDelete)].head;
			Node padre = null;
			for(int i = 0; i < this.hash[this.hashfunction(toDelete)].length() ; i++)
			{
				if(temp.value == toDelete)
				{	
					padre.next = temp.next;
					break;
				}
				padre = temp;
				temp = temp.next;
			}
		}
	}
	
	public Node search(int i)
	{
		return this.hash[this.hashfunction(i)].linealSearch(new Node(i));
	}
	
	public void print() throws IOException
	{
		System.out.println( "HashTable" );
		for(List n : this.hash)
			if(n.head != null)
			{	
				System.out.print("Clave:" + this.hashfunction(n.head.value) + " -> " );
				n.printList();
			}
	}
	
	
	public static void main(String[] agrs) throws IOException
	{
		HashTable HashTable = new HashTable();
	
		HashTable.addNewNode(new Node(87534));
		HashTable.addNewNode(new Node(87515));
		HashTable.addNewNode(new Node(87528));
		HashTable.addNewNode(new Node(87589));
		HashTable.addNewNode(new Node(34));
		HashTable.addNewNode(new Node(15));
		HashTable.addNewNode(new Node(28));
		HashTable.addNewNode(new Node(9));
		HashTable.addNewNode(new Node(9884));
		HashTable.addNewNode(new Node(7545));
		HashTable.addNewNode(new Node(548));
		HashTable.addNewNode(new Node(769));
		
		HashTable.print();
		
		HashTable.delete(87589);
		HashTable.delete(9);
		HashTable.delete(9884);
		HashTable.delete(28);
		
		HashTable.print();
		
		Node n = HashTable.search(548);
		System.out.print("Nodo Buscado: " + n.toString());	
	}
	
}
