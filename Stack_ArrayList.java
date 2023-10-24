import java.util.ArrayList;
public class StackClass1 {
     static  class stack{
    static ArrayList<Integer> list =new ArrayList<>();
       
       //isEmpty Function
       static boolean isEmpty(){
    return  list.size()==0;
       }

       //push function

       static void push(int data){
        list.add(data);
       }

       //pop
       static int pop(){
        if(isEmpty()){
            return -1;
        }
        int top =list.get(list.size()-1);
        list.remove(list.size()-1);

        return top;
       }

       static int peek(){
        if(isEmpty()){
            return -1;
        }
         int top =list.get(list.size()-1);
         return top;
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

