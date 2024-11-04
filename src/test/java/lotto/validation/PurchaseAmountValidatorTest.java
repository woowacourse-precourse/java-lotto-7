package lotto.validation;

import lotto.TestConstants;
import lotto.constants.ErrorMessageConstants;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseAmountValidatorTest {
    private static final int INVALID_AMOUNT_NOT_DIVISIBLE_BY_BASE_UNIT = 1_500;

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "         "})
    void 구입_금액_입력값이_null_또는_공백인_경우_예외_테스트(String invalidInput) {
        assertThatThrownBy(() -> PurchaseAmountValidator.validatePurchaseAmountInput(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessageConstants.EMPTY_PURCHASE_AMOUNT);
    }

    @ParameterizedTest
    @ValueSource(strings = {"five", "5.5", "abc"})
    void 구입_금액이_숫자가_아닌_경우_예외_테스트(String invalidInput) {
        assertThatThrownBy(() -> PurchaseAmountValidator.validatePurchaseAmountInput(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessageConstants.INVALID_NUMBER_FORMAT);
    }

    @Test
    void 구입_금액이_1000원_단위가_아닐_경우_예외_테스트() {
        assertThatThrownBy(() -> PurchaseAmountValidator.validatePurchaseAmount(INVALID_AMOUNT_NOT_DIVISIBLE_BY_BASE_UNIT))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessageConstants.INVALID_LOTTO_AMOUNT_UNIT);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1000", "0"})
    void 구입_금액이_양의_정수가_아닐_경우_예외_테스트(int invalidAmount) {
        assertThatThrownBy(() -> PurchaseAmountValidator.validatePurchaseAmount(invalidAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessageConstants.INVALID_NON_POSITIVE_PURCHASE_AMOUNT);
    }

    @Test
    void 구입_금액_입력_정상_테스트() {
        PurchaseAmountValidator.validatePurchaseAmount(TestConstants.VALID_PURCHASE_AMOUNT);
    }
}
