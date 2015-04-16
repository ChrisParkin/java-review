package datastructures;

public class LinkedList<T>{

	public static void main(String[] args){
		LinkedList<String> ll = new LinkedList<>();
		ll.insert("Hello");
		ll.insert("World");
		ll.insert("How's");
		ll.insert("it");
		ll.insert("going?");
		ll.print();
		ll.reverse();
		ll.print();
		ll.reverseRecursive();
		ll.print();
	}
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
	
	public int getLength(){
		return length;
	}
	
	public void reverse(){
		Node prev = null;
		Node curr = null;
		Node next = null;
		
		for(int i = 0; i < getLength(); i++){
			if(i == 0){
				curr = head.getNext();
				tail = head;
				tail.setNext(null);
				prev = tail;
			}else{
				if(i == length - 1){
					head = curr;
					curr.setNext(prev);
				}else{
					next = curr.getNext();
					curr.setNext(prev);
					prev = curr;
					curr = next;
				}
			}	
		}
	}
	
	public void reverseRecursive(Node... nodes){
		
		if(nodes.length == 0){
			tail = head;
			reverseRecursive(tail, tail.getNext());
			tail.setNext(null);
		}else{
			Node n = nodes[0];
			Node p = nodes[1];
			Node next;
			if(p == null){
				head = n;
			}else{
				next = p.getNext();
				p.setNext(n);
				reverseRecursive(p, next);
			}
		}
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
}
