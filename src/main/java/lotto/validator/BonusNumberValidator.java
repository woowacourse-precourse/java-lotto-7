package lotto.validator;

import java.util.HashSet;
import java.util.Set;
import lotto.util.WinningNumberParser;

public class BonusNumberValidator {

    private static final String BONUS_NUMBER_IS_POSITIVE = "[ERROR] 보너스 번호는 양의 정수여야 합니다.";
    private static final String INVALID_BONUS_NUMBER_RANGE = "[ERROR] 보너스 번호는 1~45 사이의 양의 정수여야 합니다.";
    private static final String BONUS_NUMBER_DUPLICATE = "[ERROR] 보너스 번호는 당첨 번호와 중복되선 안 됩니다.";

    private static final int START_NUMBER_RANGE = 1;
    private static final int END_NUMBER_RANGE = 45;

    public static void validateBonusNumber(final String winningNumbers, final String bonusNumber) {
        validateBonusNumberIsPositive(bonusNumber);
        validateBonusNumberRange(bonusNumber);
        validateBonusNumberDuplicate(winningNumbers, bonusNumber);
    }

    private static void validateBonusNumberIsPositive(final String bonusNumber) {
        if (!bonusNumber.matches("\\d+") || Long.parseLong(bonusNumber) <= 0) {
            throw new IllegalArgumentException(BONUS_NUMBER_IS_POSITIVE);
        }
    }

    private static void validateBonusNumberRange(final String bonusNumber) {
        if (Integer.parseInt(bonusNumber) < START_NUMBER_RANGE || Integer.parseInt(bonusNumber) > END_NUMBER_RANGE) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER_RANGE);
        }
    }

    private static void validateBonusNumberDuplicate(final String winningNumbers, final String bonusNumber) {
        Set<String> lottoNumberSet = new HashSet<>(WinningNumberParser.parseWinningNumber(winningNumbers));
        if (lottoNumberSet.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE);
        }
    }
}
