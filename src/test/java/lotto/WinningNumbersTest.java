package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumbersTest {
    @DisplayName("당첨 번호 6개와 로또 번호를 비교하여 몇 개가 맞는지 센다.")
    @Test
    void test1() {
        Lotto lotto = Lotto.with((List.of(1, 2, 3, 4, 5, 6)));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);

        int matchCount = winningNumbers.countMatch(lotto);

        assertThat(matchCount).isEqualTo(6);
    }

    @DisplayName("보너스 번호가 로또 번호에 포함되어 있는지 확인한다.")
    @Test
    void test2() {
        Lotto lotto = Lotto.with((List.of(1, 2, 3, 4, 5, 6)));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);
        WinningNumbers winningNumbers2 = new WinningNumbers(List.of(1, 2, 3, 4, 5, 7), 6);

        boolean hasMatchNumber = winningNumbers.hasMatchNumber(lotto);
        boolean hasMatchNumber2 = winningNumbers2.hasMatchNumber(lotto);

        assertThat(hasMatchNumber).isFalse();
        assertThat(hasMatchNumber2).isTrue();
    }

    @DisplayName("당첨 번호와 로또 번호를 비교한 후 번호 일치 갯수에 따라 등수를 결정한다")
    @ParameterizedTest
    @MethodSource("generateData")
    void test3(List<Integer> numbers, Rank expected) {
        Lotto lotto = Lotto.with((numbers));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 9), 6);

        Rank rank = winningNumbers.judgeRank(lotto);

        assertThat(rank).isEqualTo(expected);
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 9), Rank.FIRST),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), Rank.SECOND),
                Arguments.of(List.of(1, 2, 3, 4, 5, 7), Rank.THIRD),
                Arguments.of(List.of(1, 2, 3, 4, 15, 16), Rank.FOURTH),
                Arguments.of(List.of(1, 2, 3, 14, 15, 16), Rank.FIFTH),
                Arguments.of(List.of(1, 2, 13, 14, 15, 16), Rank.NONE),
                Arguments.of(List.of(1, 12, 13, 14, 15, 16), Rank.NONE),
                Arguments.of(List.of(11, 12, 13, 14, 15, 16), Rank.NONE)
        );
    }

    @DisplayName("여러 개의 로또와 (당첨 번호 + 보너스 번호)를 비교하여 몇 등을 얼마나 했는지 알려준다.")
    @Test
    void test4() {
        List<Lotto> lottos = List.of(
                Lotto.with((List.of(1, 2, 3, 4, 5, 9))),
                Lotto.with((List.of(1, 2, 3, 4, 5, 6))),
                Lotto.with((List.of(1, 2, 3, 4, 5, 7))),
                Lotto.with((List.of(1, 2, 3, 4, 15, 16))),
                Lotto.with((List.of(1, 2, 3, 14, 15, 16))),
                Lotto.with((List.of(1, 2, 13, 14, 15, 16))),
                Lotto.with((List.of(1, 12, 13, 14, 15, 16))),
                Lotto.with((List.of(11, 12, 13, 14, 15, 16)))
        );
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 9), 6);

        Map<Rank, Integer> counts = winningNumbers.countRank(lottos);

        assertThat(counts).hasSize(6);
        assertThat(counts.get(Rank.FIRST)).isEqualTo(1);
        assertThat(counts.get(Rank.SECOND)).isEqualTo(1);
        assertThat(counts.get(Rank.THIRD)).isEqualTo(1);
        assertThat(counts.get(Rank.FOURTH)).isEqualTo(1);
        assertThat(counts.get(Rank.FIFTH)).isEqualTo(1);
        assertThat(counts.get(Rank.NONE)).isEqualTo(3);
    }

    @DisplayName("번호가 6개가 아니라면 예외를 반환한다.")
    @Test
    void testException1() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5), 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("번호는 1~45 사이가 아니라면 예외를 반환한다.")
    @Test
    void testException2() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 41, 51), 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("번호가 중복이 되면, 예외를 반환한다.")
    @Test
    void testException3() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 1, 3, 41, 51), 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호는 1~45 사이가 아니라면 예외를 반환한다.")
    @Test
    void testException4() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 71))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호 6개에 포함되는 값이라면 예외를 반환한다.")
    @Test
    void testException5() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
