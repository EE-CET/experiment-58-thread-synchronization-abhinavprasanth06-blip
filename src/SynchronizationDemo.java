class Table {
    // synchronized method
    synchronized void printTable(int n) {
        for (int i = 1; i <= 5; i++) {
            System.out.print(n * i + " ");
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println(); // move to next line after table
    }
}

class MyThread1 extends Thread {
    Table t;

    MyThread1(Table t) {
        this.t = t;
    }

    public void run() {
        t.printTable(5);
    }
}

class MyThread2 extends Thread {
    Table t;

    MyThread2(Table t) {
        this.t = t;
    }

    public void run() {
        t.printTable(100);
    }
}

public class SynchronizationDemo {

    public static void main(String[] args) {
        // Create Table object
        Table obj = new Table();

        // Create threads
        MyThread1 t1 = new MyThread1(obj);
        MyThread2 t2 = new MyThread2(obj);

        // Start threads
        t1.start();
        t2.start();
    }
}
