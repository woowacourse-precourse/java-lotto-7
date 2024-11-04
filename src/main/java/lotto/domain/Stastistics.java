package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import lotto.domain.Lotto.Lotto;
import lotto.domain.Lotto.LottoNumber;
import lotto.domain.Lotto.Lottos;
import lotto.domain.Lotto.WinningLotto;
import lotto.dto.StatisticsDto;

public class Stastistics {
    private final static int INIT_VALUE = 0;
    private final static int MATCH_COUNT = 1;
    private final static int UNIT_PRICE = 1000;
    private final static int UNIT_PERCENTAGE = 100;
    private final EnumMap<Rank, Integer> rankStatistics;
    private final float profitRate;

    public Stastistics(Lottos randomLottos, WinningLotto winningLotto, int ticketCount) {
        this.rankStatistics = progressStatistics(randomLottos, winningLotto);
        this.profitRate = calculateProfitRate(ticketCount);
    }

    private EnumMap<Rank, Integer> progressStatistics(Lottos randomLottos, WinningLotto winningLotto) {
        EnumMap<Rank, Integer> rankStatistics = new EnumMap<>(Rank.class);

        for (Rank rank : Rank.values()) {
            rankStatistics.put(rank, INIT_VALUE);
        }

        randomLottos.getLottos().forEach(randomLotto -> {
            int matchCount = getMatchNumber(randomLotto, winningLotto);
            boolean hasBonus = hasSameNumber(randomLotto, winningLotto);
            Rank rank = Rank.matchLottoRank(matchCount, hasBonus);
            rankStatistics.put(rank, rankStatistics.get(rank) + MATCH_COUNT);
        });

        return rankStatistics;
    }

    private int getMatchNumber(Lotto randomLotto, WinningLotto winningLotto) {
        List<LottoNumber> winningLottoNumbers = winningLotto.getWinningLottoNum();
        List<LottoNumber> myLottoNumbers = randomLotto.getLottoNumbers();
        return (int) myLottoNumbers.stream()
                .filter(winningLottoNumbers::contains)
                .count();
    }

    private boolean hasSameNumber(Lotto randomLotto, WinningLotto winningLotto) {
        return randomLotto.getLottoNumbers().contains(winningLotto.getBonusNum());
    }

    public float calculateProfitRate(int ticketCount) {
        int totalPrize = rankStatistics.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();

        return ((float) totalPrize / (ticketCount * UNIT_PRICE) * UNIT_PERCENTAGE);
    }

    public StatisticsDto toDto() {
        return StatisticsDto.of(rankStatistics, profitRate);
    }
}
