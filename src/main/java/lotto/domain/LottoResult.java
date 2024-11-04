package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResult {

    private final List<LottoRank> lottoRanks;

    public LottoResult(List<LottoRank> lottoRanks) {
        this.lottoRanks = lottoRanks;
    }

    public Map<LottoRank, Long> calculateStatistics() {
        return lottoRanks.stream()
                .collect(Collectors.groupingBy(rank -> rank, Collectors.counting()));
    }

    public Double calculateProfit(Cost cost) {
        double sum = lottoRanks.stream()
                .mapToDouble(LottoRank::getPrize)
                .sum();
        return sum / cost.getLottoPurchasePrice() * 100;
    }

    public List<LottoRank> getLottoRanks() {
        return lottoRanks;
    }
}
