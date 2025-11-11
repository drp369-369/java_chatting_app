# Java Chatting Application  
A simple multi-client chat application built using **Java Socket Programming**, **Multithreading**, and **Swing GUI**.  
Designed and developed collaboratively by a **4-member team** using GitHub branches and pull requests.

---

## 📌 Problem Statement
To design and implement a **real-time group chat system** where multiple clients can communicate simultaneously through a central chat server.

The system must:
- Allow multiple clients to connect at once  
- Broadcast messages from one client to all connected clients  
- Provide both **GUI** and **Console** clients  
- Use clean Java packaging and socket programming  
- Demonstrate team collaboration using GitHub  

---

## 📌 Project Overview
This project demonstrates:
- Client-server architecture  
- Java socket programming  
- Handling multiple clients using threads  
- Swing GUI for user interface  
- GitHub collaboration using branches & PRs  
- Clean, modular code design

The server broadcasts every received message to all connected clients.  
The GUI client displays messages in real time using Swing.

---

## 📁 Folder Structure

java_chatting_app/
│
├── src/
│   └── com/chatting/
│       ├── Chat_Server/      → Deep
│       │     └── ChatServer.java
│       │
│       ├── Chat_Client/      → Bhavana
│       │     └── ChatClient.java
│       │
│       └── Chat_GUI/         → Chandan
│             └── ChatClientGUI.java
│
├── README.md                 → Chinmayee
├── run_server.bat
└── run_client_gui.bat

---

## ⚙️ How the System Works

### ✅ Server
- Listens on port **5000**  
- Accepts clients using `ServerSocket`  
- Creates a new thread (ClientHandler) for each client  
- Stores all clients in `CopyOnWriteArrayList`  
- Broadcasts messages to all connected clients  

### ✅ Client (Console)
- Connects using `Socket`  
- Sends text messages  
- Runs listener thread to receive broadcasts  

### ✅ GUI Client
- Built using **Java Swing**  
- Text area for messages  
- Text field for sending  
- Uses Bhavana’s ChatClient internally  

---

## 🔧 Technologies Used
- Java  
- Socket Programming  
- Multithreading  
- Swing GUI  
- Git & GitHub  

---

## 🚀 How to Run the Project

### ✅ 1. Start the Server  
Using script:

run_server.bat

OR manually:

javac -d out src\com\chatting\Chat_Server\ChatServer.java
java -cp out com.chatting.Chat_Server.ChatServer

---

### ✅ 2. Start GUI Client  

Using script:

run_client_gui.bat

OR manually:

javac -d out src\com\chatting\Chat_Client\ChatClient.java src\com\chatting\Chat_GUI\ChatClientGUI.java
java -cp out com.chatting.Chat_GUI.ChatClientGUI

---

### ✅ 3. Start Console Client (optional)

java -cp out com.chatting.Chat_Client.ChatClient

---

## 🧠 Features
✅ Multi-client communication  
✅ Real-time message broadcasting  
✅ GUI + Console clients  
✅ Clean client-server architecture  
✅ Easy-to-run scripts  
✅ GitHub-based team collaboration  

---

## 👥 Member-Wise Contributions

### ✅ **1. Deep (Team Lead — Server Developer)**
- ChatServer & ClientHandler implementation  
- Multithreading & broadcasting logic  
- Project structure & GitHub handling  
- Reviewed & merged all PRs  

### ✅ **2. Bhavana (Client Logic Developer)**
- ChatClient.java  
- MessageListener pattern  
- Console communication  
- Core client-server communication layer  

### ✅ **3. Chandan & Chinmayee  (GUI Developer — Swing UI)**
- ChatClientGUI.java  
- GUI layout & components  
- Integrated ChatClient with GUI  
- Real-time UI updates  

### ✅ **4. Chandan & Chinmayee (Documentation + Scripts)
- README.md  
- Created run scripts (.bat files)  
- PPT preparation  
- Final project organization  

---

## 📝 Changes & Improvements Made
- Reorganized complete folder structure  
- Clean, modular server and client code  
- Added GUI using Swing  
- Implemented listener interface for smooth updates  
- Added documentation and run scripts  
- Used GitHub branches & PR workflow to track member-wise contributions  

---

## Requirements
- Java JDK 8 or above






