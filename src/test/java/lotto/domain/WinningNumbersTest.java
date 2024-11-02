package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {

    @Test
    void validateTest_whenNumberIsOverlapped_throwException() {
        Numbers winningNumbers = Numbers.from(List.of(1, 2, 3, 4, 5, 6));
        Number bonusNumber = new Number(6);

        assertThatThrownBy(() -> new WinningNumbers(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호와 보너스 번호가 겹치면 안됩니다");
    }

    @Test
    void validateTest_whenNumberIsNotOverlapped() {
        Numbers winningNumbers = Numbers.from(List.of(1, 2, 3, 4, 5, 6));
        Number bonusNumber = new Number(7);

        assertThatCode(() -> new WinningNumbers(winningNumbers, bonusNumber))
                .doesNotThrowAnyException();
    }
}
