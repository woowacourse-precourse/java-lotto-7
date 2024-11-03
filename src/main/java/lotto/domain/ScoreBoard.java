package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.constant.LottoRank;
import lotto.dto.LottoRateDto;
import lotto.dto.LottoResultDto;

public class ScoreBoard {
    private final List<Lotto> lottos;
    private final Winning winning;
    private final Map<LottoRank, Integer> rankCounts;
    private final int LOTTO_PRICE = 1000;

    public ScoreBoard(List<Lotto> lottos, Winning winning) {
        this.lottos = lottos;
        this.winning = winning;
        this.rankCounts = initRankCounts();
    }

    private void calculateRanks() {

        Map<LottoRank, Integer> calculatedRanks = lottos.stream()
                .map(lotto -> lotto.getRank(winning))
                .collect(Collectors.groupingBy(rank -> rank, Collectors.summingInt(rank -> 1)));

        rankCounts.putAll(calculatedRanks);

    }

    private Map<LottoRank, Integer> initRankCounts() {
        Map<LottoRank, Integer> rankCounts = new HashMap<>();

        for (LottoRank rank : LottoRank.values()) {
            rankCounts.put(rank, 0);
        }

        return rankCounts;
    }

    public List<LottoResultDto> returnStatistics() {
        calculateRanks();

        return rankCounts.entrySet().stream()
                .filter(this::isValidRank)
                .map(LottoResultDto::from)
                .toList();
    }

    private boolean isValidRank(Map.Entry<LottoRank, Integer> entry) {
        return entry.getKey() != LottoRank.NONE;
    }

    private double calculateRate() {
        int totalPrize = rankCounts.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();

        int totalSpent = lottos.size() * LOTTO_PRICE;
        return (double) totalPrize / totalSpent * 100;
    }

    public LottoRateDto getRate() {
        return LottoRateDto.from(calculateRate());
    }

}
