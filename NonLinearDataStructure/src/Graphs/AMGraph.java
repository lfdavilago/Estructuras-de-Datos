package Graphs;

public class AMGraph {
	public int maxSize;
	public int size;
	public Node[] nodos;
	public int [][] Matriz_Adyacencia;
	
	public AMGraph(int maxsize)
	{
		this.size = 0;
		this.maxSize = maxsize;
		this.nodos = new Node[this.maxSize];
		this.Matriz_Adyacencia = new int[this.maxSize][this.maxSize];
		for(int i = 0; i < this.maxSize; i++)
			for(int j = 0; j < this.maxSize; j++)
				this.Matriz_Adyacencia[i][j] = 0;
	}
	
	public void addNodo(int toAdd)
	{
		if(this.size < this.maxSize)
		{
			this.nodos[this.size] = new Node(toAdd);
			this.size++;
		}
	}
	
	public void addEdge(int src, int dest)
	{
		this.Matriz_Adyacencia[src][dest] = 1;
		this.Matriz_Adyacencia[dest][src] = 1;
	}
	
	
	public void printMatriz()
	{
		for(int i = 0; i < this.maxSize; i++)
		{	
			for(int j = 0; j < this.maxSize; j++)
				System.out.print(this.Matriz_Adyacencia[i][j] +" ");
			System.out.println();
		}
	}
	
	public static void main(String[] agrs)
	{
        AMGraph gp = new AMGraph(5);
		
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
		gp.printMatriz();
	
	}
	
	
	
	
	
	
}
