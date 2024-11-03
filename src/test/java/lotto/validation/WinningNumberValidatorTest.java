package lotto.validation;

import java.util.Collections;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumberValidatorTest {

    private final WinningNumberValidator validator = new WinningNumberValidator();

    @Test
    @DisplayName("당첨 번호가 빈 값일 때 예외 발생")
    void shouldThrowExceptionWhenWinningNumberIsEmpty() {
        Lotto lotto = new Lotto(Collections.emptyList());
        assertThatThrownBy(() -> validator.validate(lotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호는 빈 값일 수 없습니다.");
    }

    @Test
    @DisplayName("당첨 번호의 개수가 6개 미만일 때 예외 발생")
    void shouldThrowExceptionWhenWinningNumberSizeIsLessThanSix() {
        Lotto lotto = new Lotto(List.of(3, 12, 25, 8, 10));
        assertThatThrownBy(() -> validator.validate(lotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 6개여야 합니다.");
    }

    @Test
    @DisplayName("당첨 번호에 1~45 범위를 벗어난 숫자가 있을 때 예외 발생")
    void shouldThrowExceptionWhenWinningNumberOutOfRange() {
        Lotto lotto = new Lotto(List.of(3, 12, 25, 50, 8, 10));
        assertThatThrownBy(() -> validator.validate(lotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호는 1~45 사이의 숫자여야 합니다.");
    }

    @Test
    @DisplayName("당첨 번호에 중복된 숫자가 있을 때 예외 발생")
    void shouldThrowExceptionWhenWinningNumberContainsDuplicates() {
        Lotto lotto = new Lotto(List.of(3, 12, 25, 3, 8, 10));
        assertThatThrownBy(() -> validator.validate(lotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호에 중복된 숫자가 있습니다.");
    }
}
