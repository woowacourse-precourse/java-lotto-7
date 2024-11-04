package lotto.model;

public class LottoRound {
    private final int round;
    private Lotto winningLotto;
    private int bonusNumber;

    public LottoRound(int round) {
        this.round = round;
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setWinningLotto(Lotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    @Override
    public String toString() {
        return "LottoRound{" +
                "round=" + round +
                '}';
    }
}
