package lotto.service.winningNumber;

import static lotto.common.Exceptions.DUPLICATED_BONUS_NUMBER;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.common.Converter;
import lotto.dto.WinningNumbersDto;
import lotto.model.winningNumber.BonusNumber;
import lotto.model.winningNumber.MainNumber;

public class DefaultNumberGenerator implements NumberGenerator<String, WinningNumbersDto> {
    private static final String NUMBER_DELIMITER = ",";
    private static final int SPLIT_NO_LIMIT = -1;

    @Override
    public MainNumber registerMainNumber(String mainNumberInput) {
        List<Integer> mainNumber = Arrays.stream(mainNumberInput.split(NUMBER_DELIMITER, SPLIT_NO_LIMIT))
                .map(String::trim)
                .map(Converter::toInteger)
                .collect(Collectors.toList());
        return new MainNumber(mainNumber);
    }

    @Override
    public BonusNumber registerBonusNumber(WinningNumbersDto winningNumbers) {
        int bonusNumber = Converter.toInteger(winningNumbers.bonusNumber());
        if (winningNumbers.mainNumber().contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATED_BONUS_NUMBER.getMessage());
        }
        return new BonusNumber(bonusNumber);
    }
}
