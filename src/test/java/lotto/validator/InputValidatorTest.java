package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.view.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class InputValidatorTest {

    @DisplayName("입력값이 비어 있거나 공백일 때 예외 발생")
    @ParameterizedTest
    @CsvSource({
            "'', EMPTY_INPUT_INVALID",    // 빈 문자열
            "'   ', EMPTY_INPUT_INVALID"  // 공백 문자열
    })
    void validateNotEmpty_WhenInputEmptyOrBlank_ShouldThrowException(String input, String errorMessage) {
        assertThatThrownBy(() -> InputValidator.validateNotEmpty(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.valueOf(errorMessage).getMessage());
    }

    @DisplayName("입력값이 null일 때 예외 발생")
    @Test
    void validateNotEmpty_WhenInputIsNull_ShouldThrowException() {
        assertThatThrownBy(() -> InputValidator.validateNotEmpty(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.EMPTY_INPUT_INVALID.getMessage());
    }

    @DisplayName("입력값이 정상적인 경우 예외 발생하지 않음")
    @ParameterizedTest
    @CsvSource({
            "'valid input'",  // 정상 입력
            "'another valid input'" // 정상 입력
    })
    void validateNotEmpty_WhenInputValid_ShouldNotThrowException(String input) {
        assertThatNoException().isThrownBy(() -> InputValidator.validateNotEmpty(input));
    }

    @DisplayName("구매 금액이 1,000원 단위가 아닐 때 예외 발생")
    @ParameterizedTest
    @CsvSource({
            "1500, PURCHASE_AMOUNT_INVALID",  // 1,000원으로 나누어떨어지지 않음
            "250, PURCHASE_AMOUNT_INVALID"    // 1,000원 단위가 아님
    })
    void validatePurchaseAmount_WhenNotThousandUnit_ShouldThrowException(int amount, String errorMessage) {
        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.valueOf(errorMessage).getMessage());
    }

    @DisplayName("구매 금액이 1,000원 단위일 때 예외 발생하지 않음")
    @ParameterizedTest
    @CsvSource({
            "1000",  // 1,000원 단위
            "5000",  // 1,000원 단위
            "10000"  // 1,000원 단위
    })
    void validatePurchaseAmount_WhenThousandUnit_ShouldNotThrowException(int amount) {
        assertThatNoException().isThrownBy(() -> InputValidator.validatePurchaseAmount(amount));
    }

}
