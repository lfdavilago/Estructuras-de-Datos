package Going_to_Market;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;


public class List {

	
	Node head;
	
	public List()
	{
		this.head = null;
	}
	/**
	 * isEmpty
	 * @return True if the Node is Empty. 
	 */
	public boolean isEmpty() 
	{
		return head==null? true : false;
	}
	
	public int Size()
	{
		Node temp = this.head;
	    int Size = 0;
	    while(temp != null)
	    {
	    	temp = temp.next;
	    	Size++;
	    }
	    return Size;
	}
	
	public void insertAtBegin(Node newNode)
	{
		newNode.next = this.head;
		this.head = newNode;
	}
	
	public void printList() throws IOException
	{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Node temp = head;
		bw.write("Grades: \n");
		while(temp !=null)
		{
			bw.write(temp.toString());
			temp= temp.next;
		}
		bw.flush();
	}
	
	public void insertAtEnd(Node newNode)
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
	
	public void deleteAtBegin()
	{   
		Node temp = this.head; 
		this.head = this.head.next;
		temp.next = null;
		temp = null;
		System.gc();
	}
	
	public boolean insertAtIndex(Node newNode, int location)
	{
		if(location < 0 || location > this.Size()) return false;
		
		if(location == 0)
		{
			this.insertAtBegin(newNode);
			return true;
		}
		
		if(location == this.Size())
		{
			this.insertAtEnd(newNode);
			return true;
		}
        Node temp = this.head;
	    for(int i = 0 ; i < location - 1 ; i++)
	    	temp = temp.next;
		newNode.next = temp.next;
		temp.next = newNode;
		return true;	
	}
	
	public void deleteAtEnd()
	{
		Node temp = this.head;
		while(temp.next.next != null)
			temp = temp.next;
		temp.next = null;
		System.gc();
	}
	
	public boolean deleteAtIndex(int Index) 
	{
		if(Index < 0 || Index >= this.Size()) return false;
		
		if(Index == 0)
		{
			this.deleteAtBegin();
			return true;
		}
		
		if(Index == this.Size()-1)
		{
			this.deleteAtEnd();
			return true;
		}
		Node temp = this.head;
		for(int i = 0; i < Index - 1; i++)
			temp = temp.next;
		Node toDelete = temp.next;
		temp.next = toDelete.next;
		toDelete = null;
		System.gc();
		return true;
	}
	

	public double calcular_costoTotal()
	{	
		double costoTotal = 0;
		Node temp = this.head;
		while(temp != null)
		{
			costoTotal += temp.calcular_costo();
			temp = temp.next;
		}
		return costoTotal;
	}
	
	public static void main(String[] args) throws IOException 
	{
		File file = new File("C:\\Users\\acer\\eclipse-workspace\\Problems\\src\\Going_to_Market\\Lista_articulos.txt");
		if(!file.exists())
			file.createNewFile();
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		ArrayList<List> listas = new ArrayList<>();
		int cant_listas = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < cant_listas ; i++)
		{
			List lista_articulos = new List();
			int cant_articulos = Integer.parseInt(br.readLine());
			
			for(int j = 0 ; j < cant_articulos ; j++)
			{
				String[] atributes = br.readLine().split(" ");
				lista_articulos.insertAtEnd(new Node(atributes[0], Double.parseDouble(atributes[1].replace(" ", ""))));
			}
			
			cant_articulos = Integer.parseInt(br.readLine());
			
			for(int j = 0 ; j < cant_articulos ; j++)
			{
				String[] atributes = br.readLine().split(" ");	
				Node temp = lista_articulos.head;
				while(temp != null)
				{
					if(temp.articulo.equals(atributes[0]))
					{
						temp.cantidad = Integer.parseInt(atributes[1].replace(" ", ""));
						break;
					}
					temp = temp.next;
				}
			}
			listas.add(lista_articulos);
		}
		br.close();
		for(List lista : listas)
		{
			bw.write("Costo total: " + lista.calcular_costoTotal() + "$ \n");
		}
		bw.flush();
	}
}
