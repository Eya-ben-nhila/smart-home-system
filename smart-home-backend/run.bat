@echo off
echo Starting Smart Home Backend...
echo Java version:
java -version
echo.
echo Compiling and running Spring Boot application...
java -cp "target\classes;target\dependency\*" com.smarthome.SmartHomeBackendApplication
