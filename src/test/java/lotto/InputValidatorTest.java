package lotto;

import static lotto.ErrorCode.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("InputValidator 클래스 테스트")
public class InputValidatorTest {

    private final InputValidator inputValidator = new InputValidator();

    @Test
    void 로또_구입_금액이_1000으로_나누어_떨어지지_않는다면_예외를_발생한다() {
        // given
        String purchaseAmount = "10002";

        // when & then
        assertThatThrownBy(() -> inputValidator.validatePurchaseAmount(purchaseAmount))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(INVALID_PURCHASE_AMOUNT.getMessage());
    }

    @Test
    void 로또_구입_금액이_숫자가_아니라면_예외를_발생한다() {
        // given
        String purchaseAmount = "1000a";

        // when & then
        assertThatThrownBy(() -> inputValidator.validatePurchaseAmount(purchaseAmount))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(INVALID_NUMBER_FORMAT.getMessage());
    }

    @Test
    void 로또_구입_금액이_정수_범위를_벗어나면_예외를_발생한다() {
        // given
        String purchaseAmount = "21474836998";

        // when & then
        assertThatThrownBy(() -> inputValidator.validatePurchaseAmount(purchaseAmount))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(INVALID_NUMBER_FORMAT.getMessage());
    }
}
