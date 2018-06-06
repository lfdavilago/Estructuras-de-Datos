package Where_Is_The_Marble;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Queue {

	Node head;
	int Q;
	int[] consultas;
	public Queue() 
	{
		this.head = null;
		this.Q = 0;
		this.consultas = null;
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
        int data = temp.value;
		this.head = this.head.next;
		temp = null;
		System.gc();
		return data;
	}
	
	
	public static void main(String[] args) throws IOException
	{
	
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out));
		Queue[] casos = new Queue[65];
		int N = -1, Q = -1, Index = 0;
		bw.write("N :\n");
		bw.flush();
		N = Integer.parseInt(br.readLine());
		bw.write("Q :\n");
		bw.flush();
		Q = Integer.parseInt(br.readLine());
		do 
		{			
			int cont = N + Q;

			Queue lista_de_casos = new Queue();
			lista_de_casos.Q = Q;
			lista_de_casos.consultas = new int[Q];
			
			while(cont != 0) 
			{	
				int marble = Integer.parseInt(br.readLine());
				
				if(cont > Q)
					lista_de_casos.Enqueue(new Node(marble));
				else
				{
					lista_de_casos.consultas[cont - 1] = marble;
				}
				
				cont--;
			}
			
			casos[Index] = lista_de_casos;
			Index++;
			
			bw.write("N :\n");
			bw.flush();
			N = Integer.parseInt(br.readLine());
			bw.write("Q :\n");
			bw.flush();
			Q = Integer.parseInt(br.readLine());
		} while(N != 0 && Q !=0);

		int numeral = 1;
		for(Queue cola : casos) 
		{	
			if(cola != null)
			{
				int index = 1;
				String[] outPut = new String[cola.Q];
				while(!cola.isEmpty()) 
				{	
					int contador = 0;
					int data = cola.Dequeue();
					for(int i = cola.Q - 1 ; i >=0 ; i--) 
					{
						if(cola.consultas[i] == data && outPut[i] == null)
						{
							outPut[i] = ""+ index;
							contador ++;
						}
					}
					if(contador == cola.Q)
						break;
					index++;
				}
				
				bw.write("Caso # "+ numeral + "\n");
				numeral++;
				for(int i = cola.Q - 1 ; i >=0 ; i--)
				{
					if(outPut[i] != null)
						bw.write(cola.consultas[i] + " encontrado en " + outPut[i] + "\n");
					else
						bw.write(cola.consultas[i] + " no encontrado \n");
				}
			}
			else
				break;
		}
		bw.flush();
	}
}