package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.dto.LottoResult;
import lotto.dto.RankCount;
import lotto.dto.RankCounts;
import lotto.dto.WinningLottoNumbers;
import lotto.util.enums.Rank;

public class LottoResultCalculator {

    public LottoResult calculateResult(Lottos lottos, WinningLottoNumbers winningLottoNumbers, int purchaseAmount) {
        Map<Rank, Integer> rankCountMap = initializeRankCountMap();
        List<Integer> winningNumbers = winningLottoNumbers.getWinningNumbers();
        int bonusNumber = winningLottoNumbers.getBonusNumber();
        updateRankCountMap(rankCountMap, lottos, winningNumbers, bonusNumber);

        RankCounts rankCounts = convertToRankCounts(rankCountMap, purchaseAmount);

        return new LottoResult(rankCounts, purchaseAmount);
    }

    private Map<Rank, Integer> initializeRankCountMap() {
        return Arrays.stream(Rank.values())
                .collect(Collectors.toMap(rank -> rank, rank -> 0, (a, b) -> b, () -> new EnumMap<>(Rank.class)));
    }

    private void updateRankCountMap(Map<Rank, Integer> rankCountMap, Lottos lottos, List<Integer> winningNumbers,
                                    int bonusNumber) {
        lottos.getLottos().stream()
                .map(lotto -> lotto.calculateRank(winningNumbers, bonusNumber))
                .forEach(rank -> rankCountMap.put(rank, rankCountMap.get(rank) + 1));
    }

    private RankCounts convertToRankCounts(Map<Rank, Integer> rankCountMap, int purchaseAmount) {
        List<RankCount> rankCountList = rankCountMap.entrySet().stream()
                .map(entry -> new RankCount(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
        return new RankCounts(rankCountList);
    }

    public BigDecimal calculateProfitRate(LottoResult lottoResult) {
        BigDecimal totalPrize = calculateTotalPrize(lottoResult.getRankCounts());
        BigDecimal purchaseAmount = BigDecimal.valueOf(lottoResult.getPurchaseAmount());

        return totalPrize
                .divide(purchaseAmount, 10, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(100))
                .setScale(1, RoundingMode.HALF_UP);
    }

    private BigDecimal calculateTotalPrize(RankCounts rankCounts) {
        return rankCounts.getRankCounts().stream()
                .map(rankCount -> BigDecimal.valueOf(rankCount.getRank().getPrize())
                        .multiply(BigDecimal.valueOf(rankCount.getCount())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
