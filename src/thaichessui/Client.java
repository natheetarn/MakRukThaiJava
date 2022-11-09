package thaichessui;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    private Socket socket = null;
    private ObjectInputStream in = null;
    private ObjectOutputStream out = null;
    private BoardPanelServer b = null;

    public Client(String address, int port, BoardPanelServer bp) {
        b = bp;

        try {
            socket = new Socket(address, port);
            System.out.println("Connected");

            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
        } catch (UnknownHostException u) {
            System.out.println(u);
        } catch (IOException i) {
            System.out.println(i);
        }

        try {
            whileChatting();
        } catch (IOException i) {
            System.out.println(i);
        }

        // String line = "";
        // while (!line.equals("Over")) {
        // try {
        // line = input.readLine();
        // out.writeUTF(line);
        // } catch (IOException i) {
        // System.out.println(i);
        // }
        // }

        try {
            in.close();
            out.close();
            socket.close();
        } catch (IOException i) {
            System.out.println(i);
        }
    }

    public BoardPanelServer getBoardPanel() {
        return b;
    }

    public void whileChatting() throws IOException {
        String message = "";
        do {
            try {
                message = (String) in.readObject();
                // chatArea.append("\n" + message);
            } catch (ClassNotFoundException classNotFoundException) {
            }
        } while (!message.equals("Client - END"));
    }
}
