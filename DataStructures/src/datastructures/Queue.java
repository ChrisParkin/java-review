package datastructures;

import java.util.ArrayList;
import java.util.List;


public class Queue<T> {
	
	private List<T> list;
	public Queue(){
		list = new ArrayList<>();
	}
	
	public T dequeue(){
		try{
			return list.remove(0);
		}catch(IndexOutOfBoundsException e){
			System.err.println("The queue is empty.");
			return null;
		}
	}
	
	public void enqueue(T newEntry){
		list.add(newEntry);
	}
	
	public void print(){
		System.out.println("---- Queue Print ----");
		int i = 1;
		for(T t : list){
			System.out.println(i++ + ": " + t.toString());
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Queue<Integer> s = new Queue<>();
		s.enqueue(10);
		s.enqueue(20);
		s.print();
		
		System.out.println("POP: " + s.dequeue());
		s.print();
		s.enqueue(5);
		s.enqueue(4);
		s.enqueue(3);
		s.enqueue(2);
		s.enqueue(1);
		s.print();
		
		System.out.println("POP: " + s.dequeue());
		System.out.println("POP: " + s.dequeue());
		System.out.println("POP: " + s.dequeue());
		System.out.println("POP: " + s.dequeue());
		System.out.println("POP: " + s.dequeue());
		System.out.println("POP: " + s.dequeue());
		System.out.println("POP: " + s.dequeue());
	}

}
