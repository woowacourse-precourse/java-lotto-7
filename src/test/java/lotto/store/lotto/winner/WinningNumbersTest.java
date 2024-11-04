package lotto.store.lotto.winner;

import lotto.store.lotto.Lotto;
import lotto.store.lotto.LottoNumber;
import lotto.store.lotto.winner.LottoRank;
import lotto.store.lotto.winner.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class WinningNumbersTest {
    @DisplayName("보너스 번호가 로또 번호와 중복되면 예외가 발생한다.")
    @Test
    void test1() {
        Lotto winningLotto = toLotto(1, 2, 3, 4, 5, 6);
        LottoNumber bonus = new LottoNumber(3);

        assertThatThrownBy(() -> new WinningNumbers(winningLotto, bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 규칙에 따라 등수 반환")
    @ParameterizedTest(name = "로또가 {1}일 때 Rank는 {2}")
    @MethodSource("rankOptions")
    void test2(WinningNumbers win, Lotto myLotto, LottoRank expected) {
        assertThat(win.rank(myLotto)).isEqualTo(expected);
    }

    static Stream<Arguments> rankOptions() {
        WinningNumbers win = new WinningNumbers(
                toLotto(1, 2, 3, 4, 5, 6), new LottoNumber(10)
        );

        return Stream.of(
                Arguments.arguments(win, toLotto(1, 2, 3, 4, 5, 6), LottoRank.FIRST),
                Arguments.arguments(win, toLotto(1, 2, 3, 4, 5, 10), LottoRank.SECOND),
                Arguments.arguments(win, toLotto(1, 2, 3, 4, 5, 45), LottoRank.THIRD),
                Arguments.arguments(win, toLotto(1, 2, 3, 4, 44, 45), LottoRank.FOURTH),
                Arguments.arguments(win, toLotto(1, 2, 3, 43, 44, 45), LottoRank.FIFTH),
                Arguments.arguments(win, toLotto(1, 2, 42, 43, 44, 45), LottoRank.FAIL)
        );
    }

    private static Lotto toLotto(int... numbers) {
        return new Lotto(toLottoNumbers(numbers));
    }


    private static List<LottoNumber> toLottoNumbers(int... numbers) {
        return Arrays.stream(numbers).boxed().map(LottoNumber::new).toList();
    }

}