package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.amount.Amount;
import lotto.exception.CustomException;
import lotto.exception.ExceptionMessage;
import lotto.lotto.Number;
import lotto.lotto.WinningNumbers;

public class InputView {

    public Amount getPurchaseAmount() {
        String input = Console.readLine();
        validateBlankInput(input);
        return new Amount(validateNumber(input));
    }

    public WinningNumbers getWinningNumbers() {
        String input = Console.readLine();
        validateBlankInput(input);
        return new WinningNumbers(parseNumbers(input));
    }

    public Number getBonusNumber() {
        String input = Console.readLine();
        validateBlankInput(input);
        return new Number(validateNumber(input));
    }

    private void validateBlankInput(String input) {
        if (input == null || input.isBlank()) {
            throw new CustomException(ExceptionMessage.BLANK_INPUT_EXCEPTION);
        }
    }

    private int validateNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new CustomException(ExceptionMessage.NONE_NUMERIC_INPUT_EXCEPTION);
        }
    }

    private List<Integer> parseNumbers(String numbers) {
        return Arrays.stream(numbers.split(","))
                .map(this::validateNumber)
                .toList();
    }
}
