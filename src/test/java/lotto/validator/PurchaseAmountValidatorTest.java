package lotto.validator;

import static lotto.validator.PurchaseAmountValidator.MAX_PURCHASE_AMOUNT;
import static lotto.validator.PurchaseAmountValidator.UNIT_PURCHASE_AMOUNT;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class PurchaseAmountValidatorTest {

    @Test
    void 공백_입력시_예외가_발생한다() {
        assertThatThrownBy(() -> {
            PurchaseAmountValidator.validate("");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 공백이 아닌 구입 금액을 입력해주세요.");

        assertThatThrownBy(() -> {
            PurchaseAmountValidator.validate("\n");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 공백이 아닌 구입 금액을 입력해주세요.");

        assertThatThrownBy(() -> {
            PurchaseAmountValidator.validate(null);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 공백이 아닌 구입 금액을 입력해주세요.");
    }

    @Test
    void 양수가_아닌_금액_입력시_예외가_발생한다() {
        assertThatThrownBy(() -> {
            PurchaseAmountValidator.validate("0");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 양수이어야 합니다.");

        assertThatThrownBy(() -> {
            PurchaseAmountValidator.validate("-10");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 양수이어야 합니다.");

        assertThatThrownBy(() -> {
            PurchaseAmountValidator.validate("abc000");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 양수이어야 합니다.");
    }

    @Test
    void 단위금액으로_나누어_떨어지지_않는_금액_입력시_예외가_발생한다() {
        assertThatThrownBy(() -> {
            PurchaseAmountValidator.validate("1001");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 단위 금액인 " + UNIT_PURCHASE_AMOUNT + "으로 나누어 떨어져야 합니다.");

        assertThatThrownBy(() -> {
            PurchaseAmountValidator.validate("1234");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 단위 금액인 " + UNIT_PURCHASE_AMOUNT + "으로 나누어 떨어져야 합니다.");
    }

    @Test
    void 최대_구입가능_금액_초과시_예외가_발생한다() {
        assertThatThrownBy(() -> {
            PurchaseAmountValidator.validate("100000000");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 최대 구매가능 금액인 " + MAX_PURCHASE_AMOUNT + "을 넘지 못합니다.");
    }
}