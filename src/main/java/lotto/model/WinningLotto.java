package lotto.model;

import lotto.value.BonusNumber;
import lotto.value.LottoNumbers;

public class WinningLotto {

    private final LottoNumbers winningLottoNumbers;
    private final BonusNumber bonusNumber;

    public WinningLotto(LottoNumbers winningLottoNumbers, BonusNumber bonusNumber) {
        if (winningLottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 로또번호와 보너스 로또번호는 중복될 수 없습니다.");
        }

        this.winningLottoNumbers = winningLottoNumbers;
        this.bonusNumber = bonusNumber;
    }

}
