package operation;

import matrix.Matrix;
import matrix.MatrixOperations;

public class Rank extends Matrix implements MatrixOperations{

    public int rank(float[][] x, int r, int c) {
        int rank = 0;
        for ( int i=0; i<r-1; i++) {
            float y = x[i][i];

            // Swapping rows if first element is zero
            if (x[i][i] != 0) {
                System.out.println("Dividing the "+(i+1)+" row by "+y);
                for (int j = 0; j < r; j++)
                    x[i][j] /= y;
            }
            else if ( x[i][i] == 0) {
                for(int j=i+1; j<r; j++) {
                    if ( x[j][i] != 0) {
                        System.out.println("Swapping rows "+(i+1)+" & "+(j+1));
                        for (int k=0; k<c;k++) {
                            float temp = x[j][k];
                            x[j][k] = x[i][k];
                            x[i][k] = temp;
                        }
                        break;
                    }
                }
            }

            //Reducing Rows to create upper triangular matrix
            for (int j=i+1; j<r; j++) {
                float z=x[j][i];
                System.out.println("R"+(j+1)+" ---> R"+(j+1)+" - R"+(i+1)+"*"+z);
                for(int k=0; k<c; k++) {
                    x[j][k] -=x[i][k]*z;
                }
            }
            display();
        }
        for (float[] row : x) {
            boolean hasNonZero = false;
            for (float element : row) {
                if (element != 0) {
                    hasNonZero = true;
                    break;
                }
            }
            if (hasNonZero) {
                rank++;
            }
        }
        return rank;
    }

    public void perform() {
        Rank ob = new Rank();
        ob.inputRowsAndColumn();
        ob.inputMatrix();
        ob.display();
        System.out.print("\nRank of entered matrix: "+ob.rank(ob.matrix , ob.r, ob.c));
    }
}