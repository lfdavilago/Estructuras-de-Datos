package Sorting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Random;

public class Main {
	/**
	 * Realiza un ordenamiento de menor a mayor a de los elementos de un arreglo de enteros, sobre el mismo arreglo.
	 * @param Array Arreglo de enteros que se requiere ordenar.
	 */
	public static void BubbleSort(int[] Array)
	{
		boolean swapped; 
		int lastIndex = Array.length; // Guarda la posición del útimo número en el arreglo a partir del cual no es necesario seguir
									  // ejecutando el ordenamiento.
		do
		{
			swapped = false;
			for(int i = 0; i < lastIndex - 1; i++)
			{
				if(Array[i] > Array[i + 1])
				{
					int swapp = Array[i];
					Array[i] = Array[i + 1];
					Array[i + 1] = swapp;
					swapped = true;
				}
			}
			lastIndex--;
			
		}while(swapped);
	}
	
	public static void InsertionSort(int[] unsorted)
	{
		for(int i = 1; i < unsorted.length ; i++)
		{
			int temp = unsorted[i];
			int index = i;
			while( index > 0 && unsorted[index-1] > temp)
			{
				unsorted[index] = unsorted[index-1];
				index--;
			}
			unsorted[index] = temp;
		}
	}
	
	public static int[] MergeSort(int[] unsorted)
	{
		int size;
		
		if(unsorted.length > 1)
		{
			size = unsorted.length / 2;
			int[] left_array = new int[size];
			int[] rigth_array = new int[unsorted.length - size];
		
			for(int i = 0; i < size; i++)
				left_array[i] = unsorted[i];
			for(int i = size ; i < unsorted.length ; i++)
				rigth_array[i- size] = unsorted[i];
			
			left_array = MergeSort(left_array);
			rigth_array = MergeSort(rigth_array);
			
			return Merge(left_array, rigth_array);
		}
		
		return unsorted;
	}
	
	public static int[] Merge(int[] a, int[] b)
	{
		int Size = a.length + b.length;
		int[] c = new int[Size];
		int index_a = 0, index_b = 0, index_c = 0;
		
		while(index_a < a.length && index_b < b.length)
		{
			if(a[index_a] < b[index_b])
			{
				c[index_c]  = a[index_a];
				index_a++;
			}
			else
			{
				c[index_c] = b[index_b];
				index_b++;
			}
			index_c++;
		}
		
		while(index_a < a.length)
		{
			c[index_c] = a[index_a];
			index_a++;
			index_c++;
		}
		
		while(index_b < b.length)
		{
			c[index_c] = b[index_b];
			index_b++;
			index_c++;
		}
			
		return c;
	}
	public static void CountingSort(int[] Unsorted)
	{
		int Mayor = Integer.MIN_VALUE;
		int index = 0;
		for(int i : Unsorted)
			if(i > Mayor)
				Mayor = i;
		
		int[] temp = new int[Mayor + 1];
		
		for(int i : Unsorted)
			temp[i]++;
		
		for(int i = 0; i < temp.length ; i++)
			for(int j = 0 ; j < temp[i]; j++)
			{
				Unsorted[index] = i;
				index++;
			}
	}
	
	public static int[] BigArray(int lenght)
	{
		Random rd = new Random();
		int[] temp = new int[lenght];
		
		for(int i = 0 ; i < lenght ; i++)
			temp[i] = rd.nextInt(40);
		
		return temp;
	}
	
	public static void printArray(int[] Array) throws IOException
	{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i = 0; i < Array.length ; i++)
		{
			bw.write(Array[i]+",");	 
			if(i%20 == 0 && i !=0)
				bw.write("\n");
		}
		bw.write("\nEOF \n");
		bw.flush();
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		/**int[] Array = BigArray(1000);
		int[] clone = Array.clone();
		int[] clone2 = Array.clone();
		long Start = System.currentTimeMillis();
		CountingSort(Array);
		long end = System.currentTimeMillis();
		long resultado1 = -Start + end;
		System.out.println("Fin CountigSort");
		long Start1 = System.currentTimeMillis();
		clone = MergeSort(clone);
		long end1 = System.currentTimeMillis();
		long resultado2 = -Start1 + end1;
		System.out.println("Fin MergeSort");
		long Start2 = System.currentTimeMillis();
		InsertionSort(clone2);
		long end2 = System.currentTimeMillis();
		long resultado3 = -Start2 + end2;
		System.out.println("Fin InsertionSort");
		System.out.println("MgS: " + resultado2 + " CuS: " + resultado1 + " InS: " + resultado3);
		*/
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] array = br.readLine().split(" ");
		int[] arr = new int[array.length];
		for(int i = 0 ; i < arr.length ; i++)
			arr[i] = Integer.parseInt(array[i]);
		CountingSort(arr);
		printArray(arr);
	}
		
}


