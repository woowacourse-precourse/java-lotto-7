package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningResultTest {
    @Test
    @DisplayName("보너스 번호가 범위를 벗어나면 예외가 발생한다")
    void validateBonusNumberRange() {
        // given
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        // when & then
        assertAll(
                () -> assertThatThrownBy(() -> new WinningResult(winningLotto, 0))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("1부터 45 사이"),
                () -> assertThatThrownBy(() -> new WinningResult(winningLotto, 46))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("1부터 45 사이")
        );
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다")
    void validateBonusNumberDuplicate() {
        // given
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        // when & then
        assertThatThrownBy(() -> new WinningResult(winningLotto, 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복될 수 없습니다");
    }

    @Test
    @DisplayName("당첨 번호와 보너스 번호를 기반으로 등수를 정확히 계산한다")
    void calculatePrize() {
        // given
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningResult winningResult = new WinningResult(winningLotto, 7);

        // when & then
        assertAll(
                () -> assertThat(winningResult.calculatePrize(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)))).isEqualTo(Prize.FIRST),
                () -> assertThat(winningResult.calculatePrize(
                        new Lotto(List.of(1, 2, 3, 4, 5, 7)))).isEqualTo(Prize.SECOND),
                () -> assertThat(winningResult.calculatePrize(
                        new Lotto(List.of(1, 2, 3, 4, 5, 8)))).isEqualTo(Prize.THIRD),
                () -> assertThat(winningResult.calculatePrize(
                        new Lotto(List.of(1, 2, 3, 4, 8, 9)))).isEqualTo(Prize.FOURTH),
                () -> assertThat(winningResult.calculatePrize(
                        new Lotto(List.of(1, 2, 3, 8, 9, 10)))).isEqualTo(Prize.FIFTH),
                () -> assertThat(winningResult.calculatePrize(
                        new Lotto(List.of(1, 2, 8, 9, 10, 11)))).isEqualTo(Prize.NONE)
        );
    }

    @Test
    @DisplayName("여러 장의 로또에 대한 당첨 통계를 계산한다")
    void calculateResults() {
        // given
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningResult winningResult = new WinningResult(winningLotto, 7);

        List<Lotto> lottoList = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),  // 1등
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),  // 2등
                new Lotto(Arrays.asList(1, 2, 3, 8, 9, 10))  // 5등
        );
        Lottos lottos = new Lottos(lottoList);

        // when
        Map<Prize, Integer> results = winningResult.calculateResult(lottos);

        // then
        assertAll(
                () -> assertThat(results.get(Prize.FIRST)).isEqualTo(1),
                () -> assertThat(results.get(Prize.SECOND)).isEqualTo(1),
                () -> assertThat(results.get(Prize.THIRD)).isEqualTo(0),
                () -> assertThat(results.get(Prize.FOURTH)).isEqualTo(0),
                () -> assertThat(results.get(Prize.FIFTH)).isEqualTo(1)
        );
    }

    @Test
    @DisplayName("수익률을 정확히 계산한다")
    void calculateReturnRate() {
        // given
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningResult winningResult = new WinningResult(winningLotto, 7);

        List<Lotto> lottoList = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),  // 1등: 2,000,000,000원
                new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12))  // 낙첨: 0원
        );
        Lottos lottos = new Lottos(lottoList);

        double returnRate = winningResult.calculateReturnRate(lottos);

        // then
        // 총 구매금액: 2,000원, 총 당첨금액: 2,000,000,000원
        // 수익률: (2,000,000,000 / 2,000) * 100 = 100,000,000%
        assertThat(returnRate).isEqualTo(100_000_000.0);
    }

    private void assertReturnRate(WinningResult winningResult, List<Lotto> lottoList, double expectedRate) {
        Lottos lottos = new Lottos(lottoList);
        double actualRate = winningResult.calculateReturnRate(lottos);
        assertThat(actualRate).isEqualTo(expectedRate);
    }

    @Test
    @DisplayName("수익률 계산시 소수점 둘째자리에서 반올림한다")
    void returnRateRoundingTest() {
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningResult winningResult = new WinningResult(winningLotto, 7);

        // 셋째자리가 4 이하인 경우 (내림)
        assertReturnRate(winningResult,
                Arrays.asList(
                        new Lotto(Arrays.asList(1, 2, 3, 40, 41, 42))  // 5등: 5,000원
                ),
                500.0  // 정확히 500%
        );

        // 셋째자리가 5 이상인 경우 (올림)
        assertReturnRate(winningResult,
                Arrays.asList(
                        new Lotto(Arrays.asList(1, 2, 3, 40, 41, 42)),  // 5등: 5,000원
                        new Lotto(Arrays.asList(1, 2, 3, 43, 44, 45)),  // 5등: 5,000원
                        new Lotto(Arrays.asList(40, 41, 42, 43, 44, 45))  // 낙첨
                ),
                333.3  // 333.333...% -> 333.3%로 반올림
        );
    }
}
