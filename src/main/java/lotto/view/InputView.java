package lotto.view;


import java.util.Arrays;
import java.util.List;
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

    public List<Integer> enterWinningNumbers() {
        ConsoleWriter.printlnMessage(PrintMessage.INPUT_WINNING_NUMBERS.getMessage());
        String input = ConsoleReader.enterMessage();
        checkStringFormat(input);
        checkNumbersFormat(input);
        return parseNumber(input);
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

    private void checkNumbersFormat(String str) {
        if (isNotNumberWithDelimiter(str)) {
            throw CustomException.of(ErrorMessage.INVALID_WINNING_NUMBER_STRING_ERROR);
        }
    }

    private boolean isEmptyOrBlank(String str) {
        return str == null || str.isBlank();
    }

    private boolean isNotPositiveInteger(String str) {
        return !str.matches("\\d+") || Integer.parseInt(str) <= 0;
    }

    private boolean isNotNumberWithDelimiter(String str) {
        return !str.matches("(\\d+,)*\\d+");
    }

    private List<Integer> parseNumber(String input) {
        return Arrays.stream(input.split(",")).map(Integer::parseInt).toList();
    }
}
