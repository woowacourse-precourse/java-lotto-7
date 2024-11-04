package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import lotto.dto.BonusNumber;
import lotto.dto.WinningNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WinningResultTest {
    private WinningResult winningResult;

    @BeforeEach
    void setUp() {
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");
        BonusNumber bonusNumber = new BonusNumber("7");
        WinningNumbersCombinations winningCombinations = new WinningNumbersCombinations(winningNumbers, bonusNumber);

        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)); // 1등
        Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)); // 2등
        Lotto lotto3 = new Lotto(Arrays.asList(1, 2, 7, 8, 9, 10)); // 0등

        List<Lotto> lottoList = Arrays.asList(lotto1, lotto2, lotto3);
        Lottos lottos = new Lottos(lottoList);

        winningResult = new WinningResult(lottos, winningCombinations);
    }

    @Test
    void displayWinningResult_ShouldContainFirstPlaceCount() {
        String expectedOutput = "6개 일치 (2,000,000,000원) - 1개";
        assertThat(winningResult.displayWinningResult()).contains(expectedOutput);
    }

    @Test
    void calculateProfit() {
        long profit = winningResult.calculateProfit();
        assertThat(profit).isEqualTo(2_030_000_000L);
    }
}