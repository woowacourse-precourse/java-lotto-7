package lotto.model;

import lotto.dto.CreateLottoInfo;
import lotto.dto.LottoRateInfo;

public class UserLottoInfo {
    private final Lottos lottos;
    private final Money purchaseAmount;
    private final RankingStatus rankingStatus;

    public UserLottoInfo(long purchaseAmount) {
        this.purchaseAmount = new Money(purchaseAmount);
        this.lottos = new Lottos(this.purchaseAmount.getThousandUnitCount());
        this.rankingStatus = new RankingStatus();
    }

    public CreateLottoInfo getUserLottos() {
        return lottos.getUserLottos();
    }

    public LottoRateInfo calculateReturnRate(WinningLotto winningLotto) {
        lottos.makeWinningInfo(winningLotto, rankingStatus);

        return null;
    }
}
