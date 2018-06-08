package Ants_Colony;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;



public class Graph {
	public ArrayList<Node> nodos;
	
	public Graph()
	{
		this.nodos = new ArrayList<>();
	}
	
	public void addNode(Node newNode)
	{
		this.nodos.add(newNode);
	}
	
	public void addLink(int src, int dest, int weight)
	{
		this.nodos.get(src).ramas.add(this.nodos.get(dest));
		this.nodos.get(src).linkWeight.add(weight);
		this.nodos.get(dest).ramas.add(this.nodos.get(src));
		this.nodos.get(dest).linkWeight.add(weight);
	}
	
	public ArrayList<Node> dijkstra(Node Origen)
	{
		MinHeap mp = new MinHeap(this.nodos.size());
		
		for(int i = 0; i < this.nodos.size(); i++)
		{
			int size = Integer.MAX_VALUE;
			if(this.nodos.get(i).equals(Origen))
				size = 0;
			this.nodos.get(i).weight = size;
			mp.insert(this.nodos.get(i));
		}
		
		ArrayList<Node> nodos  = new ArrayList<>();
		
 		while(!mp.isEmpty())
		{
			Node yo = mp.getMin();
			nodos.add(yo);
		}
 		
 		return nodos;
	}
	
	public void solveMinPath() throws IOException 
	{
		File input = new File("input2.txt");
		if(!input.exists())
			input.createNewFile();
		
		BufferedReader br = new BufferedReader(new FileReader(input));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String INPUT = br.readLine();
		while(INPUT != null && !INPUT.equals("0"))
		{	
			int V = Integer.parseInt(INPUT.replace(" ", ""));
			
			for(int i = 0; i <= V ; i++)
				this.addNode(new Node(i));
		
			for(int i = 1; i <= V - 1; i++)
			{
				String[] line = br.readLine().split(" ");
				this.addLink(i, Integer.parseInt(line[0]), Integer.parseInt(line[1]));
			}
			
			int C = Integer.parseInt(br.readLine().replace(" ", ""));
			
			for(int i = 0 ; i < C  ; i++)
			{
				String[] line = br.readLine().split(" ");
				ArrayList<Node> n = this.dijkstra(this.nodos.get(Integer.parseInt(line[0])));
				
				for(Node Nodo : n)
					if(Nodo.equals(this.nodos.get(Integer.parseInt(line[1]))))
					{
						bw.write(Nodo.weight + " ");
						break;
					}
			}
			bw.write("\n");
			this.nodos.clear();
			INPUT = br.readLine();
			
		}
		br.close();
		bw.flush();
	}
	
	public static void main(String[] agrs) throws IOException
	{
		Graph grafo = new Graph();
		grafo.solveMinPath();
	}



}