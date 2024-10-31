package lotto.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseAmountValidationTest {
    @Test
    @DisplayName("구입 금액은 1,000원 단위가 아닐때 오류 확인하기")
    public void 구입_금액_1000원_단위() {
        assertThatThrownBy(() -> PurchaseAmountValidation.invalidPurchaseAmountValidation(1200))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"12000", "2000"})
    @DisplayName("성공하는 구입 금액 입력 확인하기")
    public void 구입_금액_성공_테스트(String purchaseAmount) {
        int expectedAmount = Integer.parseInt(purchaseAmount);
        assertThat(PurchaseAmountValidation.purchaseAmountValidation(purchaseAmount)).isEqualTo(expectedAmount);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  ", "1200", "12000q"})
    @DisplayName("실패하는 구입 금액 입력 확인하기")
    public void 구입_금액_실패_테스트(String purchaseAmount) {
        assertThatThrownBy(() -> PurchaseAmountValidation.purchaseAmountValidation(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}