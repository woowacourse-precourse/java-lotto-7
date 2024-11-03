package lotto.view;


import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.global.exception.CustomException;
import lotto.global.exception.ErrorMessage;

public class InputView {
    public int enterAmount() {
        String input = Console.readLine();
        validateStringFormat(input);
        validateNumberFormat(input);
        return Integer.parseInt(input);
    }

    public List<Integer> enterWinningNumbers() {
        String input = Console.readLine();
        validateStringFormat(input);
        validateNumbersFormat(input);
        return parseNumber(input);
    }

    public int enterBonusNumber() {
        String input = Console.readLine();
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
