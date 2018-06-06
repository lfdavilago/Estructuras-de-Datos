import java.io.*;

/**
 * Describir de que se trata el ejercicio
 * @author Luis Felipe Dávila Goyeneche
 */
public class Recurrences {

	/**
	 * Dados dos números enteros no negativos a, b la función determina el número mayor y calcula el residuo del cociente entre el # mayor y el # menor
	 * si este residuo es cero entonces el mcd entre el # mayor y el # menor será este último, en caso que no sea cero, la fucnion calcula el mcd(b,r)
	 * donde r es el residuo entre a y b (siempre que a sea el mayor). Se sabe que mcd(a,b) = mcd(b,r) 
	 * @param a
	 * @param b
	 * @return número entero que es mcd entre a y b.
	 */
	public int mcd_euclides(int a, int b)
	{
		if(a < b) 
		{
			int temp = a;
			a = b;
			b = temp;
		}
		
		if(a%b == 0) 
			return b;
		else
			return mcd_euclides(b, a%b);

	}
	
	
	/**
	 * Dado un entero no negativo x la función realiza el producto entre x y valor de retorno de la función para (x - 1), si se sabe que el valor
	 * de retorno de la función para  x = 0 es 1.
	 * @param x
	 * @return  Número entero positivo equivalente a x!.
	 */
	public int factorial(int x)
	{
		if(x == 0)
			return 1;
		else
			return x * factorial(x - 1);
	}
	
	
	/**
	 * Describir en que consiste la funcion
	 * @param x
	 * @return describir que se retorna
	 */
	public int fibonacci(int x)
	{
		if(x == 1)
			return 1;
		else if(x == 0)
			return 0; 	
		else
			return fibonacci(x-1) + fibonacci(x-2);
	}
	
	

	/**
	 * Describir en que consiste la funcion 
	 * @param n
	 * @param k
	 * @return describir que se retorna
	 */
	public int pascal(int n, int k)
	{
		if(k == n || k == 0) 
			return 1;
		else
			return pascal(n - 1, k) + pascal(n - 1, k - 1);
	}
	
	
	/**
	 * Describir en que consiste la funcion 
	 * @return describir que se retorna
	 */
	public String print_pascal()
	{
		String pascal_matrix = "";
		
		for(int i = 0; i < 10; i++)
		{
			for(int j = 0; j <= i; j++)
				pascal_matrix += pascal(i, j) + "\t";
			
			pascal_matrix += "\n";
		}
		
		return pascal_matrix;
	}
	
	
	/**
	 * Describir en que consiste la funcion
	 * @param n
	 * @param x
	 * @return describir que se retorna
	 */
	public int multiplicacion(int n, int x)
	{
		if(n == 0 || x == 0)
			return 0;
		else
			return x + multiplicacion(n - 1, x);
	}
	
	
	/**
	 * Describir en que consiste la funcion
	 * @param cadena
	 * @return describir que se retorna
	 */
	public String inversa_cadena(String cadena)
	{
		if(cadena.length() == 1)
			return cadena;
		else
		{
			char temp = cadena.charAt(cadena.length() - 1);
			return temp + inversa_cadena(cadena.substring(0, cadena.length() - 1));
		}
	}
		
	
	/**
	 * Describir en que consiste la funcion
	 * @param args
	 */
	public static void main(String[] args)
	{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter( System.out ));
		Recurrences recurrencias = new Recurrences();
	
		try
		{
			//Aca puede probar los resultados de sus recurrencias
			bw.write(recurrencias.factorial(15) + "\n"); // respuesta: 2004310016
			
			bw.write(recurrencias.fibonacci(25) + "\n"); // respuesta: 75025
			
			bw.write(recurrencias.multiplicacion(654, 97) + "\n"); // respuesta: 63438
			
			bw.write(recurrencias.mcd_euclides(369, 1218) + "\n"); // respuesta: 3
			
			bw.write(recurrencias.inversa_cadena("asdfghjkl") + "\n"); // respuesta: lkjhgfdsa
			
			bw.write(recurrencias.print_pascal() + "\n");
			/*
			 * 1	
			 * 1	1	
			 * 1	2	1	
			 * 1	3	3	1	
			 * 1	4	6	4	1	
			 * 1	5	10	10	5	1	
			 * 1	6	15	20	15	6	1	
			 * 1	7	21	35	35	21	7	1	
			 * 1	8	28	56	70	56	28	8	1	
			 * 1	9	36	84	126	126	84	36	9	1
			 */
			
			bw.flush();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}