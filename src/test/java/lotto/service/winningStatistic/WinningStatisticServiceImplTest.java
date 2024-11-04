package lotto.service.winningStatistic;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.WinningNumbers;
import lotto.model.WinningStatistic;
import lotto.service.prize.TotalPrizeCalculatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningStatisticServiceImplTest {
    private WinningStatisticServiceImpl winningStatisticService;

    @BeforeEach
    void setUp() {
        TotalPrizeCalculatorService mockTotalPrizeCalculatorService = new TotalPrizeCalculatorService() {
            @Override
            public int calculateTotalPrize(Lottos lottos, WinningNumbers winningNumbers, WinningStatistic statistic) {
                return 5000;
            }
        };
        winningStatisticService = new WinningStatisticServiceImpl(mockTotalPrizeCalculatorService);
    }

    @Test
    @DisplayName("WinningStatistic 객체가 수익률을 포함해 올바르게 생성되는지 확인")
    void testCalculateWinningStatistic() {
        Lottos lottos = new Lottos(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))));
        WinningNumbers winningNumbers = new WinningNumbers(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        WinningStatistic result = winningStatisticService.calculateWinningStatistic(10000, lottos, winningNumbers);

        assertNotNull(result);

        String resultString = result.toString();
        assertTrue(resultString.contains("50.0%"));
    }
}
