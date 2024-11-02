package lotto.view;


import lotto.view.console.ConsoleReader;
import lotto.view.console.ConsoleWriter;
import lotto.view.global.PrintMessage;
import lotto.view.global.exception.CustomException;
import lotto.view.global.exception.ErrorMessage;

public class InputView {

    public String enterAmount() {
        ConsoleWriter.printlnMessage(PrintMessage.INPUT_AMOUNT.getMessage());
        String input = ConsoleReader.enterMessage();
        checkStringFormat(input);
        return input;
    }

    private void checkStringFormat(String str) {
        if (isEmptyOrBlank(str)) {
            throw CustomException.of(ErrorMessage.BLANK_INPUT_ERROR);
        }
    }

    private boolean isEmptyOrBlank(String str) {
        return str == null || str.isBlank();
    }
}
