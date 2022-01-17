import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static int CLIENT_PORT = 6666;
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", CLIENT_PORT);

            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            Scanner scanner = new Scanner(System.in);

            String clientMessage;
            String serverMessage;
            System.out.println("Connected to Server!\nWrite 'end' to end chat with Server.");

            while(true) {
                clientMessage = scanner.nextLine();
                dataOutputStream.writeUTF(clientMessage);
                dataOutputStream.flush();

                if(clientMessage.equals("end"))
                    break;

                serverMessage = dataInputStream.readUTF();
                System.out.println("Server says: " + serverMessage);
            }

            scanner.close();
            dataOutputStream.close();
            socket.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
