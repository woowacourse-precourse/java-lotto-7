package lotto.domain;

import java.util.List;

import static lotto.domain.Lotto.LOTTO_MAX_NUM;
import static lotto.domain.Lotto.LOTTO_MIN_NUM;

public class BonusNum {
    private static final String BONUS_MATCH_WINNING_LOTTO = "보너스 번호는 당첨 번호에 없는 번호여야 합니다.";

    private static final String LOTTO_BONUS_NUM_RANGE_ERROR = "보너스 번호는 로또 당첨을 위한 번호로 "
            + LOTTO_MIN_NUM + "과 " + LOTTO_MAX_NUM
            + "사이여야 합니다.";

    private final int bonusNum;

    public BonusNum(final int bonusNum, final List<Integer> winningLottoNumbers) {
        validateBonusNum(bonusNum, winningLottoNumbers);
        this.bonusNum = bonusNum;
    }

    public boolean isContained(final Lotto lotto) {
        return lotto.containsBonus(bonusNum);
    }

    private void validateBonusNum(final int bonusNum, final List<Integer> winningLottoNumbers) {
        validateDuplicated(bonusNum, winningLottoNumbers);
        validateBonusNumRange(bonusNum);
    }

    private void validateDuplicated(final int bonusNum, final List<Integer> winningLottoNumbers) {
        if (winningLottoNumbers.contains(bonusNum)) {
            throw new IllegalArgumentException(BONUS_MATCH_WINNING_LOTTO);
        }
    }

    private void validateBonusNumRange(final int bonusNum) {
        if (bonusNum < LOTTO_MIN_NUM || bonusNum > LOTTO_MAX_NUM) {
            throw new IllegalArgumentException(LOTTO_BONUS_NUM_RANGE_ERROR);
        }
    }
}
