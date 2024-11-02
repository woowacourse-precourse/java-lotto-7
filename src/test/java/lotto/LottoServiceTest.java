package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.service.LottoService;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {

    private final LottoService lottoService = new LottoService();

    @Test
    void 당첨_통계를_올바르게_계산한다() {
        List<Lotto> userLottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9)),
                new Lotto(Arrays.asList(10, 11, 12, 13, 14, 15))
        );
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9));
        int bonusNumber = 10;

        Map<LottoRank, Integer> statistics = lottoService.calculateWinningStatistics(userLottos, winningLotto, bonusNumber);

        assertEquals(2, statistics.get(LottoRank.FIFTH));
        assertEquals(1, statistics.get(LottoRank.NONE));
    }

    @Test
    void 총_당첨금을_올바르게_계산한다() {
        Map<LottoRank, Integer> statistics = new HashMap<>();
        statistics.put(LottoRank.FIFTH, 1);
        statistics.put(LottoRank.FOURTH, 1);
        long expectedWinnings = LottoRank.FIFTH.getPrizeAmount() + LottoRank.FOURTH.getPrizeAmount();

        long totalWinnings = lottoService.calculateTotalWinnings(statistics);

        assertEquals(expectedWinnings, totalWinnings);
    }

    @Test
    void 수익률을_올바르게_계산한다() {
        long totalWinnings = 5000;
        int totalPurchaseAmount = 8000;

        double profitRate = lottoService.calculateProfitRate(totalWinnings, totalPurchaseAmount);

        assertEquals(62.5, profitRate);
    }
}
