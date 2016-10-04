package task1.webAccess;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by User on 28.09.2016.
 */
public class Client {
    public static void main(String[] ar) {
        int serverPort = 6666;
        String address = "127.0.0.1";

        try {
            InetAddress ipAddress = InetAddress.getByName(address);
            Socket socket = new Socket(ipAddress, serverPort);

            System.out.println("Yes! I just got hold of the program.");
            OutputStream sOut = socket.getOutputStream();

            ObjectOutputStream objOut = new ObjectOutputStream(sOut);

                ClientData obj = new ClientData(1234,2,3);
                objOut.writeObject(obj);
                objOut.flush();
                objOut.close();
            sOut.close();
        } catch (Exception x) {
            x.printStackTrace();
        }
    }
}
