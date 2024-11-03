package lotto.domain.lotto;

public class BonusNumber {

    private final LottoNumber bonusNumber;

    public BonusNumber(LottoNumber bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public boolean hasMatchingBonusNumber(Lotto lotto) {
        return lotto.getLotto().contains(bonusNumber);
    }

}
