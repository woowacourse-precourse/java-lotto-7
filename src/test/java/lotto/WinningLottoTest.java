package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class WinningLottoTest {

    private WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        winningLotto = new WinningLotto(lotto, 7);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    @DisplayName("BonusNumber가 Lotto 숫자와 중복된다면 예외 발생")
    void WinningLotto_생성_시_중복_예외(int number) {
        assertThatThrownBy(() -> new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("6개 번호 일치")
    void match6Numbers() {
        // given
        List<Lotto> playerLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6))
        );

        // when
        Map<LottoPrize, Integer> result = winningLotto.getWinningResult(playerLottos);

        // then
        assertThat(result.get(LottoPrize.FIRST)).isEqualTo(1);
        assertThat(result.get(LottoPrize.SECOND)).isEqualTo(0);
        assertThat(result.get(LottoPrize.THIRD)).isEqualTo(0);
        assertThat(result.get(LottoPrize.FOURTH)).isEqualTo(0);
        assertThat(result.get(LottoPrize.FIFTH)).isEqualTo(0);
        assertThat(result.get(LottoPrize.NONE)).isEqualTo(0);
    }

    @Test
    @DisplayName("5개 번호 일치와 보너스 번호 일치")
    void match5NumbersAndBonus() {
        // given
        List<Lotto> playerLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 7))
        );

        // when
        Map<LottoPrize, Integer> result = winningLotto.getWinningResult(playerLottos);

        // then
        assertThat(result.get(LottoPrize.FIRST)).isEqualTo(0);
        assertThat(result.get(LottoPrize.SECOND)).isEqualTo(1);
        assertThat(result.get(LottoPrize.THIRD)).isEqualTo(0);
        assertThat(result.get(LottoPrize.FOURTH)).isEqualTo(0);
        assertThat(result.get(LottoPrize.FIFTH)).isEqualTo(0);
        assertThat(result.get(LottoPrize.NONE)).isEqualTo(0);
    }

    @Test
    @DisplayName("5개 번호 일치")
    void match5Numbers() {
        // given
        List<Lotto> playerLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 45))
        );

        // when
        Map<LottoPrize, Integer> result = winningLotto.getWinningResult(playerLottos);

        // then
        assertThat(result.get(LottoPrize.FIRST)).isEqualTo(0);
        assertThat(result.get(LottoPrize.SECOND)).isEqualTo(0);
        assertThat(result.get(LottoPrize.THIRD)).isEqualTo(1);
        assertThat(result.get(LottoPrize.FOURTH)).isEqualTo(0);
        assertThat(result.get(LottoPrize.FIFTH)).isEqualTo(0);
        assertThat(result.get(LottoPrize.NONE)).isEqualTo(0);
    }

    @Test
    @DisplayName("4개 번호 일치")
    void match4Numbers() {
        // given
        List<Lotto> playerLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 44, 45))
        );

        // when
        Map<LottoPrize, Integer> result = winningLotto.getWinningResult(playerLottos);

        // then
        assertThat(result.get(LottoPrize.FIRST)).isEqualTo(0);
        assertThat(result.get(LottoPrize.SECOND)).isEqualTo(0);
        assertThat(result.get(LottoPrize.THIRD)).isEqualTo(0);
        assertThat(result.get(LottoPrize.FOURTH)).isEqualTo(1);
        assertThat(result.get(LottoPrize.FIFTH)).isEqualTo(0);
        assertThat(result.get(LottoPrize.NONE)).isEqualTo(0);
    }

    @Test
    @DisplayName("3개 번호 일치")
    void match3Numbers() {
        // given
        List<Lotto> playerLottos = List.of(
                new Lotto(List.of(1, 2, 3, 43, 44, 45))
        );

        // when
        Map<LottoPrize, Integer> result = winningLotto.getWinningResult(playerLottos);

        // then
        assertThat(result.get(LottoPrize.FIRST)).isEqualTo(0);
        assertThat(result.get(LottoPrize.SECOND)).isEqualTo(0);
        assertThat(result.get(LottoPrize.THIRD)).isEqualTo(0);
        assertThat(result.get(LottoPrize.FOURTH)).isEqualTo(0);
        assertThat(result.get(LottoPrize.FIFTH)).isEqualTo(1);
        assertThat(result.get(LottoPrize.NONE)).isEqualTo(0);
    }

    @Test
    @DisplayName("여러 개의 로또 결과를 한번에 확인")
    void multipleResults() {
        // given
        List<Lotto> playerLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),  // 6개 일치
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),  // 5개 + 보너스
                new Lotto(List.of(1, 2, 3, 4, 5, 45)), // 5개 일치
                new Lotto(List.of(1, 2, 3, 4, 44, 45)), // 4개 일치
                new Lotto(List.of(30, 31, 32, 33, 34, 35)) // 0개 일치
        );

        // when
        Map<LottoPrize, Integer> result = winningLotto.getWinningResult(playerLottos);

        // then
        assertThat(result.get(LottoPrize.FIRST)).isEqualTo(1);
        assertThat(result.get(LottoPrize.SECOND)).isEqualTo(1);
        assertThat(result.get(LottoPrize.THIRD)).isEqualTo(1);
        assertThat(result.get(LottoPrize.FOURTH)).isEqualTo(1);
        assertThat(result.get(LottoPrize.FIFTH)).isEqualTo(0);
        assertThat(result.get(LottoPrize.NONE)).isEqualTo(1);
    }

}