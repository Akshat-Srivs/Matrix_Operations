package driver;
import java.util.Scanner;
import matrix.MatrixOperations;
import operation.*;

public class MatrixDriver {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MatrixOperations operation = null;
        int choice;

        do {
            System.out.println("\n--- MATRIX OPERATIONS MENU ---");
            System.out.println("1. Addition & Subtraction");
            System.out.println("2. Multiplication");
            System.out.println("3. Transpose");
            System.out.println("4. Determinant");
            System.out.println("5. Inverse");
            System.out.println("6. Rank");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.print("Please enter a valid number: ");
                sc.next(); // discard invalid input
            }

            choice = sc.nextInt();

            switch (choice) {
                case 1 -> operation = new Add_Sub();
                case 2 -> operation = new Matrix_Mul();
                case 3 -> operation = new Transpose();
                case 4 -> operation = new Determinant();
                case 5 -> operation = new Inverse();
                case 6 -> operation = new Rank();
                case 0 -> {
                    System.out.println("Exiting program.");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Try again.");
            }

            if (operation != null) {
                System.out.println("\n>>> Performing selected operation...");
                operation.perform();
                operation = null; // reset for next round
            }

        } while (true);
    }
}
