package lotto.model;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.model.domain.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {

    @Test
    @DisplayName("중복되지 않는 당첨 번호 6개는 예외를 던지지 않는다.")
    void testValidWinningNumbers() {
        assertThatCode(() -> new WinningNumbers("1,2,3,4,5,6"))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("당첨 번호가 중복이면 예외를 던진다.")
    void testUniqueWinningNumbers() {
        assertThatThrownBy(() -> new WinningNumbers("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨 번호는 중복되면 안 됩니다.");
    }

    @Test
    @DisplayName("당첨 번호를 7개 입력하면 예외를 던진다.")
    void testLagerSizeThrowsException() {
        assertThatThrownBy(() -> new WinningNumbers("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자를 6개 입력해주세요.");
    }

    @Test
    @DisplayName("당첨 번호를 2개 입력하면 예외를 던진다.")
    void testSmallerSizeThrowsException() {
        assertThatThrownBy(() -> new WinningNumbers("1,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자를 6개 입력해주세요.");
    }
}