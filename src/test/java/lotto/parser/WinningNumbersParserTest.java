package lotto.parser;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class WinningNumbersParserTest {

    @Test
    @DisplayName("유효한 당첨 번호 입력을 파싱하여 리스트로 반환")
    void parse_validInput_shouldReturnList() {
        List<Integer> winningNumbers = WinningNumbersParser.parse("1,2,3,4,5,6");
        assertThat(winningNumbers).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("당첨 번호 개수가 6개가 아닌 경우 예외 발생")
    void parse_invalidCount_shouldThrowException() {
        assertThatThrownBy(() -> WinningNumbersParser.parse("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 6개여야 합니다.");
    }

    @Test
    @DisplayName("당첨 번호에 중복된 숫자가 있는 경우 예외 발생")
    void parse_duplicateNumbers_shouldThrowException() {
        assertThatThrownBy(() -> WinningNumbersParser.parse("1,2,3,3,5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
    }

    @Test
    @DisplayName("당첨 번호에 숫자가 아닌 값이 있는 경우 예외 발생")
    void parse_nonNumericValue_shouldThrowException() {
        assertThatThrownBy(() -> WinningNumbersParser.parse("1,2,3,a,5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 번호는 숫자여야 합니다.");
    }
}
