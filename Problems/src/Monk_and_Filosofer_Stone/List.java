package Monk_and_Filosofer_Stone;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class List {
	public Node head;
	
	public List()
	{
		this.head = null;
	}
	
	public boolean isEpmty()
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
	
	public Node DeleteAtBeing()
	{
		Node toRemove = this.head;
		this.head = this.head.next;
		toRemove.next = null;
		return toRemove;
	}
	
	public void DeleteAtEnd()
	{
		Node temp = this.head;
		while(temp.next.next != null)
			temp = temp.next;
		temp.next = null;
	}
	
	public void InsertAtEnd(Node newCoin)
	{
		if(this.isEpmty())
			this.head = newCoin;
		else
		{
			Node temp = this.head;
			while(temp.next != null)
				temp = temp.next;
			temp.next = newCoin;
		}
	}

	public int totalCoinsValue()
	{
		int DineroTotal = 0;
		Node temp = this.head;
		while(temp != null)
		{
			DineroTotal += temp.getCoinValue();
			temp =  temp.next;		
		}
		
		return DineroTotal;
	}
	
	public static void main(String[] args) throws IOException
	{
		File input = new File("C:\\Users\\acer\\eclipse-workspace\\Problems\\src\\Monk_and_Filosofer_Stone\\Input.txt");
		if(!input.exists())
			input.createNewFile();
		FileReader fr = new FileReader(input);
		BufferedReader br = new BufferedReader(fr);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		List harrysBag = new List();
		List monksBag = new List();
		
		Integer.parseInt(br.readLine().trim());
		
		String[] line = br.readLine().split(" ");
		for(int i = 0; i < line.length ; i++)
			harrysBag.InsertAtEnd(new Node(Integer.parseInt(line[i])));
		line = br.readLine().split(" ");
		
		for(int i = 0; i < Integer.parseInt(line[0]) ; i++)
		{
			String operation = br.readLine();
			
			if(operation.equals("Harry"))
				monksBag.InsertAtEnd(harrysBag.DeleteAtBeing());
			else if(operation.equals("Remove"))
				monksBag.DeleteAtEnd();
			if(monksBag.totalCoinsValue() == Integer.parseInt(line[1]) )
				break;
		}
		
		if(monksBag.totalCoinsValue() == Integer.parseInt(line[1]) )
			bw.write("" + monksBag.length());
		else
			bw.write("-1");
		bw.flush();
		br.close();
	}
	
}
