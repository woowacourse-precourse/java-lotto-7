package lotto.view.validation;

import static lotto.service.exception.LottoExceptionMessage.BONUS_NUMBER_DUPLICATED;

import lotto.domain.dto.WinningNumbersDto;
import lotto.service.exception.LottoException;

public class BonusNumberValidator {

    public static int validate(WinningNumbersDto winningNumbersDto, String bonusNumber) {
        validateWinningNumbersContainsBonusNumber(winningNumbersDto, bonusNumber);
        return Integer.parseInt(bonusNumber);
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
