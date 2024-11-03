package lotto.view;


import java.util.Arrays;
import java.util.List;
import lotto.view.console.ConsoleReader;
import lotto.view.console.ConsoleWriter;
import lotto.global.PrintMessage;
import lotto.global.exception.CustomException;
import lotto.global.exception.ErrorMessage;

public class InputView {

    public int enterAmount() {
        ConsoleWriter.printlnMessage(PrintMessage.INPUT_AMOUNT.getMessage());
        String input = ConsoleReader.enterMessage();
        validateStringFormat(input);
        validateNumberFormat(input);
        return Integer.parseInt(input);
    }

    public List<Integer> enterWinningNumbers() {
        ConsoleWriter.printlnMessage(PrintMessage.INPUT_WINNING_NUMBERS.getMessage());
        String input = ConsoleReader.enterMessage();
        validateStringFormat(input);
        validateNumbersFormat(input);
        return parseNumber(input);
    }

    public int enterBonusNumber() {
        ConsoleWriter.printlnMessage(PrintMessage.INPUT_BONUS_NUMBER.getMessage());
        String input = ConsoleReader.enterMessage();
        validateStringFormat(input);
        validateNumberFormat(input);
        return Integer.parseInt(input);
    }

    private void validateStringFormat(String str) {
        if (isEmptyOrBlank(str)) {
            throw CustomException.of(ErrorMessage.BLANK_INPUT);
        }
    }

    private void validateNumberFormat(String str) {
        if (isNotPositiveInteger(str)) {
            throw CustomException.of(ErrorMessage.INVALID_INPUT_NUMBER);
        }
    }

    private void validateNumbersFormat(String str) {
        if (isNotNumberWithDelimiter(str)) {
            throw CustomException.of(ErrorMessage.INVALID_WINNING_NUMBER_STRING);
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
