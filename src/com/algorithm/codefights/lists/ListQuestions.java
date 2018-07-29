package com.algorithm.codefights.lists;

import java.math.BigInteger;
import java.util.Stack;

public class ListQuestions {

	ListNode<Integer> removeKFromList(ListNode<Integer> l, int k) {
		if (l == null)
			return null;

		ListNode<Integer> head = l;

		while (l.next != null) {

			if (l.next.value == k) {
				l.next = l.next.next;
			} else {
				l = l.next;
			}

		}

		return (head.value == k ? head.next : head);
	}

	boolean isListPalindrome(ListNode<Integer> l) {

		Stack<Integer> stc = new Stack<Integer>();

		ListNode<Integer> temp = l;

		while (temp != null) {
			stc.push(temp.value);
			temp = temp.next;
		}

		while (l != null && !stc.isEmpty()) {
			int stackValue = stc.pop();
			int listValue = l.value;
			if (stackValue != listValue)
				return false;
			l = l.next;
		}

		return stc.isEmpty();
	}

	ListNode<Integer> addTwoHugeNumbers(ListNode<Integer> a, ListNode<Integer> b) {
		int sizeOfA = getSize(a);
		int sizeOfB = getSize(b);

		int tempA = sizeOfA;
		int tempB = sizeOfB;

		double a1 = 0;
		while (a != null) {
			a1 += (double) (a.value * Math.pow(10, 4 * (--tempA)));
			a = a.next;
		}

		double b1 = 0;
		while (b != null) {
			b1 += (double) (b.value * Math.pow(10, 4 * (--tempB)));
			b = b.next;
		}

		a1 += b1;

		a1 += b1;
	     int powerOf4 = 4;
	     while(a1 > 0)
	     {     
	         a1 = a1 - (int)(a1/Math.pow(10,powerOf4));
	         System.out.println(a1);
	     }
	     
	     return null;

	}

	private int getSize(ListNode<Integer> operand) {

		ListNode<Integer> temp = operand;
		int size = 0;
		while (temp != null) {
			++size;
			temp = temp.next;
		}

		return size;
	}

	public static void main(String[] args) {


		ListQuestions remover = new ListQuestions();
		ListNode<Integer> l1 = remover.new ListNode<Integer>(7);
		ListNode<Integer> l2 = remover.new ListNode<Integer>(1);
		ListNode<Integer> l3 = remover.new ListNode<Integer>(2);
		ListNode<Integer> l4 = remover.new ListNode<Integer>(4);
		ListNode<Integer> l5 = remover.new ListNode<Integer>(3);
		ListNode<Integer> l6 = remover.new ListNode<Integer>(3);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;

		ListNode<Integer> lNew = remover.removeKFromList(l1, 3);
		while (lNew != null) {
			System.out.println("Value: " + lNew.value);
			lNew = lNew.next;
		}

		ListNode<Integer> a1 = remover.new ListNode<Integer>(1);
		ListNode<Integer> a2 = remover.new ListNode<Integer>(1000000000);
		ListNode<Integer> a3 = remover.new ListNode<Integer>(-1000000000);


		a1.next = a2;
		a2.next = a3;
		
		
		ListNode<Integer> b1 = remover.new ListNode<Integer>(1);
		ListNode<Integer> b2 = remover.new ListNode<Integer>(8001);

	}

	class ListNode<T> {
		ListNode(T x) {
			value = x;
		}

		T value;
		ListNode<T> next;
	}

}
