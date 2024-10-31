package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import lotto.domain.lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {

    private static final String ERROR_PREFIX = "[ERROR]";

    @DisplayName("객체 생성 테스트")
    @Test
    void 객체생성_테스트() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        WinningNumbers winningNumbers = WinningNumbers.of(Lotto.of(numbers));

        assertThat(winningNumbers).isNotNull();
    }

    @DisplayName("중복 번호 존재 시 예외")
    @Test
    void 중복_번호_예외_테스트() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 5);

        assertThatThrownBy(() -> WinningNumbers.of(Lotto.of(numbers)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_PREFIX);
    }

    @DisplayName("1 ~ 45 사이 숫자 아닐 시 예외")
    @Test
    void 범위_벗어난_예외_테스트() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 90);

        assertThatThrownBy(() -> WinningNumbers.of(Lotto.of(numbers)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_PREFIX);
    }

    @DisplayName("음수 값이 올 경우 예외")
    @Test
    void 음수_값_예외_테스트() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, -1);

        assertThatThrownBy(() -> WinningNumbers.of(Lotto.of(numbers)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_PREFIX);
    }

    @DisplayName("6자리 숫자가 아닐 경우 예외")
    @Test
    void 여섯_자리_숫자_아닐_경우_예외_테스트() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        assertThatThrownBy(() -> WinningNumbers.of(Lotto.of(numbers)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_PREFIX);
    }
}
