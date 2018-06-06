package Data;

public class Secuencia {
	
	public String secuencia;
	public String cromosoma;
	public int Start;
	public int fin;
	
	public Secuencia next;  // Pointer
 
	public Secuencia() {}
    
	public Secuencia(String secuencia, String cromosoma, int Start, int fin) 
	{
		this.secuencia = secuencia;
		this.cromosoma = cromosoma;
		this.Start = Start;
		this.fin = fin;
		this.next = null;
	}
	
	public String toString() 
	{
		return "Secuencia : " + this.cromosoma + "," + this.secuencia +","+ this.Start + ", "+ this.fin;
	}
}
