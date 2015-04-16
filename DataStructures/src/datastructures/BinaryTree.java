package datastructures;

import org.w3c.dom.Node;

public class BinaryTree {
	
	private Node root;
	private Node pointer;
	private int  size;
	
	public BinaryTree(){
		root    = null;
		pointer = null;
	}
	
	public int size(){
		return size;
	}
	
	public Node search(int value){
		return root == null ? null : search(value, root);
	}
	public Node search(int value, Node n){
		if(n == null){
			return null;
		}else if(n.value() == value){
			pointer = n;
			return n;
		}else{
			pointer = n;
			if(value < n.value()){
				return search(value, n.lChild());
			}else{
				return search(value, n.rChild());
			}
		}
	}
	
	public boolean hasValue(int value){
		return search(value, root) != null;
	}
	
	public void insert(int value){
		System.out.println("-- Insert " + value + " --");
		if(root == null){
			root = new Node(value, null, null, null);
		}else{
			if(!hasValue(value)){
				if(value < pointer.value()){
					pointer.addLeft(value);
				}else{
					pointer.addRight(value);				
				}
			}
		}
		size++;
	}
	
	public void delete(int value){
		System.out.println("-- Delete " + value + "--");
		if(!hasValue(value)){
			System.out.format("%d is not in the tree\n", value);
		}else{
			if(pointer.hasRight()){
				if(pointer.isRight()){
					pointer.parent().setRight(pointer.rChild());
				}else if(pointer.isLeft()){
					pointer.parent.setLeft(pointer.rChild());
				}
				pointer.rChild().setParent(pointer.parent());
			}else if(pointer.hasLeft()){
				if(pointer.isRight()){
					pointer.parent().setRight(pointer.lChild());
				}else if(pointer.isLeft()){
					pointer.parent.setLeft(pointer.lChild());
				}
				pointer.lChild().setParent(pointer.parent());
			}else{
				if(pointer.isRight()){
					pointer.parent.setRight(null);
				}else if(pointer.isLeft()){
					pointer.parent.setLeft(null);
				}else{
					root = null;
				}
			}
		}
		size--;
	}
	
	public void breadthPrint(Node... n){
		if(n.length == 0){
			if(root != null){
				breadthPrint(root);
			}else{
				System.out.println("The tree is empty.");
			}
		}else{
			
			Node curr = n[0];
			if(curr != null){
				breadthPrint(curr.lChild());
				System.out.println(curr.value());
				breadthPrint(curr.rChild());
			}
		}
	}
	
	/**
	 * Node to be found within a binary tree
	 */
	public class Node{
		private int value;
		private Node parent;
		private Node left;
		private Node right;
		
		public Node(int val, Node p, Node l, Node r){
			value   = val;
			parent  = p;
			left    = l;
			right   = r;
		}
		
		public Node parent(){
			return parent;
		}
		public Node lChild(){
			return left;
		}
		
		public Node rChild(){
			return right;
		}
		
		public Node sibling(){
			if(isRoot()){
				return null;
			}
			Node p = parent();
			if(this == p.lChild()){
				return p.rChild();
			}else{
				return p.lChild();
			}
		}
		
		public int value(){
			return value;
		}
		
		public boolean hasLeft(){
			return left != null;
		}
		
		public boolean hasRight(){
			return right != null;
		}
		
		public void setRight(Node n){
			this.right = n;
		}
		
		public void setLeft(Node n){
			this.left = n;
		}
		
		public void setParent(Node p){
			this.parent = p;
		}
		
		public boolean hasParent(){
			return parent() != null;
		}
		public boolean isRoot(){
			return parent == null;
		}
		
		public boolean hasChildren(){
			return(hasLeft() || hasRight());
		}
		
		public boolean isRight(){
			return hasParent() && this != parent.lChild();
		}
		
		public boolean isLeft(){
			return hasParent() && this != parent.rChild();
		}
		
		public boolean isInternal(){
			return(!isRoot() && hasChildren());
		}
		
		public boolean isLeaf(){
			return (!isRoot() & !hasChildren());
		}
		
		public void addLeft(int value){
			Node l = new Node(value, this, null, null);
			this.left = l;
		}
		
		public void addRight(int value){
			Node r = new Node(value, this, null, null);
			this.right = r;
		}
	}
}
