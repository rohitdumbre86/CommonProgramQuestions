package com.algorithm.heap;

public class GetKHighestNumber
{
    volatile int   size = 0;
    volatile int[] heap;

    public static void main(String[] args)
    {
        int[] nums = new int[] {3, 2, 1, 4};

        GetKHighestNumber heaper = new GetKHighestNumber();

        int kthLargestElement = heaper.kthLargestElement(nums, 0);
        System.out.println(kthLargestElement);

    }

    int kthLargestElement(int[] nums, int k)
    {

        heap = new int[nums.length];

        for (int i = 0; i < nums.length; i++)
        {
            heapAdd(nums[i]);
        }

        int kLargestValue = 0;

        while (k > 0)
        {
            kLargestValue = peek();
            k--;
        }

        return kLargestValue;
    }

    public int peek() {
        int low = heap[0];
        heap[0] = size==heap.length ? heap[size-1] : heap[size];
        size--;
        heapifyDown();
        return low;
    }
    
    private void heapifyDown()
    {
        int index = 0;
        while (hasLeftChild(index))
        {
            int greaterIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && heap[getLeftChildIndex(index)] < heap[getRightChildIndex(index)])
            {
                greaterIndex = getRightChildIndex(index);
            }

           if(heap[index] > heap[greaterIndex]) {
               break;
           }
           else {
               swap(index,greaterIndex);
           }
           index = greaterIndex;
        }

    }

    private boolean hasLeftChild(int index)
    {
        return getLeftChildIndex(index) < heap.length;
    }

    private boolean hasRightChild(int index)
    {
        return getRightChildIndex(index) < heap.length;
    }

    private int getLeftChildIndex(int index)
    {
        return (2 * index + 1);
    }

    private int getRightChildIndex(int index)
    {
        return (2 * index + 2);
    }

    private void heapAdd(int num)
    {
        heap[size] = num;
        size++;
        heapifyUp();
    }

    private void heapifyUp()
    {
        int index = size - 1;
        int parentIndex = getParentIndex(index);
        while (hasParentIndex(index) && heap[index] > heap[parentIndex])
        {
            swap(index, parentIndex);
            index = parentIndex;
        }
    }

    private int getParentIndex(int index)
    {
        return (index - 1) / 2;
    }

    private boolean hasParentIndex(int index)
    {
        return getParentIndex(index) >= 0;
    }

    private void swap(int index, int parentIndex)
    {
        int temp = heap[index];
        heap[index] = heap[parentIndex];
        heap[parentIndex] = temp;
    }
}
