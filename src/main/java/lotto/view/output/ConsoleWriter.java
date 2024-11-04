package lotto.view.output;

public class ConsoleWriter implements Writer {

    @Override
    public void writerLine(String message) {
        System.out.println(message);
    }

}
