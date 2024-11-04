package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseAmountValidatorTest {

    @Test
    @DisplayName("올바른 구매 금액을 입력하면 검증에 성공한다")
    void validate_Success() {
        // given
        String validAmount = "5000";

        // when & then
        assertThatCode(() -> PurchaseAmountValidator.validate(validAmount))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("올바른 구매 금액을 입력하면 검증에 성공한다")
    void validate_Unsuccess() {
        // given
        String validAmount = "500000000000000";

        // when & then
        assertThatCode(() -> PurchaseAmountValidator.validate(validAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "1000a", "1,000", " ", ""})
    @DisplayName("숫자가 아닌 입력의 경우 예외가 발생한다")
    void validate_WithNonNumericInput(String invalidAmount) {
        assertThatThrownBy(() -> PurchaseAmountValidator.validate(invalidAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] int 범위 숫자만 입력해 주세요.(원 단위)");
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1000", "-1", "0", "999"})
    @DisplayName("0, 음수를 입력한 경우 예외가 발생한다")
    void validate_WithNegativeAmount(String negativeAmount) {
        assertThatThrownBy(() -> PurchaseAmountValidator.validate(negativeAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 금액은 1000 이상입니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1500", "2001"})
    @DisplayName("1000원 단위가 아닌 금액 입력시 예외가 발생한다")
    void validate_WithNonThousandUnit(String invalidAmount) {
        assertThatThrownBy(() -> PurchaseAmountValidator.validate(invalidAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 금액은 1000원 단위입니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000", "2000", "5000", "10000"})
    @DisplayName("1000원 단위의 올바른 금액을 입력하면 검증에 성공한다")
    void validate_WithValidThousandUnit(String validAmount) {
        assertThatCode(() -> PurchaseAmountValidator.validate(validAmount))
                .doesNotThrowAnyException();
    }
}