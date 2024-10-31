package lotto.service;

import lotto.domain.Wallet;
import lotto.domain.lottos.user.WinningLotto;

public class YieldCalculateService {
    private final Wallet wallet;
    private final WinningLotto winningLotto;

    public YieldCalculateService(Wallet wallet, WinningLotto winningLotto) {
        this.wallet = wallet;
        this.winningLotto = winningLotto;
    }

    public void calculateRateOfReturn() {
        winningLotto.calculateRateOfReturn(wallet);
    }

}
