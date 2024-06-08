//https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/description/?envType=study-plan-v2&envId=leetcode-75
class Solution {
    int ans=0;
    public void DFS(ArrayList<ArrayList<int[]>> adj,int curr,int par){
        for(int[] arr:adj.get(curr)){
            int v =arr[0];
             int check=arr[1];
            if(v!=par){
              if(check==1){
                 ans++;
              }
              DFS(adj,v,curr);
            }
           
           
        }
    }
    public int minReorder(int n, int[][] connections) {
        ArrayList<ArrayList<int[]>> adj =new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<int[]>());
        }

        for(int i=0;i<connections.length;i++){
            int u =connections[i][0];
            int v =connections[i][1];
            adj.get(u).add(new int[]{v,1});
            adj.get(v).add(new int[]{u,0});
        }
         DFS(adj,0,-1);
         return ans;
    
    }
}
