package Logic;

import Data.Char;

public class FString {
	public Char head;
	
	public FString()
	{
		this.head = null;
	}
	
	public boolean isNull()
	{
		return this.head == null ? true:false;
	}
	
	public int length()
	{
		int length = 0;
		Char temp = this.head;
		while(temp != null)
		{
			length++;
			temp = temp.next;
		}
		
		return length;
	}
	
	public char CharAt(int index)
	{	
		if(index < this.length() )
		{	Char temp = this.head;
			for(int i = 0; i < index ; i++)
				temp = temp.next;
			return temp.getCaracter();
		}
		else
			return 0;
	}
	
	
	

}
