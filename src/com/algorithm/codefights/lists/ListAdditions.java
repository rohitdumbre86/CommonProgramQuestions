package com.algorithm.codefights.lists;

import java.util.Stack;

public class ListAdditions {
	
	private static int carryForward = 0;

	
	ListNode<Integer> addTwoHugeNumbers(ListNode<Integer> a, ListNode<Integer> b) {
	    
	    Stack<ListNode<Integer>> stackA = new Stack<ListNode<Integer>>();
	    Stack<ListNode<Integer>> stackB  = new Stack<ListNode<Integer>>();
	    
	    while(a!=null){
	        stackA.push(a);
	        a = a.next;
	    }
	    
	    while(b!=null){
	        stackB.push(b);
	        b = b.next;
	    }
	    
	    

	    ListNode<Integer> head = null;
	    while(!stackA.isEmpty() && !stackB.isEmpty()){
	        
	     int valueA = stackA.pop().value;
	     int valueB = stackB.pop().value;
	        
	     ListNode<Integer> currNode = new ListNode<Integer>(add(valueA,valueB));        
	     currNode.next = head==null ? null : head;
	     head = currNode;
	    }
	    
	    while(!stackA.isEmpty()){
	        
	        ListNode<Integer> currNode = new ListNode<Integer>(add(stackA.pop().value,carryForward));        
	        currNode.next = head == null ? null : head;
	        head = currNode;  
	    
	    }
	    
	    while(!stackB.isEmpty()){
	        
	        ListNode<Integer> currNode = new ListNode<Integer>(add(carryForward,stackB.pop().value));        
	        currNode.next = head == null ? null : head;
	        head = currNode;  
	        
	    }
	    
	    while(carryForward!=0) {
	    	
	    	int value = head.value + carryForward;
	    	carryForward = value > 9999 ? 1 : 0;
	    	value = value > 9999 ? value%10000 : value;
	    	
	    	ListNode<Integer> newNode = new ListNode<Integer>(value);
	    	newNode.next  = head;
	    	head = newNode;
	    	
	    }
	    
	    return head;
	}

	public int add(int valueA, int valueB){
	    
	     int currValue  = valueA + valueB + carryForward;
	     carryForward = currValue > 9999 ? 1 : 0;
	     currValue = currValue > 9999 ? currValue%10000 : currValue;
	    
	     return currValue;
	}



	public static void main(String[] args) {
		
		ListAdditions adder = new ListAdditions();
		ListNode<Integer> l1 = adder.new ListNode<Integer>(8339);
		ListNode<Integer> l2 = adder.new ListNode<Integer>(4510);
		
		l1.next = l2;
		l2.next = null;
		
		ListNode<Integer> a1 = adder.new ListNode<Integer>(2309);
		a1.next = null;
		
		ListNode<Integer> addition = adder.addTwoHugeNumbers(l1, a1);
		while(addition!=null) {
			System.out.print(":"+addition.value+":");
			addition = addition.next;
		}
		
		
	}
	
	class ListNode<T> {
		ListNode(T x) {
			value = x;
		}

		T value;
		ListNode<T> next;
	}
}
