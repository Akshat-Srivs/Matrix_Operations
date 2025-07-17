package operation;

import exceptions.NotSquareMatrixException;
import matrix.Matrix;
import matrix.MatrixOperations;

public class Inverse extends Matrix implements MatrixOperations{

    public Inverse inverse(Inverse A) {
        Inverse invertedMat = new Inverse();
        invertedMat.r = A.r;
        invertedMat.c = A.c;
        invertedMat.matrix = new float[invertedMat.r][invertedMat.r];
        for(int i = 0; i < invertedMat.r; i++) {
            invertedMat.matrix[i][i] = 1.00f;
        }

            float p=1;      //Stores the determinant value
        for ( int i=0; i<A.r; i++) {
            float y = A.matrix[i][i];

            // Swapping rows if first element is zero
            if (A.matrix[i][i] != 0) {
                System.out.println("Dividing the "+(i+1)+" row by "+y);
                for (int j = 0; j < A.r; j++) {
                    A.matrix[i][j] /= y;
                    invertedMat.matrix[i][j] /= y;
                }
                // if a matrix is multiplied or divided by a scalar determinant is divided or multiplied with that scalar respectively
                p *= y;
            }
            else if ( A.matrix[i][i] == 0) {
                boolean h=false;
                for(int j=i+1; j<A.r; j++) {
                    if ( A.matrix[j][i] != 0) {
                        System.out.println("Swapping rows "+(i+1)+" & "+(j+1));
                        for (int k=0; k<A.r;k++) {
                            float temp = A.matrix[j][k];
                            A.matrix[j][k] = A.matrix[i][k];
                            A.matrix[i][k] = temp;
                            temp = invertedMat.matrix[j][k];
                            invertedMat.matrix[j][k] = invertedMat.matrix[i][k];
                            invertedMat.matrix[i][k] = temp;
                        }
                        h=true;
                        p *= -1; //if row or column is swapped the sign of determinant is reversed
                        break;
                    }
                }
                //if an entire column is zero determinant becomes zero
                if (!h)
                    p=0;
            }

            //Reducing Rows to create upper triangular matrix
            for (int j=i+1; j<A.r; j++) {
                float z=A.matrix[j][i];
                System.out.println("R"+(j+1)+" ---> R"+(j+1)+" - R"+(i+1)+"*"+z);
                for(int k=0; k<A.r; k++) {
                    A.matrix[j][k] -= A.matrix[i][k] * z;
                    invertedMat.matrix[j][k] -= invertedMat.matrix[i][k] * z;
                }
            }
            System.out.println("Changes in the initial matrix: ");
            A.display();
            System.out.println();
            System.out.println("Changes in the result matrix: ");
            invertedMat.display();
        }

        if ( Math.abs(p) == 0.00) {
            System.out.println("Inverse not possible");
            System.exit(0);
        }

        for(int i = invertedMat.r - 1; i >= 0; i--) {
            for(int j = i - 1; j >= 0; j--) {
                float z = A.matrix[j][i];
                System.out.println("R"+(j+1)+" ---> R"+(j+1)+" - R"+(i+1)+"*"+z);
                for(int k = 0; k < A.r; k++) {
                    A.matrix[j][k] -= z * A.matrix[i][k];
                    invertedMat.matrix[j][k] -= z * invertedMat.matrix[i][k];
                }
            }
            System.out.println("Changes in the initial matrix: ");
            A.display();
            System.out.println();
            System.out.println("Changes in the result matrix: ");
            invertedMat.display();
        }

        return invertedMat;
    }

    public void perform(){
        try {
            Inverse ob = new Inverse();
            ob.inputRowsAndColumn();
            ob.inputSquareMatrix();
            System.out.println("Given Matrix: ");
            ob.display();
            System.out.println();
            Inverse ob1 = new Inverse();
            ob1 = ob1.inverse(ob);
            System.out.println("\nInverse of the Given Matrix: ");
            ob1.display();
        } catch (NotSquareMatrixException e) {
            e.getMessage();
        }
        
    }
}