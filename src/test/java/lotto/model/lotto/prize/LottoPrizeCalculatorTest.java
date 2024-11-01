package lotto.model.lotto.prize;

import lotto.model.lotto.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPrizeCalculatorTest {

    private List<Lotto> lottos;
    private Lotto winningLotto;
    private int bonusNumber;

    @BeforeEach
    void init() {
        lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 8))
        );
        winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        bonusNumber = 7;
    }

    @Test
    void 총_상금을_계산한다() {
        LottoPrizeCalculator calculator = new LottoPrizeCalculator(lottos, winningLotto, bonusNumber);

        Long expectedTotalPrize = LottoPrizeInfo.FIRST_PRIZE.getPrizeAmount() +
                LottoPrizeInfo.SECOND_PRIZE.getPrizeAmount() +
                LottoPrizeInfo.THIRD_PRIZE.getPrizeAmount();

        Long actualTotalPrize = calculator.calculateTotalPrize();

        assertThat(actualTotalPrize).isEqualTo(expectedTotalPrize);
    }

    @Test
    void 수익률을_계산한다() {
        long purchaseAmount = 3000L;

        LottoPrizeCalculator calculator = new LottoPrizeCalculator(lottos, winningLotto, bonusNumber);

        Long expectedTotalPrize = LottoPrizeInfo.FIRST_PRIZE.getPrizeAmount() +
                LottoPrizeInfo.SECOND_PRIZE.getPrizeAmount() +
                LottoPrizeInfo.THIRD_PRIZE.getPrizeAmount();

        double expectedProfitRate = ((double) expectedTotalPrize / purchaseAmount) * LottoPrizeCalculator.PERCENT;

        Double actualProfitRate = calculator.calculateProfitRate(purchaseAmount);

        assertThat(actualProfitRate).isEqualTo(expectedProfitRate);
    }
}
