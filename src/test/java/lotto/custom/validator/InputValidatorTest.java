package lotto.custom.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.custom.common.ErrorMessages;
import lotto.custom.constants.CustomErrorMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputValidatorTest {
    private final InputValidator inputValidator = new InputValidator();


    @DisplayName("유효성검증_구입금액입력_NULL일때_테스트")
    @Test
    void 유효성검증_구입금액입력_NULL일때_테스트() {
        assertThatThrownBy(() -> inputValidator.validatePurchaseAmountInput(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.NULL_INPUT);
    }

    @DisplayName("유효성검증_구입금액입력_빈문자열일때_테스트")
    @Test
    void 유효성검증_구입금액입력_빈문자열일때_테스트() {
        assertThatThrownBy(() -> inputValidator.validatePurchaseAmountInput(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.EMPTY_INPUT);
    }

    @DisplayName("유효성검증_구입금액입력_공백으로구성되어있을때_테스트")
    @Test
    void 유효성검증_구입금액입력_공백으로구성되어있을때_테스트() {
        assertThatThrownBy(() -> inputValidator.validatePurchaseAmountInput("   "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.WHITESPACE_ONLY);
    }

    @DisplayName("유효성검증_구입금액입력_숫자외의문자가있을때_테스트")
    @Test
    void 유효성검증_구입금액입력_숫자외의문자가있을때_테스트() {
        assertThatThrownBy(() -> inputValidator.validatePurchaseAmountInput("123#5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.INVALID_CHARACTERS);
    }

    @DisplayName("유효성검증_구입금액입력_int타입의범위를벗어날때_테스트")
    @Test
    void 유효성검증_구입금액입력_int타입의범위를벗어날때_테스트() {
        assertThatThrownBy(() -> inputValidator.validatePurchaseAmountInput("2147483648")) // Integer.MAX_VALUE + 1
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.INT_OUT_OF_BOUNDS);
    }

    @DisplayName("유효성검증_구입금액입력_1000원으로나누어떨어지지않을때_테스트")
    @Test
    void 유효성검증_구입금액입력_1000원으로나누어떨어지지않을때_테스트() {
        assertThatThrownBy(() -> inputValidator.validatePurchaseAmountInput("5400"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CustomErrorMessages.NOT_DIVISIBLE_BY_THOUSAND);
    }
}