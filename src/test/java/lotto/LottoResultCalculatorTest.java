package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class LottoResultCalculatorTest {
    @Test
    void 당첨_결과_계산_테스트() {
        List<Lotto> purchasedLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(8, 9, 10, 11, 12, 13))
        );

        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        LottoResult result = LottoResultCalculator.calculate(purchasedLottos, winningNumbers, bonusNumber);

        assertThat(result.getRankCounts().get(1)).isEqualTo(1); // 6개 일치
        assertThat(result.getRankCounts().get(2)).isEqualTo(1); // 5개 일치 + 보너스
        assertThat(result.getRankCounts().get(3)).isEqualTo(0); // 5개 일치
    }

    @Test
    void 수익률_계산_테스트() {
        LottoResult result = new LottoResult();
        result.addResult(6, false); // 1등

        double profitRate = result.calculateProfitRate(5000); // 구매 금액 5,000원
        assertThat(profitRate).isEqualTo(40000000.0); // 수익률
    }
}
