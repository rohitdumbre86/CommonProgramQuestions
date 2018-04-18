package com.datastructures.stack;

public class StackDemo {

	public static void main(String[] args) throws Exception {
		
		Stack<Integer> intStack = new Stack<Integer>();

		for(int i=1; i<=13; i++)
		{
			System.out.println("Pushing "+i+" in stack");
			intStack.push(i);
		}
		System.out.println("----------------------------------------");
		while(!intStack.isEmpty())
		{
			System.out.println("Poping "+intStack.pop()+" in stack");
		}

	}

}
