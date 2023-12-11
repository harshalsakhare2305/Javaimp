package Stack;

//https://leetcode.com/problems/asteroid-collision/

import java.util.Stack;

public class AsteroidCollision {
    
    public static int[] asteroidCollision(int[] asteroids) {
            int n =asteroids.length;
            Stack<Integer> st =new Stack<>();
           
         for(int i=0;i<n;i++){
             while(!st.isEmpty() && st.peek()>0 && asteroids[i]<0){  // In this Condition only Collision is Going to happen

             if(!st.isEmpty() && st.peek()+asteroids[i]<0){
              st.pop();
              
             }else if(!st.isEmpty() && st.peek()+asteroids[i]==0){
                 asteroids[i]=0;
                 st.pop();
             }else{
                 asteroids[i]=0;
             }
             }
              if(asteroids[i]!=0){
                     st.push(asteroids[i]);
              }
         }
      int[] ans =new int[st.size()];
      int i =ans.length-1;
         while(!st.isEmpty()){
           ans[i]=st.pop();
           i--;
         }

         return ans;
    }
    public static void main(String[] args) {
        int[] asteroids ={-1,2,-2,3};
        int [] ans =asteroidCollision(asteroids);

        for(int i:ans){
            System.out.println(i);
        }
    }
}

