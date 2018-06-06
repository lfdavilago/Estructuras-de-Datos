


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import Data.Secuencia;

public class Main {
    public static String cromosoma() 
    {
    	Random rd = new Random();
    	return "chr"+(rd.nextInt(23)+1);
    }
	
	public static String nucleotide()
	{
		Random rd = new  Random();
		
		switch(rd.nextInt(4)) 
		{
			case 0:		return "A";
			case 1:		return "C";
			case 2:		return "G";
			case 3:		return "T";
			default: 	return "";
		}
	}
	
	public static String secuence(int length) 
	{
		if(length == 1)
			return nucleotide();
		else
			return nucleotide() + secuence(length - 1);
	}
	
	public static void add(Secuencia Head,  File file, Scanner in) 
	{
		if(in.hasNextLine())
		{
			String[] Dato =  in.nextLine().split(",");
			Secuencia seq = new Secuencia(Dato[0], Dato[1], Integer.parseInt(Dato[2]), Integer.parseInt(Dato[3]));
			Head.next = seq;
		    add(seq,file,in);
		}
	}
	
	public static void combinacion(int n, String subsecuense)
	{
		if(n==1)
		{
			subsecuense = subsecuense + "A";
			subsecuense = subsecuense + "C";
			subsecuense = subsecuense + "G";
			subsecuense = subsecuense + "T";
		}
		else
		{
			combinacion(n - 1,subsecuense + "A");
			combinacion(n - 1,subsecuense + "C");
			combinacion(n - 1,subsecuense + "G");
			combinacion(n - 1,subsecuense + "T");
		}
	}
	public static void main(String[] args) throws IOException {
		
		
		File file = new File("motiff.txt");
		Random rd = new Random();
		//LLENADO DEL ARCHIVO QUE CONTIENE LOS MOTIF.... LA CLASE "Principal" Procesa los motif.
	    //if(!file.exists())  file.createNewFile();
	
		//FileWriter File = new FileWriter("motiff.txt");
        //BufferedWriter br = new BufferedWriter(File); 
	    //int length, Start, datasize = 10;
		//String Experimental_secuence;
        
		/*for(int i = 0; i < datasize ; i++) 
        //{
        	///length = rd.nextInt(50) + 1;
        	//Start = rd.nextInt(1000) + 1;
        	Experimental_secuence = secuence(length)+","+ cromosoma()+","+ Start + "," + (Start + length - 1);
        	br.write(Experimental_secuence + "\n");
        //}	
        
	br.flush();
	br.close();
	*/
	
	}
}