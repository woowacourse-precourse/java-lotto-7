package lotto.common.validator;

import java.util.List;
import lotto.common.LottoConfig;

public class LottoResultValidator {
    public static void bonusNumberValidate(int bonusNumber, List<Integer> winningNumbers) {
        if (isBonusNumberRangeValid(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스넘버는 1~45 사이의 정수여야 합니다.");
        }
        if (isLottoNumberDuplicated(bonusNumber, winningNumbers)) {
            throw new IllegalArgumentException("[ERROR] 보너스넘버는 당첨 번호와 중복되어선 안됩니다.");
        }
    }

    private static boolean isBonusNumberRangeValid(int bonusNumber) {
        return !(bonusNumber >= LottoConfig.LOTTO_MIN_NUMBER.getValue()
                && bonusNumber <= LottoConfig.LOTTO_MAX_NUMBER.getValue());
    }

    private static boolean isLottoNumberDuplicated(int bonusNumber, List<Integer> winningNumbers) {
        return winningNumbers.contains(bonusNumber);
    }
}
