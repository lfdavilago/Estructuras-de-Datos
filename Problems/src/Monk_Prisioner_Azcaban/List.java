package Monk_Prisioner_Azcaban;

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
	
	public boolean isEmpty()
	{
		return this.head == null ? true : false;
	}
	
	public int length()
	{
		if(this.isEmpty())
			return 0;
		else
		{
			int length = 0;
			Node temp  = this.head;
			while(temp != null)
			{
				length++;
				temp = temp.next;
			}
			return length;
		}		
	}
	
	public void insertAtEnd(Node newNode)
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

	public int[] recorrerX()
	{
		int[] arr = new int[this.length()];
		Node temp = this.head;
		for(int i = 1; i <= this.length() ; i++)
		{
			Node temp2 = this.head;
			int index = -1;
			for(int j = 1; j < i ; j++)
			{
				if(temp2.getValue() > temp.getValue())
					index = j;
				
				temp2 = temp2.next;
			}
			arr[i-1] = index;
			temp = temp.next;
		}
		return arr;
	}
	
	public int[] recorrerY()
	{
		int[] arr = new int[this.length()];
		Node temp = this.head;
		for(int i = 1; i <= this.length() ; i++)
		{
			Node temp2 = temp.next;
			int index = -1;
			for(int j = i + 1; j <= this.length() ; j++)
			{
				if(temp2.getValue() > temp.getValue())
				{	
					index = j;
					break;
				}
				temp2 = temp2.next;
			}
			arr[i-1] = index;
			temp = temp.next;
		}
		return arr;
	}
	
	public static void main(String[] args) throws IOException
	{
		File input = new File("C:\\Users\\acer\\eclipse-workspace\\Problems\\src\\Monk_Prisioner_Azcaban\\input.txt");
		if(!input.exists())
			input.createNewFile();
		FileReader fr = new FileReader(input);
		BufferedReader br = new BufferedReader(fr);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		br.readLine();
		
		String[] line = br.readLine().split(" ");
		br.close();
		List lista = new List();
		for(int i = 0 ; i < line.length; i++)
			lista.insertAtEnd(new Node(Integer.parseInt(line[i])));
		int[] Y = lista.recorrerY();
		int[] X = lista.recorrerX();
		
		for(int i = 0; i < lista.length() ; i++)
			bw.write((Y[i] + X[i]) + " "); 
	
	    bw.flush();
	}
}
