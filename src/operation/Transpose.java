package operation;

import matrix.Matrix;
import matrix.MatrixOperations;

public class Transpose extends Matrix implements MatrixOperations{

    public Transpose transpose(Transpose A) {
        Transpose B = new Transpose();
        B.r = A.c;
        B.c = A.r;
        B.matrix = new float[B.r][B.c];
        for(int i = 0; i < A.r; i++) {
            for(int j = 0; j < A.c; j++) {
                B.matrix[j][i] = A.matrix[i][j];
            }
        }
        return B;
    }


    public void perform() {
        System.out.println("Matrix 1:");
        Transpose ob1 = new Transpose();
        ob1.inputRowsAndColumn();
        ob1.inputMatrix();
        System.out.println("Original Matrix :");
        ob1.display();
        System.out.println("Transpose Matrix: ");
        Transpose ob3 = new Transpose();
        ob3=ob3.transpose(ob1 );
        ob3.display();
    }
}