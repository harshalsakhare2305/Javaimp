//https://leetcode.com/problems/simplify-path/
class Solution {
    public String simplifyPath(String path) {
        Stack<String> st =new Stack<>();

        StringBuilder sb =new StringBuilder("");

        boolean slash=false;

        for(char ch:path.toCharArray()){
            if((ch=='/' && !slash)){
               
               if(sb.length()>0 &&   sb.charAt(sb.length()-1)=='.' && sb.charAt(sb.length()-1)=='.'){
                  if(sb.length()==2 && sb.charAt(0)=='.' && sb.charAt(1)=='.' ){
                    if(!st.isEmpty()){
                      st.pop();
                    }
                   
                  }else if(sb.length()>2) st.push(sb.toString());
               }else if(sb.length()>0){
                  st.push(sb.toString());
               }

               sb.setLength(0);
               slash=true;
            }else if(ch!='/'){
             sb.append(ch);
             slash=false;
            }
        }

        if(path.charAt(path.length()-1)!='/'){
            if(sb.length()>0 && sb.charAt(0)=='.' && sb.charAt(sb.length()-1)=='.'){
                  if(sb.length()==2){
                    if(!st.isEmpty()){
                      st.pop();
                    }
                   
                  }
                  else if(sb.length()>2)st.push(sb.toString());
               }else if(sb.length()>0){
                  st.push(sb.toString());
               }
        }

     if(st.isEmpty())return new String("/");
        StringBuilder ans =new StringBuilder("");
        while(!st.isEmpty()){
            String s=st.pop();
            ans.insert(0,s);
            ans.insert(0,"/");
        }

        return ans.toString();
    }
}
