package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import lotto.domain.Lotto.Lotto;
import lotto.dto.StatisticsDto;

public class Stastistics {
    private final EnumMap<Rank, Integer> rankStatistics;
    private final float profitRate;

    public Stastistics(Lottos randomLottos, WinningLotto winningLotto, int ticketCount) {
        this.rankStatistics = progressStatistics(randomLottos, winningLotto);
        this.profitRate = calculateProfitRate(ticketCount);
    }

    private EnumMap<Rank, Integer> progressStatistics(Lottos randomLottos, WinningLotto winningLotto) {
        EnumMap<Rank, Integer> rankStatistics = new EnumMap<>(Rank.class);

        for (Rank rank : Rank.values()) {
            rankStatistics.put(rank, 0);
        }

        randomLottos.getLottos().forEach(randomLotto -> {
            int matchCount = getMatchNumber(randomLotto, winningLotto);
            boolean hasBonus = hasSameNumber(randomLotto, winningLotto);
            Rank rank = Rank.matchLottoRank(matchCount, hasBonus);
            rankStatistics.put(rank, rankStatistics.get(rank) + 1);
        });

        return rankStatistics;
    }

    private int getMatchNumber(Lotto randomLotto, WinningLotto winningLotto) {
        List<Number> winningNumbers = winningLotto.getWinningLottoNum();
        List<Number> myNumbers = randomLotto.getLottoNumbers();
        return (int) myNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private boolean hasSameNumber(Lotto randomLotto, WinningLotto winningLotto) {
        return randomLotto.getLottoNumbers().contains(winningLotto.getBonusNum());
    }

    public float calculateProfitRate(int ticketCount) {
        int totalPrize = rankStatistics.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();

        return ((float) totalPrize / (ticketCount * 1000) * 100);
    }

    public StatisticsDto toDto() {
        return StatisticsDto.of(rankStatistics, profitRate);
    }
}
