//https://leetcode.com/problems/word-search/?envType=daily-question&envId=2024-04-03
class Solution {
    int[]drow={-1,0,1,0};
    int[]dcol={0,1,0,-1};
    public boolean DFS(char[][]board,String word,int r,int c,int ptr,boolean[][]vis){
        int m =board.length;
        int n=board[0].length;
         boolean ans=false;
        
       
        vis[r][c]=true;
        for(int i=0;i<4;i++){
            int nr=r+drow[i];
            int nc=c+dcol[i];
            if(nr>=0 && nr<m && nc>=0 &&nc<n && ptr+1<word.length() && board[nr][nc]==word.charAt(ptr+1) && vis[nr][nc]==false){
             
                ans=ans | DFS(board,word,nr,nc,ptr+1,vis);
              
            }
        }

          if(ptr+1==word.length()){
                return true;
              }
              vis[r][c]=false;

        return ans;
    }
    public boolean exist(char[][] board, String word) {
        int m =board.length;
        int n=board[0].length;
       
        Queue<int[]> q =new LinkedList<>();
        char ch=word.charAt(0);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
               if(board[i][j]==ch){
                q.add(new int[]{i,j});
                
               }
            }
        }

        while(!q.isEmpty()){
             boolean[][] vis=new boolean[m][n];
             int[] temp =q.poll();
             int r=temp[0];
             int c=temp[1];
          if(DFS(board,word,r,c,0,vis)){
                return true;  
            }
        }

        return false;
    }
}
