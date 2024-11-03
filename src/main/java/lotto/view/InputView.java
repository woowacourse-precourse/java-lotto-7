package lotto.view;


import lotto.view.console.ConsoleReader;
import lotto.view.console.ConsoleWriter;
import lotto.view.global.PrintMessage;
import lotto.view.global.exception.CustomException;
import lotto.view.global.exception.ErrorMessage;

public class InputView {

    public Integer enterAmount() {
        ConsoleWriter.printlnMessage(PrintMessage.INPUT_AMOUNT.getMessage());
        String input = ConsoleReader.enterMessage();
        checkStringFormat(input);
        checkNumberFormat(input);
        return Integer.parseInt(input);
    }

    private void checkStringFormat(String str) {
        if (isEmptyOrBlank(str)) {
            throw CustomException.of(ErrorMessage.BLANK_INPUT_ERROR);
        }
    }

    private void checkNumberFormat(String str) {
        if (isNotPositiveInteger(str)) {
            throw CustomException.of(ErrorMessage.INVALID_AMOUNT_TYPE_ERROR);
        }
    }

    private boolean isEmptyOrBlank(String str) {
        return str == null || str.isBlank();
    }

    private boolean isNotPositiveInteger(String str) {
        return !str.matches("\\d+") || Integer.parseInt(str) <= 0;
    }
}
