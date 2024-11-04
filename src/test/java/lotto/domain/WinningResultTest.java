package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.dto.BonusNumber;
import lotto.dto.PurchaseAmount;
import lotto.dto.WinningNumbers;
import org.junit.jupiter.api.Test;

class WinningResultTest {
    private WinningResult winningResult;
    private Lottos lottos;

    void setUp() {
        // 로또 번호와 함께 Lottos 객체 생성
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))); // 1등
        lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7))); // 2등
        lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 4, 8, 9))); // 3등

        lottos = new Lottos(new PurchaseAmount("3000"));
        lottoList.forEach(lotto -> lottos.getLottos().add(lotto));

        // WinningNumbersCombinations 생성
        WinningNumbersCombinations winningCombinations = new WinningNumbersCombinations(
                new WinningNumbers("1,2,3,4,5,6"),
                new BonusNumber("7")
        );

        winningResult = new WinningResult(lottos, winningCombinations);
    }

    @Test
    void calculateProfit() {
        long profit = winningResult.calculateProfit();
        assertThat(profit).isEqualTo(1000000);
    }

    @Test
    void displayWinningResult() {
        String result = winningResult.displayWinningResult();
        assertThat(result).contains("1개 일치 (2,000,000원) - 1개");
        assertThat(result).contains("4개 일치 (50,000원) - 1개");
        assertThat(result).contains("3개 일치 (5,000원) - 1개");
    }
}