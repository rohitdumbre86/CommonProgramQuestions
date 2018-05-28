package com.datastructures.stack;

public class QueueLinkedList<T> {
	private int total = -1;
	  private Node first, last;
	  
	  protected class Node<T> {
	    
		T value;
		Node next;
		
		public Node( T val) {
		  
		  value = val;
		  next = null;
		
		}
	  
	  }
	  
	  public QueueLinkedList<T> enQueue(T val) {
	     
		 Node current = last;
		 last =  new Node(val);
		 
		 if(++total == 0) first = last;
		 else current.next = last;
		 
		 return this;
	  }

	  public T deQueue() throws Exception 
	  {
	     if(total < 0) {
		   throw new Exception(" The Queue is not empty");
		 }
	  
	     T ele = (T) first.value;
		 first = first.next;
		 
		 --total;
	  
	     return (T) ele;
	  }
	  
	  public boolean isEmpty() {
		  return first == null;
	  }
}
