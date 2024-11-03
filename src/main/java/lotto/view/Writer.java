package lotto.view;

public class Writer {

    private Writer() {}

    public static Writer initiate() {
        return new Writer();
    }

    public void printSout(final String message) {
        System.out.println(message);
    }

    public void printErrorMessage(final String message) {
        System.out.println(message);
    }

    public void printLineBefore(final String message) {
        System.out.println();
        printSout(message);
    }
}
