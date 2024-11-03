package lotto.model.domain;

public class LottoManager {

    private Lotto winningLotto;
    private Integer bonusNumber;

    public Lotto saveWinningLotto(Lotto winningLotto) {
        return this.winningLotto = winningLotto;
    }

    public Integer saveBonusNumber(String bonusNumber) {
        return this.bonusNumber = Integer.parseInt(bonusNumber);
    }
}