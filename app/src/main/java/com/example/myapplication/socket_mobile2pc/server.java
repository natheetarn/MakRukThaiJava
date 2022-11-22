import java.net.*;
import java.io.*;

public class server {
    public static void main(String[] args)  throws IOException {
        try (ServerSocket ss = new ServerSocket(6969)) {
            Socket s = ss.accept();

            System.out.println("client connected");

            InputStreamReader in = new InputStreamReader(s.getInputStream());
            BufferedReader bf = new BufferedReader(in);

            String str = bf.readLine();
            System.out.println("server: " + str);

            PrintWriter pr = new PrintWriter(s.getOutputStream());
            pr.println("yes");

            pr.flush();
            //closing sockets
            s.close();
            ss.close();
        }

    }
}
