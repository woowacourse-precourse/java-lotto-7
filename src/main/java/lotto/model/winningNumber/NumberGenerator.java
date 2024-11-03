package lotto.model.winningNumber;

import static lotto.Exceptions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberGenerator {
    private static final String NUMBER_DELIMITER = ",";
    private static final int SPLIT_NO_LIMIT = -1;

    public static WinningNumber registerWinningNumber(String winningNumberInput) {
        try {
            List<Integer> winningNumber = Arrays.stream(winningNumberInput.split(NUMBER_DELIMITER, SPLIT_NO_LIMIT))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            return new WinningNumber(winningNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_INTEGER_INCLUDED.getMessage());
        }
    }

    public static BonusNumber registerBonusNumber(String bonusNumberInput, WinningNumber winningNumber) {
        try {
            int bonusNumber = Integer.parseInt(bonusNumberInput);
            if (winningNumber.contains(bonusNumber)) {
                throw new IllegalArgumentException(DUPLICATED_BONUS_NUMBER.getMessage());
            }
            return new BonusNumber(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_INTEGER_INCLUDED.getMessage());
        }
    }
}
