package lotto.service;

import lotto.model.Rank;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoServiceTest {
    private final LottoService lottoService = new LottoService();

    @Test
    void 총_당첨금_계산_테스트() {
        Map<Rank, Integer> results = new HashMap<>();
        results.put(Rank.FIRST, 1);    // 1등 1개
        results.put(Rank.SECOND, 2);   // 2등 2개
        results.put(Rank.THIRD, 0);    // 3등 없음
        results.put(Rank.FOURTH, 3);   // 4등 3개
        results.put(Rank.FIFTH, 5);    // 5등 5개

        int totalPrize = lottoService.calculateTotalPrize(results);
        assertEquals(2_000_000_000 + 2 * 30_000_000 + 3 * 50_000 + 5 * 5_000, totalPrize);
    }

    @Test
    void 수익률_계산_테스트() {
        int totalPrize = 1_500_000;  // 당첨금 1,500,000원
        int purchaseAmount = 5_000_000; // 구입 금액 5,000,000원

        double profitRate = lottoService.calculateProfitRate(totalPrize, purchaseAmount);
        assertEquals(30.0, profitRate, 0.1); // 예상 수익률 30.0%
    }

    @Test
    void 구입금액이_잘못된_케이스_테스트() {
        int invalidAmount = 1500; // 1000원 단위가 아님
        assertThrows(IllegalArgumentException.class, () -> lottoService.validateAmount(invalidAmount));
    }

    @Test
    void 잘못된_당첨번호_입력_테스트() {
        List<Integer> invalidWinningNumbers = List.of(1, 1, 2, 3, 4, 5); // 중복된 번호
        assertThrows(IllegalArgumentException.class, () -> lottoService.validateWinningNumbers(invalidWinningNumbers));
    }
}
