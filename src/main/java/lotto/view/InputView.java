package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.CustomLottoException;
import lotto.exception.ErrorMessage;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {
    public static int inputLottoAmount(){
        String inputAmount = Console.readLine();
        return convertInputToInt(inputAmount);
    }

    public static List<Integer> inputWinningNumbers() {
        String inputWinningNumbers = Console.readLine();
        return convertInputWinningNumbersToIntegerList(inputWinningNumbers);
    }

    public static int inputBonusNumber() {
        String bonusNumber = Console.readLine();
        return convertInputToInt(bonusNumber);
    }

    private static int convertInputToInt(String input) {
        try {
            int intNumber = Integer.parseInt(input);
            long longNumber = Long.parseLong(input);
            validateAmountEquality(intNumber, longNumber);
            return intNumber;
        } catch (NumberFormatException exception) {
            throw new CustomLottoException(ErrorMessage.NOT_NUMBER);
        }
    }

    private static void validateAmountEquality(int intAmount, long longAmount) {
        if (intAmount != longAmount) {
            throw new CustomLottoException(ErrorMessage.NOT_INTEGER_NUMBER);
        }
    }

    private static List<Integer> convertInputWinningNumbersToIntegerList(String inputWinningNumbers) {
        try {
            List<Long> winningNumbers =
                    Stream.of(inputWinningNumbers.split(","))
                            .map(Long::parseLong)
                            .collect(Collectors.toList());
            validateNumberEquality(winningNumbers);
            return convertWinningNumbersToInteger(winningNumbers);
        } catch (NumberFormatException exception) {
            throw new CustomLottoException(ErrorMessage.NOT_NUMBER);
        }
    }

    private static void validateNumberEquality(List<Long> numbers) {
        for (long number : numbers) {
            int intNumber = (int)number;
            if (number != intNumber) {
                throw new CustomLottoException(ErrorMessage.NOT_INTEGER_NUMBER);
            }
        }
    }

    private static List<Integer> convertWinningNumbersToInteger(List<Long> winningNumbers) {
        return winningNumbers.stream()
                .map(Long::intValue)
                .collect(Collectors.toList());
    }
}