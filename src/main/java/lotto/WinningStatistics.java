package lotto;

import java.util.List;

public class WinningStatistics {
    private List<Lotto> purchasedLottos;
    private Lotto winningLotto;
    private int bonusNumber;

    public WinningStatistics(List<Lotto> purchasedLottos, Lotto winningLotto, int bonusNumber) {
        this.purchasedLottos = purchasedLottos;
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }


}
