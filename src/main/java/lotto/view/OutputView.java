package lotto.view;

public class OutputView {
    public void println(String message) {
        System.out.println(message);
    }

    public void println() {
        System.out.println();
    }

    public void printf(String format, Object... args) {
        System.out.printf(format, args);
    }
}
