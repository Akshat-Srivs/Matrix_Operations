@echo off
echo ================================
echo 🚀 Compiling Matrix Project...
echo ================================

REM Create the output directory if it doesn't exist
if not exist out (
    mkdir out
)

REM Compile all Java files starting from the main driver class
javac -d out -sourcepath src src\driver\MatrixDriver.java

IF %ERRORLEVEL% NEQ 0 (
    echo.
    echo ❌ Compilation failed. Check for errors above.
    pause
    exit /b
)

echo.
echo ✅ Compilation successful.
echo ================================
echo ▶ Running Matrix Project...
echo ================================

REM Run the main class from the compiled output
java -cp out driver.MatrixDriver

echo.
pause
