package lotto.view.validation;

import static lotto.service.exception.LottoExceptionMessage.BONUS_NUMBER_DUPLICATED;
import static lotto.service.exception.LottoExceptionMessage.INVALID_BONUS_NUMBER;

import lotto.domain.dto.WinningNumbersDto;
import lotto.service.exception.LottoException;

public class BonusNumberValidator {

    private static final String BONUS_NUMBER_REGEX = "^(?:[1-9]|[1-3][0-9]|4[0-5])$";

    public static int validate(WinningNumbersDto winningNumbersDto, String bonusNumber) {
        validateBonusNumber(bonusNumber);
        validateWinningNumbersContainsBonusNumber(winningNumbersDto, bonusNumber);
        return Integer.parseInt(bonusNumber);
    }

    private static void validateBonusNumber(String bonusNumber) {
        if (!bonusNumber.matches(BONUS_NUMBER_REGEX)) {
            throw new LottoException(INVALID_BONUS_NUMBER);
        }
    }

    private static void validateWinningNumbersContainsBonusNumber(WinningNumbersDto winningNumbersDto, String bonusNumber) {
        winningNumbersDto.numbers().stream()
                .filter(i -> i == Integer.parseInt(bonusNumber))
                .findAny()
                .ifPresent(i -> {
                    throw new LottoException(BONUS_NUMBER_DUPLICATED);
                });
    }


}
