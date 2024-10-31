package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.Lotto;
import lotto.exception.ExceptionMessage;

public class InputView {

    public int totalCostInput() {
        int input = parseInt(Console.readLine());
        checkPositive(input);
        checkDivisibleBy1000(input);
        Console.close();
        return input/1000;
    }

    public int setBonusNumber() {
        int input = parseInt(Console.readLine());
        checkLottoNumberRange(input);
        Console.close();
        return input;
    }

    public Lotto setWinningNumber() {
        String input = Console.readLine();

        String[] splitInput = input.split(",");
        List<Integer> valueOfWinningNumber = parseWinningNumbers(splitInput);

        return new Lotto(valueOfWinningNumber);
    }

    private List<Integer> parseWinningNumbers(String[] splitInput) {
        return Arrays.stream(splitInput)
                .map(String::trim)
                .map(Integer::parseInt)
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
}
