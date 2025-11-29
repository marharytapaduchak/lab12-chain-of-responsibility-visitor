package ucu.edu.ua.task1;

public class ATM {
    private final Tray firstTray;

    public ATM() {
        firstTray = new Tray20();
        Tray tray10 = new Tray10();
        Tray tray1 = new Tray1();

        firstTray.setNext(tray10);
        tray10.setNext(tray1);
    }

    public void process(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        firstTray.process(amount);
    }
}
