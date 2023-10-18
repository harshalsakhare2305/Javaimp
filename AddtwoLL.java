/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     val;
 *     ListNode next;
 *     ListNode() int {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
 
class Solution {
    public int findSize(ListNode head){
         int size =0;
         ListNode temp =head;

         while( temp !=null){
             temp=temp.next;
             size++;
         }

         return size;

    }

    public ListNode Reverse(ListNode head){
        ListNode prev =null;
        ListNode curr =head;

        while(curr !=null){
            ListNode next=curr.next;
            curr.next =prev;
            prev =curr;
            curr=next;

        }

        head.next=null;
        head=prev;

        return head;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
         if(l1== null && l2!=null){
             return l2;
         }else if(l1!= null && l2==null){
             return l1;
         }else if(l1== null && l2==null){
             return null;
         }

         ListNode head3=new ListNode(101);
         ListNode temp =head3;
         int sum=0;
         int carry=0;
         int size1 =findSize(l1);
         int size2 =findSize(l2);

         if(size1 !=size2){
             int n=size1 -size2;
             n=Math.abs(n);
             if(size1>size2){
                 for(int i=0;i<n;i++){
                 ListNode a =new ListNode(0);
                 a.next =l2;
                 l2=a;
             }
             }else {
                  for(int i=0;i<n;i++){
                 ListNode a =new ListNode(0);
                 a.next =l1;
                 l1=a;
             }
             }
         }

             l1=Reverse(l1);
             l2=Reverse(l2);

             ListNode temp1=l1;
             ListNode temp2=l2;

             while(temp1 !=null && temp2!=null){
                  sum=temp1.val +temp2.val;
                  sum+=carry;
                  ListNode a =new ListNode(sum%10);
                  temp.next =a;
                  temp=a;
                  carry=sum/10;
                  temp1=temp1.next;
                   temp2=temp2.next;
             }

             if(temp1==null && temp2==null){
                 if(carry !=0){
                  ListNode a =new ListNode(carry);
                     temp.next =a;
                     temp=a;
                 }
             }


             head3=head3.next;
            //  head3=Reverse(head3);


             return head3;
             
         


    }
}
