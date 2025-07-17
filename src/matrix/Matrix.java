package matrix;
import java.util.InputMismatchException;
import java.util.Scanner;

import exceptions.NotSquareMatrixException;

public class Matrix {
    public float[][] matrix;
    public int r, c;

    public void inputRowsAndColumn() throws InputMismatchException {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the number of rows and columns in the matrix: ");
        try {
            r = sc.nextInt();
            c = sc.nextInt();
        }catch (InputMismatchException e) {
            System.out.println("Please enter an integer:");
        }
    }

    public void inputMatrix() throws InputMismatchException{
        Scanner sc= new Scanner(System.in);
        try {
            matrix = new float[r][c];
            System.out.println("Enter the elements of the matrix: ");
            for ( int i=0; i<r; i++) {
                for (int j=0; j<c; j++) {
                    System.out.print("["+i+","+j+"]  -> ");
                    matrix[i][j] = sc.nextFloat();
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Please enter an integer:");
        }
    }

    public void inputSquareMatrix() throws NotSquareMatrixException{
        while (true){   
            Scanner sc= new Scanner(System.in);
            try {
                if(r == c) {
                    matrix = new float[r][c];
                    System.out.println("Enter the elements of the matrix: ");
                    for ( int i=0; i<r; i++) {
                        for (int j=0; j<c; j++) {
                            System.out.print("["+i+","+j+"]  -> ");
                            matrix[i][j] = sc.nextFloat();
                        }
                    }
                }
                else {
                    throw new NotSquareMatrixException();
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter an integer:");
            }catch (NotSquareMatrixException e) {
                e.getMessage();
            }
        }
    }

    public void display() {
        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}