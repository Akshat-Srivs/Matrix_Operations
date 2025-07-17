package operation;

import matrix.Matrix;
import matrix.MatrixOperations;

public class Matrix_Mul extends Matrix implements MatrixOperations{

    //Function to multiply the 2 matrices
    public Matrix_Mul multiply (Matrix_Mul A, Matrix_Mul B) {
        Matrix_Mul C= new Matrix_Mul();
        C.r = A.r;
        C.c = B.c;
        C.matrix = new float[C.r][C.c];
        for (int i=0; i<C.r; i++) {
            for (int j=0; j<C.c; j++){
                for (int k=0; k<A.c; k++) {
                    C.matrix[i][j] += A.matrix[i][k] * B.matrix[k][j];
                }
            }
        }
        return C;
    }


    public void perform() {
        System.out.println("Matrix 1:");
        Matrix_Mul ob1 = new Matrix_Mul();
        ob1.inputRowsAndColumn();
        ob1.inputMatrix();
        System.out.println("Matrix 2:");
        Matrix_Mul ob2 = new Matrix_Mul();
        ob2.inputRowsAndColumn();
        ob2.inputMatrix();
        System.out.println("Matrix 1:");
        ob1.display();
        System.out.println("Matrix 2:");
        ob2.display();
        if ( ob1.c != ob2.r)
            System.out.println("Multiplication not possible");
        else {
            System.out.println("Product Matrix: ");
            Matrix_Mul ob3 = new Matrix_Mul();
            ob3=ob3.multiply(ob1 , ob2);
            ob3.display();
        }
    }
}