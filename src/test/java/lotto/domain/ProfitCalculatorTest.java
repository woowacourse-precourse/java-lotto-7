package lotto.domain;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProfitCalculatorTest {

    @DisplayName("구매 금액 대비 당첨 금액의 수익률을 계산한다.")
    @Test
    void 수익률_계산() {
        Money money = new Money(8000);
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);

        List<Lotto> lottos = List.of(
                new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                new Lotto(List.of(7, 11, 16, 35, 36, 44)),
                new Lotto(List.of(1, 8, 11, 31, 41, 42)),
                new Lotto(List.of(13, 14, 16, 38, 42, 45)),
                new Lotto(List.of(7, 11, 30, 40, 42, 43)),
                new Lotto(List.of(2, 13, 22, 32, 38, 45)),
                new Lotto(List.of(1, 3, 5, 14, 22, 45))
        );

        PrizeResult prizeResult = new PrizeResult(lottos, winningLotto);
        ProfitCalculator profitCalculator = new ProfitCalculator(money, prizeResult);

        double profitRate = profitCalculator.calculateProfitRatio();

        assertThat(profitRate).isEqualTo(62.5);
    }

    @DisplayName("수익률이 요구사항에 맞는 출력 형식으로 출력된다.")
    @Test
    void 출력형식_테스트() {
        double profitRate = 125.5;
        String formattedOutput = String.format("총 수익률은 %.1f%%입니다.", profitRate);

        assertThat(formattedOutput).isEqualTo("총 수익률은 125.5%입니다.");
    }
}
