@ECHO OFF
java -cp .\bin com.paragp.games.gamefish.GameMain 2>app.log

if ERRORLEVEL 255 GOTO RESTART
EXIT
:RESTART

Aquatica.bat