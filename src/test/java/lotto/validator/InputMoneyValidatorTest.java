package lotto.validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.validator.InputMoneyValidator.validatePurchaseMoney;

class InputMoneyValidatorTest {

    private static final int LOTTO_PRICE = 1000;

    @DisplayName("로또 금액 단위로 입력하지 않을경우 예외가 발생한다. ")
    @Test
    void validatePurchaseMoneyWithoutUnit() {

        // given
        String inputPurchaseMoney = "3500";

        // when, then
        Assertions.assertThatThrownBy(() -> validatePurchaseMoney(inputPurchaseMoney))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 구입금액은 " + LOTTO_PRICE + "단위로 입력해 주세요.");

    }

    @DisplayName("문자를 포함해서 입력할 경우 예외가 발생한다. ")
    @Test
    void test() {

        // given
        String inputPurchaseMoney = "3ol0";

        // when, then
        Assertions.assertThatThrownBy(() -> validatePurchaseMoney(inputPurchaseMoney))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 구입금액은 양수로 입력해 주세요.");
    }

}