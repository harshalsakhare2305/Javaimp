//https://leetcode.com/problems/the-number-of-weak-characters-in-the-game/
class Solution {
    public void nextCount(int[][] properties,int[]mark){
        
        Stack<int[]> st =new Stack<>();
        int n=properties.length;

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && (st.peek()[0]<=properties[i][0] || st.peek()[1]<=properties[i][1] )){
                st.pop();
            }

            if(!st.isEmpty()){
                mark[i]=1;
            }

            st.push(properties[i]);
        }


    }


     public void PrevCount(int[][] properties,int[]mark){
        
        Stack<int[]> st =new Stack<>();
        int n=properties.length;

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && (st.peek()[0]<=properties[i][0] || st.peek()[1]<=properties[i][1] )){
                st.pop();
            }

            if(!st.isEmpty()){
                mark[i]=1;
            }

            st.push(properties[i]);
        }


    }
    public int numberOfWeakCharacters(int[][] properties) {
        int n=properties.length;

        Arrays.sort(properties,new Comparator<int[]>(){
            public int compare(int[]a,int[]b){
                return (a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
            }
        });
        int[]mark=new int[n];
        nextCount(properties,mark);
        PrevCount(properties,mark);

        int count=0;

        for(int i:mark){
            count+=i;
        }

        return count;
    }
}
