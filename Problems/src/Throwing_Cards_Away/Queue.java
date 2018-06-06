package Throwing_Cards_Away;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Queue {
	Node head;
	int n;
	
	public Queue(int n) 
	{
		this.head = null;
		this.n = n; 
	}
	
	public Queue()
	{
		this.head = null;
	}
	public boolean isEmpty() 
	{
		return head==null? true : false;
	}
	
	public void Enqueue(Node newNode)
	{
		if(isEmpty())
			this.head = newNode;
		else
		{
			Node temp = head;
			
			while(temp.next != null)
				temp = temp.next;
			
			temp.next = newNode;
		}
	}
	
	public int Dequeue()
	{   
		Node temp = this.head;
		int data = temp.numero;
		this.head = this.head.next;
		temp = null;
		System.gc();
		return data;
	}

	
	
	public Queue funcion( Queue descarte)
	{
		if(this.head.next.next == null)
		{	
			descarte.Enqueue(new Node(this.Dequeue()));
			return descarte;
		}
		else
		{
			descarte.Enqueue(new Node(this.Dequeue()));
			Node temp = this.head;
			this.Dequeue();
			temp.next = null;
			this.Enqueue(temp);
			return funcion(descarte);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		ArrayList<Queue> casos = new ArrayList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		while(n != 0)
		{
			Queue temporal = new Queue(n);
			for(int i = 0; i < n ; i++)
				temporal.Enqueue(new Node(i + 1));
			casos.add(temporal);
			n = Integer.parseInt(br.readLine());
		}
		
		for(Queue maso : casos)
		{
			Queue descarte = new Queue();
			maso.funcion(descarte);
			bw.write("Descartadas : " + descarte.Dequeue());
			while(!descarte.isEmpty())
			{
				bw.write(", " + descarte.Dequeue());
			}
			bw.write("\nCarta final : " + maso.Dequeue() +"\n");
		}
		bw.flush();
	}
}
