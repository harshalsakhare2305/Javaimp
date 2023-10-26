import java.util.Stack;

public class NextGreterelement {
    
    public static int[] nextGreaterElements(int[] nums) {
        int n=nums.length;

        int[] res =new int[n];
        Stack<Integer> st =new Stack<>();
        
        res[n-1]=-1;
          st.push(nums[n-1]);
        for(int i=n-2;i>=0;i--){
           while(st.isEmpty()==false && st.peek()<=nums[i] ){
              st.pop();
              
           }

          if(st.size()==0){
            res[i]=-1;
          }else{
            res[i]=st.peek();
          }

          st.push(nums[i]);
        }
       return res;
    }
    public static void main(String[] args) {
        int [] nums ={1,2,5,4,3,6,3,8,1};
        int [] arr =nextGreaterElements(nums);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}

