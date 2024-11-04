package lotto.view.input;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class LottoWinningNumber {

    private HashMap<Integer, String> winningNumbers = new HashMap<>();

    public HashMap<Integer, String> input() {
        String winningNumber = inputWinningNumbers();
        System.out.println();
        String bonusNumber = inputBonusNumber(winningNumber);
        return combineWinningNumbersAndBonus(winningNumber, bonusNumber);
    }

    public void validateWinningNumbersForTest(String winningNumber) {
        validateWinningNumbers(winningNumber);
    }

    public void validateBonusNumberForTest(String bonusNumber, String winningNumber) {
        validateBonusNumber(bonusNumber, winningNumber);
    }

    private String inputWinningNumbers() {
        while (true) {
            try {
                InputMessageEnum.WINNING_NUMBERS.printMessage();
                String input = readLine();
                validateWinningNumbers(input);
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String inputBonusNumber(String winningNumber) {
        while (true) {
            try {
                InputMessageEnum.BONUS_NUMBER.printMessage();
                String input = readLine();
                validateBonusNumber(input, winningNumber);
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateWinningNumbers(String winningNumber) {
        try {
            List<Integer> numbers = parseNumbers(winningNumber);
            validateNumberCount(numbers);
            validateNoDuplicates(numbers);
            validateNumberRange(numbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(InputMessageEnum.INVALID_NUMBER_ERROR.getMessage());
        }
    }

    private void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(InputMessageEnum.INVALID_COUNT_ERROR.getMessage());
        }
    }

    private void validateNoDuplicates(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(
                InputMessageEnum.DUPLICATE_NUMBER_ERROR.getMessage());
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(n -> n < 1 || n > 45)) {
            throw new IllegalArgumentException(InputMessageEnum.INVALID_NUMBER_ERROR.getMessage());
        }
    }

    private void validateBonusNumber(String bonusNumber, String winningNumber) {
        try {
            int bonus = Integer.parseInt(bonusNumber);
            validateBonusNumberRange(bonus);
            validateBonusNotInWinning(bonus, parseNumbers(winningNumber));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(InputMessageEnum.INVALID_NUMBER_ERROR.getMessage());
        }
    }

    private void validateBonusNumberRange(int bonus) {
        if (bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException(InputMessageEnum.INVALID_NUMBER_ERROR.getMessage());
        }
    }

    private void validateBonusNotInWinning(int bonus, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonus)) {
            throw new IllegalArgumentException(
                InputMessageEnum.DUPLICATE_BONUS_NUMBER_ERROR.getMessage());
        }
    }

    private HashMap<Integer, String> combineWinningNumbersAndBonus(String winningNumber,
        String bonusNumber) {
        List<Integer> numbers = parseNumbers(winningNumber);
        numbers.forEach(n -> winningNumbers.put(n, "winningNumber"));
        winningNumbers.put(Integer.parseInt(bonusNumber), "bonusNumber");
        return winningNumbers;
    }

    private List<Integer> parseNumbers(String numbers) {
        return Arrays.stream(numbers.split(","))
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }
}