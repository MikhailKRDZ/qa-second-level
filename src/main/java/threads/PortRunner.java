package threads;

public class PortRunner {
    public static void main(String[] args) {

       Port port = new Port(5);

        for (int j = 0; j < 5; j++) {
            new Ship(port).start();
        }
    }
}