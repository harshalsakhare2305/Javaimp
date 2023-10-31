import java.util.* ;
import java.io.*; 
public class Solution {

	public static void sortedInsert(Stack<Integer> stack,int num){
		if(stack.empty() || (!stack.empty() && stack.peek()<num)){
			stack.push(num);
			return ;
		}


		int top =stack.pop();

	sortedInsert(stack, num);

	stack.push(top);
	}

	public static void sortStack(Stack<Integer> stack) {
		
		if(stack.empty()){
			return;
		}

		int top =stack.pop();
		// recussive calls
		sortStack(stack);

		sortedInsert(stack,top);
	}

}
