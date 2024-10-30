package lotto.service;

import lotto.domain.Wallet;
import lotto.domain.lottos.user.WinningLottos;

/**
 * 왜 써비스???
 * 두개의 객체를 가ㅣㅈ고 연산해야하기땜누에.
 * Wallet 안에서 하기에는 계산하는 로직 자체는 Wallet의 역할이 아니라고 판닫
 * 근데 그럼 get해와야하는데??
 * 수익률을 어디서 계산하지
 */
public class YieldCalculateService {
    private final Wallet wallet;
    private final WinningLottos winningLottos;

    public YieldCalculateService(Wallet wallet, WinningLottos winningLottos) {
        this.wallet = wallet;
        this.winningLottos = winningLottos;
    }

    public void calculateYield() {
        int totalPrizeMoney = winningLottos.getTotalWinningPrizeMoney();
        wallet.calculateRateOfReturn(totalPrizeMoney);
    }

}
