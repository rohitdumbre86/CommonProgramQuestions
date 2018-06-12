package com.algorithm.heap;

public class MinHeap {

	int[] heap;
	int size;

	public MinHeap(int capacity) {
		this.heap = new int[capacity];
		this.size = 0;
	}

	public int getLeftChildIndex(int index) {
		return (2 * index + 1);
	};

	public int getRightChildIndex(int index) {
		return (2 * index + 2);
	};

	public int getParentIndex(int index) {
		return (index - 1) / 2;
	}

	public boolean hasLeftChild(int index) {
		return getLeftChildIndex(index) < heap.length;
	}

	public boolean hasRigthChild(int index) {
		return getRightChildIndex(index) < heap.length;
	}

	public boolean hasParent(int index) {
		return getParentIndex(index) >= 0;
	}

	public int getLeftChild(int index) {
		return heap[getLeftChildIndex(index)];
	}

	public int getRightChild(int index) {
		return heap[getRightChildIndex(index)];
	}

	public int parent(int index) {
		return heap[getParentIndex(index)];
	}

	public void swap(int index1, int index2) {
		int temp = heap[index1];
		heap[index1] = heap[index2];
		heap[index2] = temp;
	}
	
	public int poll() {
		return heap[0];
	}
	
	public int peek() {
		int low = heap[0];
		heap[0] = heap[size];
		size--;
		heapifyDown();
		return low;
	}
	
	public void add(int value) {
		heap[size] = value;
		size++;
		heapifUp();
	}

	private void heapifUp() {
		int index = size-1;
		while(hasParent(index) && parent(index) >  heap[index]) {
			swap(getParentIndex(index), index);
			index = getParentIndex(index);
		}
	}

	private void heapifyDown() {
		int index = 0;
		while(hasLeftChild(index)) {
			int smallerIndex = getLeftChildIndex(index);
			if(hasRigthChild(index) && getRightChild(index) < getLeftChild(index)) {
				smallerIndex = getRightChildIndex(index);
			}
			
			if(heap[index] < heap[smallerIndex]) {
				break;
			}
			else {
				swap(index, smallerIndex);
			}
			index = smallerIndex;
		}
		
	}

	public static void main(String[] args) {
		MinHeap minHeap = new MinHeap(6);
		minHeap.add(14);
		minHeap.add(2);
		minHeap.add(3);
		minHeap.add(1);
		minHeap.add(11);
		minHeap.add(24);
		
		System.out.println(minHeap.peek());
		System.out.println(minHeap.peek());
		System.out.println(minHeap.peek());

	}

}
