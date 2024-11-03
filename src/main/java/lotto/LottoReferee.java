package lotto;

import java.util.List;

public class LottoReferee {

    private final LottoManager lottoManager;

    public LottoReferee(final LottoManager lottoManager) {
        this.lottoManager = lottoManager;
    }

    public void judgeWinning() {
        final List<WinningStatus> winningStatuses = lottoManager.compareWinningLotto();
        final List<WinningRank> winningRanks = winningStatuses.stream()
                .map(WinningStatus::getWinningRank)
                .toList();
    }
}
