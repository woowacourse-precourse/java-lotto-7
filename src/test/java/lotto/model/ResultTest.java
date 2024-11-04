package lotto.model;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultTest {

    @DisplayName("수익률을 올바르게 계산하는 지 확인")
    @Test
    void shouldReturnCorrectRateOfReturn() {
        Money money = new Money(1000);

        Lottos lottos = new Lottos(
                List.of(
                        new Lotto(List.of(4, 5, 6, 7, 8, 9)) // 5등
                )
        );

        WinningLotto winningLotto = new WinningLotto(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new BonusNumber(7)
        );

        Result result = new Result(money, lottos, winningLotto);
        Assertions.assertThat(result.getRateOfReturn())
                .isEqualTo(500);
    }
}