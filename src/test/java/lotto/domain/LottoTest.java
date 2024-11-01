package lotto.domain;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성

    @ParameterizedTest
    @CsvSource(value = {"1, true", "2, true", "3, true", "4, true", "5, true", "6, true"})
    void 포함하고_있는_숫자인지_확인(int number, boolean excepted) {
        //given
        final Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        //when
        final boolean contains = lotto.contains(number);

        //then
        Assertions.assertThat(contains).isEqualTo(excepted);
    }

    @ParameterizedTest
    @MethodSource("provideTest")
    void 포함하고_있는_숫자의_개수_구하기(List<Integer> winningNumbers, int expected) {
        // given
        final Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when
        final int matchCount = lotto.getMatchCount(winningNumbers);

        // then
        Assertions.assertThat(matchCount).isEqualTo(expected);
    }

    private static Stream<Arguments> provideTest() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 6),
                Arguments.of(List.of(1, 2, 3, 4, 5, 7), 5),
                Arguments.of(List.of(1, 2, 3, 4, 7, 8), 4),
                Arguments.of(List.of(1, 2, 3, 7, 8, 9), 3),
                Arguments.of(List.of(1, 2, 7, 8, 9, 10), 2),
                Arguments.of(List.of(1, 7, 8, 9, 10, 11), 1),
                Arguments.of(List.of(7, 8, 9, 10, 11, 12), 0)
        );
    }
}
