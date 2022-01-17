import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static int SERVER_PORT = 6666;
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
            while (true) {
                Socket socket = serverSocket.accept();// establishes connection

                Scanner scanner = new Scanner(System.in);

                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

                String clientMessage;
                String serverMessage;
                System.out.println("Server Connected with Client!");

                while(true) {
                    clientMessage = dataInputStream.readUTF();
                    System.out.println("Client says: " + clientMessage);
                    if(clientMessage.equals("end")) {
                        System.out.println("Client disconnected. Waiting for new client...");
                        break;
                    }

                    serverMessage = scanner.nextLine();
                    dataOutputStream.writeUTF(serverMessage);
                    dataOutputStream.flush();

                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
