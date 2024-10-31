package lotto.validate;

import static lotto.validate.PurchaseAmountValidator.getValidatedPurchaseAmount;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseAmountValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"1000", "2000", "10000"})
    void 올바른_구입금액_입력_테스트(String input) {
        int validatedInput = getValidatedPurchaseAmount(input);

        assertThat(validatedInput).isEqualTo(Integer.parseInt(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "900", "1200", "1230", "1234", "-1000"})
    void 잘못된_구입금액_입력_테스트(String input) {
        assertThatThrownBy(() -> getValidatedPurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.PURCHASE_UNIT.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "도현", "1000.1", "!@#$", ","})
    void 잘못된_타입_입력_테스트(String input) {
        assertThatThrownBy(() -> getValidatedPurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.PURCHASE_TYPE.getMessage());
    }
}
