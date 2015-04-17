package datastructures;

public class Matrix {
	private int width;
	private int height;
	private int[][] matrix;
	
	public Matrix(int n, int m){
		width  = n;
		height = m;
		matrix = new int[width][height];
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	public void insert(int n, int m, int val){
		matrix[n][m] = val;
	}
	
	public void print(){
		for(int i=0; i < height; i++){
			for(int j = 0; j < width; j++){
				System.out.print(matrix[j][i] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}

	public void printDiagonal(int x, int y){
		int j = x; 
		int k = y;
		
		while(j < width && k < height){
			System.out.println(matrix[j][k]);
			j++; k++;
		}		
	}
	
	public static void main(String[] args) {
		Matrix m = new Matrix(4,4);
		for(int i=0; i<m.height; i++){
			for(int j = 0; j < m.width; j++){
				m.insert(j, i, 10*i + j+1);
			}
		}
		m.print();
		for(int i = 0; i < m.width; i++){
			if(i == 0){
				m.printDiagonal(0,0);
			}else{
				m.printDiagonal(i,0);
				m.printDiagonal(0,i);
			}
		}
	}

}
