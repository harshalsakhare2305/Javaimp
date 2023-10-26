

public class Stackclass {
     static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data=data;
            this.next=null;
        }
     }
 
     static class stack{
        public  static Node head;

        public static  boolean isEmpty(){
            return head==null;
        }

        public static void push(int data){
            Node newNode =new Node(data);
            if(isEmpty()){
              head=newNode;
              return;
            }

           newNode.next=head;
           head=newNode;
        }

        public static int pop(){
            if(isEmpty()){
              
               return -1;
            }

            int top =head.data;
            head=head.next;

            return top;
        }

        public static int peek(){
            if(isEmpty()){
              
               return -1;
            }

            return head.data;
        }
     }

    
    public static void main(String[] args) {
        stack s1 =new stack();
        s1.push(1);
        s1.push(2);
        s1.push(3);
        s1.push(4);

        while(!s1.isEmpty()){
            System.out.println(s1.peek());

            s1.pop();
        }
    }
}
