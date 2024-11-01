package lotto.model;

import java.util.List;
import lotto.Lotto;
import lotto.util.Validator;

public class WinningLotto extends Lotto {
    private int bonusNum;

    private static final int WINNING_NUMBER_COUNT = 6;

    public WinningLotto(List<Integer> nums, int bonusNum) {
        super(nums);
        this.bonusNum = bonusNum;
        //validate();
    }

    public static WinningLotto create(String winningNumber) {
        basicValidateWinningNumber(winningNumber);
        List<String> parsedNumber = parseEachNumber(winningNumber);
        validateWinningNumber(parsedNumber);
        return null;
    }


    private static List<String> parseEachNumber(String winningNumber) {
        String[] numbers = winningNumber.split(",");
        return List.of(numbers);
    }

    private static void basicValidateWinningNumber(String winningNumber) {
        Validator.isEmptyInput(winningNumber);
    }

    private static void validateWinningNumber(List<String> parsedNumbers) {
        Validator.isEqualListSize(parsedNumbers, WINNING_NUMBER_COUNT);
        parsedNumbers.stream()
                .peek(Validator::isDigitString)
                .peek(Validator::isInteger)
                .forEach(parsedNumber -> {});
    }
}
