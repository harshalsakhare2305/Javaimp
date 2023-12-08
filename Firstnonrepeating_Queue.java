class Solution
{
    public String FirstNonRepeating(String A)
    {
        Queue<Character> q =new LinkedList<>();
        HashMap<Character,Integer> mp =new HashMap<>();
        String ans ="";
        
        
        for(int i=0;i<A.length();i++){
            char ch =A.charAt(i);
            
            if(!mp.containsKey(ch)){
                mp.put(ch,1);
            }else{
                mp.put(ch,mp.get(ch)+1);
            }
        
        
        
        q.offer(ch);
        
        
        while(!q.isEmpty()){
            if(mp.get(q.peek())>1){ //repeating char
                q.poll();
                
            }else{
                ans+=q.peek();
            break;
            }
        }
        
        if(q.isEmpty()){
            ans+="#";
        }
        
        
        }
        
        return ans;
        
        
        
        
        
    }
}
