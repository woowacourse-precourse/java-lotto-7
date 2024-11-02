package lotto.domain.rank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.WinningLotto;

public class LottoRanks {

    private final List<LottoRank> lottoranks;

    public LottoRanks(List<Lotto> lottos, WinningLotto winningLotto) {
        this.lottoranks = createRanks(lottos, winningLotto);
    }

    public List<LottoRank> displayLottoRanks() {
        return Collections.unmodifiableList(lottoranks);
    }

    private List<LottoRank> createRanks(List<Lotto> lottos, WinningLotto winningLotto) {
        List<LottoRank> ranks = new ArrayList<>();

        for (Lotto lotto : lottos) {
            int winningCount = calculateWinningCount(winningLotto, lotto);
            boolean isBonus = winningLotto.isBonusNumber(lotto.displayLotto());
            ranks.add(new LottoRank(winningCount, isBonus));
        }

        return ranks;
    }

    private int calculateWinningCount(WinningLotto winningLotto, Lotto lotto) {
        return (int) lotto.displayLotto()
                .stream()
                .filter(winningLotto.displayLotto()::contains)
                .count();
    }
}
