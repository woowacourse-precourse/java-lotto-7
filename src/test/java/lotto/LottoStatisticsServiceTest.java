package lotto;

import java.util.Collections;
import lotto.domain.model.Lotto;
import lotto.domain.model.PrizeCategory;
import lotto.domain.model.WinningNumbers;
import lotto.domain.service.LottoStatisticsService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoStatisticsServiceTest {

    @Test
    @DisplayName("당첨_횟수_계산_성공")
    void 당첨_횟수_계산_성공() {
        LottoStatisticsService statisticsService = new LottoStatisticsService();
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        List<Lotto> tickets;
        tickets = Collections.singletonList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));

        int[] prizeCounts = statisticsService.calculatePrizeCounts(tickets, winningNumbers);

        assertEquals(1, prizeCounts[PrizeCategory.FIRST.ordinal()]);
    }

    @Test
    @DisplayName("수익률_계산_성공")
    void 수익률_계산_성공() {
        LottoStatisticsService statisticsService = new LottoStatisticsService();
        int purchaseAmount = 5000;
        int totalPrize = 10000;

        double profitRate = statisticsService.calculateProfitRate(purchaseAmount, totalPrize);

        assertEquals(200.0, profitRate);
    }

    @Test
    @DisplayName("티켓이_없는_경우_수익률_0_계산")
    void 티켓이_없는_경우_수익률_0_계산() {
        LottoStatisticsService statisticsService = new LottoStatisticsService();
        int purchaseAmount = 5000;
        int totalPrize = 0;

        double profitRate = statisticsService.calculateProfitRate(purchaseAmount, totalPrize);

        assertEquals(0.0, profitRate);
    }

    @Test
    @DisplayName("다양한_당첨_등급이_포함된_통계_계산_확인")
    void 다양한_당첨_등급이_포함된_통계_계산_확인() {
        LottoStatisticsService statisticsService = new LottoStatisticsService();
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        List<Lotto> tickets = Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), // 1등
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)), // 2등
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)), // 3등
                new Lotto(Arrays.asList(1, 2, 3, 4, 8, 9))  // 4등
        );

        int[] prizeCounts = statisticsService.calculatePrizeCounts(tickets, winningNumbers);

        assertEquals(1, prizeCounts[PrizeCategory.FIRST.ordinal()]);
        assertEquals(1, prizeCounts[PrizeCategory.SECOND.ordinal()]);
        assertEquals(1, prizeCounts[PrizeCategory.THIRD.ordinal()]);
        assertEquals(1, prizeCounts[PrizeCategory.FOURTH.ordinal()]);
    }
}