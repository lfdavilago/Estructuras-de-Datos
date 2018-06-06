package Monk_and_Camber_of_Secrets;

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
	
	public int length()
	{
		int length = 0;
		Node temp = this.head;
		while(temp != null)
		{
			length++;
			temp = temp.next;
		}
		return length;
	}
	
	public void Enqueue(Node newNode)
	{
		if(this.isEmpty())
			this.head = newNode;
		else
		{
			Node temp = this.head;
		
			while(temp.next != null)
				temp = temp.next;
			temp.next = newNode;
		}
	}
	
	public Node Dequeue()
	{
		Node toRemove = this.head;
		this.head = this.head.next;
		toRemove.next = null;
		return toRemove;
	}
	
	public static void main(String[] args) throws IOException
	{
		File input = new File("C:\\Users\\acer\\eclipse-workspace\\Problems\\src\\Monk_and_Camber_of_Secrets\\input.txt");
		if(!input.exists())
			input.createNewFile();
		FileReader fr =new FileReader(input);
		BufferedReader br = new BufferedReader(fr);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] line = br.readLine().split(" ");
		int subLength = Integer.parseInt(line[1]);
		int outputLength = Integer.parseInt(line[1]);
		
		line = br.readLine().split(" ");
		Queue Spiders = new Queue();
		
		for(int i = 0 ; i < line.length; i++)
		{
			Node newSpider = new Node(Integer.parseInt(line[i]));
			newSpider.setOriginalIndex(i);
			Spiders.Enqueue(newSpider);
		}
		
		for(int k = 0; k < outputLength ; k++ )
		{
			
			Node MaxValue = new Node(Integer.MIN_VALUE);
			if(Spiders.length() <= subLength)
				subLength = Spiders.length();
			
			Node[] subArr = new Node[subLength];
			
			for(int i = 0; i < subLength ; i++)
			{
				subArr[i] = Spiders.Dequeue();
				
				if(subArr[i].getPower() > MaxValue.getPower())
					MaxValue = subArr[i];
			}
			
			for(int i = 0 ; i < subLength ; i++)
				if(subArr[i].getOriginalIndex() != MaxValue.getOriginalIndex())
				{	
					subArr[i].powerDecreased();
					Spiders.Enqueue(subArr[i]);
				}
			
			bw.write((MaxValue.getOriginalIndex() + 1) + " ");
		
		}
		br.close();
		bw.flush();
	}
	

}
