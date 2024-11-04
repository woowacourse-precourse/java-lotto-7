package lotto.model.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import lotto.config.LottoRank;

public class LottoResult {
    private final Map<LottoRank, Integer> rankCounts; // 각 등수가 몇번 당첨됬는지를 저장하는 map

    public LottoResult() {
        this.rankCounts = new EnumMap<>(LottoRank.class); // LottoRank는 enum이므로 EnumMap을 사용함
        Arrays.stream(LottoRank.values()) // enum에 정의된 모든 상수를 배열로 반환
                .forEach(rank -> rankCounts.put(rank, 0)); // 발생 횟수를 0으로 초기화
    }

    public void addRank(LottoRank rank) {
        rankCounts.put(rank, rankCounts.get(rank) + 1);
    }

    //수익률 계산
    public double calculateProfitRate(int totalPurchaseAmount) {
        long totalPrize = Arrays.stream(LottoRank.values())
                .mapToLong(rank -> rank.getPrize() * rankCounts.get(rank)) // 각 상금별로 발생한 횟수만큼 곱합
                .sum();
        return (totalPrize * 100.0) / totalPurchaseAmount;
    }

    public Map<LottoRank, Integer> getRankCounts() {
        return Collections.unmodifiableMap(rankCounts); // 변환할 수 없게 반환
    }
}