package lotto.committee;

public class WonNumbers {
    private Lotto lotto;
    private Integer bonusNumber;

    void saveWonLotto(Lotto wonMainNumbers) {
        this.lotto = wonMainNumbers;
    }

    void saveWonBonus(Integer wonBonusNumber) {
        this.bonusNumber = wonBonusNumber;
    }

    public WonNumbers getWonNumbers() {
        return this;
    }

    public Lotto getLotto() {
        return this.lotto;
    }

    void cleanAll() {
        this.lotto = null;
        this.bonusNumber = null;
    }

    void cleanBonus() {
        this.bonusNumber = null;
    }
}
