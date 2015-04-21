import java.util.Arrays;
import java.util.LinkedList;

public class MergeSort {

	public static void mergesort(char[] s, int start, int stop){
		int middle;
		
		if(start < stop){
			middle = (int)(start + stop) / 2;
			mergesort(s, start, middle);
			mergesort(s, middle+1, stop);
			merge(s, start, middle, stop);
		}
	}
	
	public static void merge(char[] s, int start, int middle, int stop){
		
		int i; // counter
		
		LinkedList<Character> buff1 = new LinkedList<>();
		LinkedList<Character> buff2 = new LinkedList<>();
		
		// get buffers ready
		for(i = start; i <= middle; i++){
			buff1.add(s[i]);
		}
		for(i = middle+1; i <= stop; i++){
			buff2.add(s[i]);
		}
		
		i = start;
		while(!(buff1.isEmpty() || buff2.isEmpty())){
			if(buff1.peek() <= buff2.peek()){
				s[i++] = buff1.pop();
			}else{
				s[i++] = buff2.pop();
			}
		}
		
		while(!buff1.isEmpty()) s[i++] = buff1.pop();
		while(!buff2.isEmpty()) s[i++] = buff2.pop();
	}
	
	public static void main(String[] args){
		long starttime = System.currentTimeMillis();
		char[] myname = "HEREISMYAMAZINGSTRING".toCharArray();
		mergesort(myname,0, myname.length - 1);
		System.out.println(Arrays.toString(myname));
		long endtime = System.currentTimeMillis();
		System.out.println("Time: " + (endtime - starttime) + " milliseconds");
	}
}
