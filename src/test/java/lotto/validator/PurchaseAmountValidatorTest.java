package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseAmountValidatorTest {

    @DisplayName("구입 금액은 양의 정수만 입력받을 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {-2, -1, 0})
    void inputNonPositiveNumberString(int purchaseAmount) {

        assertThatThrownBy(() -> PurchaseAmountValidator.validate(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구입 금액은 양의 정수만 입력할 수 있습니다. 다시 시도해 주세요.");

    }
}