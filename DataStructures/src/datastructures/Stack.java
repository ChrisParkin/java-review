package datastructures;
import java.util.List;
import java.util.ArrayList;

public class Stack<T> {
	private List<T> list;
	public Stack(){
		list = new ArrayList<>();
	}
	
	public T pop(){
		try{
			return list.remove(0);
		}catch(IndexOutOfBoundsException e){
			System.err.println("The stack is empty.");
			return null;
		}
	}
	
	public void push(T newEntry){
		list.add(0,newEntry);
	}
	
	public void print(){
		System.out.println("---- Stack Print ----");
		int i = 1;
		for(T t : list){
			System.out.println(i++ + ": " + t.toString());
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> s = new Stack<>();
		s.push(10);
		s.push(20);
		s.print();
		
		System.out.println("POP: " + s.pop());
		s.print();
		s.push(5);
		s.push(4);
		s.push(3);
		s.push(2);
		s.push(1);
		s.print();
		
		System.out.println("POP: " + s.pop());
		System.out.println("POP: " + s.pop());
		System.out.println("POP: " + s.pop());
		System.out.println("POP: " + s.pop());
		System.out.println("POP: " + s.pop());
		System.out.println("POP: " + s.pop());
		System.out.println("POP: " + s.pop());
	}

}
