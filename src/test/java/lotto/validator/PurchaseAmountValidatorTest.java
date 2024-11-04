package lotto.validator;

import static lotto.message.ExceptionMessage.INVALID_BLANK_INPUT;
import static lotto.message.ExceptionMessage.INVALID_NUMBER_INPUT;
import static lotto.message.ExceptionMessage.INVALID_RANGE_INPUT;
import static lotto.message.ExceptionMessage.INVALID_TYPE_INPUT;
import static lotto.validator.PurchaseAmountValidator.INPUT;
import static lotto.validator.PurchaseAmountValidator.MAX_VALUE;
import static lotto.validator.PurchaseAmountValidator.MIN_VALUE;
import static lotto.validator.PurchaseAmountValidator.TYPE;
import static lotto.validator.PurchaseAmountValidator.UNIT;
import static lotto.validator.PurchaseAmountValidator.validatePurchaseAmount;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.message.ExceptionMessage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseAmountValidatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    void 구입_금액에_빈_값이_들어오면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> validatePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith(ExceptionMessage.getPrefix())
                .hasMessage(INVALID_BLANK_INPUT.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "1.5"})
    void 구입_금액이_정수가_아니면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> validatePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith(ExceptionMessage.getPrefix())
                .hasMessage(
                        String.format(INVALID_TYPE_INPUT.getMessage(), INPUT, TYPE)
                );
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "1", "999", "100001"})
    void 구입_금액이_1000원_미만이거나_10만원_초과이면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> validatePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith(ExceptionMessage.getPrefix())
                .hasMessage(
                        String.format(INVALID_RANGE_INPUT.getMessage(), INPUT, MIN_VALUE, MAX_VALUE)
                );
    }

    @ParameterizedTest
    @ValueSource(strings = {"1001", "1999", "99999"})
    void 구입_금액이_1000으로_나누어_떨어지지_않으면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> validatePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith(ExceptionMessage.getPrefix())
                .hasMessage(
                        String.format(INVALID_NUMBER_INPUT.getMessage(), INPUT, UNIT)
                );
    }
}