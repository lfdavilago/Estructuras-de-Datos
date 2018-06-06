package Economic_PhoneB;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

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
	
	public int pop()
	{
		Node toPop = this.head;
		this.head = this.head.next;
		int data = toPop.calcular_Ahorro();
		toPop = null;
		System.gc();
		return data;
	}
	
	public String peek()
	{
		return this.head.numero_telefono;
	}
	
	public void printStack() throws IOException
	{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		bw.write("Grades:\n");
		while(!isEmpty())
		{
			bw.write(this.peek() + "\n");
			this.pop();
		}
		bw.flush();
	}
	
	
	public int calcularAhorroTotal()
	{
		int ahorroTotal = 0;
		while(!this.isEmpty()) 
				ahorroTotal += this.pop();
		return ahorroTotal;
	}
	
	public static void main(String[] args) throws IOException
	{
		File file = new File("C:\\Users\\acer\\eclipse-workspace\\Problems\\src\\Economic_PhoneB\\Lista_de_numeros.txt");
		if(!file.exists())
			file.createNewFile();
		FileReader fl = new FileReader(file);
		BufferedReader br = new BufferedReader(fl);
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out));
		ArrayList<Stack> pilas = new ArrayList<>();
		
		String linea = br.readLine();
		
		while(linea != null)
		{ 	// Radix sort
			Stack pila = new Stack();
			int size = Integer.parseInt(linea);
			for(int i = 0; i < size ; i++)
			{
				linea = br.readLine();
				pila.push(new Node(linea));
			}
			pilas.add(pila);
			linea = br.readLine();
		}
		br.close();
		for(Stack pila : pilas)
		{
			bw.write("Ahorro total : " + pila.calcularAhorroTotal() + "\n");
			bw.flush();
		}
		
	}
}
