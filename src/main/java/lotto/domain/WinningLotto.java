package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {

    private final Lotto winnigNumber;
    private final int bonusNumber;

    public WinningLotto(Lotto winnigNumber, int bonusNumber) {
        this.winnigNumber = winnigNumber;
        this.bonusNumber = bonusNumber;
    }

    public List<Ranking> getWinningResult(List<Lotto> issuedLottos) {
        List<Ranking> rankings = new ArrayList<>();
        for (Lotto issuedLotto : issuedLottos) {
            int count = issuedLotto.countMatching(winnigNumber);
            boolean hasBonus = issuedLotto.contains(bonusNumber);
            Ranking rank = Ranking.calcRank(count, hasBonus);
            rankings.add(rank);
        }
        return rankings;
    }

}
