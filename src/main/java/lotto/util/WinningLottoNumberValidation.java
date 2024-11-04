package lotto.util;

import lotto.constant.ExceptionMessage;
import lotto.constant.GameConfig;

public class WinningLottoNumberValidation {

    public static void validateWinningNumbers(String lottoNumbers) {
        validateWinningNumberFormat(lottoNumbers);
    }

    public static void validateWinningNumberFormat(String lottoNumbers) {
        if (!lottoNumbers.matches(GameConfig.VALID_LOTTO_NUMBERS_PATTERN)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_NUMBERS_FORMAT_ERROR);
        }
    }
}
