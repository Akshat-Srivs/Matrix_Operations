# Matrix Operations in Java

This project implements a modular Java program to perform various matrix operations such as:

- Addition and Subtraction
- Multiplication
- Transpose
- Rank Calculation
- Determinant
- Inverse

It follows an object-oriented approach and clean package structure for better maintainability.

---

## 🗂 Project Structure

```
Matrix/
├── src/
│   ├── driver/                  # Contains the main class to drive the program
│   │   └── MatrixDriver.java
│   ├── matrix/                  # Contains Matrix class and MatrixOperations interface
│   │   ├── Matrix.java
│   │   └── MatrixOperations.java
│   ├── operation/               # Contains operation-specific implementations
│   │   ├── Add_Sub.java
│   │   ├── Matrix_Mul.java
│   │   ├── Transpose.java
│   │   ├── Rank.java
│   │   ├── Determinant.java
│   │   └── Inverse.java
│   └── exceptions/              # Contains custom exceptions
│       └── NotSquareMatrixException.java
├── out/                         # Compiled .class files (created after build)
└── runMatrixProject.bat         # Script to compile and run the project
```

---

## 🧠 How It Works

- All operations implement the `MatrixOperations` interface.
- The `Matrix` class handles input, validation, and common matrix utilities.
- Each operation class (like `Add_Sub`, `Inverse`, etc.) contains logic specific to that operation.
- `MatrixDriver` is the main class that takes user input and dispatches the selected operation.

---

## 🛠 How to Compile and Run

### 1. Using `.bat` script (Recommended for Windows)

Simply run:

```bash
runMatrixProject.bat
```

This script:
- Compiles all Java files from `src/`
- Stores compiled `.class` files in `out/`
- Runs the `MatrixDriver` class from `out/`

### 2. Manual Compilation (Optional)

```bash
cd src
javac -d ../out matrix/**/*.java operation/*.java exceptions/*.java driver/*.java
java -cp ../out driver.MatrixDriver
```

---

## 📋 Features

- Clean, modular codebase
- Follows best OOP practices
- Handles square matrix validation via custom exception
- Uses Java 17+ features (like enhanced `switch`)

---

## 🧪 Requirements

- Java JDK 17 or above
- Any terminal or IDE (VS Code, IntelliJ, etc.)

---

## 🧱 Future Enhancements

- Support for file input/output
- GUI using JavaFX or Swing
- More matrix operations (e.g., eigenvalues, LU decomposition)

---

## 🧑‍💻 Author

**Akshat Srivastava**  
Feel free to contribute or fork the project!

