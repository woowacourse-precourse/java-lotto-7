package lotto.model;

import lotto.dto.GeneratedUserLotto;
import lotto.dto.WinningStatistics;

public class UserLottoInfo {
    private final Lottos userLotto;
    private final Money purchaseAmount;
    private final RankingStatus rankingStatus;

    public UserLottoInfo(long purchaseAmount) {
        this.purchaseAmount = new Money(purchaseAmount);
        this.userLotto = new Lottos(this.purchaseAmount.getThousandUnitCount());
        this.rankingStatus = new RankingStatus();
    }

    public GeneratedUserLotto getUserLottos() {
        return userLotto.getUserLottos();
    }

    public WinningStatistics getWinningStatistics(WinningLotto winningLotto) {
        userLotto.calculateUserLottoResults(winningLotto, rankingStatus);

        return new WinningStatistics(
                rankingStatus.makeMatchComment(),
                purchaseAmount.calculateReturnRate(rankingStatus.getTotalPrize())
        );
    }
}
