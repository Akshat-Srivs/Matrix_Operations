package operation;

import matrix.Matrix;
import matrix.MatrixOperations;

public class Add_Sub extends Matrix implements MatrixOperations{
    
    //Function to Add the two entered Matrices
    public Add_Sub add(Add_Sub A , Add_Sub B) {
        Add_Sub C = new Add_Sub();
        C.r=A.r;
        C.c=A.c;
        C.matrix=new float[C.r][C.c];
        for (int i=0; i<C.r; i++) {
            for (int j=0; j<C.c; j++) {
                C.matrix[i][j] = A.matrix[i][j] + B.matrix[i][j] ;
            }
        }
        return C;
    }

    //Function to Subtract the two entered Matrices
    public Add_Sub subtract(Add_Sub A , Add_Sub B) {
        Add_Sub C = new Add_Sub();
        C.r=A.r;
        C.c=A.c;
        C.matrix=new float[C.r][C.c];
        for (int i=0; i<C.r; i++) {
            for (int j=0; j<C.c; j++) {
                C.matrix[i][j] = A.matrix[i][j] - B.matrix[i][j] ;
            }
        }
        return C;
    }
    
    public void perform() {
        System.out.println("Matrix 1:");
        Add_Sub ob1 = new Add_Sub();
        ob1.inputRowsAndColumn();
        ob1.inputMatrix();
        System.out.println("Matrix 2:");
        Add_Sub ob2 = new Add_Sub();
        ob2.r = ob1.r;
        ob2.c = ob1.c;
        ob2.inputMatrix();
        System.out.println("Matrix 1:");
        ob1.display();
        System.out.println("Matrix 2:");
        ob2.display();
        System.out.println("Sum Matrix: ");
        Add_Sub ob3 = new Add_Sub();
        ob3=ob3.add(ob1 , ob2);
        ob3.display();
        System.out.println("Difference Matrix: ");
        Add_Sub ob4 = new Add_Sub();
        ob4=ob4.subtract(ob1 , ob2);
        ob4.display();
    }
}
