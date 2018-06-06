package Going_to_Market;

public class Node 
{
	String articulo;
	double precio;
	int cantidad;
	Node next;
	
	public Node(String articulo, double precio)
	{
		this.articulo = articulo;
		this.precio = precio;
		this.cantidad = 0;
		this.next = null;
	}
	
	public String toString()
	{
		return ""+ this.articulo;
	}
	
	public Node clone()
	{
		return new Node(this.articulo, this.precio);
	}
	
	public double calcular_costo()
	{
		return this.cantidad * this.precio;
	}
}
