package lotto.lotto.domain;

public class LottoWinning {

    private final Lotto lotto;
    private final int bonusNumber;

    public LottoWinning(Lotto lotto, int specialNumber) {
        this.lotto = lotto;
        this.bonusNumber = specialNumber;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }


}
