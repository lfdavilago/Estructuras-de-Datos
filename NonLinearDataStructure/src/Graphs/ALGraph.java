package Graphs;

import java.util.ArrayList;

public class ALGraph {
	public ArrayList<Node> adyacentList;
	public int size;
	public ALGraph()
	{
		this.size = 0;
		this.adyacentList = new ArrayList<>();
	}
	
	public void addNodo(int toAdd)
	{
		this.adyacentList.add(new Node(toAdd));
	}
	
	public void addEdge(int src, int dest)
	{
		this.adyacentList.get(src).adyacentes.add(this.adyacentList.get(dest));
		this.adyacentList.get(dest).adyacentes.add(this.adyacentList.get(src));
	}
	
	public static void main(String[] arg)
	{
		ALGraph gp = new ALGraph();
		
		//Agregar nodos
		
		gp.addNodo(0);
		gp.addNodo(1);
		gp.addNodo(2);
		gp.addNodo(3);
		gp.addNodo(4);
		
		//Agregar links
		
		gp.addEdge(0, 1);
		gp.addEdge(0, 2);
		gp.addEdge(1, 2);
		gp.addEdge(4, 0);
		gp.addEdge(2, 4);
		gp.addEdge(3, 0);
		
		
		/*    3 
		 *    |
		 * 4--0--1     
		 *  \ | /
		 *    2       
		 */
		// Imprmir listas
		
		for(Node n : gp.adyacentList)
		{
			System.out.println("Nodo " + n.toString());
			for(Node v : n.adyacentes)
				System.out.print(v.toString() + " ");
			System.out.println();
		}
	}
}
