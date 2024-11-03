package lotto.domain.rank;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.LottoPrice;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.WinningLotto;

public class LottoRankPrices {

    private static final int BONUS_COUNT = 5;

    private final List<LottoRankPrice> lottoRankPrices;

    public LottoRankPrices(List<Lotto> lottos, WinningLotto winningLotto) {
        this.lottoRankPrices = createRanks(lottos, winningLotto);
    }

    public List<Integer> sortRanks() {
        List<Integer> sortedRanks = new ArrayList<>();

        for (LottoPrice price : LottoPrice.values()) {
            int rankCount = calculatePriceCount(price);
            sortedRanks.add(rankCount);
        }

        return sortedRanks;
    }

    public double sumLottoPrice() {
        return lottoRankPrices.stream()
                .mapToDouble(LottoRankPrice::getPrice)
                .sum();
    }

    private int calculatePriceCount(LottoPrice price) {
        return (int) lottoRankPrices.stream()
                .filter(rank -> price.isSameLottoPrice(rank.getPrice()))
                .count();
    }

    private List<LottoRankPrice> createRanks(List<Lotto> lottos, WinningLotto winningLotto) {
        List<LottoRankPrice> ranks = new ArrayList<>();

        for (Lotto lotto : lottos) {
            int winningCount = calculateWinningCount(winningLotto, lotto);
            boolean isBonus = isBonus(winningLotto, lotto, winningCount);
            ranks.add(new LottoRankPrice(winningCount, isBonus));
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
