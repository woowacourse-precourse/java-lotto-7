package lotto.domain;

import static lotto.message.ErrorMessage.ERROR_INPUT_PURCHASE_AMOUNT;
import static lotto.message.ErrorMessage.ERROR_INVALID_UNIT;
import static lotto.message.ErrorMessage.ERROR_NEGATIVE_PRICE;
import static lotto.message.ErrorMessage.ERROR_NON_NUMERIC_INPUT;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseAmountTest {

    @DisplayName("구입 금액 입력에 성공합니다.")
    @Test
    void 구입_금액_입력_성공() {
        String purchaseAmount = "14000";

        assertThatCode(() -> PurchaseAmount.createPurchaseAmount(purchaseAmount))
                .doesNotThrowAnyException();
    }

    @DisplayName("구입 금액을 입력하지 않은 경우 예외가 발생한다.")
    @Test
    void 구입_금액_입력_실패() {
        String purchaseAmount = "";

        assertThatThrownBy(() -> PurchaseAmount.createPurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_INPUT_PURCHASE_AMOUNT);
    }

    @DisplayName("구입 금액을 숫자로 입력하지 않은 경우 예외가 발생한다.")
    @Test
    void 구입_금액_숫자_예외() {
        String purchaseAmount = "abc";

        assertThatThrownBy(() -> PurchaseAmount.createPurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_NON_NUMERIC_INPUT);
    }

    @DisplayName("구입 금액을 음수로 입력한 경우 예외가 발생한다.")
    @Test
    void 구입_금액_음수_예외() {
        String purchaseAmount = "-1000";

        assertThatThrownBy(() -> PurchaseAmount.createPurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_NEGATIVE_PRICE);
    }

    @DisplayName("구입 금액 입력이 1000원 단위가 아닌 경우 예외가 발생한다.")
    @Test
    void 구입_금액_입력_1000원_단위_예외() {
        String purchaseAmount = "1500";

        assertThatThrownBy(() -> PurchaseAmount.createPurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_INVALID_UNIT);
    }

}