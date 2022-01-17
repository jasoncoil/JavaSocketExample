import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class JUnitTestSuite {
    @Test
    public void serverPortTest() {
        Server server = new Server();
        Assertions.assertEquals(6666, server.SERVER_PORT);
    }

    @Test
    public void samePortTest() {
        Server server = new Server();
        Client client = new Client();
        Assertions.assertEquals(server.SERVER_PORT, client.CLIENT_PORT);

    }
}
