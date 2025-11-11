package com.chatting.Chat_Client;

import java.io.*;
import java.net.*;

public class ChatClient {

    private final Socket socket;
    private final BufferedReader in;
    private final PrintWriter out;

    public ChatClient(String host, int port) throws IOException {
        socket = new Socket(host, port);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
    }

    public void start(MessageListener listener) {
        Thread thread = new Thread(() -> {
            try {
                String msg;
                while ((msg = in.readLine()) != null) {
                    listener.onMessage(msg);
                }
            } catch (IOException ignored) {
            } finally {
                close();
            }
        });

        thread.setDaemon(true);
        thread.start();
    }

    public void send(String msg) {
        out.println(msg);
    }

    public void close() {
        try { in.close(); } catch (Exception ignored) {}
        out.close();
        try { socket.close(); } catch (Exception ignored) {}
    }

    public interface MessageListener {
        void onMessage(String msg);
    }

    public static void main(String[] args) throws Exception {
        ChatClient client = new ChatClient("127.0.0.1", 5000);
        client.start(System.out::println);

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter your name: ");
        String name = console.readLine();

        client.send(name + " joined the chat");

        String line;
        while ((line = console.readLine()) != null) {
            if (line.equalsIgnoreCase("quit")) break;
            client.send(name + ": " + line);
        }

        client.send(name + " left the chat");
        client.close();
    }
}
