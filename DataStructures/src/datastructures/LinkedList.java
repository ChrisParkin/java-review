package datastructures;

public class LinkedList<T>{

	public class Node{
		private Node next;
		private T value;
		
		public Node(T newVal){
			this.setValue(newVal);
			this.setNext(null);
		}
		
		public Node(T newVal, Node newNext){
			this.setValue(newVal);
			this.setNext(newNext);
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node newNext) {
			this.next = newNext;
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
	private int     length = 0;
	
	public LinkedList(T[] initialValues){
		Node prevNode = null;
		for(int i=initialValues.length - 1; i > 0; i--){
			if(prevNode == null){
				Node tmpNode = new Node(initialValues[i]);
				tail = tmpNode;
			}else{
				Node tmpNode = new Node(initialValues[i], prevNode);
				prevNode = tmpNode;
				head = tmpNode;
			}
		}
	}
	
	public LinkedList(){
		// nothing to do
	}
	
	public void insert(T value){
		if(!search(this.head, value)){
			Node n = new Node(value);
			if(this.length == 0){
				this.head = n;
				this.tail = n;
			}else{
				this.tail.setNext(n);
				this.tail = n;
			}
			this.length++;
		}
	}
	
	public boolean search(Node n, T value){
		if(n == null){
			return false;
		}else{
			if(n.getValue().equals(value)){
				return true;
			}else{
				return search(n.getNext(), value);
			}
		}
	}
	
	public Node getPredecessor(Node n, T value){
		if(n.getNext() == null){
			return null;
		}else{
			if(n.getNext().getValue().equals(value)){
				return n;
			}else{
				return getPredecessor(n.getNext(), value);
			}
		}
	}
	
	public void delete(T value){
		if(this.head.getValue() == value){
			this.head = this.head.getNext();
		}else{
			Node upstream = getPredecessor(this.head, value);
			if(upstream != null){
				if(upstream.getNext().getNext() == null){
					this.tail = upstream;
					upstream.setNext(null);
				}else{
					upstream.setNext(upstream.getNext().getNext());
				}
			}
		}
	}
	
	public Node getHead(){
		return head;
	}
	
	public Node getTail(){
		return tail;
	}
	
	public void print(){
		if(this.head != null){
			Node p = this.head;
			while(p != null){
				System.out.print(p.getValue());
				if(p.getNext() != null){
					System.out.print(" --> ");
				}
				p = p.getNext();
			}
			System.out.println();
		}else{
			System.out.println("The list is empty.");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<String> ll = new LinkedList<>();
		ll.insert("Christopher");
		ll.insert("Daniel");
		ll.insert("Parkin");
		ll.print();
		System.out.println("HEAD: " + ll.getHead().getValue());
		System.out.println("TAIL: " + ll.getTail().getValue());
		System.out.println("SEARCH Dan: " + ll.search(ll.getHead(), "Dan"));
		System.out.println("SEARCH Daniel: " + ll.search(ll.getHead(), "Daniel"));
		System.out.println("--- Delete Daniel ---");
		ll.delete("Daniel");
		ll.print();
		System.out.println("HEAD: " + ll.getHead().getValue());
		System.out.println("TAIL: " + ll.getTail().getValue());
		System.out.println("--- Delete Christopher ---");
		ll.delete("Christopher");
		ll.print();
		System.out.println("HEAD: " + ll.getHead().getValue());
		System.out.println("TAIL: " + ll.getTail().getValue());
		System.out.println("--- Delete Parkin ---");
		ll.delete("Parkin");
		ll.print();
	}

}
