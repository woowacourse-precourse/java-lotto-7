package lotto;

import java.util.Arrays;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;

/*
* 로또 결과를 저장하고 처리하는 클래스
* 로또 당첨이 됐는지 확인하여 당첨 통계를 내고, 수익률을 계산한다.*/
public class LottoResult {
    private final Map<Rank, Integer> rankCount;

    public LottoResult() {
        this.rankCount = new EnumMap<>(Rank.class);
        initRankCount();
    }

    public void addMatching(Rank rank) {
        rankCount.put(rank, rankCount.get(rank) + 1);
    }

    public String getWinningStatistics() {
        return Arrays.stream(Rank.values())
                .filter(Rank::isWinning)
                .sorted(Comparator.comparing(rank -> rank.ordinal(), Comparator.reverseOrder()))
                .map(rank -> rank.getWinningResult(rankCount.get(rank)))
                .collect(Collectors.joining("\n"));
    }

    public double calculateProfitRate(int purchaseAmount) {
        long totalPrize = Arrays.stream(Rank.values())
                .mapToLong(rank -> rank.calculatePrize(rankCount.get(rank)))
                .sum();

        return ((double) totalPrize / purchaseAmount) * 100;
    }

    private void initRankCount() {
        Arrays.stream(Rank.values())
                .forEach(rank -> rankCount.put(rank, 0));
    }

}
