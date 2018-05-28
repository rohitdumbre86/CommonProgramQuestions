package com.datastructures.stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue<T> {
	
	private Queue<T> linkedList;
	
	public StackUsingQueue() {
		linkedList = new LinkedList<>();
	}
	
	public void push(T value) {
		
		linkedList.add(value);
		int size = linkedList.size();
		
		while(size > 1) {
			linkedList.add(linkedList.remove());
			size--;
		}
		
	}
	
	public T pop() {
		return linkedList.remove();
	}
	
	public boolean isEmpty() {
		return linkedList.isEmpty();
	}
	
	 /** Get the top element. */
    public T top() {
        return linkedList.peek();
    }

}
