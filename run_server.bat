@echo off
echo Starting Chat Server...
javac -d out src\com\chatting\Chat_Server\ChatServer.java
java -cp out com.chatting.Chat_Server.ChatServer
pause
