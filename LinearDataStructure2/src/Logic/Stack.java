package Logic;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import Data.Node;

public class Stack {
	
	Node head;
	
	public Stack() 
	{
		this.head = null;
	}
	
	public boolean isEmpty()
	{
		return head == null ? true : false;
	}
	
	public void push(Node newNode)
	{
		newNode.next = this.head;
		this.head = newNode;
	}
	
	public String pop()
	{
		Node toPop = this.head;
		this.head = this.head.next;
		String data = toPop.toString();
		toPop = null;
		System.gc();
		return data;
	}
	
	public String peek()
	{
		return this.head.toString();
	}
	
	public void printStack() throws IOException
	{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		bw.write("Grades:\n");
		while(!isEmpty())
			bw.write(pop());
		bw.flush();
	}
	
	
	public static void main(String[] args) throws IOException
	{
		Stack pila = new Stack();
		
		pila.push(new Node(0));
		
		pila.push(new Node(1));
		
		pila.push(new Node(2));
		
		pila.push(new Node(3));
		
		pila.push(new Node(4));
		
		pila.printStack();
	   
	}
	
	
}
