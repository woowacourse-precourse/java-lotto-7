package lotto.view;


import lotto.view.console.ConsoleReader;
import lotto.view.console.ConsoleWriter;
import lotto.view.global.MessageType;

public class InputView {

    public String enterAmount() {
        ConsoleWriter.printlnMessage(MessageType.START_MESSAGE.getMessage());
        return ConsoleReader.enterMessage();
    }
}
