package lotto.lottoapp.model.value;

import java.util.Objects;
import lotto.lottoapp.model.Lotto;

public class WinningLottoNumbers {

    private final LottoNumbers lottoNumbers;
    private final BonusNumber bonusNumber;

    public WinningLottoNumbers(LottoNumbers lottoNumbers, BonusNumber bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨 로또번호와 보너스 로또번호는 중복될 수 없습니다.");
        }

        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public WinningResult drawLotto(Lotto targetLotto) {
        int countOfWinningNumber = (int) targetLotto.stream()
                .filter(lottoNumbers::contains)
                .count();
        boolean isWinningBonus = targetLotto.stream()
                .anyMatch(bonusNumber::equals);
        return WinningResult.matchBy(countOfWinningNumber, isWinningBonus);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WinningLottoNumbers that = (WinningLottoNumbers) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers) &&
                Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers, bonusNumber);
    }

}
