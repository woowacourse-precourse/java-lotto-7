package lotto.validator;

import lotto.domain.Lotto;

import java.util.List;

public class BonusNumValidator {
    private static final int LOTTO_MIN_NUM = 1;
    private static final int LOTTO_MAX_NUM = 45;
    private static final String BONUS_MATCH_WINNING_LOTTO = "보너스 번호는 당첨 번호에 없는 번호여야 합니다.";
    private static final String LOTTO_BONUS_NUM_RANGE_ERROR = "보너스 번호는 로또 당첨을 위한 번호로 " + LOTTO_MIN_NUM + "과 " + LOTTO_MAX_NUM + "사이여야 합니다.";

    private final List<Integer> winningLottoNumbers;

    public BonusNumValidator(Lotto winningLotto) {
        winningLottoNumbers = winningLotto.getNumbers();
    }

    public void validateBonusNum(int bonusNum) {
        validateDuplicated(bonusNum);
        validateBonusNumRange(bonusNum);
    }

    private void validateDuplicated(int bonusNum) {
        if (winningLottoNumbers.contains(bonusNum)) {
            throw new IllegalArgumentException(BONUS_MATCH_WINNING_LOTTO);
        }
    }

    private void validateBonusNumRange(int bonusNum) {
        if (bonusNum < LOTTO_MIN_NUM || bonusNum > LOTTO_MAX_NUM) {
            throw new IllegalArgumentException(LOTTO_BONUS_NUM_RANGE_ERROR);
        }
    }
}
