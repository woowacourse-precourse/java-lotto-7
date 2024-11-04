package lotto.parser;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BonusNumberParserTest {

    @Test
    @DisplayName("유효한 보너스 번호 입력을 파싱하여 정수로 반환")
    void parse_validInput_shouldReturnInteger() {
        int bonusNumber = BonusNumberParser.parse("7");
        assertThat(bonusNumber).isEqualTo(7);
    }

    @Test
    @DisplayName("보너스 번호가 숫자가 아닌 경우 예외 발생")
    void parse_nonNumericValue_shouldThrowException() {
        assertThatThrownBy(() -> BonusNumberParser.parse("b"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 번호는 숫자여야 합니다.");
    }

    @Test
    @DisplayName("보너스 번호가 범위를 벗어난 경우 예외 발생")
    void parse_numberOutOfRange_shouldThrowException() {
        assertThatThrownBy(() -> BonusNumberParser.parse("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
}
