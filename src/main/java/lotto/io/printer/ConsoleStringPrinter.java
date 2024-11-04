package lotto.io.printer;

public class ConsoleStringPrinter implements StringPrinter {

    @Override
    public void printString(String string) {
        System.out.println(string);
    }
}
