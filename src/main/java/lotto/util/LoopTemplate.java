package lotto.util;

public abstract class LoopTemplate<T> {

    public T execute() {
        while (true) {
            try {
                return doLoop();
            } catch (IllegalArgumentException e) {
                Printer.print(e);
            }
        }
    }
    protected abstract T doLoop() throws IllegalArgumentException;
}
