package lotto.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    private final InputValidator inputValidator = new InputValidator();

    @Test
    @DisplayName("구매 금액 검증 - 성공 케이스")
    void validatePurchaseAmount_Success() {
        // given
        int purchaseAmount = 2000;
        int lottoPrice = 1000;

        // when & then
        Assertions.assertThatCode(() -> inputValidator.validatePurchaseAmount(purchaseAmount, lottoPrice))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("구매 금액 검증 - 실패 케이스: 나누어 떨어지지 않음")
    void validatePurchaseAmount_Failure() {
        // given
        int purchaseAmount  = 2500;
        int lottoPrice  = 1000;

        // when & then
        Assertions.assertThatThrownBy(
                        () -> inputValidator.validatePurchaseAmount(purchaseAmount, lottoPrice)
                ).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.PURCHASE_AMOUNT_NOT_DIVISION_ERROR.getMessage());
    }

}
