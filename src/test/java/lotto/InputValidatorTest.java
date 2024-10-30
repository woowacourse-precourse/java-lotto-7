package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("InputValidator 클래스 테스트")
public class InputValidatorTest {

    @Test
    void 금액이_1000_단위로_나누어_떨어지지_않으면_예외를_발생() {
        // given
        int purchaseAmount = 10500;
        // when & then
        Assertions.assertThatThrownBy(() -> InputValidator.validatePurchaseAmount(purchaseAmount))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("구입 금액은 1,000원 단위로만 가능합니다.");
    }

}
