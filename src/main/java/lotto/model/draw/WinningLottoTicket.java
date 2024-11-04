package lotto.model.draw;

import lotto.model.lotto.Lotto;

public class WinningLottoTicket {

    private final Lotto winningLotto;
    private final BonusNumber bonusNumber;

    private WinningLottoTicket(Lotto winningLotto, BonusNumber bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLottoTicket of(Lotto lotto, BonusNumber bonusNumber) {
        return new WinningLottoTicket(lotto, bonusNumber);
    }

    public boolean isContainBonusNumber(Lotto lotto) {
        return lotto.isContain(bonusNumber.getNumber());
    }

    public int countSameNumber(Lotto lotto) {
        return lotto.countSameNumber(winningLotto);
    }

    @Override
    public String toString() {
        return winningLotto.toString();
    }

}
