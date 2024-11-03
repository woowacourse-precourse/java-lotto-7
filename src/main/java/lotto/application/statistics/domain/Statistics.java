package lotto.application.statistics.domain;

import java.util.List;
import lotto.application.prize.domain.PrizeNumberResult;
import lotto.application.ticket.domain.ticket.Lotto;


public class Statistics {

    private final List<Lotto> lottos;
    private final PrizeNumberResult prizeNumber;
    private final RankCounter rankCounter;

    public Statistics(List<Lotto> lottos, PrizeNumberResult prizeNumber, RankCounter rankCounter) {
        this.lottos = lottos;
        this.prizeNumber = prizeNumber;
        this.rankCounter = rankCounter;
    }

    public static Statistics of(List<Lotto> lottos, PrizeNumberResult prizeNumber) {
        return new Statistics(
                lottos,
                prizeNumber,
                new RankCounter()
        );
    }

    public StatisticsResult compile() {
        compileRanks();
        return StatisticsResult.from(rankCounter);
    }

    private void compileRanks() {
        lottos.stream()
                .map(this::toRank)
                .forEach(rankCounter::add);
    }

    private Rank toRank(Lotto lotto) {
        int matchCount = countMatchNumbers(lotto);
        boolean matchBonus = hasMatchBonus(lotto);
        return Rank.valueOf(matchCount, matchBonus);
    }

    private int countMatchNumbers(Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(prizeNumber.getWinnerNumbers()::contains)
                .count();
    }

    private boolean hasMatchBonus(Lotto lotto) {
        return lotto.getNumbers().contains(prizeNumber.getBonusNumber());
    }


}
