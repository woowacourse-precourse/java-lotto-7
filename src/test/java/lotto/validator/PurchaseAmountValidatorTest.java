package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseAmountValidatorTest {

    @DisplayName("구입 금액은 빈 문자열이 구입 금액이 수 없다.")
    @ParameterizedTest
    @EmptySource
    void inputEmptyString(String rawPurchaseAmount) {
        //given
        assertThatThrownBy(() -> PurchaseAmountValidator.validate(rawPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구입 금액으로 빈 문자열을 입력할 수 없습니다. 다시 시도해 주세요.");
    }

    @DisplayName("구입 금액은 숫자가 아닌 문자열이 될 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"123avd", "12.3", "lll"})
    void inputNonNumericString(String rawPurchaseAmount) {
        //given
        assertThatThrownBy(() -> PurchaseAmountValidator.validate(rawPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구입 금액은 정수형 범위의 숫자만 입력할 수 있습니다. 다시 시도해 주세요.");
    }

    @DisplayName("구입 금액은 양의 정수만 입력받을 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"-123", "0", "-1"})
    void inputNonPositiveNumberString(String rawPurchaseAmount) {
        //given

        assertThatThrownBy(() -> PurchaseAmountValidator.validate(rawPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구입 금액은 양의 정수만 입력할 수 있습니다. 다시 시도해 주세요.");
    }
}