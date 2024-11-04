package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.CustomLottoException;
import lotto.exception.ErrorMessage;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {
    public static int inputLottoAmount() {
        while (true) {
            try {
                String inputAmount = Console.readLine();
                int amount = convertInputToInt(inputAmount);
                validateMultipleOfThousandLottoAmount(amount);
                return amount;
            } catch (CustomLottoException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public static List<Integer> inputWinningNumbers() {
        while (true) {
            try {
                String inputWinningNumbers = Console.readLine();
                return convertInputWinningNumbersToIntegerList(inputWinningNumbers);
            } catch (CustomLottoException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public static int inputBonusNumber() {
        while (true) {
            try {
                String bonusNumber = Console.readLine();
                return convertInputToInt(bonusNumber);
            } catch (CustomLottoException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private static int convertInputToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new CustomLottoException(ErrorMessage.NOT_INTEGER_NUMBER);
        }
    }

    private static void validateMultipleOfThousandLottoAmount(int amount) {
        if (amount % 1000 != 0) {
            throw new CustomLottoException(ErrorMessage.NOT_MULTIPLE_THOUSAND);
        }
    }

    private static List<Integer> convertInputWinningNumbersToIntegerList(String inputWinningNumbers) {
        try {
            return Stream.of(inputWinningNumbers.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException exception) {
            throw new CustomLottoException(ErrorMessage.NOT_INTEGER_NUMBER);
        }
    }
}