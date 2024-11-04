package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.Lottos;
import lotto.model.lottoprize.LottoPrizes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoPrizeCalculatorTest {
    public static final String SUM_OF_ALL_PRIZE_AMOUNT = "20315550.0";
    private LottoPrizes lottoPrizes;
    private LottoPrizeCalculator calculator;

    @BeforeEach
    public void 모든_등수의_로또_1개씩_당첨되었다고_가정() {
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = new WinningNumbers(winningLotto, "7");

        List<Lotto> testLottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 8, 9)),
                new Lotto(Arrays.asList(1, 2, 3, 10, 11, 12))
        );

        Lottos lottos = new Lottos(testLottos);

        this.lottoPrizes = new LottoPrizes(lottos, winningNumbers);
        this.calculator = new LottoPrizeCalculator(lottoPrizes);
    }

    @DisplayName("당첨 통계를 생성할 때 정확한 통계를 반환해야한다")
    @Test
    public void 당첨_통계를_생성할_때_정확한_통계를_반환해야한다() {
        List<String> expectedStatistics = Arrays.asList(
                "3개 일치 (5,000원) - 1개",
                "4개 일치 (50,000원) - 1개",
                "5개 일치 (1,500,000원) - 1개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                "6개 일치 (2,000,000,000원) - 1개"
        );

        List<String> actualStatistics = calculator.generateMatchStatistics();

        assertEquals(expectedStatistics.size(), actualStatistics.size());
        for (int i = 0; i < expectedStatistics.size(); i++) {
            assertEquals(expectedStatistics.get(i), actualStatistics.get(i));
        }
    }

    @DisplayName("수익률을 계산할 때 정확한 수익률을 반환해야한다")
    @Test
    public void 수익률을_계산할_때_정확한_수익률을_반환해야한다() {
        int purchaseAmount = 10000;

        String actualYield = calculator.calculateYield(purchaseAmount);

        assertEquals(SUM_OF_ALL_PRIZE_AMOUNT, actualYield);
    }
}
