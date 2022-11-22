import java.net.*;
import java.io.*;

public class client {
    public static void main(String[] args)  throws IOException {
        Socket s = new Socket("localhost",6969);

        PrintWriter pr = new PrintWriter(s.getOutputStream());
        pr.println("hello");
        pr.flush();

        InputStreamReader in = new InputStreamReader(s.getInputStream());
        BufferedReader bf = new BufferedReader(in);

        String str = bf.readLine();
        System.out.println("server: " + str);
        //comment
        s.close();

    }
}
