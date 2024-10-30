package lotto.domain;

import java.util.HashSet;
import java.util.Set;

public class WinningLotto {
    private static final int LOTTO_MIN_NUM = 1;
    private static final int LOTTO_MAX_NUM = 45;
    private static final String BONUS_MATCH_WINNING_LOTTO = "보너스 번호는 당첨 번호에 없는 번호여야 합니다.";
    private static final String LOTTO_BONUS_NUM_RANGE_ERROR = "보너스 번호는 로또 당첨을 위한 번호로 " + LOTTO_MIN_NUM + "과 " + LOTTO_MAX_NUM + "사이여야 합니다.";

    private final Set<Integer> winningLottoNumbers;
    private final int bonusNum;

    public WinningLotto(final Lotto winningLotto, final int bonusNum) {
        this.winningLottoNumbers = new HashSet<>(winningLotto.getNumbers());
        validateBonusNum(bonusNum);
        this.bonusNum = bonusNum;
    }

    private void validateBonusNum(int bonusNum) {
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

    public Set<Integer> getWinningLottoNumbers() {
        return winningLottoNumbers;
    }

    public int getBonusNum() {
        return bonusNum;
    }
}
