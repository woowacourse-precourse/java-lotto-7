package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import lotto.Input.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("입력값 검증 테스트")
public class InputValidatorTest {

    @Test
    @DisplayName("로또 구매 금액이 숫자가 아니라면 예외가 발생한다.")

    void 실패_로또구입_숫자아님(){
        // given
        InputValidator validator = new InputValidator();

        // when & then
        assertThatThrownBy(() -> validator.validatePurchaseFormat("이천원"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력 가능합니다.");
    }
}
