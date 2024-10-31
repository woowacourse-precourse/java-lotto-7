package lotto.entity;

import java.util.List;

public class LottoYieldCalculator {
    private final long totalInvestment; // 총 투자금액
    private long totalPrize; // 총 당첨금액

    public LottoYieldCalculator(long totalInvestment) {
        this.totalInvestment = totalInvestment;
        this.totalPrize = 0;
    }

    public void addPrize(long prize) {
        totalPrize += prize;
    }

    public double calculateYield() {
        if (totalInvestment == 0) {
            return 0.0; // 투자금액이 0일 경우 수익률 0.0 반환
        }
        return Math.round((double) totalPrize / totalInvestment * 10000) / 100.0; // 소수점 둘째 자리에서 반올림
    }
}
