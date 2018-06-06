import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

import Data.List;
import Data.Secuencia;
public class Principal 
{
    List secuencias = new List();
	int max_occurrences = Integer.MIN_VALUE;
	String motif_winer = "";
	
	public  void compareMotif(String motif_candidate) 
	{
		int cont = counterOcurrences(motif_candidate);
		if(cont > max_occurrences)
		{
			max_occurrences = cont;
			motif_winer = motif_candidate;
		}
	}
	
	public int counterOcurrences(String motif_candidate)
	{
		int counter = 0;
		String gen_secuencia;
		
		Secuencia temp = secuencias.head;
		
		while(temp != null)
		{
			gen_secuencia = temp.secuencia;
			for(int i = 0; i <=(gen_secuencia.length() - motif_candidate.length()) ; i++)
			{
				if(gen_secuencia.substring(i, i + motif_candidate.length()).equals(motif_candidate))
				{
					counter++;
					i += motif_candidate.length() - 1;
				}
			}
			temp = temp.next;
		}
		return counter;
	}
	
	public void combinacion(int n, String subsecuense)
	{
		if(n==1)
		{
			compareMotif(subsecuense + "A");
		    compareMotif(subsecuense + "C");
	     	compareMotif(subsecuense + "G");
			compareMotif(subsecuense + "T");
		}
		else
		{
			combinacion(n - 1,subsecuense + "A");
			combinacion(n - 1,subsecuense + "C");
			combinacion(n - 1,subsecuense + "G");
			combinacion(n - 1,subsecuense + "T");
		}
	}
	
	public void countChromosomes() throws IOException
	{
		int[] chromosomes = new int[23];
		Secuencia temp = this.secuencias.head;
		while(temp != null)
		{   
			if(temp.secuencia.contains(this.motif_winer))
			{
				chromosomes[ Integer.parseInt(temp.cromosoma.replace("chr","")) - 1 ]++;
			}
			temp = temp.next;
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int i = 0 ; i < 23 ; i++)
		{
			bw.write("Cromosoma "+ (i + 1) + ": "+ chromosomes[i] +"\n");
		}
		
		bw.flush();
	}
	
	public static void main(String[] args) throws IOException 
	{
		Principal pl = new Principal();
		FileReader fr = new FileReader("motif.txt");
		BufferedReader br = new BufferedReader(fr);
		String input = br.readLine();
	
		while(input != null)
		{
			String[]  data = input.split(",");
			pl.secuencias.insertAtEnd(new Secuencia(data[0],data[1],Integer.parseInt(data[2]),Integer.parseInt(data[3])));
			input = br.readLine();	
 		}
		// Imprime la lista
		pl.secuencias.printList();
		// Imprime el tamaño de la lista de secuencias
		System.out.println(pl.secuencias.Size());
		//Genera las diferentes combinaciones te tamaño 4 y busca las ocurrencias en la lista 
		pl.combinacion(4, "");
		//Imprime la secuencia de 4 nuclotidos mas repetidas y su cantidad de repeticones
		System.out.print("Max ocuerrencias: "+ pl.max_occurrences +" Motif winner: " + pl.motif_winer + "\n");
		pl.countChromosomes();
	}
}
