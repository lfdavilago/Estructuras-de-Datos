package Monk_Order_Phoenix;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Stack {
	public Node head;
	
	public Stack()
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
	
	public void push(Node newNode)
	{
		newNode.next = this.head;
		this.head = newNode;
	}
	
	public void pop()
	{	
		Node toPop = this.head;
		this.head = this.head.next;
		toPop.next = null;
		toPop = null;
		System.gc();
	}
	
	public Node getAtIndex(int index)
	{
		if(this.length() - 1 < index)
			return null;
		else
		{	
			Node temp = this.head;
			for(int i = 0 ; i < index; i++)
				temp = temp.next;
			return temp;
		}	
	}
	
	public Node BinarySearch(Node nodeToCompare)
	{
		int Up = 0;
		int Dw = this.length() - 1;
		int stat = 0;
		Node temp = null;
		Node temp1 = null;
		
		if(nodeToCompare.getHeight() > this.head.getHeight())
			return null;
		
		int MidPoint =0;
		while(Dw >= Up)
		{	
			MidPoint = (Dw + Up)/2;
			temp = this.getAtIndex(MidPoint);
			if(temp.getHeight() > nodeToCompare.getHeight())
			{	
				Up = MidPoint + 1;
				stat = 1;
			}
			else if (temp.getHeight() < nodeToCompare.getHeight())
			{	
				Dw = MidPoint - 1;
				stat = 0;
			}
			else
			{
				stat = -1;
				break;
			}
			
			temp1 = this.getAtIndex(MidPoint - 1);
		}	
		
		if(stat == 1)
			return temp;
		else if(stat == 0)
			return temp1;
		else
		{
			for(int i = 0; i < this.length() ; i++ )
			{
				Node temp2 = this.getAtIndex(MidPoint - i);
				if(temp2.getHeight() != temp.getHeight())
					temp1 = temp2;
			}
			
			return temp1;
		}
		
	}
	
	public static void main(String[] args) throws IOException
	{
		File input = new File("C:\\Users\\acer\\eclipse-workspace\\Problems\\src\\Monk_Order_Phoenix\\input.txt");
		if(!input.exists())
			input.createNewFile();
		BufferedReader br = new BufferedReader(new FileReader(input));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		ArrayList<Stack> ejercito = new ArrayList<>();
		
		int N = Integer.parseInt(br.readLine().replace(" ", ""));
		for(int i = 0 ; i < N ; i++)
		{
			String[] line = br.readLine().split(" ");
			Stack newFila = new Stack();
			
			for(int j = 1 ; j < line.length ; j++)
				newFila.push(new Node(Integer.parseInt(line[j])));
			
			ejercito.add(newFila);
		}
		
		int Q = Integer.parseInt(br.readLine().replace(" ", ""));
		
		for(int i = 0 ; i < Q ; i++)
		{
			String[] operation = br.readLine().split(" ");
			
			if(Integer.parseInt(operation[0]) == 0)
				ejercito.get(Integer.parseInt(operation[1]) - 1).pop();
			else if(Integer.parseInt(operation[0]) == 1)
				ejercito.get(Integer.parseInt(operation[1]) - 1).push(new Node(Integer.parseInt(operation[2])));
			else
			{
				Node min = new Node(Integer.MAX_VALUE);
				Node temp = ejercito.get(0).head;
				for(int j = 0; j < ejercito.get(0).length() ; j++)
				{
					if(temp.getHeight()  < min.getHeight())
						min = temp;
					temp = temp.next;
				}
				
				int contador = 1;
				
				for(int x = 1; x < ejercito.size() ; x++)
				{	
					min = ejercito.get(x).BinarySearch(min);
					
					if(min == null)
						break;
					else
						contador++;
				}
				
				if(contador == N)
					bw.write("YES \n");
				else
					bw.write("NO \n");
			}
		}
		
		br.close();
		bw.flush();
	}
}
