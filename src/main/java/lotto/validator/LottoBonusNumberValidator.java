package lotto.validator;

import lotto.dto.WinningLottoNumbers;

public class LottoBonusNumberValidator {
    private static final String LOTTO_BONUS_NUMBER_REGEX = "^[0-9]+$";

    private LottoBonusNumberValidator() {
    }

    public static void validateLottoBonusNumber(String inputLottoBonusNumber, WinningLottoNumbers winningLottoNumbers) {
        try {
            int lottoBonusNumber = Integer.parseInt(inputLottoBonusNumber);
            checkLottoBonusNumberRange(lottoBonusNumber);
            checkDuplicateInWinningLottoNumber(lottoBonusNumber, winningLottoNumbers);
        } catch (NumberFormatException e) {
            checkIncludeSpecialCharacters(inputLottoBonusNumber);
            throw new IllegalArgumentException("로또 당첨 번호는 0 이상 45 이하입니다");
        }
    }

    private static void checkLottoBonusNumberRange(int lottoBonusNumber) {
        if (0 >= lottoBonusNumber || lottoBonusNumber > 45) {
            throw new IllegalArgumentException("로또 보너스 번호는 0 이상 45 이하입니다");
        }
    }

    private static void checkIncludeSpecialCharacters(String lottoBonusNumber) {
        if (!lottoBonusNumber.matches(LOTTO_BONUS_NUMBER_REGEX)) {
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
