package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class NumbersTest {

    @Test
    void validateTest_whenSizeIsOverBound_throwException() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);

        assertThatThrownBy(() -> Numbers.from(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자는 총 6개 이어야 합니다");
    }

    @Test
    void validateTest_whenSizeIsUnderBound_throwException() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        assertThatThrownBy(() -> Numbers.from(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자는 총 6개 이어야 합니다");
    }

    @Test
    void validateTest_whenSizeIsSuitable() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        assertThatCode(() -> Numbers.from(numbers))
                .doesNotThrowAnyException();
    }

    @Test
    void validateTest_whenNumberIsOverlapped_throwException() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 5);

        assertThatThrownBy(() -> Numbers.from(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자는 중복되지 않아야 합니다");
    }

    @Test
    void validateTest_whenNumberIsNotOverlapped() {
        List<Integer> numbers = List.of(2, 3, 4, 5, 6, 7);

        assertThatCode(() -> Numbers.from(numbers))
                .doesNotThrowAnyException();
    }
}
