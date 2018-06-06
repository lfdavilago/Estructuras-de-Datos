package Searching;

public class Main {

	/**
	 * 
	 * @param Array Arreglo de enteros cuyos elemenos estan ordenados de mayor a menor. 
	 */
	public static int BinarySearch(int[] Array, int n, int Up, int Dw)
	{
		int Size;
		Size = (Up + Dw)/2;

		if(n > Array[Size])
			return BinarySearch(Array, n, Up, Size + 1);
		else if(n < Array[Size])
			return BinarySearch(Array, n, Size - 1, Dw);
		else if(n == Array[Size])
			return Size;
		return -1;
	}
	
	public static int BinarySearch(int Array[], int n)
	{
		int Dw = 0;
		int Up = Array.length;
		
		while(Dw <= Up)
		{
			int MidPoint = (Dw + Up) / 2;
			if(n == Array[MidPoint])
				return MidPoint;
			if(Array[MidPoint] < n )
				Dw = MidPoint + 1;
			else
				Up = MidPoint - 1;
		}
		return -1;
	}
	public static int InterpolationSearch(int Array[], int n)
	{
		int Dw = 0;
		int Up = Array.length - 1;
		
		while(Dw <= Up)
		{
			int MidPoint = Dw + ((Up - Dw)/(Array[Up] - Array[Dw])) * (n - Array[Dw]);
			if( n == Array[MidPoint])
				return MidPoint;
			if( MidPoint > n )
				Up = MidPoint - 1;
			else
				Dw = MidPoint + 1;
		}	
		return -1;
	}
	
	
	public static int LinearSearch(int Array[], int n)
	{
		for(int i = 0; i < Array.length ; i++)
			if(Array[i] == n)
				return i;
		return -1;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] Array = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};
		System.out.println(BinarySearch(Array,14,Array.length-1, 0));
		System.out.println(InterpolationSearch(Array,14));
		System.out.println(LinearSearch(Array,14));
		System.out.print(BinarySearch(Array,14));
	}
}
