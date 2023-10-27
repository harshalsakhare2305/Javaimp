class Solution
{ 
   private boolean knows(int M[][],int a,int b){
       if(M[a][b]==1){
           return true;
       }
       
       return false;
   }
    int celebrity(int M[][], int n)
    {
        
        //step 1
     	Stack<Integer> st =new Stack<>();
     	for(int i=0;i<n;i++){
     	    st.push(i);
     	}
     	
     	//step2 :take  two topmost element
     	
     	while(st.size()>1){
     	    int a =st.pop();
     	    int b =st.pop();
     	    
     	    if(knows(M,a,b)){
     	        st.push(b);
     	    }else{
     	        st.push(a);
     	    }
     	}
     	
     	// step3: we found our probable celebrity which st.peek() now verify it is actually a celebrity or not
     	int celebrity =st.peek();
     	int zerocount =0;
     	// rows ==0
     	for(int i=0;i<n;i++){
     	  if(  M[celebrity][i]==0){
     	      zerocount++;
     	  }
     	}
     	
     	if(zerocount!=n){
     	    return -1;
     	}
     	int onecount =0;
     	// column ==1
     		for(int i=0;i<n;i++){
     	  if(  M[i][celebrity]==1){
     	      onecount++;
     	  }
     	}
     	if(onecount !=n-1){
     	    return -1;
     	}
     	return celebrity;
     	
     	}
}
