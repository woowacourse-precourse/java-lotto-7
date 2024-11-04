package lotto;

import lotto.message.ErrorMessage;
import lotto.validator.LottoAmountValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoAmountValidatorTest {

    @Test
    @DisplayName("구입 금액이 null 또는 빈 문자열이면 예외가 발생한다.")
    void validatePurchaseAmountWithNullOrEmpty() {
        String amount = "";

        assertThatThrownBy(() -> LottoAmountValidator.validatePurchaseAmout(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INPUT_NULL_OR_EMPTY.getMessage());
    }

    @Test
    @DisplayName("구입 금액이 숫자가 아니면 예외가 발생한다.")
    void validatePurchaseAmountWithNonNumeric() {
        String amount = "abc";

        assertThatThrownBy(() -> LottoAmountValidator.validatePurchaseAmout(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.PURCHASE_AMOUNT_NOT_NUMBER.getMessage());
    }

    @Test
    @DisplayName("구입 금액이 1000원 미만이면 예외가 발생한다.")
    void validatePurchaseAmountLessThanMinimum() {
        String amount = "500";

        assertThatThrownBy(() -> LottoAmountValidator.validatePurchaseAmout(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.PURCHASE_AMOUNT_NEGATIVE_OR_ZERO.getMessage());
    }

    @Test
    @DisplayName("구입 금액이 1000원으로 나누어 떨어지지 않으면 예외가 발생한다.")
    void validatePurchaseAmountNotDivisibleByThousand() {
        String amount = "2500";

        assertThatThrownBy(() -> LottoAmountValidator.validatePurchaseAmout(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_PURCHASE_AMOUNT.getMessage());
    }

    @Test
    @DisplayName("유효한 구입 금액을 입력하면 검증에 성공한다.")
    void validatePurchaseAmountSuccessfully() {
        String amount = "3000";

        int result = LottoAmountValidator.validatePurchaseAmout(amount);

        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("구입 금액에 공백이 포함되어 있으면 예외가 발생한다.")
    void validatePurchaseAmountWithBlankSpace() {
        String amount = "1 000";

        assertThatThrownBy(() -> LottoAmountValidator.validatePurchaseAmout(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INPUT_HAS_BLANK.getMessage());
    }
}
