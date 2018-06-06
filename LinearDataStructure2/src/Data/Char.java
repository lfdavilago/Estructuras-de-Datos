package Data;

public class Char {
	private char caracter;
	public Char next;
	public Char()
	{
		this.caracter = 0;
		this.next = null;
	}

	public void setCaracter(char a)
	{
		this.caracter = a;
	}
	
	public char getCaracter()
	{
		return this.caracter;
	}

}
