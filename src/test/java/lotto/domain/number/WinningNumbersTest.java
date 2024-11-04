package lotto.domain.number;

import lotto.global.exception.ErrorMessage;
import lotto.global.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumbersTest {

    @DisplayName("당첨 번호는 쉼표로 구분된 문자열을 파싱하여 생성된다.")
    @Test
    void should_CreateWinningNumbers_When_InputString() {
        // given
        String input = "1, 2, 3, 4, 5, 6";

        // when
        WinningNumbers winningNumbers = WinningNumbers.from(input);

        // then
        assertThat(winningNumbers.countMatchedNumbers(List.of(1, 2, 3, 4, 5, 6))).isEqualTo(6);
    }

    @DisplayName("당첨 번호에 빈 문자열이 있으면 무시한다.")
    @Test
    void should_IgnoreEmptyString_When_ParsingWinningNumbers() {
        // given
        String input = "1, , 2, 3, 4, 5, , 6";

        // when
        WinningNumbers winningNumbers = WinningNumbers.from(input);

        // then
        assertThat(winningNumbers.countMatchedNumbers(List.of(1, 2, 3, 4, 5, 6))).isEqualTo(6);
    }

    @DisplayName("당첨 번호가 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void should_ThrowException_When_NotNumber() {
        assertThatThrownBy(() -> WinningNumbers.from("1,2,3,4,5,a"))
                .isInstanceOf(LottoException.class)
                .hasMessage(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage())
                .hasCauseInstanceOf(NumberFormatException.class);
    }

    @DisplayName("당첨 번호들과 일치하는 번호의 개수를 반환한다.")
    @Test
    void should_ReturnMatchedNumberCount_When_CompareWithWinningNumbers() {
        // given
        WinningNumbers winningNumbers = WinningNumbers.from("1,2,3,4,5,6");

        // then
        assertThat(winningNumbers.countMatchedNumbers(List.of(1, 2, 3, 7, 8, 9))).isEqualTo(3);
        assertThat(winningNumbers.countMatchedNumbers(List.of(7, 8, 9, 10, 11, 12))).isEqualTo(0);
    }
}