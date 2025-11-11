package com.chatting.Chat_GUI;

import com.chatting.Chat_Client.ChatClient;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ChatClientGUI extends JFrame {

    private JTextArea messageArea;
    private JTextField inputField;
    private ChatClient client;
    private String username;

    public ChatClientGUI() {
        setTitle("Chat Client (GUI)");
        setSize(450, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        username = JOptionPane.showInputDialog(this, "Enter your name:");
        if (username == null || username.isBlank()) {
            username = "User";
        }

        messageArea = new JTextArea();
        messageArea.setEditable(false);
        add(new JScrollPane(messageArea), BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        inputField = new JTextField();
        JButton sendButton = new JButton("Send");

        bottomPanel.add(inputField, BorderLayout.CENTER);
        bottomPanel.add(sendButton, BorderLayout.EAST);
        add(bottomPanel, BorderLayout.SOUTH);

        try {
            client = new ChatClient("127.0.0.1", 5000);
            client.start(msg -> SwingUtilities.invokeLater(() -> {
                messageArea.append(msg + "\n");
                messageArea.setCaretPosition(messageArea.getDocument().getLength());
            }));
            client.send(username + " joined the chat.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Unable to connect to server", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }

        sendButton.addActionListener(e -> sendMessage());
        inputField.addActionListener(e -> sendMessage());
    }

    private void sendMessage() {
        String text = inputField.getText().trim();
        if (!text.isEmpty()) {
            client.send(username + ": " + text);
            inputField.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ChatClientGUI().setVisible(true));
    }
}
