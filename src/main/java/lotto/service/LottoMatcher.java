package lotto.service;

import java.util.List;
import lotto.constants.WinRank;
import lotto.domain.Lotto;
import lotto.domain.WinLotto;

public class LottoMatcher {
    private final List<Lotto> lotties;
    private final WinLotto winLotto;

    public LottoMatcher(List<Lotto> lotties, WinLotto winLotto) {
        this.lotties = lotties;
        this.winLotto = winLotto;
    }

    public void matchLotties() {
        lotties.forEach(lotto -> lotto.matchWinLotto(winLotto));
    }

    public long getResult(WinRank winRank) {
        return lotties.stream()
                .map(Lotto::getRank)
                .filter(rank -> rank == winRank)
                .count();
    }
}
