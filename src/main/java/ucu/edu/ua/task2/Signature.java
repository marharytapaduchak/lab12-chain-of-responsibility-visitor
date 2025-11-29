package ucu.edu.ua.task2;

import java.util.function.Consumer;

import ucu.edu.ua.task2.visitor.Visitor;

public class Signature<T> extends Task<T> {
    public Consumer<T> consumer;
    public Signature(Consumer<T> consumer) {
        this.consumer = consumer;
    }

    @Override
    public void apply(T arg) {
        this.freeze();
        consumer.accept(arg);
    }

    @Override
    public void stamp(Visitor<T> visitor) {
        visitor.onTask(this);
    }

}
