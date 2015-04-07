package datastructures;

import datastructures.LinkedList.Node;

public class DoublyLinkedList<T>{

	public class Node{
		private Node next;
		private Node prev;
		private T value;
		
		public Node(T newVal){
			this.setValue(newVal);
			this.setNext(null);
			this.setPrev(null);
		}
		
		public Node(T newVal, Node newPrev){
			this.setValue(newVal);
			this.setPrev(newPrev);
			this.setNext(null);
		}
		
		public Node(T newVal, Node newPrev, Node newNext){
			this.setValue(newVal);
			this.setPrev(newPrev);
			this.setNext(newNext);
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node newNext) {
			this.next = newNext;
		}

		public Node getPrev(){
			return prev;
		}
		
		public void setPrev(Node newPrev){
			this.prev = newPrev;
		}
		
		public T getValue() {
			return value;
		}

		public void setValue(T newValue) {
			this.value = newValue;
		}
		
		public String toString(){
			return getValue().toString();
		}
	}
	
	private Node head   = null;
	private Node tail   = null;
	
	public DoublyLinkedList(T[] initialValues){
		Node prevNode = null;
		
		for(int i=0; i<initialValues.length; i++){
			Node tmpNode;
			if(prevNode == null){
				tmpNode = new Node(initialValues[i]);
				this.head = tmpNode;
				this.tail = tmpNode;
			}else{
				tmpNode = new Node(initialValues[i], prevNode);
				this.tail.setNext(tmpNode);
				prevNode.setNext(tmpNode);
				this.tail = tmpNode;
			}
			prevNode = tmpNode;
		}
	}
	
	public DoublyLinkedList(){
		// nothing to do
	}
	
	public void insert(T value){
		if(search(this.head, value) == null){
			Node n;
			if(this.head == null){
				n = new Node(value);
				this.head = n;
				this.tail = n;
			}else{
				n = new Node(value, this.tail);
				this.tail.setNext(n);
				this.tail = n;
			}
		}
	}
	
	public Node search(Node n, T value){
		if(n == null){
			return null;
		}else{
			if(n.getValue().equals(value)){
				return n;
			}else{
				return search(n.getNext(), value);
			}
		}
	}
	
	public void delete(T value){
		Node toDelete = search(this.head, value);
		if(toDelete != null){
			if(toDelete.getPrev() == null){
				if(toDelete.getNext() != null){
					toDelete.getNext().setPrev(null);
					this.head = toDelete.getNext();
				}else{
					this.head = null;
				}
			}else if(toDelete.getNext() == null){
				toDelete.getPrev().setNext(null);
				this.tail = toDelete.getPrev();
				
			}else{
				toDelete.getPrev().setNext(toDelete.getNext());
				toDelete.getNext().setPrev(toDelete.getPrev());
			}
		}
	}
	
	public Node getHead(){
		return head;
	}
	
	public Node getTail(){
		return tail;
	}
	
	public void print(boolean reverse){
		if(this.head != null){
			if(reverse){
				Node p = this.head;
			
				while(p != null){
					System.out.print(p.getValue());
					if(p.getNext() != null){
						System.out.print(" <--> ");
					}
					p = p.getNext();
				}
			}else{
				Node p = this.tail;
				
				while(p != null){
					System.out.print(p.getValue());
					if(p.getPrev() != null){
						System.out.print(" <--> ");
					}
					p = p.getPrev();
				}
			}
			System.out.println();	
		}else{
			System.out.println("The list is empty.");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoublyLinkedList<String> ll = new DoublyLinkedList<>();
		ll.insert("Christopher");
		ll.insert("Daniel");
		ll.insert("Parkin");
		ll.print(false);
		ll.print(true);
		System.out.println("HEAD: " + ll.getHead().getValue());
		System.out.println("TAIL: " + ll.getTail().getValue());
		System.out.println("SEARCH Dan: " + ll.search(ll.getHead(), "Dan"));
		System.out.println("SEARCH Daniel: " + ll.search(ll.getHead(), "Daniel"));
		System.out.println("--- Delete Daniel ---");
		ll.delete("Daniel");
		ll.print(false);
		ll.print(true);
		System.out.println("HEAD: " + ll.getHead().getValue());
		System.out.println("TAIL: " + ll.getTail().getValue());
		System.out.println("--- Delete Christopher ---");
		ll.delete("Christopher");
		ll.print(false);
		ll.print(true);
		System.out.println("HEAD: " + ll.getHead().getValue());
		System.out.println("TAIL: " + ll.getTail().getValue());
		System.out.println("--- Delete Parkin ---");
		ll.delete("Parkin");
		ll.print(false);
		ll.print(true);
		Integer[] input = {1,2,3,4,5,6,7,8,9,10};
		DoublyLinkedList<Integer> dll = new DoublyLinkedList<>(input);
		dll.print(false);
		dll.print(true);
		dll.delete(5);
		dll.print(false);
		dll.print(true);
	}

}

