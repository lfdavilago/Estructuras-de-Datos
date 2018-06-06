package How_to_Train_Your_Dragon;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class List {

	public Node head;
	public int Multa;
	public List()
	{
		this.head = null;
		this.Multa = 0;
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
	public boolean isEmpty()
	{
		return this.head == null ? true : false;
	}
	public int calcularMultaTotal()
	{		
		return this.Multa;
	}
	
	public void add(Node newDragon)
	{
		Node temp = this.head;
		if(this.isEmpty())
			this.head = newDragon;
		else
		{	
			while(temp.next != null)
				temp = temp.next;
			temp.next = newDragon;
		}
	}
	
	public void setSleepDays()
	{
		if(!this.isEmpty())
		{	
			Node temp = this.head.next;
		
			while(temp != null)
			{
				temp.setSleepDays();
				temp = temp.next;
			}
		}
	}
	
	public List QuickSort()
	{	
		
		if(this.length() <= 1)
			return this;
		else
		{
			double Pivot = this.head.prioridad();
			Node temp = this.head.next;
			List less = new List();
			List Upper = new List();
			while(temp != null)
			{
				if(temp.prioridad() < Pivot)
					less.add(temp.Clone());
				else
					Upper.add(temp.Clone());
				temp = temp.next;
			}
			less = less.QuickSort();
			Upper = Upper.QuickSort();
			this.head.next = Upper.head;
			less.add(this.head);
			return less;
		}
	}
	
	public void deleteAtBeing()
	{
		this.Multa += this.head.calcularMulta();
		Node toDelete = this.head;
		this.head = this.head.next;
		toDelete.next = null;
		toDelete = null;
	}
	public static void main(String[] args) throws IOException
	{
		File file = new File("C:\\Users\\acer\\eclipse-workspace\\Problems\\src\\How_to_Train_Your_Dragon\\Entradas.txt");
		if(!file.exists())
			file.createNewFile();
		
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		List lista = new List();
		String[] line = br.readLine().split(" "); 
		lista.head = new Node(Integer.parseInt(line[0])-1, Integer.parseInt(line[1]));
		String nline = br.readLine(); 
		while(nline != null)
		{
			line = nline.split(" ");
			lista.add(new Node(Integer.parseInt(line[0]), Integer.parseInt(line[1])));
			
			if(lista.head.trainigDays > 0)
				lista.head.setTrainigDays();
			else
			{ 
				lista = lista.QuickSort();
				lista.deleteAtBeing();
			}
			lista.setSleepDays();
			nline = br.readLine(); 
		}
		br.close();
		
		while(!(lista.isEmpty()))
		{   
			if(lista.head.trainigDays > 1)
				lista.head.setTrainigDays();
			else
				lista.deleteAtBeing();
			lista.setSleepDays();
		}
		
		
		System.out.print("Multa total : " + lista.calcularMultaTotal());
		
		
	}
	
	
	
	
}
