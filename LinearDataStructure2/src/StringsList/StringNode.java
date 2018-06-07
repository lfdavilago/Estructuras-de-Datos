package StringsList;

import Data.Node;

/*
# String Node for Strings based on Lists.
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
 * This class represents the behavior of a String Node for Strings based on Lists
 * @author MSc. Carlos Andres Sierra, PhD. student
 */
public class StringNode extends Node {

	/*
	 * 
	 */
	public char character;
	public Node next;
	
	public StringNode(char character) 
	{	
		this.character = character;
		this.next = null;
	}

	public void setNext(Node node) 
	{
		this.next = node;
	}
	
	public Node getNext() 
	{
		return this.next;
	}
	
	public StringNode clone() 
	{
		StringNode clone = new StringNode(this.character);
		return clone;
	}

	
	public boolean isEqual(Node node)
	{
		StringNode temp = (StringNode) node;
		return temp.character == this.character ? true : false;
	}

	public String toString() 
	{
		return this.character + "";
	}
	public boolean isLessThan(Node node) 
	{
		StringNode temp = (StringNode) node;
		return (int)this.character < (int)temp.character ? true : false;
	}
}