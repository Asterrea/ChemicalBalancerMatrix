package model;

public class Matrix {
	private int ROWS;             
    private int COLS;            
    private double[][] DATA;   

    // create by ROWS COLS (Empty Matrix)
    public Matrix(int ROWS, int COLS) {
        this.ROWS = ROWS;
        this.COLS = COLS;
        DATA = new double[ROWS][COLS];
    }

    // create matrix by 2D ARRAY (Data Matrix)
    public Matrix(double[][] DATA) {
        ROWS = DATA.length;
        COLS = DATA[0].length;
        this.DATA = new double[ROWS][COLS];
        
        for (int i = 0; i < ROWS; i++)
            for (int j = 0; j < COLS; j++)
                    this.DATA[i][j] = DATA[i][j];
    }
    
    //Create Identity
    public static Matrix identity(int COLS) {
        Matrix I = new Matrix(COLS, COLS);
        for (int i = 0; i < COLS; i++)
            I.DATA[i][i] = 1;
        return I;
    }

    // Swap rows i and j for calling Matrix
    private void swap(int ROWS, int COLS) {
        double[] temp = DATA[ROWS];
        DATA[ROWS] = DATA[COLS];
        DATA[COLS] = temp;
    }
    
    //Multiplies a specified row by a specified factor
    private void multiplyRow(int ROWS, double factor) {
    	for(int i = 0; i < COLS; i++) {
    		DATA[ROWS][i] *= factor;
    	}
    }
    
    //Adds a source row multiplied by a factor to the destination row
    private void addRow(int source, int destination, double factor) {
    	for(int i = 0; i < COLS; i++) {
    		DATA[destination][i] += DATA[source][i] * factor;
    	}
    }

    // Transpose calling Matrix
    public Matrix transpose() {
        Matrix A = new Matrix(COLS, ROWS);
        for (int i = 0; i < ROWS; i++)
            for (int j = 0; j < COLS; j++)
                A.DATA[j][i] = this.DATA[i][j];
        return A;
    }

    // return C = A + B
    public Matrix addition(Matrix B) {
        Matrix A = this;
        if (B.ROWS != A.ROWS || B.COLS != A.COLS) throw new RuntimeException("Illegal matrix dimensions.");
        Matrix C = new Matrix(ROWS, COLS);
        for (int i = 0; i < ROWS; i++)
            for (int j = 0; j < COLS; j++)
                C.DATA[i][j] = A.DATA[i][j] + B.DATA[i][j];
        return C;
    }


    // Subtract Matrices
    public Matrix subtract(Matrix B) {
        Matrix A = this;
        if (B.ROWS != A.ROWS || B.COLS != A.COLS) throw new RuntimeException("Illegal matrix dimensions.");
        Matrix C = new Matrix(ROWS, COLS);
        for (int i = 0; i < ROWS; i++)
            for (int j = 0; j < COLS; j++)
                C.DATA[i][j] = A.DATA[i][j] - B.DATA[i][j];
        return C;
    }

    // Check if Matrix is Equal
    public boolean eq(Matrix B) {
        Matrix A = this;
        if (B.ROWS != A.ROWS || B.COLS != A.COLS) throw new RuntimeException("Matrix Dimensions is UnOperatable.");
        for (int i = 0; i < ROWS; i++)
            for (int j = 0; j < COLS; j++)
                if (A.DATA[i][j] != B.DATA[i][j]) return false;
        return true;
    }

    //Multiply Matrices
    public Matrix multiply(Matrix B) {
        Matrix A = this;
        if (A.COLS != B.ROWS) throw new RuntimeException("Matrix Dimensions is UnOperatable.");
        Matrix C = new Matrix(A.ROWS, B.COLS);
        for (int i = 0; i < C.ROWS; i++)
            for (int j = 0; j < C.COLS; j++)
                for (int k = 0; k < A.COLS; k++)
                    C.DATA[i][j] += (A.DATA[i][k] * B.DATA[k][j]);
        return C;
    }

	// print matrix
    public double[][] printMatrix() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) 
                System.out.printf("%9.2f ", DATA[i][j]);
            System.out.println();
        }
		return DATA;
    }
    
    //reduce matrix via Gauss-Jordan Reduction
    public void reduceMatrix() {
    	int numPivots = 0;
    	for(int j = 0; j < COLS; j++) {
    		int pivotRow = numPivots;
    		while(pivotRow < ROWS && DATA[pivotRow][j] == 0.0) 
    			pivotRow++;
    		if(pivotRow == ROWS)
    			continue;
    		swap(numPivots,pivotRow);
    		pivotRow = numPivots;
    		numPivots++;
    		multiplyRow(pivotRow, 1.0/DATA[pivotRow][j]);
    		for(int i = pivotRow + 1; i < ROWS; i++) 
    			addRow(pivotRow,i,-DATA[i][j]);
    	}
    	
    	for(int i = ROWS - 1; i >= 0; i--) {
    		int pivotCol = 0;
    		while(pivotCol < COLS && DATA[i][pivotCol] == 0) 
    			pivotCol++;
    		if(pivotCol == COLS)
    			continue;
    		for(int j = i - 1; j >= 0; j--) 
    			addRow(i,j,-DATA[j][pivotCol]);
    	}
    }
    
    private void pivot(int row, int col) {
    	for(int i = 0; i < COLS; i++) {
    		double a = DATA[i][col]/DATA[row][col];
    	}
    }
    
    public double[][] getDATA() {
		return DATA;
	}

	public void setDATA(double[][] dATA) {
		DATA = dATA;
	}
}
