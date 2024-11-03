package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.view.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;

public class InputValidatorTest {

    @DisplayName("입력값이 정상적인 경우 예외 발생하지 않음")
    @ParameterizedTest
    @CsvSource({"'valid input'", "'another valid input'"})
    void validateNotEmpty_WhenInputValid_ShouldNotThrowException(String input) {
        assertThatNoException().isThrownBy(() -> InputValidator.validateNotEmpty(input));
    }

    @DisplayName("[ERROR] 입력값은 비어 있을 수 없습니다.")
    @ParameterizedTest
    @CsvSource({"''", "'   '"}) // 빈 문자열과 공백 문자열
    @NullSource
    void validateNotEmpty_WhenInputEmptyOrBlankOrNull_ShouldThrowException(String input) {
        assertThatThrownBy(() -> InputValidator.validateNotEmpty(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.EMPTY_INPUT_INVALID.getMessage());
    }

    @DisplayName("[ERROR] 구입 금액은 양수이며 1,000원 단위여야 합니다.")
    @ParameterizedTest
    @CsvSource({
            "1500, '[ERROR] 구입 금액은 양수이며 1,000원 단위여야 합니다.'",
            "250, '[ERROR] 구입 금액은 양수이며 1,000원 단위여야 합니다.'"
    })
    void validatePurchaseAmount_WhenNotThousandUnit_ShouldThrowException(int amount, String expectedMessage) {
        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedMessage);
    }

    @DisplayName("구매 금액이 1,000원 단위일 때 예외 발생하지 않음")
    @ParameterizedTest
    @CsvSource({"1000", "5000", "10000"})
    void validatePurchaseAmount_WhenThousandUnit_ShouldNotThrowException(int amount) {
        assertThatNoException().isThrownBy(() -> InputValidator.validatePurchaseAmount(amount));
    }

    @DisplayName("[ERROR] 구입 금액이 너무 큽니다. 최대 금액은 1,000,000원입니다.")
    @ParameterizedTest
    @CsvSource({
            "1001000, '[ERROR] 구입 금액이 너무 큽니다. 최대 금액은 1,000,000원입니다.'",
            "2000000, '[ERROR] 구입 금액이 너무 큽니다. 최대 금액은 1,000,000원입니다.'"
    })
    void validatePurchaseAmount_WhenExceedsMaxAmount_ShouldThrowException(int amount, String expectedMessage) {
        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedMessage);
    }

}
