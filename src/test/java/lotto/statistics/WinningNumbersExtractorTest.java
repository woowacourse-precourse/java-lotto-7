package lotto.statistics;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersExtractorTest {

    @DisplayName("당첨 번호에 null이 입력되면 예외가 발생한다.")
    @Test
    void shouldThrowIllegalArgumentExceptionWhenInputNullWinningNumbers() {
        assertThatThrownBy(() -> new WinningNumbersExtractor().validateInput(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] null은 입력할 수 없습니다.");
    }

    @DisplayName("당첨 번호에 빈 문자열이 입력되면 예외가 발생한다.")
    @Test
    void shouldThrowIllegalArgumentExceptionWhenInputEmptyWinningNumbers() {
        assertThatThrownBy(() -> new WinningNumbersExtractor().validateInput(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 빈 문자열과 공백은 입력할 수 없습니다.");
    }

    @DisplayName("당첨 번호에 공백이 입력되면 예외가 발생한다.")
    @Test
    void shouldThrowIllegalArgumentExceptionWhenInputBlankWinningNumbers() {
        assertThatThrownBy(() -> new WinningNumbersExtractor().validateInput(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 빈 문자열과 공백은 입력할 수 없습니다.");
    }

    @DisplayName("당첨 번호에 숫자가 아닌 값이 입력되면 예외가 발생한다.")
    @Test
    void shouldThrowIllegalArgumentExceptionWhenIsNotNumberInputWinningNumbers() {
        assertThatThrownBy(() -> new WinningNumbersExtractor().validateInput("10,3-3,34"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 숫자만 가능합니다.");
    }

    @DisplayName("당첨 번호에 중복된 값이 입력되면 예외가 발생한다.")
    @Test
    void shouldThrowIllegalArgumentExceptionWhenDuplicateInputWinningNumbers() {
        assertThatThrownBy(() -> new WinningNumbersExtractor().validateInput("10,10,34"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 중복될 수 없습니다.");
    }
}
