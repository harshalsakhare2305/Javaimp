public class LL {
    // declaring the variable head
    Node head;
    class Node{
     String data;
     Node next;
 // constructor of node
     Node(String data){
        this.data=data;
        this.next=null;
     }

    }
     // add first 
     public void addfirst(String data){
         Node newNode = new Node(data);
         
         if(head==null){
             head = newNode;
             return;
            }
            newNode.next= head;
            head =newNode;
        }
        // add last
     public void addlast(String data){
         Node newNode = new Node(data);

        if(head==null){
          head = newNode;
          return;
        }
        Node currnode=head;

        while(currnode.next !=null){
       currnode =currnode.next;
        }

        currnode.next= newNode;

     }
     // print 
     public void printlist() {
        if(head==null){
            System.out.println( "list is empty");
            return;
        }
        Node currnode=head;

        while(currnode!=null){
            System.out.print(currnode.data +" "+ "->");
       currnode =currnode.next;
        }
System.out.print("null");
        
     }

     // reverse the linked list using iterations
     public void reversell(){
     if(head==null || head.next==null){
        return;
     }   

        Node prevnode=head;
        Node currnode =head.next;

        while(currnode !=null){
            Node nextnode =currnode.next;

            currnode.next= prevnode;

            //updation
            prevnode =  currnode;
            currnode=nextnode;
        }
          head.next=null;
          head=prevnode;


     }

     public Node reverserecursive(Node head){

        if(head==null || head.next==null){
            return head;
        }
        Node newnode= reverserecursive(head.next);
        head.next.next=head;
        head.next=null;
        return newnode;    
    }

    public Node deletenthnodefromlast(Node head,int n){
        int size=0;
        Node currnode=head;
        while(currnode!=null){
            currnode=currnode.next;
            size++;
        }
        if(head.next==null){
            return null;
        }
        if(n==size){
            return head.next;
        }
        Node prevnode=head;
        int idxprev=size-n;
        int i=1;
        while(i< idxprev){
            prevnode=prevnode.next;
            i++;

        }
        prevnode.next=prevnode.next.next;
        return head;
    }
 
    public Node reverelist(Node head){
        Node prev =null;
        Node curr=head;
        while(curr!=null){
            Node next =curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;

        }
        head.next=null;
        return prev;

    }
    public Node Middle(Node head){
        Node hair=head;
        Node turtle=head;
        while(turtle.next!=null && turtle.next.next!=null){
            hair=hair.next;
            turtle=turtle.next.next;
        }
        return hair;
    }
    public Boolean islistpalindrome(Node head){
        if(head==null || head.next==null){
            return true;

        }

        Node middlenode =Middle();
        Node startsecondhalf=reversell(middlenode.next);
     Node startfirsthalf =head; 
        while(startsecondhalf !=null){
            if(startfirsthalf.data!=startsecondhalf.data){
                return false;
            }
            startfirsthalf=startfirsthalf.next;
            startsecondhalf=startsecondhalf.next;
        }

        return true;
        
    }
    public static void main(String[] args) {
        LL list =new LL();
        list.addfirst("is");
        list.addfirst("this");
        list.addfirst("list");
        // list.printlist();
        // list.head= list.reverserecursive(list.head);
        // list.printlist();
        //  list.head= list.deletenthnodefromlast(list.head,2);
list.islistpalindrome(list.head);

        //  System.out.println();

    }
}
