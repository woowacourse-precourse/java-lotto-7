package lotto.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseAmountValidationTest {
    @ParameterizedTest
    @ValueSource(strings = {"12000", "2000"})
    @DisplayName("성공하는 구입 금액 입력 확인하기")
    public void 구입_금액_성공_테스트(String purchaseAmount) {
        int expectedAmount = Integer.parseInt(purchaseAmount) / 1000;
        assertThat(PurchaseAmountValidation.purchaseAmountValidationAndGetLottoQuantity(purchaseAmount))
                .isEqualTo(expectedAmount);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  ", "1200", "12000q"})
    @DisplayName("실패하는 구입 금액 입력 확인하기")
    public void 구입_금액_실패_테스트(String purchaseAmount) {
        assertThatThrownBy(() -> PurchaseAmountValidation.purchaseAmountValidationAndGetLottoQuantity(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}