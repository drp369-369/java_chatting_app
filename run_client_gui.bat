@echo off
echo Starting GUI Chat Client...
javac -d out src\com\chatting\Chat_Client\ChatClient.java src\com\chatting\Chat_GUI\ChatClientGUI.java
java -cp out com.chatting.Chat_GUI.ChatClientGUI
pause
