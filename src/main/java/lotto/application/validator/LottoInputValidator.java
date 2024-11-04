package lotto.application.validator;

import lotto.domain.cost.Cost;
import lotto.domain.lotto.WinningLottoImpl;
import lotto.infrastructure.constant.ExceptionMessage;
import lotto.infrastructure.constant.LottoConfig;
import lotto.infrastructure.exception.CustomException;

import java.util.Arrays;
import java.util.List;

public class LottoInputValidator {
    public Cost validateCost(final String input) {
        validateEmpty(input);
        final int number = validateNumberFormat(input);
        return Cost.of(number);
    }

    public WinningLottoImpl validateWinningLotto(String numbers, String bonusInput) {
        validateEmpty(numbers);
        validateEmpty(bonusInput);
        List<String> splits = Arrays.stream(numbers.split(LottoConfig.DELIMITER))
                .map(String::trim)
                .toList();
        List<Integer> basicNumbers = splits.stream().map(this::validateNumberFormat).toList();
        int bonusNumber = validateNumberFormat(bonusInput);
        return WinningLottoImpl.of(basicNumbers, bonusNumber);
    }

    private void validateEmpty(final String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new CustomException(ExceptionMessage.EMPTY_INPUT);
        }
    }

    private int validateNumberFormat(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new CustomException(ExceptionMessage.INVALID_INTEGER);
        }
    }
}
