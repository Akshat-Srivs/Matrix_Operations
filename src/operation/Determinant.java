package operation;

import exceptions.NotSquareMatrixException;
import matrix.Matrix;
import matrix.MatrixOperations;

public class Determinant extends Matrix implements MatrixOperations{
    
    /*Function to calculate determinant using row reduction method and properties of determinants
    that is: 1. converting into an upper triangular matrix
    2. multiplying the principal diagonal elements.*/
    public float determinant (float[][] x ,int n) {
        float p=1;      //Stores the determinant value
        for ( int i=0; i<n-1; i++) {
            float y = x[i][i];

            // Swapping rows if first element is zero
            if (x[i][i] != 0) {
                System.out.println("Dividing the "+(i+1)+" row by "+y);
                for (int j = 0; j < n; j++)
                    x[i][j] /= y;

                // if a matrix is multiplied or divided by a scalar determinant is divided or multiplied with that scalar respectively
                p *= y;
            }
            else if ( x[i][i] == 0) {
                boolean h=false;
                for(int j=i+1; j<n; j++) {
                    if ( x[j][i] != 0) {
                        System.out.println("Swapping rows "+(i+1)+" & "+(j+1));
                        for (int k=0; k<n;k++) {
                            float temp = x[j][k];
                            x[j][k] = x[i][k];
                            x[i][k] = temp;
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
            for (int j=i+1; j<n; j++) {
                float z=x[j][i];
                System.out.println("R"+(j+1)+" ---> R"+(j+1)+" - R"+(i+1)+"*"+z);
                for(int k=0; k<n; k++) {
                    x[j][k] -=x[i][k]*z;
                }
            }
            display();
        }

        //Multiplying the diagonal elements
        for( int i=0; i<n; i++)
            p *= x[i][i];
        if ( p == -0.00) {
            p = 0.00f;
        }
        return p;
    }


    public void perform(){
        try {
            Determinant ob = new Determinant();
            ob.inputRowsAndColumn();
            ob.inputSquareMatrix();
            ob.display();
            System.out.printf("\nDeterminant of entered matrix: %.2f",ob.determinant(ob.matrix , ob.r));
        } catch (NotSquareMatrixException e) {
            // TODO Auto-generated catch block
            e.getMessage();
        }
    }
}
