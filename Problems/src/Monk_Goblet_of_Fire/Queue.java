package Monk_Goblet_of_Fire;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Queue {
	
	public Node head;
	
	public Queue()
	{
		this.head = null;
	}
	
	public boolean isEmpty()
	{
		return this.head == null ? true : false;
	}
	
	public void Enqueue(Node newNode)
	{
		if(this.isEmpty())
			this.head = newNode;
		else
		{
			Node temp = this.head;
			boolean stat = true;
			while(temp.next != null)
			{
				if(temp.getX() == newNode.getX())
				{
					if(temp.next.getX() == temp.getX())
					{	
						if( temp.getY() < newNode.getY() && temp.next.getY() >= newNode.getY())
						{	
							newNode.next = temp.next;
							temp.next = newNode;
							stat = false;
							break;
						}
					}
					else
					{
						newNode.next = temp.next;
						temp.next = newNode;
						stat = false;
						break;
					}
				}
				temp = temp.next;
			}
			if(stat)
				temp.next = newNode;
		}
	}
	
	public String Dequeue()
	{
		Node temp = this.head;
		this.head = temp.next;
		temp.next = null;
		return temp.toString();
	}
	
	
	public static void main(String[] args) throws IOException
	{
		File input = new File("C:\\Users\\acer\\eclipse-workspace\\Problems\\src\\Monk_Goblet_of_Fire\\input.txt");
		if(!input.exists())
			input.createNewFile();
		BufferedReader br = new BufferedReader(new FileReader(input));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine().replace(" ", ""));
		Queue cola = new Queue();
		for(int i = 0 ; i < N ; i++)
		{
			String[] line = br.readLine().split(" ");
			
			if(line[0].equals("E"))
			{
				Node newNode = new Node(Integer.parseInt(line[1]), Integer.parseInt(line[2]));
				cola.Enqueue(newNode);
			}
			else
				bw.write(cola.Dequeue());
		}
		
		br.close();
		bw.flush();
	}
}
