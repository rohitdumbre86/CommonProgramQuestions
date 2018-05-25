package com.datastructures.stack;

public class QueueDemo
{

    public static void main(String[] args) throws Exception
    {
        final QueueUsingStack<Integer> queue = new QueueUsingStack<Integer>();

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

    }

}
