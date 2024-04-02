//https://www.geeksforgeeks.org/problems/minimum-absolute-difference-in-bst-1665139652/1
class Solution
{
    static Node prev ;
    static int min;
    Solution(){
        this.prev = null;
        this.min = Integer.MAX_VALUE;
    }
    int absolute_diff(Node root)
    {
        inorder(root);
        return min;
    }
    public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        if(prev!=null){
            min = Math.min(Math.abs(root.data-prev.data),min);
        }
        prev = root;
        inorder(root.right);
    }
}
