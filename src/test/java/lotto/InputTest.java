package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputTest {
    private static final String CREDIT_ERROR = "[ERROR] 구입 금액은 1,000의 배수여야 합니다.";

    @Test
    @DisplayName("구입 금액 1,000의 배수 아니면 예외 발생")
    void testCreditMultiple1000() {
        InputHandler inputHandler = new InputHandler();
        assertThatThrownBy(() -> inputHandler.checkCredit(1500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CREDIT_ERROR);
    }

    @Test
    @DisplayName("구입 금액을 1000으로 나눈 몫 만큼 로또 발행")
    void testPieces() {
        InputHandler inputHandler = new InputHandler();
        assertThat(inputHandler.getPieces(8000)).isEqualTo(8);
    }
}
