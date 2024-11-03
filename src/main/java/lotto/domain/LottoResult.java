package lotto.domain;

import java.util.List;
import lotto.common.LottoConfig;

public class LottoResult {
    private final Lotto winningNumbers;
    private final int bonusNumber;

    public LottoResult(List<Integer> resultNumbers, int bonusNumber) {
        this.winningNumbers = new Lotto(resultNumbers);
        bonusNumberValidate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void bonusNumberValidate(int bonusNumber) {
        if (isBonusNumberRangeValid(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스넘버는 1~45 사이의 정수여야 합니다.");
        }
        if (isLottoNumberDuplicated(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스넘버는 당첨 번호와 중복되어선 안됩니다.");
        }
    }

    private boolean isBonusNumberRangeValid(int bonusNumber) {
        return !(bonusNumber >= LottoConfig.LOTTO_MIN_NUMBER.getValue()
                && bonusNumber <= LottoConfig.LOTTO_MAX_NUMBER.getValue());
    }

    private boolean isLottoNumberDuplicated(int bonusNumber) {
        return winningNumbers.getNumbers().contains(bonusNumber);
    }
}
