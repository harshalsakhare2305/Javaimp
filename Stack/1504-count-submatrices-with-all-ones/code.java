//https://leetcode.com/problems/count-submatrices-with-all-ones/

class Solution {
    int res=0;
    public void solve(int[]row,int[][]mat){
        Stack<int[]> st =new Stack<>();
       st.push(new int[]{-1,0,-1});

        for(int j=0;j<mat[0].length;j++){

            while(!st.isEmpty() && st.peek()[2]>=row[j]){
                st.pop();
            }

            int left=st.peek()[0];
            int prev=st.peek()[1];

            int curr=prev+(j-left)*row[j];

            st.push(new int[]{j,curr,row[j]});
            res+=curr;
        }


    }
    public int numSubmat(int[][] mat) {
        int n=mat.length;
       
       int[] row =new int[mat[0].length];
       
       for(int i=0;i<n;i++){
          
         for(int j=0;j<mat[0].length;j++){
            if(i==0){
                row[j]=mat[i][j];
            }else{
                row[j]=(mat[i][j]==1?row[j]+1:0);
            }

          
         }
           solve(row,mat);
       }
    
    return res;

         
   
    }
}
