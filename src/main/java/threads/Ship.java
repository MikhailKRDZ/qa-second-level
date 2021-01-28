package threads;


public class Ship extends Thread {
    private final Port port;
    private final OperationsWithShip operations;
    int containers;

    Ship(Port port) {
        this.containers = 10 + (int) (Math.random() * 50);
        this.operations = OperationsWithShip.values()[(int) (Math.random() * 3)];
        this.port = port;
    }

    @Override
    public void run() {
            try {
                    if (OperationsWithShip.LOAD.equals(this.operations)) {
                        port.take(this);
                        sleep(this.containers);
                    } else if (OperationsWithShip.UNLOAD.equals(this.operations)) {
                        port.put(this);
                        sleep(this.containers);
                    } else if (OperationsWithShip.LOAD_UNLOAD.equals(this.operations)) {
                        port.put(this);
                        sleep(this.containers);
                        port.take(this);
                        sleep(this.containers);
                    } else {
                        throw new IllegalStateException("Unexpected value: " + operations);
                    }
            } catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
    }
}



