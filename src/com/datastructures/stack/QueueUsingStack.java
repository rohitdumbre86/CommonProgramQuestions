package com.datastructures.stack;

/**
 * Implement a queue using stack.
 * 
 * The basic idea is to use two stack1. Say s1 and s2.
 *  
 * You can make enQueue operation costly or deQueue operation costly.
 * 
 * 
 * <p />
 * <p style="font-style:italic;font-variant;small-caps;font-size:80%">
 * Copyright &copy; Cerner Corporation May 24, 2018 All rights reserved.
 * </p>
 * 
 * @since X.X
 */
public class QueueUsingStack<T>
{
    Stack<T> stack1;
    Stack<T> stack2;

    public QueueUsingStack()
    {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public QueueUsingStack(int capacity)
    {
        stack1 = new Stack<>(capacity / 2);
        stack2 = new Stack<>(capacity / 2);
    }

    public boolean isEmpty()
    {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public void enQueue(T value)
    {
        stack1.push(value);
    }

    public T deQueue() throws Exception
    {
        if (isEmpty())
        {
            throw new Exception("The queue is empty");
        }

        if (stack2.isEmpty())
        {
            while (!stack1.isEmpty())
            {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }
}
