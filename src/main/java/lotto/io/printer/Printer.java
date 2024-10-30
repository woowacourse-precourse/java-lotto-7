package lotto.io.printer;

public final class Printer {

    private Printer() {
    }

    public static void printEmptyLine() {
        System.out.println();
    }

    public static void printLine(String text) {
        System.out.println(text);
    }

}
