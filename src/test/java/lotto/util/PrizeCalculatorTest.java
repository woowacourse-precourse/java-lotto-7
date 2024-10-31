package lotto.util;

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
        prizeCalculator.setBonusNumber(7);

        // 테스트용 티켓 리스트 생성
        List<Lotto> tickets = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),  // 1등
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),  // 2등 (보너스 번호 매칭)
                new Lotto(List.of(1, 2, 3, 4, 5, 8))   // 3등 (보너스 번호 미매칭)
        );

        // 결과 계산
        List<PrizeTier> results = prizeCalculator.calculateResults(tickets, winningLotto);

        // 기대하는 당첨 등급 확인
        assertThat(results).containsExactly(
                PrizeTier.FIRST,
                PrizeTier.SECOND,
                PrizeTier.THIRD
        );
    }

    @Test
    @DisplayName("올바른 수익률 계산 테스트")
    void calculateProfitRate_ShouldReturnCorrectProfitRate() {
        List<PrizeTier> prizeResults = List.of(
                PrizeTier.FIRST,
                PrizeTier.SECOND,
                PrizeTier.THIRD
        );
        int purchaseAmount = 3000;

        double profitRate = prizeCalculator.calculateProfitRate(prizeResults, purchaseAmount);

        // 기대 수익률 계산
        double expectedProfitRate = (PrizeTier.FIRST.getPrizeAmount() +
                PrizeTier.SECOND.getPrizeAmount() +
                PrizeTier.THIRD.getPrizeAmount()) / (double) purchaseAmount * 100;

        assertThat(profitRate).isCloseTo(expectedProfitRate, within(0.01));
    }
}
