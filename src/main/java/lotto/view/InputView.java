package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.enums.ErrorCode;
import lotto.util.StringParser;

import java.util.Collections;
import java.util.List;

public class InputView {
    public InputView() {
    }

    public int readPurchaseAmount() {
        String input = Console.readLine().replaceAll(" ", "");
        validateEmptyInput(input);
        validateNumericInput(input);

        int purchaseAmount = Integer.parseInt(input);
        validatePurchaseAmount(purchaseAmount);

        return purchaseAmount;
    }

    public List<Integer> readWinningNumbers() {
        String input = Console.readLine().replaceAll(" ", "");
        List<String> winningNumbers = List.of(input.split(","));

        validateWinningNumbersInput(winningNumbers);

        List<Integer> parsedWinningNumbers = StringParser.parseToIntegerList(winningNumbers);
        validateWinningNumbers(parsedWinningNumbers);

        return parsedWinningNumbers;
    }

    public int readBonusNumber() {
        String input = Console.readLine().replaceAll(" ", "");
        validateNumericInput(input);

        int bonusNumber = Integer.parseInt(input);
        validateNumberRange(bonusNumber);

        return bonusNumber;
    }

    private void validateEmptyInput(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ErrorCode.INVALID_INPUT.getMessage());
        }
    }

    private void validateNumericInput(String input) {
        if (!StringParser.isNumeric(input)) {
            throw new IllegalArgumentException(ErrorCode.INVALID_INPUT.getMessage());
        }
    }

    private void validatePurchaseAmount(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException(ErrorCode.INVALID_NEGATIVE_AMOUNT.getMessage());
        }
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorCode.INVALID_PURCHASE_AMOUNT.getMessage());
        }
    }

    private void validateWinningNumbersInput(List<String> numbers) {
        for (String number : numbers) {
            if (number.isEmpty() || !StringParser.isNumeric(number)) {
                throw new IllegalArgumentException(ErrorCode.INVALID_INPUT.getMessage());
            }
        }
    }

    private void validateWinningNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorCode.INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }
        for (Integer number : numbers) {
            validateNumberRange(number);
            if (Collections.frequency(numbers, number) > 1) {
                throw new IllegalArgumentException(ErrorCode.DUPLICATE_NUMBER.getMessage());
            }
        }
    }

    private void validateNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ErrorCode.NUMBER_OUT_OF_RANGE.getMessage());
        }
    }
}
