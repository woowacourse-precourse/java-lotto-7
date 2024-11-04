package lotto.domain;

import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {
    @DisplayName("당첨 통계를 정확하게 계산한다")
    @Test
    void calculateResult() {
        // given
        WinningNumber winningNumber = new WinningNumber(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        
        List<Lotto> purchasedLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),  // 1등
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),  // 2등
                new Lotto(List.of(1, 2, 3, 4, 5, 8)),  // 3등
                new Lotto(List.of(1, 2, 3, 4, 7, 8)),  // 4등
                new Lotto(List.of(1, 2, 3, 7, 8, 9))   // 5등
        );

        // when
        Result Result = new Result(purchasedLottos, winningNumber);
        Map<Prize, Integer> results = Result.getResults();

        // then
        assertThat(results.get(Prize.FIRST)).isEqualTo(1);
        assertThat(results.get(Prize.SECOND)).isEqualTo(1);
        assertThat(results.get(Prize.THIRD)).isEqualTo(1);
        assertThat(results.get(Prize.FOURTH)).isEqualTo(1);
        assertThat(results.get(Prize.FIFTH)).isEqualTo(1);
    }

    @DisplayName("수익률을 정확하게 계산한다")
    @Test
    void calculateReturnRate() {
        // given
        WinningNumber WinningNumber = new WinningNumber(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        
        List<Lotto> purchasedLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),  // 1등: 2,000,000,000원
                new Lotto(List.of(1, 2, 3, 7, 8, 9))   // 5등: 5,000원
        );

        // when
        Result Result = new Result(purchasedLottos, WinningNumber);

        // then
        assertThat(Result.calculateReturnRate())
                .isEqualTo(100000250.0); // (2,000,005,000 / 2,000) * 100
    }
}