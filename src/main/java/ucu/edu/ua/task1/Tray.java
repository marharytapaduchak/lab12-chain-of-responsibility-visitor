package ucu.edu.ua.task1;

import lombok.Getter;
import lombok.Setter;

public abstract class Tray {
    private int denomination;

    @Setter@Getter
    private Tray next;

    public Tray(int denomination) {
        this.denomination = denomination;
    }

    public void process(int amount) {
        int count = amount / denomination;
        int remainder = amount % denomination;

        if (count > 0) {
            System.out.println("You received " + denomination + " x " + count);
        }

        if (remainder > 0) {
            if (next != null) {
                next.process(remainder);
            } else {
                throw new IllegalArgumentException("Impossible to provide such amount: " + remainder + " left");
            }
        }
    }
}
