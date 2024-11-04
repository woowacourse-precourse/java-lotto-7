package lotto.domain.winning;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import lotto.domain.lotto.Number;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class WinningLottoTest {

    private static final String ERROR_PREFIX = "[ERROR]";

    @DisplayName("객체 생성 테스트")
    @Test
    void 객체생성_테스트() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        WinningLotto winningLotto = WinningLotto.of(numbers);

        assertThat(winningLotto).isNotNull();
    }

    @DisplayName("중복 번호 존재 시 예외")
    @Test
    void 중복_번호_예외_테스트() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 5);

        assertThatThrownBy(() -> WinningLotto.of(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_PREFIX);
    }

    @DisplayName("1 ~ 45 사이 숫자 아닐 시 예외")
    @Test
    void 범위_벗어난_예외_테스트() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 90);

        assertThatThrownBy(() -> WinningLotto.of(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_PREFIX);
    }

    @DisplayName("음수 값이 올 경우 예외")
    @Test
    void 음수_값_예외_테스트() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, -1);

        assertThatThrownBy(() -> WinningLotto.of(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_PREFIX);
    }

    @DisplayName("6자리 숫자가 아닐 경우 예외")
    @Test
    void 여섯_자리_숫자_아닐_경우_예외_테스트() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        assertThatThrownBy(() -> WinningLotto.of(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_PREFIX);
    }

    @DisplayName("당첨 번호에 번호가 포함")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void 포함_테스트(int number) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        WinningLotto winningLotto = WinningLotto.of(numbers);

        assertThat(winningLotto.contains(Number.of(number))).isTrue();
    }

    @DisplayName("당첨 번호에 번호가 미포함")
    @ParameterizedTest
    @ValueSource(ints = {11, 12, 13})
    void 미포함_테스트(int number) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        WinningLotto winningLotto = WinningLotto.of(numbers);

        assertThat(winningLotto.contains(Number.of(number))).isFalse();
    }

    @DisplayName("contains 메서드 테스트")
    @ParameterizedTest
    @CsvSource({
            "1, true",
            "6, true",
            "9, false",
            "45, false"
    })
    void 오버로딩_된_포함_여부_테스트(int bonusNumber, boolean expected) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        WinningLotto winningLotto = WinningLotto.of(numbers);

        assertThat(winningLotto.contains(bonusNumber)).isEqualTo(expected);
    }
}
