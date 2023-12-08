class Compute {
    
    public long[] printFirstNegativeInteger(long A[], int N, int K)
    { 
      
      Queue<Integer> q =new LinkedList<>();
    
      long[] result =new long[N-K+1];
      
      
      //Accessing the First Kth Window 
      
      for(int i=0;i<K;i++){
          if(A[i]<0){
              q.add(i);
          }
      }
      
      if(q.size()>0){
          result[0]=A[q.peek()];
      }else{
          result[0]=0;
      }
      
      
        int m=1;
      //Accesing the the Other Remaining Windows 
      for(int i=K;i<N;i++){
          if(!q.isEmpty() && i-q.peek()>=K){
              q.remove();
          }
          
          if(A[i]<0){
              q.add(i);
          }
          
           if(q.size()>0){
          result[m]=A[q.peek()];
         }else{
          result[m]=0;
      }
          
            m++;
          
          
      }
      
      
      
      return result;
      
        
    }
}
