package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("InputValidator 클래스 테스트")
public class InputValidatorTest {

    private final InputValidator inputValidator = new InputValidator();

    @Test
    void 로또_구입_금액이_1000으로_나누어_떨어지지_않는다면_예외를_발생한다() {
        // given
        int purchaseAmount = 10002;

        // when & then
        Assertions.assertThatThrownBy(() -> inputValidator.validatePurchaseAmount(purchaseAmount))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("로또 구입 금액은 1000원 단위로 입력해야합니다.");
    }
}
