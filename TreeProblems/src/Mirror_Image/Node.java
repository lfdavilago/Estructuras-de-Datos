package Mirror_Image;



public class Node {

	
	public int value;
	
	public Node left;
	public Node right;
	public int id;
	public Node(int i)
	{
		
		this.value= i;
		this.left = null;
		this.right = null; 
		if(i == 1)
			this.id = 0;
		else
			this.id = -1;
	}
	
	public boolean isEqual(int i)
	{
		return this.value == i ? true : false;
	}
	
	public int numbreOfChild()
	{
		return this.left == null ? (this.right == null ? 0 : 1) : (this.right == null ? 1 : 2);
	}
	public void setChild(Node nodo, String Addto)
	{
		if(Addto.equals("L"))
		{
			nodo.id = this.id*2 + 1; 
			this.left = nodo;
		}
		else if(Addto.equals("R"))
		{	
			nodo.id = this.id*2 + 2; 
			this.right = nodo;
		}
	}
}
