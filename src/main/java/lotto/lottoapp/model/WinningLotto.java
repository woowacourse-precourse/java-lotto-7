package lotto.lottoapp.model;

import lotto.lottoapp.model.value.BonusNumber;
import lotto.lottoapp.model.value.LottoNumbers;
import lotto.lottoapp.model.value.WinningResult;

public class WinningLotto {

    private final LottoNumbers winningLottoNumbers;
    private final BonusNumber bonusNumber;

    public WinningLotto(LottoNumbers winningLottoNumbers, BonusNumber bonusNumber) {
        if (winningLottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨 로또번호와 보너스 로또번호는 중복될 수 없습니다.");
        }

        this.winningLottoNumbers = winningLottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public WinningResult drawLotto(Lotto targetLotto) {
        int countOfWinningNumber = (int) targetLotto.stream()
                .filter(winningLottoNumbers::contains)
                .count();
        boolean isWinningBonus = targetLotto.stream()
                .anyMatch(bonusNumber::equals);
        return WinningResult.matchBy(countOfWinningNumber, isWinningBonus);
    }

}
