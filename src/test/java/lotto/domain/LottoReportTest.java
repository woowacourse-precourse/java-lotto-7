package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoReportTest {
    private static final int PURCHASE_AMOUNT = 8000; // 구매 금액
    private LottoReport lottoReport;

    @BeforeEach
    void init() {
        lottoReport = new LottoReport(PURCHASE_AMOUNT);
    }

    @DisplayName("로또 총 상금액 계산 테스트")
    @Test
    void calculateTotalPrizeTest() {
        lottoReport.updateReport(3, 0); // 3개 일치
        lottoReport.updateReport(4, 0); // 4개 일치
        lottoReport.updateReport(5, 1); // 5개 일치 + 보너스
        lottoReport.updateReport(6, 0); // 6개 일치

        long totalPrize = lottoReport.calculateTotalPrize();

        assertEquals(30000000 + 2000000000 + 5000 + 50000, totalPrize);
    }

    @Test
    void calculateReturnRate_테스트() {
        lottoReport.updateReport(4, 0); // 4개 일치
        lottoReport.updateReport(5, 0); // 5개 일치 + 보너스
        lottoReport.updateReport(6, 0); // 6개 일치
        lottoReport.updateReport(6, 0); // 6개 일치
        lottoReport.updateReport(6, 0); // 6개 일치

        double returnRate = lottoReport.calculateReturnRate();
        long totalPrize = (2000000000L * 3) + 50000 + 1500000;

        // 수익률 검증 (상금 총합 / 구매 금액 * 100)
        double expectedReturnRate = (totalPrize / (double)PURCHASE_AMOUNT) * 100;
        assertEquals(expectedReturnRate, returnRate, 0.001);
    }
}
