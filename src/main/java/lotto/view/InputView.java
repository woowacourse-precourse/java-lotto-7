package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import lotto.Lotto;
import lotto.exception.ExceptionMessage;

public class InputView {

    public int totalCostInput() {
        int input = parseInt(input());
        checkPositive(input);
        checkDivisibleBy1000(input);
        return input / 1000;
    }

    public int setBonusNumber() {
        int input = parseInt(input());
        checkLottoNumberRange(input);
        return input;
    }

    public Lotto setWinningNumber() {
        String input = input();
        String[] splitInput = input.split(",");
        List<Integer> valueOfWinningNumber = parseWinningNumbers(splitInput);
        checkLottoSize(valueOfWinningNumber);

        return new Lotto(valueOfWinningNumber);
    }

    private String input() {
        try {
            String input = Console.readLine();
            Console.close();
            return input;
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_NULL.getMessage());
        }
    }

    private List<Integer> parseWinningNumbers(String[] splitInput) {
        return Arrays.stream(splitInput)
                .map(String::trim)
                .map(this::parseInt)
                .peek(this::checkLottoNumberRange)
                .collect(Collectors.toList());
    }

    private int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_NOT_INTEGER.getMessage());
        }
    }

    private void checkDivisibleBy1000(int number) {
        if (number % 1000 != 0) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_NOT_DIVISIBLE_BY_1000.getMessage());
        }
    }

    private void checkPositive(int number) {
        if (number < 1) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_NEGATIVE_NUMBER.getMessage());
        }
    }

    private void checkLottoNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_NOT_IN_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    private void checkLottoSize(List<Integer> number) {
        if (number.size() != 6) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_LOTTO_SIZE_NOT_MATCHED.getMessage());
        }
    }
}
