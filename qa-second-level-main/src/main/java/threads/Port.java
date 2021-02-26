package threads;

import java.util.concurrent.LinkedBlockingQueue;

class Port extends Thread {
    private int currentNumberOfContainers;
    private final int pearsNumber;
    private final int containersCapacity;
    private LinkedBlockingQueue<Pear> pears;

    Port(int pearsNumber) {
        this.pearsNumber = pearsNumber;
        this.currentNumberOfContainers = 0;
        this.containersCapacity = 500;
        setPears(pearsNumber);
    }

    private void setPears(int pearsNumber) {
        this.pears = new LinkedBlockingQueue<>(pearsNumber);
        for (int i = 0; i < pearsNumber; i++) {
            this.pears.add(new Pear(i));
        }
    }

    public synchronized void put(Ship ship) {
        while (this.currentNumberOfContainers + ship.containers > containersCapacity) {
            System.out.println("Извините порт перегружен, " + Thread.currentThread().getName() +
                    " ожидает очереди когда произведётся отгрузка из корабля");
            try {
                wait();
            } catch (InterruptedException e1) {
                System.out.println("итеррапт перехвачен");
            }
        }
        this.currentNumberOfContainers = this.currentNumberOfContainers + ship.containers;

        System.out.println("Причал " + Thread.currentThread().getName().substring(6) + " Доставил " + ship.containers +
                " контейнер(а) в порт, текущее количество контейнеров в порту:  "
                + this.currentNumberOfContainers);
        notifyAll();
    }

    public synchronized void take(Ship ship) {
        while (this.currentNumberOfContainers - ship.containers < 0) {
            System.out.println("Извините, в порту груз отсутствует, " + Thread.currentThread().getName() +
                    " ожидает очереди когда груз поступит в порт");
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("итеррапт перехвачен");
            }
        }
        this.currentNumberOfContainers = this.currentNumberOfContainers - ship.containers;

        System.out.println("Причал " + Thread.currentThread().getName().substring(6) + " Произвёл отгрузку " + ship.containers +
                " контейнеров из порта, текущее количество контейнеров в порту:  "
                + this.currentNumberOfContainers);
        notifyAll();
    }
}