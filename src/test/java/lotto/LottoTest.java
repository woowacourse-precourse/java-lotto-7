package lotto;

import static lotto.exception.ErrorMessage.INVALID_LOTTO_COUNTS;
import static lotto.exception.ErrorMessage.INVALID_LOTTO_RANGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

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

    @ParameterizedTest
    @MethodSource
    @DisplayName("로또 번호가 6개가 아닌 경우 예외가 발생한다.")
    void failMakeLottoWhenDoesNotHaveSixNumbers(List<Integer> numbers) {
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_LOTTO_COUNTS.getMessage());
    }

    static Stream<List<Integer>> failMakeLottoWhenDoesNotHaveSixNumbers() {
        return Stream.of(
                List.of(1),
                List.of(1, 2),
                List.of(1, 2, 3),
                List.of(1, 2, 3, 4),
                List.of(1, 2, 3, 4, 5),
                List.of(1, 2, 3, 4, 5, 6, 7)
        );
    }

    @Test
    @DisplayName("로또 번호가 1부터 45 사이가 아니면 예외가 발생한다.")
    void failMakeLottoWhenInvalidRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 123, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_LOTTO_RANGE.getMessage());
    }

    @Test
    @DisplayName("정상적인 숫자들에 대해서는 정상적으로 Lotto 객체가 생성된다.")
    void successMakeLotto() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        // when & then
        assertDoesNotThrow(() -> new Lotto(numbers));
    }

    @Test
    @DisplayName("숫자들을 조회하면 오름차순으로 정렬이 되어있어야한다.")
    void getSortedNumbers() {
        // given
        List<Integer> numbers = List.of(6, 1, 44, 2, 10, 7);
        Lotto lotto = new Lotto(numbers);
        // when
        List<Integer> sortedNumbers = lotto.getSortedNumbers();
        // then
        assertThat(sortedNumbers).isSorted();
        assertThat(sortedNumbers).containsExactly(1, 2, 6, 7, 10, 44);
    }
}

