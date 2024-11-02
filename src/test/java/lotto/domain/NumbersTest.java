package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
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

    @Test
    void countOfOverlappedTest() {
        Numbers numbers1 = Numbers.from(List.of(1, 2, 3, 4, 5, 6));
        Numbers numbers2 = Numbers.from(List.of(4, 5, 6, 7, 8, 9));
        int expected = 3;

        int actual = numbers1.countOfOverlapped(numbers2);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void containsTest_whenContainNumber_returnsTrue() {
        Numbers numbers = Numbers.from(List.of(1, 2, 3, 4, 5, 6));
        Number number = new Number(6);

        boolean actual = numbers.contains(number);

        assertThat(actual).isTrue();
    }

    @Test
    void containsTest_whenNotContainNumber_returnsFalse() {
        Numbers numbers = Numbers.from(List.of(1, 2, 3, 4, 5, 6));
        Number number = new Number(7);

        boolean actual = numbers.contains(number);

        assertThat(actual).isFalse();
    }
}
