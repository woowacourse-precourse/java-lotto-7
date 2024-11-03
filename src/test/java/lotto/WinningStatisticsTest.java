package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningPrize;
import lotto.domain.WinningStatistics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningStatisticsTest {
    private WinningStatistics winningStatistics;
    private WinningPrize winningPrize;

    @BeforeEach
    void setUp() {
        winningStatistics = new WinningStatistics();
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        winningPrize = new WinningPrize(winningNumbers, bonusNumber);
    }

    @Test
    @DisplayName("총 수익률 계산 확인")
    void 총_수익률_계산_확인() {
        //given
        List<Lotto> purchasedLotto = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(4, 15, 16, 18, 20, 22)),
                new Lotto(Arrays.asList(11, 21, 31, 41, 15, 16))
        );
        winningStatistics.calculateCount(purchasedLotto, winningPrize);
        int purchaseAmount = 3 * 1000;

        //when
        double yield = winningStatistics.calculateTotalProfit(purchaseAmount);

        //then
        assertThat(yield).isEqualTo(66666666.7);
    }

    @Test
    @DisplayName("총 수익률 없음")
    void 총_수익률_없음() {
        //given
        List<Lotto> purchasedLotto = Arrays.asList(
                new Lotto(Arrays.asList(13, 14, 15, 16, 17, 18)),
                new Lotto(Arrays.asList(24, 25, 26, 38, 40, 42))
        );
        winningStatistics.calculateCount(purchasedLotto, winningPrize);
        int purchaseAmount = 2 * 1000;

        //when
        double yield = winningStatistics.calculateTotalProfit(purchaseAmount);

        //then
        assertThat(yield).isEqualTo(0.0);
    }
}
