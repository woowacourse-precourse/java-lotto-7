package lotto.util.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.AssertionsForClassTypes;
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

    @DisplayName("구입 금액은 반드시 천원단위로 떨어져야 한다.")
    @ParameterizedTest
    @ValueSource(ints = {1_200, 10_400, 15_012, 50_001})
    void notThousandUnit(int purchaseAmount) {

        AssertionsForClassTypes.assertThatThrownBy(() -> PurchaseAmountValidator.validate(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구입 금액은 반드시 천원 단위로 떨어져야 합니다. 다시 입력해 주세요.");
    }

    @DisplayName("구입 금액은 10만원을 초과할 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {100_001, 100_002, 200_000})
    void overOneHundredThousandPurchaseAmount(int purchaseAmount) {

        AssertionsForClassTypes.assertThatThrownBy(() -> PurchaseAmountValidator.validate(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("한번 구매할때 10만원 이하로 구매할 수 있습니다. 다시 시도해 주세요.");
    }
}