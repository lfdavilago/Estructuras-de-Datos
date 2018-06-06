package Economic_PhoneB;

public class Node 
{
	String numero_telefono;
	Node next;
	
	public Node(String numero_telefono)
	{
		this.numero_telefono = numero_telefono;
		this.next = null;
	}
	
	public String toString()
	{
		return ""+ this.numero_telefono;
	}
	
	public Node clone()
	{
		return new Node(this.numero_telefono);
	}
	
	public int comparar_numeros(String numero_self, String numero_Anterior)
	{
		if(numero_self.equals(numero_Anterior))
		{
			return numero_self.length();
		}
		else
		{
			String numero_self1 = numero_self.substring(0, numero_self.length() - 1);
			String numero_Anterior1 = numero_Anterior.substring(0, numero_Anterior.length() - 1);
			return comparar_numeros(numero_self1, numero_Anterior1);
		}
	}
	public int calcular_Ahorro()
	{
		if(this.next == null)
			return 0;
		else
		{	
			String numero_anterior = this.next.numero_telefono;
			return comparar_numeros(this.numero_telefono, numero_anterior);
		}
	}
}
