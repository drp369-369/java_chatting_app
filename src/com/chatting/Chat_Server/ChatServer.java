package com.chatting.Chat_Server;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ChatServer {

    private static final List<ClientHandler> clients =
            new CopyOnWriteArrayList<>();

    public static void main(String[] args) {
        int port = 5000;
        System.out.println("ChatServer running on port " + port + "...");

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Waiting for clients...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket);

                ClientHandler handler = new ClientHandler(socket);
                clients.add(handler);
                new Thread(handler).start();
            }
        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }

    static void broadcast(String msg) {
        for (ClientHandler c : clients) {
            c.send(msg);
        }
    }

    static void remove(ClientHandler c) {
        clients.remove(c);
    }
}

class ClientHandler implements Runnable {

    private final Socket socket;
    private PrintWriter out;

    ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try (
            Socket s = socket;
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter pw = new PrintWriter(s.getOutputStream(), true)
        ) {
            out = pw;

            String msg;
            while ((msg = in.readLine()) != null) {
                ChatServer.broadcast(msg);
            }

        } catch (IOException e) {
            System.out.println("Client disconnected.");
        } finally {
            ChatServer.remove(this);
        }
    }

    void send(String message) {
        if (out != null) out.println(message);
    }
}
