package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import lotto.domain.vo.LottoRank;

public class PurchasedLottos {
    private final List<Lotto> lottos;

    private PurchasedLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static PurchasedLottos of(List<Lotto> lottos) {
        return new PurchasedLottos(lottos);
    }

    public List<Lotto> getLottosAsUnmodifiableList() {
        return Collections.unmodifiableList(lottos); // unmodifiableList 반환
    }

    public EnumMap<LottoRank, Integer> calculateRankCounts(WinningLotto winningLotto) {
        EnumMap<LottoRank, Integer> rankCounts = initializeRankCounts();

        lottos.forEach(lotto -> updateRankCounts(rankCounts, winningLotto, lotto));

        return rankCounts;
    }

    private EnumMap<LottoRank, Integer> initializeRankCounts() {
        EnumMap<LottoRank, Integer> rankCounts = new EnumMap<>(LottoRank.class);
        Arrays.stream(LottoRank.values())
                .forEach(rank -> rankCounts.put(rank, 0));
        return rankCounts;
    }

    private void updateRankCounts(
            EnumMap<LottoRank, Integer> rankCounts,
            WinningLotto winningLotto,
            Lotto lotto
    ) {
        LottoRank rank = LottoRank.of(
                winningLotto.getCountMatchedNumber(lotto),
                winningLotto.checkBonusNumberMatched(lotto)
        );
        rankCounts.put(rank, rankCounts.get(rank) + 1);
    }
}
