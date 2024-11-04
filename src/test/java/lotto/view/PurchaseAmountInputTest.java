package lotto.view;

import static lotto.common.exception.ExceptionMessages.EMPTY_INPUT;
import static lotto.common.exception.ExceptionMessages.NONE_NUMERIC_INPUT;
import static lotto.common.exception.ExceptionMessages.NOT_MULTIPLE_OF_UNIT_PRICE;
import static lotto.common.exception.ExceptionMessages.OUT_OF_INTEGER_RANGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PurchaseAmountInputTest {
    private PurchaseAmountInput purchaseAmountInput;

    @BeforeEach
    void setUp() {
        purchaseAmountInput = new PurchaseAmountInput();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000", "2000", "100000", "0", "1000000000"})
    void 올바른_금액_입력시_정상_동작(String input) {
        assertThatCode(() -> purchaseAmountInput.validate(input)).doesNotThrowAnyException();
    }

    private void throwException(String input, String message) {
        assertThatThrownBy(() -> purchaseAmountInput.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @ParameterizedTest
    @ValueSource(strings = {""})
    void 빈_구입_금액_입력시_예외_발생(String input) {
        throwException(input, EMPTY_INPUT.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1000", " ", " 1000", "1000 ", " 1000 ", "1000,"})
    void 숫자_아닌_값_입력시_예외_발생(String input) {
        throwException(input, NONE_NUMERIC_INPUT.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"2147483648", "2147483649000000000000"})
    void 정수_범위_밖의_값_입력시_예외_발생(String input) {
        throwException(input, OUT_OF_INTEGER_RANGE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "1001", "1111", "7010"})
    void 개당_가격의_배수가_아닌_수_입력시_예외_발생(String input) {
        throwException(input, NOT_MULTIPLE_OF_UNIT_PRICE.getMessage());
    }
}
