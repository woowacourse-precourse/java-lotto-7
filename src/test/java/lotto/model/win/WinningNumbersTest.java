package lotto.model.win;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.message.LottoErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("당첨 번호 객체 테스트")
class WinningNumbersTest {

    @DisplayName("당첨 번호가 올바른 경우 예외가 발생하지 않는다.")
    @Test
    void shouldNotThrowException_WhenBonusNumberIsValid() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        assertDoesNotThrow(() -> {
            WinningNumbers winningNumbers = new WinningNumbers(numbers);
            assertEquals(winningNumbers.get(), numbers);
        });
    }

    @DisplayName("당첨 번호의 개수가 6개보다 작으면 예외가 발생한다.")
    @Test
    void shouldThrowException_WhenWinningNumbersCountLessThan6() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        assertThatThrownBy(() -> new WinningNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoErrorMessage.WINNING_NUMBERS_COUNT.get());
    }

    @DisplayName("당첨 번호의 개수가 6개보다 작으면 예외가 발생한다.")
    @Test
    void shouldThrowException_WhenWinningNumbersCountGreaterThan6() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);

        assertThatThrownBy(() -> new WinningNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoErrorMessage.WINNING_NUMBERS_COUNT.get());
    }

    @DisplayName("당첨 번호에 중복된 숫자가 존재하는 경우 예외가 발생한다.")
    @Test
    void shouldThrowException_WhenWinningNumbersDuplicate() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 5);

        assertThatThrownBy(() -> new WinningNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoErrorMessage.WINNING_NUMBERS_DUPLICATE.get());
    }

    @DisplayName("당첨 번호에 범위를 벗어난 숫자가 있으면 예외가 발생한다.")
    @Test
    void shouldThrowException_WhenWinningNumbersOutOfRange() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 46);

        assertThatThrownBy(() -> new WinningNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoErrorMessage.WINNING_NUMBERS_OUT_OF_RANGE.get());
    }
}
