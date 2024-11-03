package lotto.model.winningNumber;

import static lotto.common.Exceptions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.common.Converter;

public class NumberGenerator {
    private static final String NUMBER_DELIMITER = ",";
    private static final int SPLIT_NO_LIMIT = -1;

    public static WinningNumber registerWinningNumber(String winningNumberInput) {
        List<Integer> winningNumber = Arrays.stream(winningNumberInput.split(NUMBER_DELIMITER, SPLIT_NO_LIMIT))
                .map(String::trim)
                .map(Converter::toInteger)
                .collect(Collectors.toList());
        return new WinningNumber(winningNumber);
    }

    public static BonusNumber registerBonusNumber(String bonusNumberInput, WinningNumber winningNumber) {
        int bonusNumber = Converter.toInteger(bonusNumberInput);
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATED_BONUS_NUMBER.getMessage());
        }
        return new BonusNumber(bonusNumber);
    }
}
