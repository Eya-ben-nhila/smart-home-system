@echo off
echo Compiling Java files...
mkdir target\classes 2>nul
dir /s /b src\main\java\*.java > sources.txt
javac -d target\classes -cp "target\dependency\*" @sources.txt
echo.
echo Starting Smart Home Backend...
java -cp "target\classes" com.smarthome.SmartHomeBackendApplication
