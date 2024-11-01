package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import lotto.Input.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("입력값 검증 테스트")
public class InputValidatorTest {

    @Test
    @DisplayName("로또 구매 금액이 숫자가 아니라면 예외가 발생한다.")
    void 실패_로또구입_숫자아님() {
        // given
        InputValidator validator = new InputValidator();

        // when & then
        assertThatThrownBy(() -> validator.validateInput("이천원"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력 가능합니다.");
    }

    @Test
    @DisplayName("구매 금액이 0 이하이면 예외가 발생한다.")
    void 실패_로또구입_0원이하() {
        // given
        InputValidator validator = new InputValidator();

        // when & then
        assertThatThrownBy(() -> validator.validateInput("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구입 금액은 0보다 커야 합니다.");
    }

    @Test
    @DisplayName("구매 금액이 1,000원 단위가 아니면 예외가 발생한다")
    void 실패_로또구입_1000원단위_아님() {
        // given
        InputValidator validator = new InputValidator();

        // when & then
        assertThatThrownBy(() -> validator.validateInput("2500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구입 금액은 1,000원 단위여야 합니다.");
    }

    @Test
    @DisplayName("정상적인 구매입력값이 입력되면 정상 처리된다.")
    void 성공_로또구입_알맞은_입력값() {
        // given
        InputValidator validator = new InputValidator();

        // when & then
        assertThatCode(() -> validator.validateInput("3000"))
                .doesNotThrowAnyException();
    }
}
