package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> get() {
        return Collections.unmodifiableList(lottos);
    }

    public WinningResult getWinningResult(WinningNumbers winningNumbers) {
        final List<LottoRank> result = new ArrayList<>();
        for (final Lotto lotto : lottos) {
            final int matchCount = lotto.getMatchCount(winningNumbers.getNumbers());
            final boolean isBonus = lotto.contains(winningNumbers.getBonusNumber());

            final LottoRank lottoRank = LottoRank.get(matchCount, isBonus);
            result.add(lottoRank);
        }
        return new WinningResult(result);
    }
}
