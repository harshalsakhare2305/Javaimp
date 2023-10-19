/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution { 
    public int findSize(ListNode head){
        int size =0;
        ListNode temp=head;
        while(temp !=null){
            temp=temp.next;
            size++;
        }
        return size;
    }
    public ListNode reverseKtimes(ListNode head,int k){
         
        ListNode next =null;
        ListNode prev =null;
        ListNode curr =head;
        int count =0;

        while(curr !=null && count<k){
           next =curr.next;
           curr.next =prev;
           prev =curr;
           curr =next;
           count++;
        }
         head.next=curr; 

        return prev;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
       
        if(head==null){
            return null;
        }else if (head.next==null &&left ==right){
            return head;
        }else if(left==right){
            return head; 
        }
        int k=(right-left)+1;
        int size =findSize(head);
        if(k==size){
            return reverseKtimes(head,size);
        }else if (left ==1){
            return reverseKtimes(head,k);
        }

        ListNode temp =head;
        
        int i=1;
        while(i<left){
            temp=temp.next;
            i++;
        }

        ListNode temp3=head;
        for(int j=0;j<(left-2);j++){
            temp3=temp3.next;
        }
        ListNode left1 =temp3;

       ListNode rotated= reverseKtimes(temp,k);
       left1.next=rotated;
       return head;
    }
}
