package lotto.parser;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PurchaseAmountParserTest {

    @Test
    @DisplayName("유효한 금액 입력을 파싱하여 정수로 변환")
    void parse_validAmount_shouldReturnInteger() {
        int amount = PurchaseAmountParser.parse("5000");
        assertThat(amount).isEqualTo(5000);
    }

    @Test
    @DisplayName("금액 입력이 숫자가 아닌 경우 예외 발생")
    void parse_invalidAmount_shouldThrowException() {
        assertThatThrownBy(() -> PurchaseAmountParser.parse("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 숫자여야 합니다.");
    }
}
