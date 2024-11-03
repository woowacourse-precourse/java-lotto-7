package lotto.model;

import lotto.dto.GeneratedLottoInfo;
import lotto.dto.WinningStatistics;

public class UserLottoInfo {
    private final Lottos lottos;
    private final Money purchaseAmount;
    private final RankingStatus rankingStatus;

    public UserLottoInfo(long purchaseAmount) {
        this.purchaseAmount = new Money(purchaseAmount);
        this.lottos = new Lottos(this.purchaseAmount.getThousandUnitCount());
        this.rankingStatus = new RankingStatus();
    }

    public GeneratedLottoInfo getUserLottos() {
        return lottos.getUserLottos();
    }

    public WinningStatistics getWinningStatistics(WinningLotto winningLotto) {
        lottos.makeWinningInfo(winningLotto, rankingStatus);

        long totalPrize = rankingStatus.getTotalPrize();

        String matchComment = rankingStatus.makeMatchComment();
        String returnRate = purchaseAmount.calculateReturnRate(totalPrize);

        return new WinningStatistics(matchComment, returnRate);
    }
}
