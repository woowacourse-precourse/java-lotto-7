package lotto.validator;

import static lotto.config.EnvironmentVariables.LOTTO_NUMBER_RANGE_END;
import static lotto.config.EnvironmentVariables.LOTTO_NUMBER_RANGE_START;
import static lotto.config.LottoRegularExpression.LOTTO_NUMBER_REGEX;

import lotto.dto.WinningLottoNumbers;

public class LottoBonusNumberValidator {
    private LottoBonusNumberValidator() {
    }

    public static void validateLottoBonusNumber(String inputLottoBonusNumber, WinningLottoNumbers winningLottoNumbers) {
        try {
            int lottoBonusNumber = Integer.parseInt(inputLottoBonusNumber);
            checkLottoBonusNumberRange(lottoBonusNumber);
            checkDuplicateInWinningLottoNumber(lottoBonusNumber, winningLottoNumbers);
        } catch (NumberFormatException e) {
            checkIncludeSpecialCharacters(inputLottoBonusNumber);
            throw new IllegalArgumentException("로또 당첨 번호는 1 이상 45 이하입니다");
        }
    }

    private static void checkLottoBonusNumberRange(int lottoBonusNumber) {
        if (LOTTO_NUMBER_RANGE_START > lottoBonusNumber || lottoBonusNumber > LOTTO_NUMBER_RANGE_END) {
            throw new IllegalArgumentException("로또 보너스 번호는 1 이상 45 이하입니다");
        }
    }

    private static void checkIncludeSpecialCharacters(String lottoBonusNumber) {
        if (!lottoBonusNumber.matches(LOTTO_NUMBER_REGEX)) {
            throw new IllegalArgumentException("로또 보너스 번호는 숫자로 입력해야 합니다.");
        }
    }

    private static void checkDuplicateInWinningLottoNumber(
            int lottoBonusNumber, WinningLottoNumbers winningLottoNumbers
    ) {
        if (winningLottoNumbers.numbers().contains(lottoBonusNumber)) {
            throw new IllegalArgumentException("로또 보너스 번호와 로또 당첨 번호가 중복됩니다.");
        }
    }
}
