package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class Lottery {
    private final PurchaseLotto purchaseLotto;
    private final WinningNumber winningNumber;
    private final BonusNumber bonusNumber;

    public Lottery(PurchaseLotto purchaseLotto, WinningNumber winningNumber, BonusNumber bonusNumber) {
        this.purchaseLotto = purchaseLotto;
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public LottoResult createLottoResult() {
        Map<Rank, Integer> result = new EnumMap<>(Rank.class);
        countRank(result);
        return new LottoResult(result, purchaseLotto.getLottoCount());
    }

    private void countRank(Map<Rank, Integer> result) {
        purchaseLotto.getTickets().stream()
                .map(lotto -> Rank.findMatchesRankCount(winningNumber, bonusNumber, lotto))
                .forEach(rank -> increaseRankCount(result, rank));
    }

    private void increaseRankCount(Map<Rank, Integer> result, Rank rank) {
        result.put(rank, result.getOrDefault(rank, 0) + 1);
    }
}
