import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MyThread extends Thread {
    Socket soc;

    MyThread(Socket soc) {
        this.soc = soc;
    }

    @Override
    public void run() {
        try {
            super.run();

            // flux d entre w sorti
            BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            PrintWriter out = new PrintWriter(soc.getOutputStream(), true);

            // Receive a message from the client
            String message = in.readLine();
            String message2 = in.readLine();
            String response;
            if (message.contains(message2)) {

                response = message + " contains " + message2;
            } else {
                response = message + " does not  contains " + message2;
            }

            // Send a response to the client

            out.println(response);

            // Close the socket
            Server.count--;
            System.out.println("Clients Connected : " + Server.count);
            soc.close();
        } catch (Exception e) {
            Server.count--;
            System.out.print(e.getMessage());
        }
    }
}
