package datastructures;

public class BinaryTreeTest {
	public static void main(String args[]){
		BinaryTree bt = new BinaryTree();
		
		bt.insert(10);
		bt.insert(15);
		bt.insert(20);
		bt.insert(5);
		bt.insert(7);
		bt.insert(4);
		bt.insert(13);
		bt.insert(8);
		bt.breadthPrint();
		
		bt.insert(6);
		bt.breadthPrint();
		
		bt.delete(13);
		bt.breadthPrint();
		
		bt.delete(14);
		bt.delete(15);
		bt.breadthPrint();
		
		bt.insert(11);
		bt.insert(18);
		bt.insert(12);
		bt.insert(19);
		bt.breadthPrint();
		
		bt.delete(11);
		bt.breadthPrint();
		
		bt.delete(18);
		bt.breadthPrint();
		
		bt.delete(4);
		bt.delete(5);
		bt.delete(19);
		bt.delete(8);
		bt.breadthPrint();
		
		bt.delete(7);
		bt.delete(6);
		bt.delete(20);
		bt.delete(10);
		bt.breadthPrint();
		
		bt.insert(10);
		bt.breadthPrint();
	}
}
