package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.PrizeTier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PrizeCalculatorTest {

    private PrizeCalculator prizeCalculator;

    @BeforeEach
    void setUp() {
        prizeCalculator = new PrizeCalculator();
    }

    @Test
    @DisplayName("티켓의 당첨 결과 계산 테스트")
    void calculateResults_ShouldReturnPrizeResultsWithBonus() {
        // 당첨 번호와 보너스 번호 설정
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        // 테스트용
        List<Lotto> tickets = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),  // 1등
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),  // 2등 (보너스 번호)
                new Lotto(List.of(1, 2, 3, 4, 5, 8))   // 3등 (보너스 번호 X)
        );

        List<PrizeTier> results = prizeCalculator.calculateResults(tickets, winningLotto, bonusNumber);

        assertThat(results).containsExactly(
                PrizeTier.MATCH_SIX,
                PrizeTier.MATCH_FIVE_WITH_BONUS,
                PrizeTier.MATCH_FIVE
        );
    }

    @Test
    @DisplayName("올바른 수익률 계산 테스트")
    void calculateProfitRate_ShouldReturnCorrectProfitRate() {
        // 당첨 결과 생성
        int totalPrize = PrizeTier.MATCH_SIX.getPrizeAmount() +
                PrizeTier.MATCH_FIVE_WITH_BONUS.getPrizeAmount() +
                PrizeTier.MATCH_FIVE.getPrizeAmount();
        int purchaseAmount = 3000;

        // 수익률 계산
        double profitRate = prizeCalculator.calculateProfitRate(totalPrize, purchaseAmount);

        // 예상 수익률 계산
        double expectedProfitRate = (double) totalPrize / purchaseAmount * 100;

        assertThat(profitRate).isCloseTo(expectedProfitRate, within(0.01));
    }

}
