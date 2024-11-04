package lotto.model;

import java.text.NumberFormat;
import java.util.EnumMap;
import java.util.Locale;
import java.util.Map;

public class WinningStatistic {
    private static final long MAX_INT_VALUE = (long) Integer.MAX_VALUE; // int의 최대값을 long으로 저장
    private final Map<PrizeTier, Integer> prizeCounts; // 각 등수별 당첨 횟수를 저장
    private final double profitRate;

    public WinningStatistic() {
        this.profitRate = -1; // -1은 수익률이 아직 세팅되지 않았음을 의미
        this.prizeCounts = new EnumMap<>(PrizeTier.class);
        for (PrizeTier tier : PrizeTier.values()) {
            prizeCounts.put(tier, 0); // 모든 등수의 초기값을 0으로 설정
        }
    }

    private WinningStatistic(Map<PrizeTier, Integer> prizeCounts, double profitRate) {
        this.prizeCounts = prizeCounts;
        this.profitRate = Math.round(profitRate * 100) / 100.0; // 소수점 둘째 자리에서 반올림
        validatePrizeAmount(); // 당첨 금액 검증
    }

    // 수익률와 기존 인스턴스를 기반으로 새로운 인스턴스를 생성
    public WinningStatistic createWithProfitRate(WinningStatistic statistic, double profitRate) {
        return new WinningStatistic(statistic.prizeCounts, profitRate);
    }

    public void addPrizeCount(PrizeTier tier) {
        prizeCounts.put(tier, prizeCounts.get(tier) + 1);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);

        for (PrizeTier tier : PrizeTier.values()) {
            String formattedPrize = numberFormat.format(tier.getPrizeAmount());
            if (tier == PrizeTier.SECOND) {
                result.append(String.format("5개 일치, 보너스 볼 일치 (%s원) - %d개\n",
                        formattedPrize, prizeCounts.getOrDefault(tier, 0)));
                continue;
            }
            result.append(String.format("%d개 일치 (%s원) - %d개\n",
                    tier.getMatchCount(), formattedPrize, prizeCounts.getOrDefault(tier, 0)));
        }
        result.append(String.format("총 수익률은 %.1f%%입니다.", profitRate));
        return result.toString();
    }

    // 당첨 금액이 int의 범위를 초과하는지 검증
    private void validatePrizeAmount() {
        long totalPrize = calculateTotalPrize();
        if (totalPrize > MAX_INT_VALUE) {
            throw new ArithmeticException("[ERROR] 당첨금액이 int의 범위 안에 있지 않습니다. 얼른 실제 로또를 사셔야합니다!");
        }
    }

    // 총 당첨 금액을 계산
    private long calculateTotalPrize() {
        long totalPrize = 0;
        for (PrizeTier tier : PrizeTier.values()) {
            totalPrize += (long) tier.getPrizeAmount() * prizeCounts.getOrDefault(tier, 0);
        }
        return totalPrize;
    }
}
