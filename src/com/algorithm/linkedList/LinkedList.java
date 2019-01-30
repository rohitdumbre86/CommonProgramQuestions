package com.algorithm.linkedList;

public class LinkedList
{
    
    ListNode temp = null;

    public class ListNode
    {
        int      val;
        ListNode next;

        ListNode(int x)
        {
            val = x;
        }
    }

    public static void main(String[] args)
    {
        LinkedList l1 = new LinkedList();        
        ListNode nod1 = l1.new ListNode(1);
        ListNode nod2 = l1.new ListNode(2);
        ListNode nod4 = l1.new ListNode(4);
        
        
        nod1.next = nod2;
        nod2.next = nod4;
        nod4.next = null;
        
        LinkedList l2 = new LinkedList();        
        ListNode nod11 = l2.new ListNode(1);
        ListNode nod3 = l2.new ListNode(3);
        ListNode nod5 = l2.new ListNode(5);
        
        
        nod11.next = nod3;
        nod3.next = nod5;
        nod5.next = null;
        
        LinkedList list = new LinkedList();
        list.mergeTwoLists(nod1,nod11);
        
    }
    
    public ListNode reverseList(ListNode head) {
        
        if(head == null) return null;
         
         reverseList(null,head);  
         
         return temp;
     }

     public void reverseList(ListNode prev, ListNode curr){
         
         if(curr==null){
             temp = prev;
             return;
         }
         
         reverseList(curr, curr.next);
         
         if(prev!=null){
             
           prev.next = null;
             
         }
         
         curr.next = prev;    
     }
     
     
     public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
         
         if(l1==null && l2==null) return null;
        
         ListNode head = l1.val <= l2.val ? l1 : l2;
         ListNode smallHead = head;
         ListNode bigHead = l1.val >= l2.val ? l1 : l2;
         
         while(smallHead!=null && bigHead!=null)
         {
             
             if(smallHead.val <= bigHead.val)
             {
                 ListNode temp = smallHead.next;
                 smallHead.next = bigHead;
                 ListNode temp2 = bigHead.next;
                 bigHead.next = temp;
                 bigHead = temp2;
                 
                 balanceSmall(smallHead.next);
                 
             }
             
             
             
             smallHead = smallHead.next;
             
         }
         
         
        return head;
     }
     
     public void balanceSmall(ListNode smallHead)
     {
         while(smallHead!=null)
         {
             if(smallHead.next!=null){
                 
                 if(smallHead.val > smallHead.next.val)
                 {
                     int temp = smallHead.next.val;
                     smallHead.next.val = smallHead.val;
                     smallHead.val = temp;
                     
                 }                
             }
             
             smallHead = smallHead.next;
         }
     }
      
      

}
