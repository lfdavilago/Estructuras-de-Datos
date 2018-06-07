package StringsList;



import java.io.*;
import java.util.ArrayList;

import Data.Node;
import Logic.List;

/*
# Strings based on Character Lists.
#
# Created by Msc. Carlos Andres Sierra on April 2018.
# Copyright (c) 2018  Msc. Carlos Andres Sierra. Research Group on Artificial Life - ALIFE. All rights reserved.
#
# This file is part of DataStructuresTemplates.
#
# DataStructuresTemplates is free software: you can redistribute it and/or modify it under the terms of the
# GNU General Public License as published by the Free Software Foundation, version 3.
*/

/**
 * This class represents the behavior of Strings based on Character Lists
 * @author MSc. Carlos Andres Sierra, PhD. student
 */
public class StringAsList {

	private List string = new List();
	
	/**
	 * 
	 */
	public StringAsList()
	{
		string = new List();
	}
	
	/**
	 * 
	 * @param string_
	 */
	public StringAsList(char[] string_)
	{
		string = new List();
				
		for(int i = 0; i < string_.length; i++)
			string.insertAtEnd(new StringNode( string_[i] ));
	}
	
	
	/**
	 * 
	 * @param newString
	 */
	public void concatenate(StringAsList newString)
	{
		string.insertAtEnd( newString.string.head );
	}
	
	
	/**
	 * 
	 * @param regex
	 * @return
	 */
	public ArrayList<StringAsList> split(StringAsList regex)
	{
		ArrayList<StringAsList> response = new ArrayList<>();
		
		List sublist = new List();
		for(int i = 0 ; i < this.length(); i++)
		{
			List temp = this.string.sublist(i, i + 1);
			
			if(!temp.isEqual(regex.string))
				sublist.insertAtEnd(this.string.sublist(i, i + 1).head);
			else if (sublist.length() != 0)
			{
				StringAsList s = new StringAsList();
				s.string = sublist;
				response.add(s);
				sublist = new List();
			}
			
			if(i == this.length()-1 && !temp.isEqual(regex.string) )
			{
				StringAsList s = new StringAsList();
				s.string = sublist;
				response.add(s);
				sublist = new List();
			}
		}
		return  response;
	}
	
	
	/**
	 * 
	 * @param regex
	 * @return
	 */
	public boolean contains(StringAsList regex)
	{
		
		return false;
	}
	
	
	/**
	 * 
	 * @param beginIndex
	 * @return
	 */
	public StringAsList substring(int beginIndex)
	{
		StringAsList subString = new StringAsList();
		subString.string = this.string.sublist(beginIndex);
		return subString;
	}
	
	
	/**
	 * 
	 * @param beginIndex
	 * @param endIndex
	 * @return
	 */
	public StringAsList substring(int beginIndex, int endIndex)
	{
		StringAsList subString = new StringAsList();
		subString.string = this.string.sublist(beginIndex, endIndex);
		return subString;
	}
	
	
	/**
	 * 
	 * @param regex
	 * @return
	 */
	public int indexOf(StringAsList regex)
	{
		Node temp = this.string.head;
		for(int i = 0; i < this.length() ; i++)
		{
			if(temp.isEqual(regex.string.head))
				return i;
			temp = temp.next; 
		}
		return -1; 
	}
	/**
	 * 
	 * @param string_
	 * @return
	 */
	public boolean equals(StringAsList string_)
	{
		return this.string.equals( string_.string );
	}
	
	
	/**
	 * 
	 * @return
	 */
	public int length()
	{
		return this.string.length();
	}
	
	
	/**
	 * 
	 * @return
	 */
	public StringAsList reverse()
	{
		StringAsList reverse = new StringAsList();
		reverse.string = this.string.reverse();
		return reverse;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public boolean isPalindrome()
	{
		List temp = this.string.reverse();
		if(temp.isEqual(this.string))
			return true;
		return false;
	}
	
	
	/**
	 * 
	 * @param anagramCandidate
	 * @return
	 */
	public boolean isAnagram(StringAsList anagramCandidate)
	{	
		if(this.length() != anagramCandidate.length())
			return false;
		
		Node temp = this.string.head;
		int contador = 0;
		for(int i = 0; i < this.length() ; i++)
		{
			Node temp2 = anagramCandidate.string.head;
			for(int j = 0; j < anagramCandidate.length(); j++)
			{
				if(temp.isEqual(temp2))
				{
					contador++;
					break;
				}
				temp2 = temp2.next;
			}
			temp = temp.next;
		}
		
		if(contador == this.length())
			return true;
		else
			return false;
	}
	
	
	public void print() throws IOException
	{
		this.string.printList();
		System.out.println();
	}
	
	public static void main(String[] agrs) throws IOException
	{
		
		
		String ss ="acasohubobuhosacah";
		
		StringAsList s = new StringAsList(ss.toCharArray());
		
		if(s.isPalindrome())
			System.out.println("palindrome");
		else
			System.out.println("No");
		
		/*s.print();
		s = s.reverse();
		s.print();
		s = s.substring(3,8);
		s.print();
		*/
		
		String a = "o";
		ArrayList<StringAsList> Arr = s.split(new StringAsList(a.toCharArray()));
		System.out.println(Arr.size() );
		for(StringAsList string : Arr)
			string.print();
		
		
		String anagrama1 = "thealiasmen";
		String anagrama2 = "alansmithee";
		
		StringAsList Origin = new StringAsList(anagrama1.toCharArray());
		StringAsList anagramCandidate = new StringAsList(anagrama2.toCharArray());
		
		if(Origin.isAnagram(anagramCandidate))
			System.out.println("is Anagram");
		else
			System.out.println("No Anagram");
		
		System.out.println(Origin.indexOf(new StringAsList("l".toCharArray())));
	
	}
	
	
	
}