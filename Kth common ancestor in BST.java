//https://www.geeksforgeeks.org/problems/kth-common-ancestor-in-bst/1
class Solution {
    public Node lowestCommonAncestor(Node root,int p,int q){
        
        if(p>root.data && q>root.data ){
            return  lowestCommonAncestor(root.right,p,q);
        }else if(p<root.data && q<root.data){
            return  lowestCommonAncestor(root.left,p,q);
        }else if(p==root.data || q==root.data){
            return root;
        }else{
            return root;
        }
        
    }
    public int kthCommonAncestor(Node root, int k, int x, int y) {
        // code here
        Node lca=lowestCommonAncestor(root,x,y);
        
        ArrayList<Integer>ans =new ArrayList<>();
        Node temp=root;
          
          
          while(temp.data!=lca.data){
              ans.add(temp.data);
              if(lca.data>temp.data){
              temp=temp.right;
          }else if(lca.data<temp.data){
              temp=temp.left;
          }
          }
          ans.add(lca.data);
          
          if(k>ans.size()){
              return -1;
          }
          Collections.reverse(ans);
          
          for(int i=0;i<ans.size();i++){
              if(k==i+1){
                  return ans.get(i);
              }
          }
          
          
          
          
        return -1;
          
        
    }
}
