
//https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> st =new Stack<>();
        char[] arr =s.toCharArray();

        for(int i=0;i<s.length();i++){
            if(arr[i]>='a' && arr[i]<='z')continue;
            if(arr[i]=='('){
               st.push(i);
            }else if(arr[i]==')'){
                if(st.isEmpty()){
                    arr[i]='*';
                }else{
                    st.pop();
                }
            }

        }

        while(!st.isEmpty()){
            int i=st.pop();
            arr[i]='*';
        }

        StringBuilder sb =new StringBuilder("");
        for(int i=0;i<arr.length;i++){
            if(arr[i]!='*')sb.append(arr[i]);
        }

        return sb.toString();
    }
}
