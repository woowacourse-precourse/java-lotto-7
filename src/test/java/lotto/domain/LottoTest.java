package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개를 초과할 경우 예외가 발생한다.")
    @Test
    void numberCountExceedsLimit() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있을 경우 예외가 발생한다.")
    @Test
    void duplicateNumbers() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 6개 미만일 경우 예외가 발생한다.")
    @Test
    void numberCountBelowLimit() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 유효 범위(1~45)를 벗어날 경우 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource({"0", "46"})
    void numberOutOfRange(int invalidNumber) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, invalidNumber);

        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("유효한 로또 번호가 주어지면 예외가 발생하지 않는다.")
    @Test
    void validNumbers() {
        assertThatNoException().isThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6)));
    }
}
