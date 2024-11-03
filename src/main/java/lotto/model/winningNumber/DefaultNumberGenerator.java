package lotto.model.winningNumber;

import static lotto.common.Exceptions.DUPLICATED_BONUS_NUMBER;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.common.Converter;
import lotto.model.dto.AllWinningNumberDto;

public class DefaultNumberGenerator implements NumberGenerator<String, AllWinningNumberDto>{
    private static final String NUMBER_DELIMITER = ",";
    private static final int SPLIT_NO_LIMIT = -1;

    @Override
    public WinningNumber registerWinningNumber(String winningNumberInput) {
        List<Integer> winningNumber = Arrays.stream(winningNumberInput.split(NUMBER_DELIMITER, SPLIT_NO_LIMIT))
                .map(String::trim)
                .map(Converter::toInteger)
                .collect(Collectors.toList());
        return new WinningNumber(winningNumber);
    }

    @Override
    public BonusNumber registerBonusNumber(AllWinningNumberDto allWinningNumber) {
        int bonusNumber = Converter.toInteger(allWinningNumber.bonusNumber());
        if (allWinningNumber.winningNumber().contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATED_BONUS_NUMBER.getMessage());
        }
        return new BonusNumber(bonusNumber);
    }
}
