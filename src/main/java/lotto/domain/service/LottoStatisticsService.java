package lotto.domain.service;

import lotto.domain.model.Lotto;
import lotto.domain.model.WinningNumbers;
import lotto.domain.model.PrizeCategory;
import java.util.List;

//로또 당첨 통계 및 수익률 계산을 담당하는 클래스
public class LottoStatisticsService {
    private final LottoPrizeService prizeService;

    public LottoStatisticsService() {
        this.prizeService = new LottoPrizeService();
    }

    /**
     * 각 당첨 등급별 당첨 횟수를 계산.
     *
     * @param tickets 구매한 로또 티켓 리스트
     * @param winningNumbers 당첨 번호
     * @return 당첨 등급별 횟수 배열
     */
    public int[] calculatePrizeCounts(List<Lotto> tickets, WinningNumbers winningNumbers) {
        int[] prizeCounts = new int[PrizeCategory.values().length];

        for (Lotto ticket : tickets) {
            PrizeCategory prize = prizeService.calculatePrize(ticket, winningNumbers);
            if (prize != null) {
                prizeCounts[prize.ordinal()]++;
            }
        }
        return prizeCounts;
    }

    /**
     * 총 상금을 계산.
     *
     * @param prizeCounts 당첨 횟수 배열
     * @return 총 상금
     */
    public int calculateTotalPrize(int[] prizeCounts) {
        int totalPrize = 0;
        for (PrizeCategory category : PrizeCategory.values()) {
            totalPrize += prizeCounts[category.ordinal()] * category.getPrize();
        }
        return totalPrize;
    }

    /**
     * 수익률을 계산.
     *
     * @param purchaseAmount 총 구매 금액
     * @param totalPrize 총 상금
     * @return 수익률
     */
    public double calculateProfitRate(int purchaseAmount, int totalPrize) {
        return Math.round(((double) totalPrize / purchaseAmount) * 1000) / 10.0;
    }
}