package lotto.domain.rank;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.LottoPrice;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.WinningLotto;

public class LottoRanks {

    private static final int BONUS_COUNT = 5;

    private final List<LottoRank> lottoRanks;

    public LottoRanks(List<Lotto> lottos, WinningLotto winningLotto) {
        this.lottoRanks = createRanks(lottos, winningLotto);
    }

    public List<Integer> provideSortedRankCounts() {
        List<Integer> sortedRanks = new ArrayList<>();

        for (LottoPrice price : LottoPrice.values()) {
            int rankCount = calculatePriceCount(price);
            sortedRanks.add(rankCount);
        }

        return sortedRanks;
    }

    public double sumLottoPrice() {
        return lottoRanks.stream()
                .mapToDouble(LottoRank::getPrice)
                .sum();
    }

    private int calculatePriceCount(LottoPrice price) {
        return (int) lottoRanks.stream()
                .filter(rank -> price.isSameLottoPrice(rank.getPrice()))
                .count();
    }

    private List<LottoRank> createRanks(List<Lotto> lottos, WinningLotto winningLotto) {
        List<LottoRank> ranks = new ArrayList<>();

        for (Lotto lotto : lottos) {
            int winningCount = calculateWinningCount(winningLotto, lotto);
            boolean isBonus = isBonus(winningLotto, lotto, winningCount);
            ranks.add(new LottoRank(winningCount, isBonus));
        }

        return ranks;
    }

    private boolean isBonus(WinningLotto winningLotto, Lotto lotto, int winningCount) {
        return (winningCount == BONUS_COUNT)
                && winningLotto.isBonusNumber(lotto.displayLotto());
    }

    private int calculateWinningCount(WinningLotto winningLotto, Lotto lotto) {
        return (int) lotto.displayLotto()
                .stream()
                .filter(winningLotto.displayLotto()::contains)
                .count();
    }
}
