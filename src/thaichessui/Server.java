package thaichessui;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    private Socket socket = null;
    private ServerSocket server = null;
    private ObjectInputStream in = null;
    private ObjectOutputStream out = null;
    private BoardPanelServer b = null;
    private ArrayList<String> msg = new ArrayList<String>();

    public Server(int port, BoardPanelServer bp) {
        b = bp;

        try {
            server = new ServerSocket(port);
            System.out.println("server started");

            System.out.println("Waiting for a client ...");
            msg.add("Waiting for a client");
            b.printCustom(msg.get(0));

            socket = server.accept();
            System.out.println("Client accepted");
            msg.add("Client Accepted");
            b.printCustom(msg.get(1));

            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());

            try {
                whileChatting();
            } catch (IOException i) {
                System.out.println(i);
            }

            // String line = "";

            // while (!line.equals("Over")) {
            // try {
            // line = in.readUTF();
            // System.out.println(line);
            // } catch (IOException i) {
            // System.out.println(i);
            // }
            // }

            System.out.println("closing connection");

            socket.close();
            in.close();
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

    public ArrayList<String> getMsg() {
        return msg;
    }
}
