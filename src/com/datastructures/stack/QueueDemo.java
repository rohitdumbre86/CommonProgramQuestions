package com.datastructures.stack;

public class QueueDemo
{

    public static void main(String[] args) throws Exception
    {
        final QueueUsingStack<Integer> queue = new QueueUsingStack<Integer>();

        System.out.println("--------- Implement Queue using stack ---------------------");
        for (int i = 1; i <= 13; i++)
        {
            System.out.println("EnQueueing " + i + " in queue");
            queue.enQueue(i);
        }
        System.out.println("----------------------------------------");
        while (!queue.isEmpty())
        {
            System.out.println("DeQueueing " + queue.deQueue() + " in queue");
        }
        
        System.out.println("------- Implement Queue using linked list -----------------");
       
        final QueueLinkedList<Integer> queueInteger = new QueueLinkedList<>();
        for (int i=1; i< 10; i++) {
        
        	System.out.println("EnQueueing " + i + " in queue");
        	queueInteger.enQueue(i);
        }
        
        System.out.println("--------- Dequeuing -----------------------------");
        
        while(!queueInteger.isEmpty())
        {
            System.out.println("DeQueueing " + queueInteger.deQueue() + " in queue");
        }

    }

}
