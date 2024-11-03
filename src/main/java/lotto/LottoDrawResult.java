package lotto;

import java.util.List;

public class LottoDrawResult {
    private Lotto winingLotto;
    private BonusNumber bonusNumber;

    public void assignWinningNumber(Lotto winingLotto) {
        this.winingLotto = winingLotto;
    }
    public void assignBonusNumber(BonusNumber bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningLotto() {
        return winingLotto.getNumbers();
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }
}
