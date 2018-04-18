package com.datastructures.stack;

public class Stack<T> {

	T[] stack;
	int tos;

	public Stack() {
		tos = -1;
		stack = (T[]) new Object[10];
	}

	public Stack(int capacity) {
		tos = -1;
		stack = (T[]) new Object[capacity];
	}

	/**
	 * Pushes a value on top of the stack. If the stack is full, the capacity is
	 * increased by 10.
	 * 
	 */
	public void push(T value) {

		if (tos < stack.length - 1) {
			stack[++tos] = value;
		} else {
			T[] dest = (T[]) new Object[stack.length + 10];
			System.arraycopy(stack, 0, dest, 0, stack.length);
			stack = (T[]) new Object[stack.length + 10];
			System.arraycopy(dest, 0, stack, 0, dest.length);
			stack[++tos] = value;

		}

	}

	/**
	 * @return Removes and returns the top of the stack.
	 * @throws Exception If the stack is empty.
	 */
	public T pop() throws Exception {

		if (tos == -1) {
			throw new Exception("The stack is empty");
		}

		return stack[tos--];
	}

	/**
	 * @return True if the stack is empty, false otherwise.
	 */
	public boolean isEmpty() {
		return tos == -1;
	}

	/**
	 * @return Returns the top of the stack without removing it.
	 * @throws Exception
	 *             If peeking on an empty stack.
	 */
	public T peek() throws Exception {
		if (tos == -1) {
			throw new Exception("The stack is empty");
		}
		return stack[tos];
	}
}
