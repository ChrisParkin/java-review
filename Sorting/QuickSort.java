import java.util.Arrays;


public class QuickSort {

	public static void quicksort(char[] s, int start, int stop){
		if(start < stop){

			char pivot = s[stop];
			int wall = start;
			for(int i = start; i < stop; i++){
				if(s[i] <= pivot){
					swap(s, wall++, i);
				}
			}
			swap(s, wall, stop);
			quicksort(s, start, wall-1);
			quicksort(s, wall+1, stop);
		}
	}
	public static void swap(char[] s, int i, int j){
		char tmp = s[i];
		s[i] = s[j];
		s[j] = tmp;
	}
	
	public static void main(String[] args){
		long starttime = System.currentTimeMillis();
		char[] myname = "HEREISMYAMAZINGSTRING".toCharArray();
		quicksort(myname,0, myname.length - 1);
		System.out.println(Arrays.toString(myname));
		long endtime = System.currentTimeMillis();
		System.out.println("Time: " + (endtime - starttime) + " milliseconds");
	}

}
