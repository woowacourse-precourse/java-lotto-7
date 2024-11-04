package lotto.service.prize;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.WinningNumbers;
import lotto.model.WinningStatistic;
import lotto.service.winningCheck.WinningCheckService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TotalPrizeCalculatorServiceImplTest {

    @Test
    @DisplayName("총 상금 계산 테스트")
    void calculateTotalPrizeTest() {
        // WinningCheckService를 임시 구현
        WinningCheckService mockWinningCheckService = (lotto, winningNumbers, winningStatistic) -> 5000;

        TotalPrizeCalculatorServiceImpl service = new TotalPrizeCalculatorServiceImpl(mockWinningCheckService);

        Lottos lottos = new Lottos(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))));

        WinningNumbers winningNumbers = new WinningNumbers(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        WinningStatistic winningStatistic = new WinningStatistic();

        int totalPrize = service.calculateTotalPrize(lottos, winningNumbers, winningStatistic);

        // 총 상금이 5000원인지 확인
        assertEquals(5000, totalPrize);

        // WinningStatistic이 null이 아닌지 확인
        assertNotNull(winningStatistic);
    }
}
