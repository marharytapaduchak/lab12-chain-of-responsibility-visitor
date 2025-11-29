package ucu.edu.ua.task1;

public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM();

        atm.process(50);  // 20 x 2, 10 x 1
        atm.process(23);  // 20 x 1, 1 x 3
        atm.process(5);   // 1 x 5
    }
}
