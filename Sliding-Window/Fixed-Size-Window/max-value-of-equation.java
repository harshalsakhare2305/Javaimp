//https://leetcode.com/problems/max-value-of-equation/
class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        int n=points.length;
        int maxi=Integer.MIN_VALUE;

        ArrayDeque<int[]> dq =new ArrayDeque<>();

        for(int[] curr:points){

            while(!dq.isEmpty() && Math.abs(dq.peekFirst()[1]-curr[0])>k){
                dq.pollFirst();
            }

            int value = curr[1]-curr[0];

              if(!dq.isEmpty()){
                maxi=Math.max(maxi,dq.peekFirst()[0]+curr[0]+curr[1]);
            }

            while(!dq.isEmpty() && dq.peekLast()[0] <= value){
                dq.pollLast();
            }
           
          

            dq.addLast(new int[]{value,curr[0]});

        }

        return maxi;






        }

    }
